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
<title>Admin | Transporters list</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<!-- <script>
function myFunction(id) {

	  var transId = id;
	

	$(document).ready(function(){
		
        $.get("fetchTransporter",{id:transId},function(data){
           alert(data);
        });

		//alert("jquery"+transId);
	}); 
	
}
</script> -->

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
	align-content: center;
	align-items: center;
	text-align:center;
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
		<%@include file="AdmHeader.jsp" %>
	</div>
	
	<br/>
	
	<div class="bodyDiv">
	
		<h3>TRANSPORTERS LIST</h3>
		<br>
		
		<div class="table-responsive-md">
          <table class="table">
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Email</th>
              <th>Mobile</th>
              <th>Rating</th>
              <th>Approval</th>
              <th>Action</th>
     
            </tr>
         
         <c:forEach var="transporter" items="${transporters}">
       
      		 <tr>
              
               <td><p>${transporter.transporterId}</p></td>
              <td><p>${transporter.name}</p></td>
              <td><p>${transporter.email}</p></td>
              <td><p>${transporter.mobile}</p></td>
               <td><p style="color:#ED5C2C;">${transporter.rating}</p></td>
              <td><p>${transporter.login.approval}</p></td>
              
              <td>
               
              <a href="fetchTransporter?id=${transporter.transporterId}"> 
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