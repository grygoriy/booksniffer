package com.booksniffer

class Book {
    Long BookId
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
            id column: 'BookId'
        }
        version false
    }
}