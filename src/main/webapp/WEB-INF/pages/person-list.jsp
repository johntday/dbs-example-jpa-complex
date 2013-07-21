<%@page import="com.dbs.training.util.Utils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>Person List page</title>
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css" type="text/css"/>
	</head>
	<body>
		<h1>Person List page</h1>
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
					<th>toString</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="person" items="${personList}">
					<tr>
						<td>${person.id}</td>
						<td>${person.username}</td>
						<td>${person.password}</td>
						<td>${person.firstname}</td>
						<td>${person.lastname}</td>
						<td>${person.phoneSms}</td>
						<td>${person.activeIndicator}</td>
						<td><a href="${pageContext.request.contextPath}/person/tostring/${person.id}">toString</a></td>
						<td>
							<a href="${pageContext.request.contextPath}/person/edit/${person.id}">Edit</a><br/>
							<a href="${pageContext.request.contextPath}/person/delete/${person.id}">Delete</a><br/>
							<a href="${pageContext.request.contextPath}/wip">Show Enrolled Classes</a><br/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<a href="${pageContext.request.contextPath}/">Home page</a>
	</body>
</html>