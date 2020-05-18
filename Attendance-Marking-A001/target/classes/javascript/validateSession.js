/**
 * 
 */
function checkRegistration() {
	var regex = /^[a-zA-Z ]{2,30}$/;
	var number = /^[0-9]*$/;
	var mobile = /^\d{10}$/;
	var seDec = document.getElementById("sessiondes").value;
	var skillSet = document.getElementById("skillsets").value;
	var skillSet = document.getElementById("session_date").value;
	
	if (seDec == "") {
		alert('Please Enter Session Description');
		document.getElementById('sessiondes').style.borderColor = "red";
		return false;
		// Admin Password Validation
	} else if (number.test(document.getElementById("sessiondes").value)) {
		alert("Session Description Contains Alphabets only");
		document.getElementById('sessiondes').style.borderColor = "red";
		return false;
	} else if (seDec.length <= 2) {
		alert('Your Session Description is Too Short');
		document.getElementById('sessiondes').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('sessiondes').style.borderColor = "green";
	}
	
	if (skillSet == "") {
		alert('Please Enter Skill Set');
		document.getElementById('skillsets').style.borderColor = "red";
		return false;
		// Admin Password Validation
	} else if (number.test(document.getElementById("skillsets").value)) {
		alert("Skill Set Contains Alphabets only");
		document.getElementById('skillsets').style.borderColor = "red";
		return false;
	} else if (skillSet.length <= 2) {
		alert('Your Skill Set is Too Short');
		document.getElementById('skillsets').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('skillsets').style.borderColor = "green";
	}
}