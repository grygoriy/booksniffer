import com.booksniffer.Language
import com.booksniffer.Book

class BootStrap {

    def init = { servletContext ->
        initLanguages()
    }

    void initLanguages() {
        def english = new Language(LanguageId : 1, title: 'English').save()
        def russian = new Language(LanguageId : 2, title: 'Russian').save()

        new Book(isbn: 1 , title: '11', language: english).save()
        new Book(isbn: 1, title: '22', language: russian).save()
        new Book(isbn: 1, title: '33', language: english).save()
        new Book(isbn: 1, title: '44', language: russian).save()
        new Book(isbn: 1, title: '55', language: english).save()
        new Book(isbn: 1, title: '66', language: english).save()
        new Book(isbn: 1, title: '77', language: russian).save()
        new Book(isbn: 1, title: '88', language: english).save()
        new Book(isbn: 1, title: '99', language: russian).save()
        new Book(isbn: 1, title: '1010', language: english).save()
    }

    def destroy = {
    }
}
