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
<title>Admin | Vehicles list</title>

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
	margin-left:28%;
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
	color:green;
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
	
		<h3 align="center">Vehicles List</h3>

<br/>

		<div class="table-responsive-md">
          <table class="table">
            <tr>
              <th>#</th>
              <th>Registration No</th>
              <th>Vehicle Type</th>
              <th>Capacity</th>
              <th>Transporter</th>
              <th>Approval</th>
              <th>Action</th>
     
            </tr>
         
         <c:forEach var="vehicle" items="${vehicles}">
       
      		 <tr>
              
               <td><p></p></td>
              <td><p>${vehicle.registrationNumber}</p></td>
              <td><p>${vehicle.vehicleType}</p></td>
              <td><p>${vehicle.capacity}</p></td>
              <td><p>${vehicle.transporter.name}</p></td>
              <td><p>${vehicle.approval}</p></td>
              
              <td>
               
              <a href="fetchVehicle?regNo=${vehicle.registrationNumber}"> 
              <button type="button"  class="btn btn-info">      
                More Details
              </button>
              </a>
                
              </td>
          </tr>
          
          </c:forEach>
          
          </table>
        </div>
		
	</div>
	
</div>
	
</body>
</html>