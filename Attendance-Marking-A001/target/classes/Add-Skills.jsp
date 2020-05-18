<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/add.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="javascript/validateSkills.js"></script>
<title>Adding Skills</title>
</head>
<body>
	<header>
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
							href="Admin-Home.jsp">ADMIN HOME</a></li>
						<li class="nav-item active"><a class="nav-link" href="#">LOGOUT</a></li>


					</ul>
				</div>
			</nav>
		</section>
		<section>
			<div class="bigimga">
				<div class="span-message">
					<span>
						<h3>${message}</h3>
					</span>
				</div>
				<div class="centerdivs">

					<img src="images/s1s.png" id="ulogins">

					<form method="get" action="AddTrainer"
						onsubmit="return checkRegistration();">

						<div class="form-group H2">
							<h2>Skill Details</h2>
						</div>
						<div class="form-group">
							<label for="skill_type">Skill Type</label><input type="text"
								class="form-control" name="skill_type" id="skill_type"
								placeholder="Skill Type">
						</div>
						<div class="form-group">
							<label for="S-Desc">Skill Description</label> <input type="text"
								class="form-control" name="S-Descr" id="S-Descr"
								placeholder="Skill Description">
						</div>
						
						<br>
						<div>
							<button type="submit" class="btn btn-primary" id="register-btn">SUBMIT</button>

						</div>
						
					</form>

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