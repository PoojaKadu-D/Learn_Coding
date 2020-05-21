/**
 * 
 */

function validateLogin() {
	var regex = /^[a-zA-Z ]{2,30}$/;
	var number = /^[0-9]*$/;
	var passwordR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})"
	var adminid = document.getElementById('adminid').value;
	var password = document.getElementById('adminpassword').value;

	// Admin Id validation
	if (adminid == "") {
		alert('Please Enter Admin Id');
		document.getElementById('adminid').style.borderColor = "red";
		return false;
		// Admin Password Validation
	} else if (adminid.length < 0 && adminid != 0) {
		alert('Your id is too short');
		document.getElementById('adminid').style.borderColor = "red";
		return false;
	} else if (!number.test(adminid)) {
		alert('Id should contains number only!');
		document.getElementById('adminid').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('adminid').style.borderColor = "green";
	}

	if (password == "") {
		alert('Please Enter  Admin Password');
		document.getElementById('adminpassword').style.borderColor = "red";
		return false;

	} else if (password.length < 7) {
		alert('Your Password is too short');
		document.getElementById('adminpassword').style.borderColor = "red";
		return false;
	} else if (!passwordR.test(password)) {
		alert('Please Enter Correct Admin Password');
		document.getElementById('adminpassword').style.borderColor = "red";
		return false;
	} else {

		document.getElementById('adminpassword').style.borderColor = "green";

	}

}
// Admin Registration Validation

function validateAdminReg() {
	var pattern = "^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$";
	var passwordR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})";
	// var dateformat = "/([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/";
	// var dateformat = "/([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/";
	// var patt = new RegExp("[12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])");

	var empfname = document.getElementById('empfname').value;
	var emplname = document.getElementById('emplname').value;
	// var gender = document.getElementById('gender').value;
	var date = document.getElementById('date').value;
	var contactNumber = document.getElementById('contact').value;
	var password = document.getElementById("password").value;
	var email = document.getElementById("email").value;

	if (empfname == "") {
		alert('Please Enter First Name');
		document.getElementById('empfname').style.borderColor = "red";
		return false;
	} else if (/^[0-9]*$/.test(document.getElementById("empfname").value)) {
		alert("First Name Contains Alphabets!");
		document.getElementById('empfname').style.borderColor = "red";
		return false;
	} else if (empfname.length <= 2) {
		alert('Your Name is To Short');
		document.getElementById('empfname').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('empfname').style.borderColor = "green";
	}

	if (emplname == "") {
		alert('Please Enter Last Name');
		document.getElementById('emplname').style.borderColor = "red";
		return false;
	} else if (/^[0-9]*$/.test(document.getElementById("emplname").value)) {
		alert("Last Name Contains Alphabets!");
		document.getElementById('emplname').style.borderColor = "red";
		return false;
	} else if (emplname.length <= 2) {
		alert('Your Name is To Short');
		document.getElementById('emplname').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('emplname').style.borderColor = "green";
	}

	if (date == "") {
		alert('Please Enter Date of Birth');
		document.getElementById('date').style.borderColor = "red";
		return false;
	} else if (!/[12]\d{3}[/\/-](0[1-9]|1[0-2])[/\/-](0[1-9]|[12]\d|3[01])/
			.test(date)) {
		alert('Error: Date format: ####/##/##');
		document.getElementById('date').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('date').style.borderColor = "green";
	}
	/*
	 * if (date == "") { alert('Please Enter Your Age');
	 * document.getElementById('ageadmin').style.borderColor = "red"; return
	 * false; } else if (ageadmin == 0) { alert('Age is not Zero');
	 * document.getElementById('ageadmin').style.borderColor = "red"; return
	 * false; } else if
	 * (!/^[0-9]*$/.test(document.getElementById("ageadmin").value)) {
	 * alert('Please Enter Valid Age');
	 * document.getElementById('ageadmin').style.borderColor = "red"; return
	 * false; } else { document.getElementById('ageadmin').style.borderColor =
	 * "green"; }
	 */

	if (document.getElementById("gender_male").checked == false
			&& document.getElementById("gender_fmale").checked == false) {
		alert('Please Select Your Gender');
		return false;
	}

	if ((contactNumber == "") || (!/^\d{10}$/.test(contactNumber))) {
		alert('Please Enter Your Contact number');
		document.getElementById('contact').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('contact').style.borderColor = "green";
	}

	if (password == "") {
		alert('Please Enter  Admin Password');
		document.getElementById('password').style.borderColor = "red";
		return false;

	} else if (password.length < 7) {
		alert('Your Password is too short');
		document.getElementById('password').style.borderColor = "red";
		return false;
	} else if (!/(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/
			.test(password)) {
		alert('Please Enter Correct Admin Password');
		document.getElementById('password').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('password').style.borderColor = "green";
	}

	if (email == "") {
		alert('Please Enter Email');
		document.getElementById('email').style.borderColor = "red";
		return false;
	}
	if (email.indexOf('@') <= 0) {
		alert('**Invalid Email');
		document.getElementById('email').style.borderColor = "red";
		return false;
	}
	if ((email.charAt(email.length - 4) != '.')
			&& (email.charAt(email.length - 3) != '.')) {
		alert('**Invalid Email');
		document.getElementById('email').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('email').style.borderColor = "green";
	}

}
