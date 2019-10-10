<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<%@page isELIgnored="false" %>
	
	<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>
     
  <%
  if(request.getSession().getAttribute("id")==null)
  	response.sendRedirect("sessionExpired");
  %> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transporter | Add Vehicle</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style type="text/css">
.mainDiv 
{
	padding: 4%;
}

pre 
{
	font-size: 16px;
}

.menuItems
{
	float:left;
	margin-left:35px;
}

.links
{
	margin-top:5px;
}

.first
{
	margin-left:2%;
}


@media screen and (max-width:1300px) 
{
	.button
	{
		clear:both;
		float:right;
	}
	
	.first
	{
		margin-left:0%;
	}
}

@media screen and (max-width:700px) 
{
	.menuItems
	{
		clear:both;
		float:left;
		margin-left:10px;
		
	}
	
	.button
	{
		margin-top: 15px;
	}
}


.content
{
	padding:0px;
}

.bodyDiv
{
	padding-left:3%;
}

.logo
{
	color:black;
	text-decoration:none;
	transition:0.3s;
}

.logo:hover
{
	color:blue;
	text-decoration:none;
}

.bodyDiv
{
	margin-left:5%;
	align-items: center;
	text-align: center;
}

.bodyDiv h3
{
	color:green;'
}


/* Form css */


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
	color:grey;
	margin-left:0%;
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

.validation
{
	color:red;
	font-size:12px;
}

</style>

</head>
<body>

<div class="mainDiv">

	<div class="headerDiv">		
		<%@include file="TransHeader.jsp" %>
	</div>
	
	<a href="transVehicles" style="margin-left:10%;">
            	<button type="button" class="btn btn-info">Back</button>
    </a>
	
	<div class="bodyDiv">
		
		
		<h3 align="center">${status}</h3><br/><br/>

		
		<div class="formDiv card">

			<h2>Add Vehicle</h2>
			<br>
			
			<p class="lbl">
			 Basic Details
			</p>

			<frm:form action="saveVehicle" modelAttribute="vehicle"  method="post" class="registerForm form-group" enctype="multipart/form-data" >
			
				<frm:input type="text" id="registrationNumber" path="registrationNumber" class="form-control txtbox" placeholder="Enter Registration Number" required="required" maxlength="10"/> <br/> 
				
				<%-- <label class="validation"><i><frm:errors path="registrationNumber"/></i></label>
				 --%>
				
				<p class="headings">Vehicle Type</p>
				<frm:select class="form-control" path="vehicleType" items="${vehicleTypes}">
				</frm:select>  <br/>
				
				<p class="headings">Brand</p>
				<frm:select class="form-control" path="brand" items="${brands}" >
				</frm:select>  <br/>
				
				<input type="number" id="capacity" name="capacity" class="form-control txtbox" placeholder="Enter Capacity (in Kg)" required="required" min="50" /> <br/> 

				
			<br>
			<p class="lbl">
			 Upload Needed Documents
			</p>
				
				<br/>
			
				<p class="files">1. Vehicle Insurance Paper (JPG/JPEG)  </p>
				<input type="file" id="vInsurance" name="vInsurance" class="fileInput" accept="image/*" required="required" /><br/> <br/>
				
				
				<p class="files">2. Fitness Paper (JPG/JPEG) &nbsp;</p>
				<input type="file" id="vFitness" name="vFitness" class="" accept="image/*" required="required" /> <br/> 
				
				
				<br/><br/>
				
				<input type="submit" class="btn btn-success form-control" value="Add"/>
		
			</frm:form>
		</div>
	</div>
	
	<br/>
	
	
</div>

</body>
</html>