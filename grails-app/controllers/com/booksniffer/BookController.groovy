package com.booksniffer

import grails.converters.JSON

class BookController {
    static defaultAction = "list"

    def isbnFinderService

    def list = {
        def elementsPerPage = grailsApplication.config.booksniffer.pages.books
        def books = Book.list(max:elementsPerPage)
        Long bookAmount = Book.count()
        def pages =  Math.ceil(bookAmount / elementsPerPage).intValue()
        [books: books, pages: pages]
    }

    def booksonpage = {
        Integer page;
        String pageParam = params.page;
        if (!pageParam?.isEmpty() && pageParam?.isInteger() ) {
            page = Integer.valueOf(pageParam)
        } else {
            page = 1
        }
        def elementsPerPage = grailsApplication.config.booksniffer.pages.books
        def offset = elementsPerPage * (page -1)
        def books = Book.list(offset:offset, max:elementsPerPage)
        render books.collect {[bookId:it.id, title: it.title, isbn:it.isbn,language:it.language.title]} as JSON
    }

    def delete = {
        Book.executeUpdate("delete from Book where BookId = :id", [id:params.id])
        redirect(action: 'list')
    }

    def edit = {
        def book = Book.findById(params.id)
        [book: book]
    }

    def doEdit = {
        def book = Book.findById(params.id)
        book.isbn = params.isbn
        book.title = params.title
        book.authors = params.author
        book.publisher = params.publisher
        book.summary = params.summary
        book.language = Language.get(params.language)

        if (book.hasErrors() || !book.save()) {
            render (view: "edit", model:[book: book])
        } else {
            redirect(action: "list")
        }
    }

    def checkByIsbn = {
        render isbnFinderService.getByIsbn(params.isbn) as JSON
    }

    def add = {

    }
    def doAdd = {
        def book = new Book(
                title: params.title,
                isbn: params.isbn,
                authors: params.author,
                publisher: params.publisher,
                summary: params.summary)
        book.language = Language.get(params.language)
        if (book.hasErrors() || !book.save()) {
            render (view: "add", model:[book: book])
        } else {
            redirect(action: "list")
        }
    }
}