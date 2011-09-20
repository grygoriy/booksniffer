<%@ page import="com.booksniffer.Language; com.booksniffer.Book" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
    <g:javascript library="jquery-1.6.4.min" />
    <g:javascript library="bookadd" />
</head>

<body>
<g:hasErrors>
<div class="errors">
    <g:renderErrors/>
</div>
</g:hasErrors>
<g:form name="addBook" action="doAdd">
    <table>
        <tr>
            <td>${message(code: 'book.isbn')}</td>
            <td><g:textField name="isbn" value="${book?.isbn}" /><a id="fillLink" class="click" href="javascript:void(0)">${message(code: 'book.add.fill')}</a></td>
        </tr>
        <tr>
            <td>${message(code: 'book.title')}</td>
            <td><g:textField name="title" value="${book?.title}"/></td>
        </tr>
        <tr>
            <td>${message(code: 'book.language')}</td>
            <td><g:select name="language" value="${book?.language}" from="${Language.list()}" optionValue="title"
                          optionKey="LanguageId"/></td>
        </tr>
        <tr>
            <td>${message(code: 'book.authors')}</td>
            <td><g:textField name="author" value="${book?.authors}"/></td>
        </tr>
        <tr>
            <td>${message(code: 'book.publisher')}</td>
            <td><g:textField name="publisher" value="${book?.publisher}"/></td>
        </tr>
        <tr>
            <td>${message(code: 'book.summary')}</td>
            <td><g:textArea name="summary" value="${book?.summary}" cols="20" rows="30"/></td>
        </tr>
    </table>
<g:submitButton name="Submit" value="${message(code: 'submit')}"/>
</g:form>
</body>
</html>
