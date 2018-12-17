/**
 * 
 */

function getContextPath() {
	 return window.location.pathname.substring(0, window.location.pathname
	 .indexOf("/", 2));
}
$(document).ready(function() {
	
	
	 $('#user_date_birth').datetimepicker({
			format: 'DD-MM-YYYY'
		});
	 
	 $("#user_mobile_no").keydown(function(event) {
		    if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 ) && (event.keyCode !=8 &&event.keyCode !=46)) {
		        event.preventDefault(); 
		    }  

		});
});


function saveUserDetails(){
	 if($("#user_first_name").val()=="" || $("#user_first_name").val()==null)
		toastr.error("Please Enter  Name!");
	else if($("#user_email").val()=="" || $("#user_email").val()==null)
		toastr.error("Please Enter Email!");
	else if($("#user_password").val()=="" || $("#user_password").val()==null)
		toastr.error("Please Enter  Password!");
	else if($("#user_confirm_password").val()=="" || $("#user_confirm_password").val()==null)
		toastr.error("Please Enter Confirm Password!");
	else if(($("#user_password").val())!=($("#user_confirm_password").val())&& $("#user_password").val()!="")
			toastr.error("Password Mismatch!");	
	else{
	    $.ajax({
		type : 'POST',
		url : getContextPath() +"/user/saveUserDetails",
		dataType : "text",
		data : $("#id_form_user_registration").serialize(),
		success : function(data) {
			if (data == "success") {
				toastr.success("Saved successfully...!!!");
				window.location.reload();
			} else {
				toastr.error("Save failed...!!!");
			}
		}
	 });
	}
	
}




function clearUserForm(){
	$("input[type='text'],input[type='password'],input[type='email'],textarea").val("");
}

function validateEmail(){
	var mail=$("#user_email").val();
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)){
    
  }else if($("#user_email").val()!=""){
	  $("#user_email").val("");
	  toastr.error("Please Enter Valid Email!");  
  }
}