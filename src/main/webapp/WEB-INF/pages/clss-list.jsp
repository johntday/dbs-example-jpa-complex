<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Clss List page</title>
</head>
<body>
<h1>Clss List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
	<th width="50px">id</th>
	<td>course.code</td>
	<th>code</th>
	<th>name</th>
	<th>description</th>
	<th width="50px">action</th>
</tr>
</thead>
<tbody>
<c:forEach var="clss" items="${clssList}">
<tr>
	<td>${clss.id}</td>
	<td>${clss.course.code}</td>
	<td>${clss.code}</td>
	<td>${clss.name}</td>
	<td>${clss.description}</td>
	<td>
		<a href="${pageContext.request.contextPath}/clss/edit/${clss.id}">Edit</a><br/>
		<a href="${pageContext.request.contextPath}/clss/delete/${clss.id}">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>