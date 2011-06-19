
includeTargets << grailsScript("Init")

target(main: "The description of the script goes here!") {

    depends(parseArguments)


    def action = argsMap["params"][0]

    if (action) {

        if (action.equals("apply")) {
            String env = environment(argsMap)
            def version = version(argsMap["params"][2])
            apply env, version
        }
        else if (action.equals("revert")) {
            def version = version(argsMap["params"][1])
            revert version
        }
        else {
            println "!!!Unexpected action: ${action}."
            usage()
        }
    }
    else {
        usage()
    }
}

private String version(version) {
    if (!version) {
        println ("*** Detected current application version ${grailsAppVersion}")
        return "v${grailsAppVersion}"
    }
    return (version.equals("all") ? version : "v${version}")
}

private String environment(argsMap) {
    def env = argsMap["params"][1]
    env = (env ? env : "dev");
    if (!(env in ["dev", "prod"])) {
        println "!!!Unexpected environment: ${env}."
        usage()
    }
    return env
}

private def apply(String env, String version) {
    println "*** Applying database updates to version ${version} for enviroment ${env}"

    def dbPatchDir = "${grailsSettings.baseDir}/database"
    def dataSourceConfig = configSlurper.parse(classLoader.loadClass("DataSource"))

    def ver = (version.equals("all") ? "" : "${version}/");

    ant.sql(url: dataSourceConfig.dataSource.url,
            driver: dataSourceConfig.dataSource.driverClassName,
            userid: dataSourceConfig.dataSource.username,
            password: dataSourceConfig.dataSource.password) {
        fileset(dir: "${dbPatchDir}/${ver}") {
            include(name: "**/*.sql")
            exclude(name: "**/*_revert.sql")
            exclude(name: "**/.reverts/*.sql")
            if (env.equals("prod")) {
                exclude(name: "**/*_dev.sql")
            }
            else if (env.equals("dev")) {
                exclude(name: "**/*_prod.sql")
            }
        }
    }
    println "*** Done!"
}

private def revert(String version) {
    println "*** Reverting database from vesion ${version} to previous version"

    def dbPatchDir = "${grailsSettings.baseDir}/database"
    def dataSourceConfig = configSlurper.parse(classLoader.loadClass("DataSource"))

    def ver = (version.equals("all") ? "" : "${version}/");

    def scanner = ant.fileScanner {
        fileset(dir: "${dbPatchDir}/${ver}") {
            include(name: "**/*_revert.sql")
            exclude(name: "**/.reverts/*.sql")
        }
    }
    def files = scanner.findAll {true} as List
    Collections.reverse(files)

    ant.delete(dir: "${dbPatchDir}/${ver}.reverts", deleteonexit: true)
    ant.mkdir(dir: "${dbPatchDir}/${ver}.reverts")
    files.eachWithIndex {file, i ->
        def index = i.sprintf("%05d", i)
        ant.copy(tofile: "${dbPatchDir}/${ver}.reverts/${index}.sql") {
            fileset(file: file)
        }
    }

    ant.sql(url: dataSourceConfig.dataSource.url,
            driver: dataSourceConfig.dataSource.driverClassName,
            userid: dataSourceConfig.dataSource.username,
            password: dataSourceConfig.dataSource.password, onerror: "continue") {
        fileset(dir: "${dbPatchDir}/${ver}.reverts") {
            include(name: "*.sql")
        }
    }

    println "*** Done!"
}


private def usage() {
    println """Usage:
    database apply [environment] ([version]|all)
        - to apply version changes for specified environment.
    database revert ([version]|all)
        - to revert version changes for specified environment.
        
Parameters:
    [version] - if not set than default value is current version
    [environment] - can be dev or prod, required.

Examples:
    \$grails database apply all
        - to apply prod all scripts from all versions (used to create database objects)

    \$grails database apply dev 0.1
        - to apply dev using version 0.1

    \$grails database apply prod
        - to apply prod using current version

    \$grails database revert
        - to remove only current version

    \$grails database revert 0.1
        - to revert version 0.1 only

    \$grails database revert all
        - to revert all changes using revert scripts from all versions (used to cleanup database)
"""

    exit 1
}

setDefaultTarget(main)
