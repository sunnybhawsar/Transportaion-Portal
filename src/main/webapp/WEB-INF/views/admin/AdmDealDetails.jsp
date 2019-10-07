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
<title>Admin | Transporter Details</title>

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

.actionsDiv
{
	clear:both;
	float:right;
	margin:20px;
}

.formDiv
{
	width: 92%;
	height: auto;
	padding:2%;
	clear:both;
	margin-top:20px;
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
	
		
				<a href="admDeals">
            	<button type="button" class="btn btn-info" >Back</button>
            	</a>
	
		<br/>
	
		 <div class="formDiv card">
         
         <h4>#Deal ${deal.dealId}</h4>
         <br/>
         	
         	<div class="container">
         	
         	<div class="row">
         	
  <!-- Deal -->
          	
         	<div class="col-lg-4 contents">
         		
         		<h5>Deal Details</h5> <br/>	
         		
         	<table>

				
				<tr>
					<td><p class="lbl">Source City : </p></td>
					<td><p> ${deal.sourceCity}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Destination City :  </p></td>
					<td><p>${deal.destinationCity}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Return Date : </p></td>
					<td><p>${deal.returnDate}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl">  Reach Date :</p></td>
					<td><p>${deal.reachDate}  </p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Pricing : </p> </td>
					<td><p>${deal.pricing} &nbsp; (in Rs/Kg)</p></td>
				</tr>
				
				
			</table>
         	</div>
         		
         		
    <!-- Transporter -->    		
         		
         		<div class="col-lg-4 contents">
         		
         		<h5>Transporter Details</h5> <br/>
         		
         		<table>
         		
         		<caption style="margin-left:25%;">
         		<a href="fetchTransporter?id=${deal.transporter.transporterId}">(More)</a>
         		</caption>
			
				
				<tr>
					<td><p class="lbl"> Name : </p> </td>
					<td><p>${deal.transporter.name}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Email : </p> </td>
					<td><p>${deal.transporter.email}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Mobile : </p> </td>
					<td><p>${deal.transporter.mobile}</p></td>
				</tr>
			
			</table>
         	
         		
         		</div>
         		
         	
  <!-- Vehicle -->
         		<div class="col-lg-4 contents">
         		
         		<h5>Vehicle Details</h5> <br/>
         		
         		<table>
         		
         		<caption style="margin-left:25%;">
         		<a href="fetchVehicle?regNo=${deal.vehicle.registrationNumber}">(More)</a>
         		</caption>
				
				<tr>
					<td><p class="lbl"> Registration No : </p> </td>
					<td><p>${deal.vehicle.registrationNumber}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Vehicle Type : </p> </td>
					<td><p>${deal.vehicle.vehicleType}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Capacity : </p> </td>
					<td><p>${deal.vehicle.capacity}</p></td>
				</tr>
			
			</table>
         		
         		</div>
         	</div>
         	
         	</div>
         	
         	
<!-- Actions -->        	
         	<div class="actionsDiv">
         	 <a href=""> 
              <button type="button"  class="btn btn-danger">      
                Decline
              </button>
              </a>
         	</div>
              
         </div>
		
	</div>
	
</div>
	
</body>
</html>