<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/admin-functions.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="javascript/validateUser.js"></script>
<title>User Login</title>
</head>
<body>

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
					<li class="nav-item active"><a class="nav-link"
						href="home.html">HOME</a></li>

				</ul>
			</div>
		</nav>
	</section>

	<section>
		<div class="bigimg">
			<div class="span-message">
				<span> <%
 	session.getAttribute("name");
 	session.getAttribute("Welcome");
 	session.getAttribute("u_id");
 %>
					<h3>${message}${ userFirstName }${user.user_id}</h3>
					<h3>${error_Message}</h3>
				</span>
			</div>
			<div class="centerdiv">

				<img src="images/user.jpg" id="ulogin">

				<form method="get" action="UserLogin"
					onsubmit="return validateUser();">
					<!-- onchange="return validateUser();" -->
					<div class="form-group">
						<h2>User Login</h2>
					</div>
					<div class="form-group">
						<label for="employeeId">Employee Id</label> <input type="text"
							class="form-control" name="empid" id="empid" placeholder="">
						<small id="empid" class="form-text text-muted">Enter your
							Employee Id.</small>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password" placeholder="">
						<small id="emppassword" class="form-text text-muted">Enter
							your Password.</small>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Remember
							Me</label>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary" id="register-btn">LOGIN</button>
					</div>
					<hr>
					<div class="form-group">
						<span> Don't have Account <a href="UserRegistration.jsp">Register
								Here</a></span>
					</div>
				</form>

			</div>
		</div>
	</section>
</body>
</html>