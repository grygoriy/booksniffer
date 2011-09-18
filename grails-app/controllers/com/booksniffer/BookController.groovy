package com.booksniffer

class BookController {
    static defaultAction = "list"

    def list = {
        def books = Book.list()
        [books: books]
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