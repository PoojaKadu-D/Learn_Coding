<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/user-functions.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>User Home</title>
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
						<li class="nav-item"><a class="nav-link" href="#"></a></li>
						<li class="nav-item"><a class="nav-link" href="AvaSessions"></a>
						</li>
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
			if (session.getAttribute("name") == null && session.getAttribute("Welcome") == null
					&& session.getAttribute("u_id") == null) {
				response.sendRedirect("UserLogin.jsp");
			}
			%>
			<p id="p1">${Welcome}${name }</p>

			<div class="functions">
				<div id="i1">

					<img src="images/s2.png"> <br> <a
						href="AvaSessions?UserId=${user.user_id}">
						<h3>Available Session</h3>
					</a>
				</div>

				<div id="i2">

					<img src="images/n.png"> <br> <a href="AvaNotification">
						<h3>Notification</h3>
					</a>
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