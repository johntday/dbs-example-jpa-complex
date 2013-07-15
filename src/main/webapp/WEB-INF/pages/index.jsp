<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>

<i>${message}</i>

<h3>Room</h3>
<ul>
	<li><a href="${pageContext.request.contextPath}/room/create">Create</a></li>
	<li><a href="${pageContext.request.contextPath}/room/list">View all</a></li>
</ul>

<h3>Course</h3>
<ul>
	<li><a href="${pageContext.request.contextPath}/course/create">Create</a></li>
	<li><a href="${pageContext.request.contextPath}/course/list">View all</a></li>
</ul>

<h3>Class</h3>
<ul>
	<li><a href="${pageContext.request.contextPath}/clss/create">Create</a></li>
	<li><a href="${pageContext.request.contextPath}/clss/list">View all</a></li>
</ul>

<h3>Person</h3>
<ul>
	<li><a href="${pageContext.request.contextPath}/person/create">Create</a></li>
	<li><a href="${pageContext.request.contextPath}/person/list">View all</a></li>
</ul>

<h3>Classinstance</h3>
<ul>
	<li><a href="${pageContext.request.contextPath}/classinstance/create">Create</a></li>
	<li><a href="${pageContext.request.contextPath}/classinstance/list">View all</a></li>
</ul>

<hr/>
<img  src="${pageContext.request.contextPath}/static/img/erd.png" alt="Database diagram for MySQL" title="Database diagram for MySQL" /><br/>
<a href="${pageContext.request.contextPath}/static/img/erd-detail.png" title="Database diagram for MySQL">Detailed Diagram for MySQL</a>

</body>
</html>