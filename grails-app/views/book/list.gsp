<%@ page import="com.booksniffer.Book" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title><g:message code="book.list.title"/></title>
    <g:javascript library="jquery-1.6.4.min" />
    <g:javascript library="jquery.pagination" />
    <g:javascript library="booklist" />
    <link rel="stylesheet" href="${resource(dir:'css',file:'pagination.css')}" />
</head>

<body>
<table>
    <tr>
        <td>${message(code: 'book.isbn')}</td>
        <td>${message(code: 'book.title')}</td>
        <td>${message(code: 'book.language')}</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <g:each in="${books}" var="book">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.language.title}</td>
            <td><g:link  action="edit" params="${[id:book.BookId]}">${message(code: 'edit')} </g:link></td>
            <td><g:link  action="delete" params="${[id:book.BookId]}">${message(code: 'delete')}</g:link></td>
        </tr>
    </g:each>
</table>
<table>
    <tr>
        <td><g:link action="add">${message(code: 'add')}</g:link></td>
    </tr>
</table>
<div id="pagingArea"></div>
</body>
</html>
