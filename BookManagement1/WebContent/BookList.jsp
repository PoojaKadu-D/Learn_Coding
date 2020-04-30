<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Montserrat" >
<title>Books Store Application</title>
</head>
<body>
	<h1>Book Management</h1>
	<h2>
	<a href="new">Add New Book</a> &nbsp;&nbsp;&nbsp; <a href="list">List All Books</a>
	</h2>
	
	<div class="container">
		<table border="1" cellpadding="5">
			<caption><h3>List of Books</h3>	</caption>
			
			<tr>
			<th>ID</th>
			<th>TITLE</th>
			<th>AUTHOR</th>
			<th>PRICE</th>
			<th>ACTION</th>
			</tr>
		
			<c:forEach var="book" items="${booklist}">
			<tr>
			<td><c:out value='${book.id}'/></td>
			<td><c:out value="${book.title}"/></td>
			<td><c:out value="${book.author}"/></td>
			<td><c:out value="${book.price}"/></td>
			<td><a href="edit?id=${book.id}">Edit</a>  :  <a href="delete?id=${book.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>