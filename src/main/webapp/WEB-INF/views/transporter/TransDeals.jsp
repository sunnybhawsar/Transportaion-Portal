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
<title>Transporter | Deals</title>

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
	
		<a href="addDeal">
		<button type="button" class="btn btn-success">Post a Deal</button>
		</a>
		
		<br>
		
		<h3 align="center">My Deals</h3>
		<br/>
		
		<p style="float:right; margin-right:5%; color:#ed5c2c;">${status}</p>
		
		<div class="table-responsive-md">
          <table class="table">
            <tr>
              <th>#</th>
              <th>Source City</th>
              <th>Destination City</th>
              <th>Return Date</th>
              <th>Reach Date</th>
              <th>Action</th>
     
            </tr>
         
         <c:forEach var="deal" items="${deals}">
       
      		 <tr>
              
               <td><p>${deal.dealId}</p></td>
              <td><p>${deal.sourceCity}</p></td>
              <td><p>${deal.destinationCity}</p></td>
              <td><p>${deal.returnDate}</p></td>
              <td><p>${deal.reachDate}</p></td>
              
              <td>
               
              <a href="fetchDeal?dealId=${deal.dealId}"> 
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