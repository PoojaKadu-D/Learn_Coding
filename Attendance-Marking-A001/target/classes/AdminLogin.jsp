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
<link rel="stylesheet" href="css/admin-functions.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="javascript/validateLogin.js"></script>
<title>Admin Login</title>
</head>
<body>

	<!--  Navigation-->

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
				<span>
					<h3>${reject_Msg}</h3>
					<h3>${pending_message}</h3>
					<h3>${register_msg}</h3>
				</span>
			</div>

			<!-- <div class="span-message">
				<span>
					
				</span>
			</div>
			<div class="span-message">
				<span>
					
				</span>
			</div> -->

			<div class="centerdiv">

				<img src="images/user.jpg" id="ulogin">

				<form method="get" action="AdminLogin"
					onsubmit="return validateLogin();">
					<!-- onchange="return validateLogin();" -->

					<div class="form-group admin">
						<h2>Admin Login</h2>
					</div>

					<div class="form-group">
						<label for="employeeId">Admin ID</label> <input type="text"
							class="form-control" name="adminid" id="adminid" placeholder="">
						<small id="adminid" class="form-text text-muted">Enter
							your Admin Id.</small>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="adminpassword" name="adminpassword"
							placeholder=""> <small id="adminpassword"
							class="form-text text-muted">Enter your Password.</small>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Remember
							Me</label>

					</div>
					<div>
						<button type="submit" class="btn btn-primary" id="register-btn">LOGIN</button>
					</div>
					<hr>
					<div class="form-group">
						<span> Don't have an Account <a
							href="AdminRegistration.jsp">Register Here</a></span>
					</div>
				</form>

			</div>
		</div>
	</section>
</body>
</html>