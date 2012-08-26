<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>List of authors</title>
</head>

<decorator:usePage id="theme" />
<body>
	<h2>List of authors</h2>
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