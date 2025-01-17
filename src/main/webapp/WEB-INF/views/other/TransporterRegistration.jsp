<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<%@page isELIgnored="false" %>
	
	<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transporter | Registration</title>

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

.files
{
	font-size:17px;
	color:black;
	margin-left:12%;
}



.lbl
{
	margin-left:0;
	color:#478939;
}

.headings
{
	font-size:12px;
	float:left;
	margin-left:12px;
	margin-top: 1px;
	margin-bottom:0px;
	color:black;
}

</style>

</head>
<body>

<div class="mainDiv">

			<div class="formDiv card">

			<h1>Transporter Registration</h1>
			<br>
			
			<p class="lbl">
			 Basic Details
			</p>

			<form action="addTransporter" method="post" class="registerForm form-group" enctype="multipart/form-data" >
			
				<input type="text" id="name" name="name" class="form-control txtbox" placeholder="Enter name" required="required"/> <br/> 
				
				<input type="email" id="email" name="email" class="form-control txtbox" placeholder="Enter email" required="required"/> <br/> 
				
				<input type="number" id="mobile" name="mobile" class="form-control txtbox" placeholder="Enter mobile number" required="required" min="6000000000" max="9999999999"/> <br/> 
 
				
				<p class="pAddress">Enter Address</p>
				<textarea id="address" name="address" class="form-control txtarea" placeholder="Enter address" > 
				</textarea> <br/> 
								
				<p class="pAddress">City</p>
				<select class="form-control" name="city">
					<option> Indore </option>
					<option> Ujjain </option>
					<option> Dewas </option>
					<option> Ratlam </option>
				</select>  <br/>
			
				
				<br/>	
				<p class="lbl">
				 Set Credentials
				</p>
				
				<input type="text" id="username" name="username" class="form-control txtbox" placeholder="Enter username" required="required"/> <br/> 
				
				<input type="password" id="password" name="password" class="form-control txtbox" placeholder="Enter password" required="required"/> <br/> 
				
				
			<br>
			<p class="lbl">
			 Documents
			</p>
				
				<br/>
			
				<p class="files">Your Pan Card (JPG)</p>
				<input type="file" id="picture" name="picture" class="fileInput" accept="image/*" required="required" /><br/> 
				
				<br/><br/>
				
				<p class="files">Your Id Proof (PDF) &nbsp; </p>
				<input type="file" id="identityProof" name="identityProof" accept="application/pdf" required="required" /> <br/> 
				
				
				<br/><br/>
				
				<input type="submit" class="btn btn-success form-control" value="Register"/>
		
			</form>
		</div>
		

	</div>

</body>
</html>