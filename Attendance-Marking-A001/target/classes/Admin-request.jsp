<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/user-functions.css">
<link rel="stylesheet" href="css/admin-functions.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Admin Request</title>
</head>
<body>
	<header class="headers">

		<!--Navigation-->
		<section id="nav-bar">
			<nav class="navbar navbar-expand-lg navbar-light">
				<a class="navbar-brand" href="#"><img src="images/logo.png"></a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link"
							href="AdminLogin.jsp"></a></li>
						<li class="nav-item"><a class="nav-link"
							href="SuperUser-functions.jsp">USER HOME</a></li>
						<li class="nav-item"><a class="nav-link" href="Logout">LOGOUT</a>
						</li>
					</ul>
				</div>
			</nav>
		</section>
		<section>

			<div class="container ">

				<%
					if (session.getAttribute("name") == null) {
					response.sendRedirect("UserLogin.jsp");
				}
				%>
				<div class="admins">
					<c:if test="${empty adminPendinlist}">
						<h2 id="h21">There is no Pending Request !</h2>
					</c:if>
					<c:if test="${not empty adminPendinlist}">
						<div class="divformat"></div>
						<div class="divformat">
							<h4 id="h41">List of Users</h4>
						</div>
				</div>


				<table class="tables">
					<tr id="head">

						<th>Admin Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Admin Age</th>
						<th>Admin Gender</th>
						<th>Contact Number</th>
						<th>Email Id</th>
						<th>Action</th>

					</tr>

					<c:forEach items="${adminPendinlist}" var="admin">

						<tr>
							<td>${admin.admin_Id}</td>
							<td>${admin.adminFirstName}</td>
							<td>${admin.adminLastName}</td>
							<td>${admin.adminAge}</td>
							<td>${admin.adminGender}</td>
							<td>${admin.adminContactNumber}</td>
							<td>${admin.adminEmailId}</td>
							<td><a class="btn btn-info"
								href="AcceptRequest?admin_Id=${admin.admin_Id}">Accept</a> : <a
								class="btn btn-info"
								href="RejectRequest?admin_Id=${admin.admin_Id}">Reject</a></td>

						</tr>

					</c:forEach>
				</table>
				</c:if>

			</div>

		</section>

	</header>
	<footer class="footer">
		<div>
			<span>
				<h3>Copyright &copy; 2020</h3>
			</span>
		</div>
	</footer>
</body>
</html>