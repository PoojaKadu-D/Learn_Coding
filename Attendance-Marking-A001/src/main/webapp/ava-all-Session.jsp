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
<title>Session Details</title>
</head>
<body>
	<header class="header">

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
						<li class="nav-item"><a class="nav-link" href="#"></a></li>
						<li class="nav-item"><a class="nav-link" href="Logout">LOGOUT</a>
						</li>
					</ul>
				</div>
			</nav>
		</section>
		<section>
			<%
				//response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
			if (session.getAttribute("name") == null && session.getAttribute("id") == null) {
				response.sendRedirect("UserLogin.jsp");
			}
			%>
			<div class="container">
				<c:if test="${empty session}">
					<h2 id="h21">
						Session enrolled by user successfully
						</h1>
				</c:if>
				<c:if test="${not empty session}">
					<div class="divformat">
						<h3></h3>
					</div>
					<div class="divformat">
						<h4 id="h41">Session Details</h4>
					</div>

					<table class="tables">
						<tr id="head">
							<th>Session Id</th>
							<th>Session Description</th>
							<th>Skill Set</th>
							<th>Session Date</th>
							<th>Session Time</th>
							<th>Available Slots</th>
							<th>Action</th>
						</tr>
						<tr>
							<td>${session.session_Id}</td>
							<td>${session.session_Description}</td>
							<td>${session.session_SkillSet}</td>
							<td>${session.session_Date}</td>
							<td>${session.session_time}</td>
							<td>${session.available_Slot}</td>
							<td><a class="btn btn-info"
								href="EnrollSession?Session_Id=${session.session_Id}&UserId=${u_id}">Enroll</a></td>
						</tr>
					</table>
				</c:if>
				<input type="hidden" name="id" value="UserId=${user.user_id}">
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