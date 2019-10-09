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
<title>Customer | Profile</title>

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
	margin-left:5%;
}

.links
{
	margin-top:5px;
}

.first
{
	margin-left:30%;
}


@media screen and (max-width:1250px) 
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
		margin-top:10px;
	}
}


.content
{
	padding:0px;
}

.bodyDiv
{
	margin-left:3%;
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

table
{
	width:60%;
}

.lbl
{
	padding-top:9px;
}

.txtbox
{
	width:55%;
}
</style>

</head>
<body>

<div class="mainDiv">

	<div class="headerDiv">		
		<%@include file="CustHeader.jsp" %>
	</div>
	
	<div class="bodyDiv">
	
		<h3 align="center">My Profile</h3>
		
		
		      <div class="contt" style="">
			<br/>
			
			<frm:form action="updateProfile" modelAttribute="customer" method="post" enctype="multipart/form-data" class="form-group">
			<table>
				<tr>
					<td><p> Customer Id : </p><td>
					<td><p>${customer.customerId}</p></td>
				</tr>
				
				<tr>
					<td class="lbl"><p >Name : </p><td>
					<td>
					<frm:input path="name"  class="txtbox" />
					</td>
				</tr>
				
				<tr>
					<td class="lbl"><p > Email :  </p><td>
					<td>
					<frm:input  path="email" class="txtbox" />
					</td>
				</tr>
				
				<tr>
					<td class="lbl"><p > Mobile : </p><td>
					<td>
					<frm:input  path="mobile" class="txtbox" />
					</td>
				</tr>
				
				<tr>
					<td class="lbl"><p > City : </p><td>
					<td>
					<frm:select  path="city" items="${cities}" style="height:28px;" />
					</td>
				</tr>
				
				<tr>
					<td  class="lbl"><p>  Aadhaar Card :</p><td>
					<td>
					<br/>
					<p>
					<a href="viewFile?fileName=${customer.aadhaar}" target="_blank">
						View Card
					</a> <br/>
					
					CHANGE <input type="file" name="picture" style="margin-top:10px;" />
					
					</p></td>
				</tr>
				
				
			</table>
            	
            	<br/>
            	
            	<input type="submit" class="btn btn-success"  value="Update Profile" style="float:left;" />
            	
           
            	
            	<p style="color: #ed5c2c; float:left; margin:8px; margin-left:3%;">${status}</p>
            	
            	</frm:form>
            	
            
			  
              </div>
		
	</div>

</div>

</body>
</html>