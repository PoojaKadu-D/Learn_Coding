/**
 * 
 */
function validateSkills(){
	
	var number = /^[0-9]*$/;
	var skill_type = document.getElementById("skill_type").value;
	var S_Descr = document.getElementById("S_Descr").value;
	
	if (skill_type == "") {
		alert('Please Enter Skill Type');
		document.getElementById('skill_type').style.borderColor = "red";
		return false;
		
	} else if (number.test(document.getElementById("skill_type").value)) {
		alert("Skill Type Contains Alphabet only");
		document.getElementById('skill_type').style.borderColor = "red";
		return false;
	} else if (skill_type.length <= 2) {
		alert('Skill Type is Too Short');
		document.getElementById('skill_type').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('skill_type').style.borderColor = "green";
	}
	
	if (S_Descr == "") {
		alert('Please Enter Skill Description');
		document.getElementById('S_Descr').style.borderColor = "red";
		return false;
		
	} else if (number.test(document.getElementById("S_Descr").value)) {
		alert("Skill Description Contains Alphabet only");
		document.getElementById('S_Descr').style.borderColor = "red";
		return false;
	} else if (S_Descr.length <= 2) {
		alert('Skill Description is Too Short');
		document.getElementById('S_Descr').style.borderColor = "red";
		return false;
	} else {
		document.getElementById('S_Descr').style.borderColor = "green";
	}
}