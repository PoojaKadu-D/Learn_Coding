
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Login_Success</title>
</head>
<body>
	
	<div class="container">
	<c:if test="${empty data}">
		<h1>Login failed</h1>
	</c:if>
	<c:if test="${not empty data}">
	    <h3>Welcome Admin </h3> 
		<h4>List of Users</h4>
		
	
		
		<table border="1">
		<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Password</th>
		<th>Email Id</th>
		<th>Mobile Number</th>
		<th>Action on Data</th>
		</tr>
		
		<c:forEach items="${userList}" var="data">
		
		<tr>
			<td>${data.id}</td>	
			<td>${data.uname}</td>
			<td>${data.password}</td>
			<td>${data.email}</td>
			<td>${data.mobileno}</td>
			<td><a href="Edit-Servlet?userId=${data.id}">Edit</a>  :  <a href="DeleteServlet?userId=${data.id}">Delete</a></td>
			
		</tr>
		</c:forEach>
		</table>
		</c:if>
		
		<span>If you want to go back<a href="Index.jsp"> Click Here</a></span>
		</div>
		

		
</body>
</html>
