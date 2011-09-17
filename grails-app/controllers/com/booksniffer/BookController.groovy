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
        def book = Book.get(params.id)
        [book: book]
    }

    def doEdit = {
        def book = Book.get(params.id)
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
}
