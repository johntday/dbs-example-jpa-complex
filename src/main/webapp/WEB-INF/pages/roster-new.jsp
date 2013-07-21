<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>New Roster page</title>
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css" type="text/css"/>
	</head>
	<body>
		<h1>New Roster page</h1>
		<form:form method="POST" commandName="roster" action="${pageContext.request.contextPath}/roster/create">
			<table>
				<tbody>
					<tr>
						<td>Roster.classinstance *</td>
						<td><form:select path="classinstance.id" items="${classinstanceList}" /></td>
						<td><form:errors path="classinstance.id" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Roster.student *</td>
						<td><form:select path="student.id" items="${studentList}" /></td>
						<td><form:errors path="student.id" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Roster.attendanceIndicator *</td>
						<td><form:checkbox path="attendanceIndicator" /></td>
						<td><form:errors path="attendanceIndicator" cssStyle="color: red;" /></td>
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