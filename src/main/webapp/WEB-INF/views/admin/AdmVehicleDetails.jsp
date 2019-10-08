<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
  <%@page isELIgnored="false" %>
      
  <%
  if(request.getSession().getAttribute("id")==null)
  	response.sendRedirect("sessionExpired");
  %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin | Vehicle Details</title>

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
	margin-left:20px;
}

.links
{
	margin-top:5px;
}

.first
{
	margin-left:9%;
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
}


.content
{
	padding:0px;
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
}

.bodyDiv h3
{
	
}

table
{
	width:35%;
	margin-left:5%;
	float:left;
}

.lbl
{
	color:black;
}
</style>

</head>
<body>

<div class="mainDiv">

	<div class="headerDiv">
		<%@include file="AdmHeader.jsp" %>
	</div>
	
	<br/>
	
	<div class="bodyDiv">
	
		
				<a href="admVehicles">
            	<button type="button" class="btn btn-info" >Back</button>
            	</a>
	
		<h3 align="center">Vehicle Details</h3>
		
		<br>
		
		      <div class="contt" style="">
		      <br/>
			
			<table>
				<tr>
					<td><p class="lbl"> Registration No : </p><td>
					<td><p>${vehicle.registrationNumber}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl">Vehicle Type : </p><td>
					<td><p> ${vehicle.vehicleType}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Brand :  </p><td>
					<td><p>${vehicle.brand}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Capacity : </p><td>
					<td><p>${vehicle.capacity}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl">  Insurance Paper :</p><td>
					<td><p>
					<a href="vehicleDocument?fileName=${vehicle.insurance}" target="_blank">
						VIEW
					</a>
					</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Fitness Paper : </p> <td>
					<td><p>
					<a href="vehicleDocument?fileName=${vehicle.fitness}" target="_blank">
						VIEW
					</a>
					</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl" style="color:maroon;">  Approval : </p><td>
					<td><p style="color:maroon;">${vehicle.approval}</p></td>
				</tr>
				
			</table>
			
			<table>
				<tr>
					<td><p class="lbl"> Transporter Name :</p><td>
					<td><p> ${vehicle.transporter.name} </p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Transporter Email : </p> <td>
					<td><p> ${vehicle.transporter.email} </p></td>
				</tr>
			</table>
            	
              <div style="margin-left:37%; clear:both;">
              	<a href="approveVehicle?regNo=${vehicle.registrationNumber}" style="float:left;">
            	<button type="button" class="btn btn-warning" >Approve Request</button>
            	</a>
            	
            	&nbsp;
            	
            	<a href="declineVehicle?regNo=${vehicle.registrationNumber}" style="float:left; margin-left:20px;">
            	<button type="button" class="btn btn-danger" >Decline</button>
            	</a>
            	
			  </div>
			  
              </div>
		
	</div>
	
</div>
	
</body>
</html>