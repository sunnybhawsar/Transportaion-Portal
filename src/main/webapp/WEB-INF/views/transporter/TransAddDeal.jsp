<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
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
<title>Transporter | Add Deal</title>

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

</style>

</head>
<body>

<div class="mainDiv">

	<div class="headerDiv">		
		<%@include file="TransHeader.jsp" %>
	</div>
	
	<a href="transDeals" style="margin-left:10%;">
            	<button type="button" class="btn btn-info">Back</button>
    </a>
	
	<div class="bodyDiv">	
		
		<h3 align="center">${status}</h3><br/><br/>

	
		<div class="formDiv card">

			<h2>Post a Deal</h2>
			<br>
			

			<frm:form action="saveDeal" modelAttribute="deal"  method="post" class="registerForm form-group">
			
				<p class="headings">Source City</p>
				<frm:select class="form-control" path="sourceCity" items="${sourceCities}">
					
				</frm:select>  <br/>
				
				
				<p class="headings">Destination City</p>
				<frm:select class="form-control" path="destinationCity" items="${destinationCities}" >
					
				</frm:select>  <br/>
								
								
				<p class="headings">Return Date</p>
				<input type="date" id="returnDate" name="returnDate" class="form-control" required="required" min="2019-10-10" /> <br/>
				
				<p class="headings">Reach Date</p>
				<input type="date" id="reachDate" name="reachDate" class="form-control" required="required" min="2019-10-11"/> <br/>
				
				
				<p class="headings">Price Quotes (in Rs/kg)</p>
				<input type="number" id="pricing" name="pricing" class="form-control txtbox"  required="required" min="1"/> <br/> 


				<p class="headings">Select Vehicle</p>			
				<%-- <frm:select class="form-control" path="vehicle" items="${vehicles}">		</frm:select> --%> 
				
				<select class="form-control" name="selectedVehicle" required="required">
					<c:forEach var="availableVehicle" items="${availableVehicles}">
     				<option>${availableVehicle}</option>
   					 </c:forEach>
				</select> <br/>
				
				
				<br/><br/>
				
				<input type="submit" class="btn btn-success form-control" value="Add"/>
		
			</frm:form>
		</div>
	
	</div>
	
	<br/>
	
	
</div>

</body>
</html>