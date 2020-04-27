/**
 * 
 */
function validateFormData(){
	
	//var status = false;
	var nameCheck = /^[a-zA-Z]+$/;
	var priceCheck = /^[0-9]+$/;
	var dateFromat = /^([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/;
	
	var name= document.editForm.title;

	var price= document.editForm.price;
	/*document.forms["editForm"]["price"].value;*/
	
	var active = document.editForm.inStock.value;
	/*var active = document.forms["editform"]["inStock"].value;*/
	
	var date_of_launch = document.editForm.dateOfLaunch;
	
	
	var category1 = document.getElementById("category").value;
	
	var free_delivery = document.editForm.freeDelivery;
	
		
	// validation code for name
	
	if(name.value.match(nameCheck)){
	//	status = true;
		
	}
	else{
		
		alert("Name should contains alphabets only");
	
		
	}
	
	//validation code for price
	
	if(price.value.match(priceCheck)){
		//return true;
	}
	else{
		alert("Price must contains numeric data only");
		
		
	}
	
	//validation for active status
	
	if(active == "Yes"){
		
	}
	else if (active== "No"){
		
	}
	else{
		alert("Active status must be selected");
		
	}
	
	//validation for date of launch
	if(date_of_launch.value.match(dateFromat)){
		
	}
	else{
		alert("Please select correct date format");
	
		
	}
	
	//validation for category
	if(category1==""){
		alert("Category must be selected");	
		
			
	}else{

	}
	

	
	if(free_delivery.checked)
	{
		return true;
	}
	else{
		alert("Select delivery option");
		return false;
	}
	
}