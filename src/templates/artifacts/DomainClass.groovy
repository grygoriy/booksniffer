@artifact.package@class @artifact.name@ {

    Long @artifact.name@Id

    static constraints = {
    }

    static mapping = {
        table '@artifact.name@'
        columns {
            id column:'@artifact.name@Id'
        }
        version false
    }
}

