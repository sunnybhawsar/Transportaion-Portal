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
<title>Admin | Decline Deal</title>

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
	font-size:16px;
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
		<%@include file="AdmHeader.jsp" %>
	</div>
	
	<br/>
	
	<a href="admDeals" style="margin-left:10%;">
            	<button type="button" class="btn btn-secondary" >Cancel</button>
    </a>
	
	<div class="bodyDiv">
	
	<br/>
	
	<div class="formDiv card">

			<h3>Add Reason (Optional)</h3>
			<br>
			

			<form action="declineDeal"  method="get" class="registerForm form-group">
				
				<input type="hidden"  name="dealId" value="${dealId}"/>
				<input type="hidden" name="transEmail" value="${transEmail}" />
				
				
				<p class="headings">Deal Id : ${dealId}</p> <br/>
				
				<p class="headings">Transporter Email :  ${transEmail}</p> <br/><br/>
				
				
				<p class="headings">Enter Reason (Optional):</p>
				
				<textarea  id="reason" name="reason" class="form-control">
				</textarea> <br/> 
			
				
				<input type="submit" class="btn btn-danger form-control" value="Decline Deal"/>
		
			</form>
		</div>

		
	</div>
	
</div>
	
</body>
</html>