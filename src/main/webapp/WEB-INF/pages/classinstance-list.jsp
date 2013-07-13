<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Classinstance List page</title>
</head>
<body>
<h1>Classinstance List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
	<th width="50px">id</th>
	<th>dateTime</th>
	<th>durationMinutes</th>
	<th>note</th>
	<th>clss.course.name</th>
	<th>clss.name</th>
	<th>instructor.username</th>
	<th>room.name</th>
	<th>toString</th>
	<th>action</th>
</tr>
</thead>
<tbody>
<c:forEach var="classinstance" items="${classinstanceList}">
<tr>
	<td>${classinstance.id}</td>
	<td><spring:eval expression="classinstance.dateTime"/></td>
	<td>${classinstance.durationMinutes}</td>
	<td>${classinstance.note}</td>
	<td>${classinstance.clss.course.name}</td>
	<td>${classinstance.clss.name}</td>
	<td>${classinstance.instructor.username}</td>
	<td>${classinstance.room.name}</td>
	<td><a href="${pageContext.request.contextPath}/classinstance/tostring/${classinstance.id}">toString</a></td>
	<td>
		<a href="${pageContext.request.contextPath}/classinstance/edit/${classinstance.id}">Edit</a><br/>
		<a href="${pageContext.request.contextPath}/classinstance/delete/${classinstance.id}">Delete</a><br/>
		<a href="${pageContext.request.contextPath}/wip">Show Roster</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>