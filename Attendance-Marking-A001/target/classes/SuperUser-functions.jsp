<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Super User Functions</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/user-functions.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
						<li class="nav-item"><a class="nav-link" href="home.html">HOME</a></li>
						<li class="nav-item"><a class="nav-link" href="#">LOGOUT</a>
						</li>
					</ul>
				</div>
			</nav>
		</section>
		<section>
			<div class="page-property">
				<div class="span-message">
					<span>
						<h4>Welcome ${name}...</h4>
					</span>
				</div>
				<div class="centerdiv">

					<div class="icon">
						<a href="AdminRequests"><i class="fa fa-user-circle fa-5x"></i></a>
					</div>
					<br>
					<div class="title">
						<h4>Admin Requests</h4>
					</div>
				</div>

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
