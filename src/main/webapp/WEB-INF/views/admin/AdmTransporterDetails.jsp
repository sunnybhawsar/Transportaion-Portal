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
	color:green;'
}

table
{
	width:40%;
	margin-left:5%;
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
	
		
				<a href="admTransporters">
            	<button type="button" class="btn btn-info" >Back</button>
            	</a>
	
		<h3 align="center">Transporter Details</h3>
		
		<br>
		
		      <div class="contt" style="">
			
			<table>
				<tr>
					<td><p class="lbl"> Name : </p><td>
					<td><p>${transporter.getName()}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl">Email : </p><td>
					<td><p> ${transporter.getEmail()}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Mobile No.  </p><td>
					<td><p>${transporter.getMobile()}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Address : </p><td>
					<td><p>${transporter.getAddress()}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl">  City :</p><td>
					<td><p>${transporter.getCity()}  </p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Id Proof : </p> <td>
					<td><p>${transporter.getIdProof()} </p></td>
				</tr>
				
				<tr>
					<td><p class="lbl" style="color:maroon;">  Approval : </p><td>
					<td><p style="color:maroon;">${transporter.getLogin().isApproval()}</p></td>
				</tr>
				
			</table>
            	
              <div style="margin-left:37%;">
              	<a href="approveTransporter?id=${transporter.getTransporterId()}" style="float:left;">
            	<button type="button" class="btn btn-warning" >Approve Request </button>
            	</a>
            	
            	&nbsp;
            	
            	<a href="declineTransporter?id=${transporter.getTransporterId()}" style="float:left; margin-left:20px;">
            	<button type="button" class="btn btn-danger" >Decline </button>
            	</a>
            	
			  </div>
			  
              </div>
		
	</div>
	
</div>
	
</body>
</html>