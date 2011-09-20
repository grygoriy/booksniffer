package com.booksniffer

class Book {
    String isbn
    String title
    String authors
    String summary
    String publisher
    Language language

    static constraints = {
        isbn(nullable: false, blank: false)
        title(nullable: false, blank: false)
        authors(nullable: true, blank: true)
        summary(nullable: true, blank: true)
        publisher(nullable: true, blank: true)
    }

    static mapping = {
        table 'Book'
        columns {
            language lazy: false
        }
        autoTimestamp false
        version false
    }
}