<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<%@page isELIgnored="false" %>
	
	<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %> 
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer | Registration</title>

<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style type="text/css">

.mainDiv
{
	align-items: center;
	text-align: center;
	padding:9%;
}

.formDiv {
	width: 60%;
	height: auto;
	align-items: center;
	text-align: center;
	margin-left:19%;
	padding:2%;
}

.registerForm {
	width: 60%;
}

.pAddress
{
	font-size:17px;
	float:left;
	margin-left:12px;
	margin-top: 4px;
	margin-bottom:0px;
	color:grey;
}

.lbl
{
	margin-left:0;
	color:#478939;
}

.files
{
	font-size:17px;
	color:grey;
	margin-left:12%;
}


</style>

</head>
<body>

<div class="mainDiv">

		<div class="formDiv card">

			<h1>Customer Registration</h1>
			<br>
			
			<p class="lbl">
			 Basic Details
			</p>

			<frm:form action="addCustomer" method="post" class="registerForm form-group" enctype="multipart/form-data">

				<input type="text" id="name" name="name" class="form-control txtbox" placeholder="Enter name" required="required"/> <br/> 
				
				<input type="email" id="email" name="email" class="form-control txtbox" placeholder="Enter email" required="required"/> <br/> 
				
				<input type="number" id="mobile" name="mobile" class="form-control txtbox" placeholder="Enter mobile number" required="required"  min="6000000000" max="9999999999"/> <br/> 
 
				<p class="pAddress">City</p>
				<select class="form-control" name="city">
					<option> Indore </option>
					<option> Ujjain </option>
					<option> Dewas </option>
					<option> Ratlam </option>
				</select>  <br/>		
				
				<p class="lbl">
			 Set Credentials
			</p>
			
				<input type="text" id="username" name="username" class="form-control txtbox" placeholder="Enter username" required="required"/> <br/> 
				
				<input type="password" id="password" name="password" class="form-control txtbox" placeholder="Enter password" required="required"/> <br/> 
				
				
			<p class="lbl">
			 Customer Identity
			</p>

			<br/>

				<p class="files">Upload Aadhaar Card (JPG)
				<input type="file" id="picture" name="picture" class="fileInput" accept="image/*" required="required"/> </p><br/> 
				
				
				
				<br/>
				 
				<input type="submit" class="btn btn-success form-control" value="Register"/>
				
				
				
			</frm:form>
		</div>

	</div>
</body>
</html>