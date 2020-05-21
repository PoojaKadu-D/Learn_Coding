/**
 * 
 */
function validateUser() {
	var regex = /^[a-zA-Z ]{2,30}$/;
	var number = /^[0-9]*$/;
	var passwordR = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
	var emplid = document.getElementById('empid').value;
	var password = document.getElementById('password').value;

	// Admin Id validation
	if (emplid == "") {
		alert('Please Enter User Id');
		document.getElementById('empid').style.borderColor = "red";
		return false;
		// Admin Password Validation
	} else if (emplid.length < 0) {
		alert('Your id is too short');
		document.getElementById('empid').style.borderColor = "red";
		return false;
	} else if (!number.test(emplid)) {
		alert('Id should contains numbers only!');
		document.getElementById('empid').style.borderColor = "red";
		return false;
	} else if (emplid == 0) {
		alert('Id greater than Zero!');
		document.getElementById('empid').style.borderColor = "red";
		return false;
	}

	else if (password == "") {
		alert('Please Enter User Password');
		document.getElementById('password').style.borderColor = "red";
		return false;

	} else if (password.length < 7) {
		alert('Your Password is too short');
		document.getElementById('password').style.borderColor = "red";
		return false;
	} else if (!passwordR.test(password)) {
		alert('Please Enter Correct User Password');
		document.getElementById('password').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('empid').style.borderColor = "green";
		document.getElementById('password').style.borderColor = "green";

	}
}

function validateUserReg() {

	var pattern = "^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$";
	var passwordR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})";
	var empfname = document.getElementById('empfname').value;
	var emplname = document.getElementById('emplname').value;
	var email = document.getElementById('email').value;
	var password = document.getElementById('password').value;
	var date = document.getElementById('date').value;
	var contactNumber = document.getElementById('contact').value;

	if (empfname == "") {
		alert('Please Enter First Name');
		document.getElementById('empfname').style.borderColor = "red";
		return false;
	} else if (/^[0-9]+$/.test(document.getElementById("empfname").value)) {
		alert("First Name Contains Numbers!");
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
		alert('Please Last First Name');
		document.getElementById('emplname').style.borderColor = "red";
		return false;
	} else if (/^[0-9]+$/.test(document.getElementById("emplname").value)) {
		alert("Last Name Contains Numbers!");
		document.getElementById('emplname').style.borderColor = "red";
		return false;
	} else if (emplname.length <= 2) {
		alert('Your Name is To Short');
		document.getElementById('emplname').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('emplname').style.borderColor = "green";
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
	if (password == "") {
		alert('Enter Your Password');
		document.getElementById('password').style.borderColor = "red";
		return false;
	}
	else if (password.length < 7) {
		alert('Your Password is too short');
		document.getElementById('password').style.borderColor = "red";
		return false;
	} else if (!/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/
			.test(password)) {
		alert('Please Enter Correct Password');
		document.getElementById('password').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('password').style.borderColor = "green";
	}
	
	if (date == "") {
		alert('Please Enter Date of Birth');
		document.getElementById('date').style.borderColor = "red";
		return false;
	} else if (!/[12]\d{3}[/\/-](0[1-9]|1[0-2])[/\/-](0[1-9]|[12]\d|3[01])/
			.test(date)) {
		alert('Error: Date format:  ####/##/##');
		document.getElementById('date').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('date').style.borderColor = "green";
	}

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

}
