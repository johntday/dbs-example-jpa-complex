<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>Edit Classinstance page</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css" type="text/css"/>
	</head>
	<body>
		<h1>Edit Classinstance page</h1>
		<form:form method="POST" commandName="classcomment" action="${pageContext.request.contextPath}/classcomment/edit/${classcomment.id}" >
			<fieldset>
				<legend>Classcomment</legend>
				<table>
					<tbody>
						<tr>
							<td>score</td>
							<td><form:input path="score" /></td>
							<td><form:errors path="score" cssStyle="color: red;"/></td>
						</tr>
						<tr>
							<td>comment *</td>
							<td><form:textarea path="comment" /></td>
							<td><form:errors path="comment" cssStyle="color: red;"/></td>
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
		
		<a href="${pageContext.request.contextPath}/">Home page</a>
	</body>
</html>