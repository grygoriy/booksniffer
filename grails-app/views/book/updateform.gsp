<table>
    <tr>
        <td>${message(code: 'book.isbn')}</td>
        <td><g:textField name="isbn" value="${book.isbn}" /></td>
    </tr>
    <tr>
        <td>${message(code: 'book.title')}</td>
        <td><g:textField name="title" value="${book.title}"/></td>
    </tr>
    <tr>
        <td>${message(code: 'book.language')}</td>
        <td><g:select name="language" value="${book.language}" from="${Language.list()}" optionValue="title"
                      optionKey="LanguageId"/></td>
    </tr>
</table>
