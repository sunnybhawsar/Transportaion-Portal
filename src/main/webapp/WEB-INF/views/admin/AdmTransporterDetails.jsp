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
	color:green;'
}

table
{
	width:40%;
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
	
		
				<a href="admTransporters">
            	<button type="button" class="btn btn-info" >Back</button>
            	</a>
	
		<h3 align="center">Transporter Details</h3>
		
		<br>
		
		      <div class="contt" style="">
			
			<table>
				<tr>
					<td><p class="lbl"> Name : </p><td>
					<td><p>${transporter.name}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl">Email : </p><td>
					<td><p> ${transporter.email}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Mobile No.  </p><td>
					<td><p>${transporter.mobile}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Address : </p><td>
					<td><p>${transporter.address}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl">  City :</p><td>
					<td><p>${transporter.city}  </p></td>
				</tr>
				
				
				<tr>
					<td><p class="lbl"> Rating : </p> <td>
					<td><p>${transporter.rating}</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl" style="color:maroon;">  Approval : </p><td>
					<td><p style="color:maroon;">${transporter.login.approval}</p></td>
				</tr>
				
			</table>
			
			
			<table style="margin-top:5%; width:16%;">
			
         		<caption style="margin-left:5%;">
         			Uploaded Documents
         		</caption>
			
			<tr>
					<td><p class="lbl"> Pan Card : </p> <td>
					<td><p>
					<a href="openDocument?fileName=${transporter.pancard}" target="_blank">
						VIEW
					</a>
					</p></td>
				</tr>
				
				<tr>
					<td><p class="lbl"> Id Proof : </p> <td>
					<td><p>
					<a href="openDocument?fileName=${transporter.idProof}" target="_blank">
					 	VIEW 
					</a>
					</p></td>
				</tr>
			
			</table>
            	
              <div style="margin-left:37%; clear:both;">
              	<a href="approveTransporter?id=${transporter.transporterId}" style="float:left;">
            	<button type="button" class="btn btn-warning" >Approve Request </button>
            	</a>
            	
            	&nbsp;
            	
            	<a href="declineTransporter?id=${transporter.transporterId}" style="float:left; margin-left:20px;">
            	<button type="button" class="btn btn-danger" >Decline </button>
            	</a>
            	
			  </div>
			  
              </div>
		
	</div>
	
</div>
	
</body>
</html>