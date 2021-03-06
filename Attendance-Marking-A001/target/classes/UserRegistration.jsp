<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/registration.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="javascript/validateUser.js"></script>
<title>User Registration</title>
</head>

<body>

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
					<li class="nav-item active"><a class="nav-link"
						href="UserLogin.jsp">USER LOGIN</a></li>

				</ul>
			</div>
		</nav>
	</section>
	<section>
		<div class="bigimg">

			<div class="centerdiv">

				<img src="images/user.jpg" id="ulogin">
				<!-- onchange="return validateUserReg();" -->
				<form method="get" id="registrationForm" action="UserRegistration"
					onsubmit="return validateUserReg();">

					<div class="form-group">
						<h2>User Registration</h2>
					</div>
					<div class="side-label">
						<div class="form-group">
							<label for="empfname">First Name</label><input type="text"
								class="form-control" name="empfname" id="empfname"
								placeholder="for ex. Pooja">
						</div>

						<div class="form-group ">
							<label for="emplname">Last Name</label><input type="text"
								class="form-control" name="emplname" id="emplname"
								placeholder="for ex. Kadu">
						</div>
					</div>

					<div class="form-group">
						<label for="employeeId">Email</label> <input type="text"
							class="form-control" name="email" id="email"
							placeholder="for ex. root@gmail.com">
					</div>

					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" name="password" id="password"
							placeholder="for ex. Root@123">

					</div>
					<div class="form-group">

						<label for="dob">Date of Birth</label> <input type='text'
							class="form-control" id='date' name="date"
							placeholder="YYYY/MM/DD">

					</div>


					<div class=" form-group">
						<div>
							<label for="userage">Gender</label>
						</div>
						<div class="radiobutton">
							<div class="form-check ">
								<input class="form-check-input" type="radio" name="gender"
									id="gender_fmale" value="Female"> <label
									class="form-check-label" for="exampleRadios1"> Female </label>
							</div>
							<div class="form-check gender-two ">
								<input class="form-check-input" type="radio" name="gender"
									id="gender_male" value="Male"> <label
									class="form-check-label" for="exampleRadios1"> Male </label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="contact">Contact Number</label> <input type="text"
							class="form-control" name="contact" id="contact"
							placeholder="for ex 88######99">
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Remember
							Me</label>

					</div>

					<br>
					<div>
						<button type="submit" class="btn btn-primary" id="register-btn">SUBMIT</button>

					</div>
				</form>

			</div>
		</div>
	</section>
</body>
</html>