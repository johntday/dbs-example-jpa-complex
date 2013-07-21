<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>Course List page</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css" type="text/css"/>
	</head>
	<body>
		<h1>Course List page</h1>
		<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
			<thead>
				<tr>
					<th width="50px">id</th>
					<th>code</th>
					<th>name</th>
					<th>description</th>
					<th>toString</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courseList}">
					<tr>
						<td>${course.id}</td>
						<td>${course.code}</td>
						<td>${course.name}</td>
						<td>${course.description}</td>
						<td><a href="${pageContext.request.contextPath}/course/tostring/${course.id}">toString</a></td>
						<td>
							<a href="${pageContext.request.contextPath}/course/edit/${course.id}">Edit</a><br/>
							<a href="${pageContext.request.contextPath}/course/delete/${course.id}">Delete</a><br/>
							<a href="${pageContext.request.contextPath}/wip">Show Classes</a><br/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<a href="${pageContext.request.contextPath}/">Home page</a>
	</body>
</html>