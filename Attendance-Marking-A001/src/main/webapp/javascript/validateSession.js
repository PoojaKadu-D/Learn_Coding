/**
 * 
 */
function checkRegistration() {
	var regex = /^[a-zA-Z ]{2,30}$/;
	var number = /^[0-9]*$/;
	var mobile = /^\d{10}$/;
	var seDec = document.getElementById("sessiondes").value;
	var skillSet = document.getElementById("skillsets").value;
	var s_date = document.getElementById("session_date").value;
	var s_time = document.getElementById("sessiontime").value;
	var a_slots = document.getElementById("a_slots").value;

	if (seDec == "") {
		alert('Please Enter Session Description');
		document.getElementById('sessiondes').style.borderColor = "red";
		return false;
		
	} else if (number.test(document.getElementById("sessiondes").value)) {
		alert("Session Description Contains Alphabet only");
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
	if (s_date == "") {
		alert('Please Enter Date of Session');
		document.getElementById('session_date').style.borderColor = "red";
		return false;
	} else if (!/[12]\d{3}[/\/-](0[1-9]|1[0-2])[/\/-](0[1-9]|[12]\d|3[01])/
			.test(s_date)) {
		alert('Error: Date format: ####/##/##');
		document.getElementById('session_date').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('session_date').style.borderColor = "green";
	}
	if (s_time == "") {
		alert('Please Enter Session Time');
		document.getElementById('sessiontime').style.borderColor = "red";
		return false;
	} else if (/^[a-zA-Z]$/.test(s_time)) {
		alert('Enter Correct Time');
		document.getElementById('sessiontime').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('sessiontime').style.borderColor = "green";
	}
	if (a_slots == "") {
		alert('Please Enter Slot');
		document.getElementById('a_slots').style.borderColor = "red";
		return false;
	} else if (/^[a-zA-Z]$/.test(a_slots)) {
		alert('Enter Correct Slot data-type');
		document.getElementById('a_slots').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('a_slots').style.borderColor = "green";
	}
}