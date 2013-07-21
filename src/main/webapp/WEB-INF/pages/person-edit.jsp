<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="com.dbs.training.model.Person"%>
<%@page import="com.dbs.training.model.Role"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>Edit Person page</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.css" type="text/css"/>
	</head>
	<body>
		<h1>Edit Person page</h1>
		<form:form method="POST" commandName="person" action="${pageContext.request.contextPath}/person/edit/${person.id}" >
			<table>
				<tbody>
					<tr>
						<td>username *</td>
						<td><form:input path="username" /></td>
						<td><form:errors path="username" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>password *</td>
						<td><form:input path="password" /></td>
						<td><form:errors path="password" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>firstname *</td>
						<td><form:input path="firstname" /></td>
						<td><form:errors path="firstname" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>lastname *</td>
						<td><form:input path="lastname" /></td>
						<td><form:errors path="lastname" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>phoneSms</td>
						<td><form:input path="phoneSms" maxlength="10" /></td>
						<td><form:errors path="phoneSms" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>email *</td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>activeIndicator *</td>
						<td><form:input path="activeIndicator" /></td>
						<td><form:errors path="activeIndicator" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td>roles</td>
						<td>
						<select id="roles" name="roles" multiple="multiple">
							<% 
								Person p = (Person) request.getAttribute("person");
								List<Role> allroles = (List<Role>) request.getAttribute("roleList");
								Set<Role> myroles = p.getRoles();
								
								for (Role role : allroles) {
									boolean isPicked = false;
									for (Role r : myroles) {
										if (r.getId() == role.getId()) {
											isPicked = true;
											break;
										}
									}
							%>
								<option value="<%=role.getId()%>" <%=(isPicked ? " selected" : "")%>><%=role.getName()%></option>
							<% } %>
						</select>
						</td>
						<td><form:errors path="roles" cssStyle="color: red;"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="Update" /></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</form:form>

		<a href="${pageContext.request.contextPath}/">Home page</a>
	</body>
</html>