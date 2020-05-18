<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Functions</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/user-functions.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<header class="header" id="hero">

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
						<li class="nav-item"><a class="nav-link" href="Add-Trainer.jsp">ADD TRAINER</a></li>
						<li class="nav-item"><a class="nav-link" href="Add-Session.jsp">ADD SESSION</a></li>
						<li class="nav-item"><a class="nav-link" href="Add-Skills.jsp">ADD SKILLS</a></li>
						<li class="nav-item"><a class="nav-link" href="Map-Skills.jsp">MAP SKILLS</a></li>
						<li class="nav-item"><a class="nav-link" href="#">LOGOUT</a>
						</li>
					</ul>
				</div>
			</nav>
		</section>
		<section>
			<div class="span-message">
				<span>
					<h3>Welcome Admin ${fName}...</h3>
				</span>
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