<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
  <%@page isELIgnored="false" %>
  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
  <%
  if(request.getSession().getAttribute("id")==null)
  	response.sendRedirect("sessionExpired");
  %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transporter | Home</title>

<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

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
	margin-left:3%;
	align-content: center;
	align-items: center;
	align-self: center;
	padding:5%;
}

.box
{
	height: 200px;
	width:40%;
	margin-left:30%;
}

.img
{
	height:50%;
	width:25%;
	margin-left:35%;
}
</style>

</head>
<body>

<div class="mainDiv">
	
	<div class="headerDiv">
	<%@include file="TransHeader.jsp" %>
	</div>
	
	<br/>
	
	<div class="bodyDiv">
		
		<br/>
		
		<h1 align="center" style="color:grey;">
		Welcome To Portal
		</h1>
		
		<br/>
	
					<div class="box">
						
						<img src="<c:url value="/images/transporter.png"/>" class="img" />
						<br/><br/>
						<h4 align="center" style="color:#ed5c2c;">
						Hello, ${user} ! 
						</h4>
					</div>
				
		
	</div>
	
</div>

</body>
</html>