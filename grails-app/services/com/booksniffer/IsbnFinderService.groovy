package com.booksniffer

class IsbnFinderService {

    static transactional = true

    def getByIsbn() {
        http://isbndb.com/api/books.xml?access_key=F52KAMSE&index1=isbn&value1=978-1-449-30535-2
    }
}
