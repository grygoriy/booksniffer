<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of authors</title>
</head>
<body>
	<h2>List of authors</h2>

	<table>
	<c:out value="This is JSTL" />
		<c:forEach var="author" items="${authors}" varStatus="status">
			<tr>
				 <c:out value="${status.count}"/>
				<td><c:out value="${author.authorName}" escapeXml="false" /></td>
				<td><c:out value="${author.authorLastName}" escapeXml="false" /></td>
			</tr>
		</c:forEach>
	</table>

	<table>
		<tr>
			<th>Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach var="author" items="${authors}">
			<tr>
				<td>${author.authorName}</td>
				<td>${author.authorLastName}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>