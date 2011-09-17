<%@ page import="com.booksniffer.Book" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a>
    </span>
    <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label"
                                                                           args="[entityName]"/></g:link></span>
</div>

<div class="body">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${bookInstance}">
        <div class="errors">
            <g:renderErrors bean="${bookInstance}" as="list"/>
        </div>
    </g:hasErrors>
    <g:form action="save">
        <div class="dialog">
            <table>
                <tbody>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="isbn"><g:message code="book.isbn.label" default="Isbn"/></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: bookInstance, field: 'isbn', 'errors')}">
                        <g:textField name="isbn" value="${bookInstance?.isbn}"/>
                    </td>
                </tr>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="title"><g:message code="book.title.label" default="Title"/></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: bookInstance, field: 'title', 'errors')}">
                        <g:textField name="title" value="${bookInstance?.title}"/>
                    </td>
                </tr>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="bookId"><g:message code="book.bookId.label" default="Book Id"/></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: bookInstance, field: 'bookId', 'errors')}">
                        <g:textField name="bookId" value="${fieldValue(bean: bookInstance, field: 'bookId')}"/>
                    </td>
                </tr>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="language"><g:message code="book.language.label" default="Language"/></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: bookInstance, field: 'language', 'errors')}">
                        <g:select name="language.id" from="${com.booksniffer.Language.list()}" optionKey="id"
                                  value="${bookInstance?.language?.id}"/>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>

        <div class="buttons">
            <span class="button"><g:submitButton name="create" class="save"
                                                 value="${message(code: 'default.button.create.label', default: 'Create')}"/></span>
        </div>
    </g:form>
</div>
</body>
</html>
