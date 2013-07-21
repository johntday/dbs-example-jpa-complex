<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Classcomment</h2>

<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
	<thead>
		<tr>
			<th width="50px">id</th>
			<th>comment</th>
			<th>score</th>
			<th width="50px">action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="classcomment" items="${roster.comments}">
			<tr>
				<td>${classcomment.id}</td>
				<td>${classcomment.comment}</td>
				<td>${classcomment.score}</td>
				<td>
					<a href="${pageContext.request.contextPath}/classcomment/edit/${classcomment.id}">Edit</a><br/>
					<a href="${pageContext.request.contextPath}/classcomment/delete/${classcomment.id}">Delete</a><br/>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>