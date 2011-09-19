package com.booksniffer

class Book {
    String isbn
    String title
    Language language

    static constraints = {
        isbn(nullable: false, blank: false, size: 1..15, matches: "[0-9]+")
        title(nullable: false, blank: false)
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