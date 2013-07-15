<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Classinstance page</title>
</head>
<body>
<h1>Edit Classinstance page</h1>
<form:form method="POST" commandName="classinstance" action="${pageContext.request.contextPath}/classinstance/edit/${classinstance.id}" >
<table>
<tbody>
<tr>
	<td>Classinstance.dateTime:</td>
	<td><form:input path="dateTime" /></td>
	<td><form:errors path="dateTime" cssStyle="color: red;"/></td>
</tr>
<tr>
	<td>Classinstance.durationMinutes:</td>
	<td><form:input path="durationMinutes" /></td>
	<td><form:errors path="durationMinutes" cssStyle="color: red;"/></td>
</tr>
<tr>
	<td>Classinstance.note:</td>
	<td><form:textarea path="note" /></td>
	<td><form:errors path="note" cssStyle="color: red;"/></td>
</tr>
<tr>
	<td>Classinstance.clss:</td>
	<td><form:select path="clss.id" items="${clssList}" /></td>
	<td><form:errors path="clss.id" cssStyle="color: red;"/></td>
</tr>
<tr>
	<td>Classinstance.room:</td>
	<td><form:select path="room.id" items="${roomList}" /></td>
	<td><form:errors path="room.id" cssStyle="color: red;"/></td>
</tr>
<tr>
	<td>Classinstance.instructor:</td>
	<td><form:select path="instructor.id" items="${instructorList}" /></td>
	<td><form:errors path="instructor.id" cssStyle="color: red;"/></td>
</tr>
<tr>
	<td><input type="submit" value="Update" /></td>
	<td></td>
	<td></td>
</tr>
</tbody>
</table>
</form:form>
<p>* ==> required field</p>

<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>