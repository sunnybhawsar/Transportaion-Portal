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
              
               <td><p>${transporter.getTransporterId()}</p></td>
              <td><p>${transporter.getName()}</p></td>
              <td><p>${transporter.getEmail()}</p></td>
              <td><p>${transporter.getMobile()}</p></td>
               <td><p style="color:#ED5C2C;">${transporter.rating}</p></td>
              <td><p>${transporter.getLogin().isApproval()}</p></td>
              
              <td>
               
              <a href="fetchTransporter?id=${transporter.getTransporterId()}"> 
              <button type="button"  class="btn btn-info">      
                More Details
              </button>
              </a>
                &nbsp;
              <button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#viewApplicationModalLong">Delete</button>
              </td>
          </tr>
          
          </c:forEach>
          
          </table>
        </div>
        
      </div>

      <!-- Modal -->
      <div class="modal fade" id="viewApplicationModalLong" tabindex="-1" role="dialog" aria-labelledby="viewApplicationtionModalLongTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title" id="viewApplicationModalLongTitle">Details</h4>
              <button  type="button" class="close" data-dismiss="modal" aria-label="Close" >
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
                
              <div class="contt" style="">

              <p>
               <b> Name : </b>
                ${transporters.get(0).getName()}
              </p>
               
              <p>
               <b> Email : </b>
               ${transporters.get(0).getEmail()}
              </p>
               
              <p>
               <b> Mobile no : </b>
                ${transporters.get(0).getMobile()}
              </p>
               
              <p>
               <b> Address : </b>
                ${transporters.get(0).getAddress()}
              </p>  

              <p>
               <b> City : </b>
                ${transporters.get(0).getCity()}  
              </p>

              <p>
               <b> Photo : </b>
               ${transporters.get(0).getImage()} 
              </p> 
              
              <p>
               <b> Id Proof : </b>
               ${transporters.get(0).getIdProof()} 
              </p> 
              
               <p>
               <b> Approval : </b>
               ${transporters.get(0).getLogin().isApproval()}
              </p> 

              </div>
            </div>
            <div class="modal-footer">
            	
            	<a href="">
            	<button type="button" class="btn btn-warning" data-dismiss="modal">Approve Request </button>
            	</a>
            </div>
          </div>
        </div>
		
	</div>
	
	<!-- End of Modal -->

	
</div>
	
</body>
</html>