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
			<th>Value</th>
			<th>Square</th>
		</tr>
		<c:forEach var="x" begin="0" end="18" step="2">
			<tr>
				<td><c:out value="${x}" /></td>
				<td><c:out value="${x * x}" /></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>