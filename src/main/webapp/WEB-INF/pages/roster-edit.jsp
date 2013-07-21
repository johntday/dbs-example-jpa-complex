<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>Edit Roster page</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css" type="text/css"/>
	</head>
	<body>
		<h1>Edit Roster page</h1>
		<form:form method="POST" commandName="roster" action="${pageContext.request.contextPath}/roster/edit/${roster.id}" >
			<fieldset>
				<legend>Roster</legend>
				<table>
					<tbody>
						<tr>
							<td>classinstance *</td>
							<td><form:select path="classinstance.id" items="${classinstanceList}" /></td>
							<td><form:errors path="classinstance.id" cssStyle="color: red;"/></td>
						</tr>
						<tr>
							<td>student *</td>
							<td><form:select path="student.id" items="${studentList}" /></td>
							<td><form:errors path="student.id" cssStyle="color: red;"/></td>
						</tr>
						<tr>
							<td>attendanceIndicator *</td>
							<td><form:checkbox path="attendanceIndicator" /></td>
							<td><form:errors path="attendanceIndicator" cssStyle="color: red;"/></td>
						</tr>
						<tr>
							<td><input type="submit" value="Update" /></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form:form>

		<jsp:include page="classcomment-new.jsp"/>
		<jsp:include page="classcomment-list.jsp"/>
		
		<a href="${pageContext.request.contextPath}/">Home page</a>
	</body>
</html>