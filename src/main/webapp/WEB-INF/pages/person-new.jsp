<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>New Person page</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css" type="text/css"/>
	</head>
	<body>
		<h1>New Person page</h1>
		<form:form method="POST" commandName="person" action="${pageContext.request.contextPath}/person/create">
			<table>
				<tbody>
					<tr>
						<td>Person.username *</td>
						<td><form:input path="username" /></td>
						<td><form:errors path="username" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Person.password *</td>
						<td><form:input path="password" /></td>
						<td><form:errors path="password" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Person.firstname *</td>
						<td><form:input path="firstname" /></td>
						<td><form:errors path="firstname" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Person.lastname *</td>
						<td><form:input path="lastname" /></td>
						<td><form:errors path="lastname" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Person.phoneSms</td>
						<td><form:input path="phoneSms" maxlength="10" /></td>
						<td><form:errors path="phoneSms" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Person.email *</td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Person.activeIndicator *</td>
						<td><form:input path="activeIndicator" /></td>
						<td><form:errors path="activeIndicator" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>roles</td>
						<td><form:select path="roles" multiple="true" items="${roleList}" itemValue="id" itemLabel="name" /></td>
						<td><form:errors path="roles" cssStyle="color: red;" /></td>
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