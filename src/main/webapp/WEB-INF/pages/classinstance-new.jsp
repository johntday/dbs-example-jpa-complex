<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>New Classinstance page</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css" type="text/css"/>
	</head>
	<body>
		<h1>New Classinstance page</h1>
		<form:form method="POST" commandName="classinstance" action="${pageContext.request.contextPath}/classinstance/create" >
			<table>
				<tbody>
					<tr>
						<td>Classinstance.dateTime *</td>
						<td><form:input path="dateTime" /></td>
						<td><form:errors path="dateTime" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>Classinstance.durationMinutes *</td>
						<td><form:input path="durationMinutes" /></td>
						<td><form:errors path="durationMinutes" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>Classinstance.note</td>
						<td><form:textarea path="note" /></td>
						<td><form:errors path="note" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>Classinstance.clss *</td>
						<td><form:select path="clss.id" items="${clssList}" /></td>
						<td><form:errors path="clss.id" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>Classinstance.room *</td>
						<td><form:select path="room.id" items="${roomList}" /></td>
						<td><form:errors path="room.id" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>Classinstance.instructor *</td>
						<td><form:select path="instructor.id" items="${instructorList}" /></td>
						<td><form:errors path="instructor.id" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="Create" /></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<a href="${pageContext.request.contextPath}/">Home page</a>
	</body>
</html>