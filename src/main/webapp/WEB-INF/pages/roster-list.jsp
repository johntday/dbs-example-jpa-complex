<%@page import="com.dbs.training.util.Utils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Roster List page</title>
</head>
<body>
<h1>Roster List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
	<th width="50px">id</th>
	<td>username</td>
	<th>password</th>
	<th>firstname</th>
	<th>lastname</th>
	<th>phoneSms</th>
	<th>active</th>
	<th>roles</th>
	<th>toString</th>
	<th width="50px">action</th>
</tr>
</thead>
<tbody>
<c:forEach var="roster" items="${rosterList}">
<tr>
	<td>${roster.id}</td>
	<td>${roster.username}</td>
	<td>${roster.password}</td>
	<td>${roster.firstname}</td>
	<td>${roster.lastname}</td>
	<td>${roster.phoneSms}</td>
	<td>${roster.activeIndicator}</td>
	<td> &nbsp;
		<c:forEach var="role" items="${roster.roles}">
			${role.name} &nbsp;
		</c:forEach>
	</td>
	<td><a href="${pageContext.request.contextPath}/roster/tostring/${roster.id}">toString</a></td>
	<td>
		<a href="${pageContext.request.contextPath}/roster/edit/${roster.id}">Edit</a><br/>
		<a href="${pageContext.request.contextPath}/roster/delete/${roster.id}">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>