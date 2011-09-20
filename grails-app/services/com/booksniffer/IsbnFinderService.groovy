package com.booksniffer

class IsbnFinderService {

    static transactional = true

    def grailsApplication

    def getByIsbn(String isbn) {
        def data = new URL(grailsApplication.config.booksniffer.isbncomurl+isbn).getText()
        def root = new XmlParser().parseText(data)
        def bookInfo = root.BookList[0].BookData[0]
        [
         title:bookInfo.Title.text(),
         authors:bookInfo.AuthorsText.text(),
         publisher:bookInfo.PublisherText.text(),
         summary:bookInfo.Summary.text()
        ]
    }
}
