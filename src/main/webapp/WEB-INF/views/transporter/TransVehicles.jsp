<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	  
	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
	<%@page isELIgnored="false" %>
     
  <%
  if(request.getSession().getAttribute("id")==null)
  	response.sendRedirect("sessionExpired");
  %> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transporter | Vehicles</title>

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
	margin-left:0%;
}

.bodyDiv h3
{
	color:green;
}
</style>

</head>
<body>

<div class="mainDiv">

	<div class="headerDiv">		
		<%@include file="TransHeader.jsp" %>
	</div>
	
	<div class="bodyDiv">
	
		<a href="addVehicle">
		<button type="button" class="btn btn-success">Register Vehicle</button>
		</a>
		
		<br>
		
		<h3 align="center">My Vehicles</h3>

<br/>

		<div class="table-responsive-md">
          <table class="table">
            <tr>
              <th>#</th>
              <th>Registration No</th>
              <th>Vehicle Type</th>
              <th>Capacity</th>
              <th>Approval</th>
              <th>Action</th>
     
            </tr>
         
         <c:forEach var="vehicle" items="${vehicles}">
       
      		 <tr>
              
               <td><p></p></td>
              <td><p>${vehicle.getRegistrationNumber()}</p></td>
              <td><p>${vehicle.getVehicleType()}</p></td>
              <td><p>${vehicle.getCapacity()}</p></td>
              <td><p>${vehicle.isApproval()}</p></td>
              
              <td>
               
              <a href="fetchVehicle?regNo=${vehicle.getRegistrationNumber()}"> 
              <button type="button"  class="btn btn-info">      
                More Details
              </button>
              </a>
                &nbsp;
              <button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#viewApplicationModalLong">Delete</button>
              </td>
          </tr>
          
          </c:forEach>
          
          </table>
        </div>
		
	</div>

</div>

</body>
</html>