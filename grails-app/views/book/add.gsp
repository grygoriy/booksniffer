<%@ page import="com.booksniffer.Language; com.booksniffer.Book" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<div class="errors">
    <g:renderErrors/>
</div>
<g:form name="addBook" action="doAdd">
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
<g:submitButton name="Submit" value="${message(code: 'submit')}"/>
</g:form>
</body>
</html>
