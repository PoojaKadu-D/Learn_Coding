/**
 * 
 */
function checkRegistration() {
	var regex = /^[a-zA-Z ]{2,30}$/;
	var number = /^[0-9]*$/;
	var mobile = /^\d{10}$/;
	var trName = document.getElementById("trainer_name").value;
	var trainer_contact = document.getElementById("Trainer_Contact").value;
	var t_email = document.getElementById("t_email").value;
	var Skillset = document.getElementById("Skillset").value;
	var experiences = document.getElementById("experiences").value;

	if (trName == "") {
		alert('Please Enter Name');
		document.getElementById('trainer_name').style.borderColor = "red";
		return false;
		// Admin Password Validation
	} else if (number.test(document.getElementById("trainer_name").value)) {
		alert("Name Contains Alphabets only");
		document.getElementById('trainer_name').style.borderColor = "red";
		return false;
	} else if (trName.length <= 2) {
		alert('Your Name is Too Short');
		document.getElementById('trainer_name').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('trainer_name').style.borderColor = "green";
	}

	if (trainer_contact == "") {
		alert('Please Enter Contact Number');
		document.getElementById('Trainer_Contact').style.borderColor = "red";
		return false;
	} else if (!mobile.test(trainer_contact)) {
		alert('Please Enter Correct Contact Number');
		document.getElementById('Trainer_Contact').style.borderColor = "red";
		return false;

	} else {
		document.getElementById('Trainer_Contact').style.borderColor = "green";
	}

	if (t_email == "") {
		alert('Please Enter Email');
		document.getElementById('t_email').style.borderColor = "red";
		return false;
	}
	if (t_email.indexOf('@') <= 0) {
		alert('**Invalid @ position');
		document.getElementById('t_email').style.borderColor = "red";
		return false;
	}
	if ((t_email.charAt(t_email.length - 4) != '.')
			&& (t_email.charAt(t_email.length - 3) != '.')) {
		alert('**Invalid . position');
		document.getElementById('t_email').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('t_email').style.borderColor = "green";
	}

	if (Skillset == "") {
		alert('Please Enter Skills');
		document.getElementById('Skillset').style.borderColor = "red";
		return false;
	} else if (Skillset.length <= 3) {
		alert(' Length is Too Short');
		document.getElementById('Skillset').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('Skillset').style.borderColor = "green";
	}
	
	
	if (experiences == "") {
		alert('Enter Your Experience');
		document.getElementById('experiences').style.borderColor = "red";
		return false;
	}else if(!number.test(document.getElementById("experiences").value)){
		alert( 'Experience Contains Number Only!');
		document.getElementById('experiences').style.borderColor = "red";
		return false;
	}else{
		document.getElementById('experiences').style.borderColor = "green";
	}
}