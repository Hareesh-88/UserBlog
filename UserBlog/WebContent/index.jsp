<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
   <link rel="stylesheet" type="text/css"
         href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
   <link rel="stylesheet" type="text/css"
         href="${pageContext.request.contextPath}/resources/plugins/data-table-1.10.9/css/jquery.dataTables.min.css">
  <link rel="stylesheet" type="text/css"
         href="${pageContext.request.contextPath}/resources/plugins/data-table-1.10.9/css/responsive.dataTables.min.css">
   <link rel="stylesheet" type="text/css"
         href="${pageContext.request.contextPath}/resources/plugins/data-table-1.10.9/css/select.dataTables.min.css">
  <link rel="stylesheet" type="text/css"
		 href="${pageContext.request.contextPath}/resources/css/toastr.min.css" > 
   <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-datetimepicker.css" />
  <script type="text/javascript"
                src="${pageContext.request.contextPath}/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script> 
  <script type="text/javascript"
			    src="${pageContext.request.contextPath}/resources/plugins/jquery-form/jquery.validate.min.js"></script>
  <script type="text/javascript"
                src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
   <script type="text/javascript"
                src="${pageContext.request.contextPath}/resources/plugins/data-table-1.10.9/js/jquery.dataTables.min.js"></script>
   <script type="text/javascript"
              src="${pageContext.request.contextPath}/resources/plugins/toastr/toastr.min.js"></script>
   <script type="text/javascript"
	            src="${pageContext.request.contextPath}/resources/plugins/daterangepicker/moment.min.js"></script>
    <script type="text/javascript"
	            src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-datetimepicker.js"></script>
  <script type="text/javascript" 
	     src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<body>
<div class="container">
  <h2>User Registration</h2>
<div class="col-md-10">
  <form class="form-horizontal" id="id_form_user_registration" method="POST">
    <div class="form-group">
      <label class="control-label col-sm-2" for="user_id">User Id<span style="color:red">*</span>:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="user_id"  name="userId" placeholder="Enter UserID">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="user_first_name">First Name<span style="color:red">*</span>:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="user_first_name"  name="firstName" placeholder="Enter First Name">
      </div>
    </div>
  <div class="form-group">
      <label class="control-label col-sm-2" for="user_last_name">Last Name<span style="color:red">*</span>:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="user_last_name"  name="lastName" placeholder="Enter Last Name">
      </div>
    </div>
  <div class="form-group">
      <label class="control-label col-sm-2" for="user_date_birth">Date Of Birth<span style="color:red">*</span>:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="user_date_birth"  name="dateOfBirth" placeholder="Enter Date Of Birth">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="user_email">Email<span style="color:red">*</span>:</label>
      <div class="col-sm-8">
        <input type="email" class="form-control" id="user_email" name="email" placeholder="Enter email" onblur="validateEmail()">
      </div>
    </div>
    
       <div class="form-group">
      <label class="control-label col-sm-2" for="user_address">Address<span style="color:red">*</span>:</label>
      <div class="col-sm-8">
      <textarea class="form-control" id="user_address" name="address" placeholder="Enter address"></textarea>
      </div>
    </div>
       <div class="form-group">
      <label class="control-label col-sm-2" for="user_mobile_no">Mobile No<span style="color:red">*</span>:</label>
      <div class="col-sm-8">
      <input type="text" class="form-control" id="user_mobile_no" name="mobileNo" placeholder="Enter Mobile No" maxlength="10">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="user_password">Password<span style="color:red">*</span>:</label>
      <div class="col-sm-8">          
        <input type="password" class="form-control" id="user_password" placeholder="Enter password">
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="user_confirm_password">Confirm Password<span style="color:red">*</span>:</label>
      <div class="col-sm-8">          
        <input type="password" class="form-control" id="user_confirm_password" name="password" placeholder="Enter confirm password">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-success" onclick="saveUserDetails()">Submit</button>
        <button type="button" class="btn btn-warning" onclick="clearUserForm()">Clear</button>
      </div>
    </div>
  </form>
  </div>
  
  
   <div class="col-md-12">
   <h2>User Registration List</h2>
		<table class="table table-striped table-bordered table-hover"
			 id="dataTables-userList">
		 </table>
      </div>
  
  </div>
</body>
</html>