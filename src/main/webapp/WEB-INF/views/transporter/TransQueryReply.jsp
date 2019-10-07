<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 
	 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>
		  
	<%@page isELIgnored="false" %>
     
  <%
  if(request.getSession().getAttribute("id")==null)
  	response.sendRedirect("sessionExpired");
  %> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transporter | Reply </title>

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
	
	<a href="transQueries" style="margin-left:10%;">
            	<button type="button" class="btn btn-info">Back</button>
    </a>	
	
	<div class="bodyDiv">

	<h3 align="center">${status}</h3><br/><br/>

	
		<div class="formDiv card">

			<h2>Add Reply</h2>
			<br>
			

			<form action="saveReply"  method="post" class="registerForm form-group">
				
				<input type="hidden" id="qId" name="qId" value="${query.queryId}"/>
				
				<p class="headings">Query :</p> <br/>
				<label> ${query.query} </label> <br/>
				
	
				<p class="headings">Enter Your Reply :</p>
				
				<textarea  id="reply" name="reply" class="form-control"  required="required">
				</textarea> <br/> 
				
				
				
				<input type="submit" class="btn btn-success form-control" value="Submit Reply"/>
		
			</form>
		</div>
	</div>

</div>

</body>
</html>