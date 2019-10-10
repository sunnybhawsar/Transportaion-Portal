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
<title>Transporter | Profile</title>

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
}

.bodyDiv h3
{
	color:green;'
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
		<%@include file="TransHeader.jsp" %>
	</div>
	
	<div class="bodyDiv">
	
		<h3 align="center">My Profile</h3>
		
		
		      <div class="contt" style="">
			<br/>
			
			<frm:form action="updateProfile" modelAttribute="transporter" method="post" enctype="multipart/form-data" class="form-group">
			<table>
				<tr>
					<td><p> Transporter Id : </p><td>
					<td><p>${transporter.transporterId}</p></td>
				</tr>
				
				<tr>
					<td><p> Rating : </p><td>
					<td><p style="color:#ed5c2c;">${transporter.rating}</p></td>
				</tr>
				
				<tr>
					<td class="lbl"><p >Name : </p><td>
					<td>
					<frm:input path="name"  class="txtbox" required="required"/>
					</td>
				</tr>
				
				<tr>
					<td class="lbl"><p > Email :  </p><td>
					<td>
					<frm:input type="email"  path="email" class="txtbox" required="required"/>
					</td>
				</tr>
				
				<tr>
					<td class="lbl"><p > Mobile : </p><td>
					<td>
					<frm:input type="number"  path="mobile" class="txtbox" required="required" min="6000000000" max="9999999999"/>
					</td>
				</tr>
				
				<tr>
					<td class="lbl"><p > Address : </p><td>
					<td>
					<frm:textarea  path="address" items="${transporter.address}" />
					</td>
				</tr>
				
				<tr>
					<td class="lbl"><p > City : </p><td>
					<td>
					<frm:select  path="city" items="${cities}" style="height:28px;" />
					</td>
				</tr>
				
				<tr>
					<td  class="lbl"><p>  Pan Card :</p><td>
					<td>
					<br/>
					<p>
					<a href="viewFile?fileName=${transporter.pancard}" target="_blank">
						View Pancard
					</a> <br/>
					
					CHANGE <input type="file" accept="image/*" name="picture" style="margin-top:10px;" />
					
					</p></td>
				</tr>
				
				<tr>
					<td  class="lbl"><p>  Id proof :</p><td>
					<td>
					<br/>
					<p>
					<a href="viewFile?fileName=${transporter.idProof}" target="_blank">
						View Id Proof
					</a> <br/>
					
					CHANGE <input type="file" accept="application/pdf" name="identityProof" style="margin-top:10px;" />
					
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