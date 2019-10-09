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
<title>Transporter | Queries</title>

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
	color:green;'
}
</style>

</head>
<body>

<div class="mainDiv">

	<div class="headerDiv">		
		<%@include file="TransHeader.jsp" %>
	</div>
	
	<div class="bodyDiv">
		
		<h3 align="center">Customer Queries</h3>
		<br/>
		
		<p style="float:right; margin-right:5%; color:#ed5c2c;">${status}</p>
		
		<div class="table-responsive-md">
          <table class="table">
            <tr>
              <th>#</th>
              <th>Customer Name</th>
              <th>Customer Email</th>
              <th>Query</th>
              <th>Response</th>
              <th>Action</th>
     
            </tr>
         
         <c:forEach var="query" items="${queries}">
       
      		 <tr>
              
               <td><p>${query.queryId}</p></td>
              <td><p>${query.customer.name}</p></td>
              <td><p>${query.customerEmail}</p></td>
              <td><p>${query.query}</p></td>
              <td><p>${query.response}</p></td>
              
              <td>
               
              <a href="queryReply?queryId=${query.queryId}"> 
              <button type="button"  class="btn btn-info">      
                Reply
              </button>
              </a>
              
                &nbsp;
                
              <a href="deleteQuery?queryId=${query.queryId}">
              <button type="button" class="btn btn-danger"> Delete </button>
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