<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<form:form method="POST" commandName="classcomment" action="${pageContext.request.contextPath}/roster/addComment/${roster.id}" >
			<fieldset>
				<legend>Add Classcomment</legend>
				<table>
					<tbody>
						<tr>
							<td>score</td>
							<td><form:input path="score" /></td>
							<td><form:errors path="score" cssStyle="color: red;"/></td>
						</tr>
						<tr>
							<td>comment *</td>
							<td><form:input path="comment" /></td>
							<td><form:errors path="comment" cssStyle="color: red;"/></td>
						</tr>
						<tr>
							<td><input type="submit" value="Create" /></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form:form>