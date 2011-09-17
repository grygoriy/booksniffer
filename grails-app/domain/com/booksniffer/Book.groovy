package com.booksniffer

class Book {
    String BookId
    String isbn
    String title
    Language language

    static constraints = {
        isbn(nullable: false, blank: false, size: 1..15, matches: "[0-9]+")
        title(nullable: false, blank: false)
        BookId(nullable: true, blank: true)
    }

    static mapping = {
        table 'Book'
        columns {
            id column: 'BookId', index: 'Book_BookId_Idx'
        }
        version false
    }

    transient beforeInsert = {
        BookId = java.util.UUID.randomUUID().toString()
    }
}