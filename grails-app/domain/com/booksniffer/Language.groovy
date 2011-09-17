package com.booksniffer

class Language {
    Long LanguageId
    String title

    static constraints = {
        title(nullable: false, blank: false, unique: true)
    }

    static mapping = {
        table 'Language'
        id column: 'LanguageId'
        version false
    }
}

