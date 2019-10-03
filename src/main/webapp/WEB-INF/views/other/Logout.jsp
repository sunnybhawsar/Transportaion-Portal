<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged Out</title>

<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- <script>
/* break back button */                                                                        
window.onload=function(){                                                                      
  var i=0; var previous_hash = window.location.hash;                                           
  var x = setInterval(function(){                                                              
    i++; window.location.hash = "/noop/" + i;                                                  
    if (i==10){clearInterval(x);                                                               
      window.location.hash = previous_hash;}                                                   
  },10);
}
</script> -->

<style type="text/css">
.mainDiv
{
	align-items: center;
	text-align: center;
	padding:9%;
}
</style>


</head>
<body>

<div class="mainDiv">

	<h2>
		You have been logged out successfully!
	</h2>
	
	<br/>
	
	<a href="Login"><button type="button" class="btn btn-primary" >Go to Login</button></a>
</div>

</body>
</html>