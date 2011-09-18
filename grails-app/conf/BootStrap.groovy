import com.booksniffer.Language
import com.booksniffer.Book

class BootStrap {

    def init = { servletContext ->
        initLanguages()
    }

    void initLanguages() {
        def english = new Language(LanguageId : 1, title: 'English').save()
        def russian = new Language(LanguageId : 2, title: 'Russian').save()

        1.upto(100) {
            new Book(isbn: it, title: "$it", language: english).save()
        }
    }

    def destroy = {
    }
}
