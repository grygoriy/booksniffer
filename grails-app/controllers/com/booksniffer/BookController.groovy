package com.booksniffer

import grails.converters.JSON
import org.apache.commons.lang.StringUtils
import org.hibernate.FetchMode

class BookController {
    static defaultAction = "list"

    def list = {
        def elementsPerPage = grailsApplication.config.booksniffer.pages.books
        def books = Book.list(max:elementsPerPage)
        Long bookAmount = Book.count()
        def pages = (bookAmount / elementsPerPage).longValue()
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
        def book = Book.findByBookId(params.id)
        [book: book]
    }

    def doEdit = {
        def book = Book.findByBookId(params.id)
        book.isbn = params.isbn
        book.title = params.title
        book.language = Language.get(params.language)
        if (book.hasErrors() || !book.save()) {
            render (view: "edit", model:[book: book])
        } else {
            redirect(action: "list")
        }
    }

    def add = {

    }
    def doAdd = {
        def book = new Book(title: params.title, isbn: params.isbn)
        book.language = Language.get(params.language)
        book.BookId = UUID.randomUUID().toString()
        book.save()
        redirect(action: 'list')
    }
}