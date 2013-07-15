<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Roster page</title>
</head>
<body>
<h1>Edit Roster page</h1>
<form:form method="POST" commandName="roster" action="${pageContext.request.contextPath}/roster/edit/${roster.id}" >
<table>
<tbody>
<tr>
	<td>Roster.classinstance</td>
	<td><form:select path="classinstance.id" items="${classinstanceList}" /></td>
	<td><form:errors path="classinstance.id" cssStyle="color: red;"/></td>
</tr>
<tr>
	<td>Roster.student</td>
	<td><form:select path="student.id" items="${studentList}" /></td>
	<td><form:errors path="student.id" cssStyle="color: red;"/></td>
</tr>
<tr>
	<td>Roster.attendanceIndicator</td>
	<td><form:input path="attendanceIndicator" /></td>
	<td><form:errors path="attendanceIndicator" cssStyle="color: red;"/></td>
</tr>
<tr>
	<td><input type="submit" value="Create" /></td>
	<td></td>
	<td></td>
</tr>
</tbody>
</table>
</form:form>
<p>* ==> required field</p>

<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
	<th width="50px">id</th>
	<th>comment</th>
	<th>score</th>
	<th width="50px">action</th>
</tr>
</thead>
<tbody>
<c:forEach var="classcomment" items="${comments}">
<tr>
	<td>${classcomment.id}</td>
	<td>${classcomment.comment}</td>
	<td>${classcomment.score}</td>
	<td>
		<a href="${pageContext.request.contextPath}/classcomment/create/${roster.id}">Create</a><br/>
		<a href="${pageContext.request.contextPath}/classcomment/edit/${classcomment.id}">Edit</a><br/>
		<a href="${pageContext.request.contextPath}/classcomment/delete/${classcomment.id}">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>


<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>