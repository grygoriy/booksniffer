<%@ page import="com.booksniffer.Book" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title><g:message code="book.list.title"/></title>
    <g:javascript library="jquery-1.6.4.min" />
    <g:javascript library="booklist" />
    <link rel="stylesheet" href="${resource(dir:'css',file:'pagination.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css',file:'bookList.css')}" />
</head>

<body>
<div >

 <g:hiddenField name="pages" value="${pages}"/>
 <g:hiddenField name="editValue" value="${message(code: 'edit')} "/>
 <g:hiddenField name="deleteValue" value="${message(code: 'delete')} "/>

<table id="bookListHeader">
    <tr>
        <td id="isbnHeader">${message(code: 'book.isbn')}</td>
        <td id="titleHeader">${message(code: 'book.title')}</td>
        <td id="languageHeader">${message(code: 'book.language')}</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    </table>
    <table id="bookList">
    <g:each in="${books}" var="book">
        <tr>
            <td class="isbnRow">${book.isbn}</td>
            <td class="titleRow">${book.title}</td>
            <td class="languageRow">${book.language.title}</td>
            <td class="editRow"><g:link  action="edit" params="${[id:book.id]}">${message(code: 'edit')} </g:link></td>
            <td class="deleteRow"><g:link  action="delete" params="${[id:book.id]}">${message(code: 'delete')}</g:link></td>
        </tr>
    </g:each>
</table>
<table>
    <tr>
        <td><g:link action="add">${message(code: 'add')}</g:link></td>
    </tr>
</table>

<ul id="pagination"></ul>
</div>
</body>
</html>
