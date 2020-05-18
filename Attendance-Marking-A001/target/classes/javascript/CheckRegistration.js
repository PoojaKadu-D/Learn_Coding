
function CheckRegistration(){
	
var form = document.getElementById('registrationForm');
const fName= document.getElementById('empfname1');
const lName= document.getElementById('emplname');
const email = document.getElementById('email1');
const password = document.getElementById('password');


form.addEventListener('submit', e => {
	e.preventDefault();
	
	checkInputs();
});

function checkInputs() {
	// trim to remove the whitespaces
	var nameCheck = /^[a-zA-Z]+$/;
	const usernameValue1 = fName.value.trim();
	const usernameValue2 = lName.value.trim();
	const emailValue = email.value.trim();
	const passwordValue = password.value.trim();
	
	if(usernameValue1 === '' && usernameValue1 !=nameCheck) {
		setErrorFor(fName, 'First name cannot be blank');
	} else {
		setSuccessFor(fName);
	}
	if(usernameValue2 === '' && usernameValue2 !=nameCheck) {
		setErrorFor(lName, 'Last name cannot be blank');
	} else {
		setSuccessFor(lName);
	}
	
	
	if(emailValue === '') {
		setErrorFor(email, 'Email cannot be blank');
	} else if (!isEmail(emailValue)) {
		setErrorFor(email, 'Not a valid email');
	} else {
		setSuccessFor(email);
	}
	
	if(passwordValue === '') {
		setErrorFor(password, 'Password cannot be blank');
	} else {
		setSuccessFor(password);
	}
	
	/*if(password2Value === '') {
		setErrorFor(password2, 'Password2 cannot be blank');
	} else if(passwordValue !== password2Value) {
		setErrorFor(password2, 'Passwords does not match');
	} else{
		setSuccessFor(password2);
	}*/
}

function setErrorFor(input, message) {
	const formControl = input.parentElement;
	const small = formControl.querySelector('small');
	formControl.className = 'form-control error';
	small.innerText = message;
}

function setSuccessFor(input) {
	const formControl = input.parentElement;
	formControl.className = 'form-control success';
}
	
function isEmail(email) {
	return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

}
