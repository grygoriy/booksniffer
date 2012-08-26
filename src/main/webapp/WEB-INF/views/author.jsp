<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="sitemesh-decorator" prefix="decorator" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add author</title>
</head>
<decorator:usePage id="theme" />
<body>
	<h2>Adding author</h2>
	<form:form method="post" action="addAuthor.html">

		<table>
			<tr>
				<td><form:label path="authorName">Author Name</form:label></td>
				<td><form:input path="authorName" /></td>
			</tr>
			<tr>
				<td><form:label path="authorLastName">Author Last Name</form:label></td>
				<td><form:input path="authorLastName" /></td>
			</tr>
		<%-- 	<tr>
				<td><form:label path="book">Book Name</form:label></td>
				<td><form:input path="book" /></td>
			</tr> --%>
			<tr>
				<td colspan="2"><input type="submit" value="Submit input" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>