<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/style.css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Montserrat">
<title>Books Store Application</title>
</head>
<body>
	<h1>Book Management</h1>
	<h2>
		<a href="new">Add New Book</a> &nbsp;&nbsp;&nbsp; <a href="list">List All Books</a>
	</h2>
	
	<div class="container">
		<c:if test="${not empty book}">
		<form action="update" method="post">
		</c:if>
	
		<c:if test="${empty book}">
		<form action="insert" method="post">
		</c:if>
			<table border="1" cellpadding="5">
			<caption>
			<h2> 
			<c:if test="${not empty book}">Edit Book </c:if>
			<c:if test="${empty book}"> Add New Book</c:if>
			</h2>
		</caption>
			 <c:if test="${not empty book}">
				<input type="hidden" name="id" value="${book.id}">
			</c:if>
		<tr>
			<th>Title:</th>
			<td>
					<input type="text" name="title" size="40" value="${book.title}">
			</td>
		</tr>
		 <tr>
                <th>Author: </th>
                <td>
                    <input type="text" name="author" size="40" value="${book.author}">
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="5" value="${book.price}" >
                </td>
            </tr>
           
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" >
                </td>
            </tr>
            
		</table>
	</form>
	</div>
</body>
</html>