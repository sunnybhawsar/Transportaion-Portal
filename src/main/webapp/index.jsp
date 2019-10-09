<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transportation | Login</title>

<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<%-- <link href='<c:url value="/css/style.css"/>' rel="stylesheet" /> --%>
<%-- <img  src="<c:url value="/images/x.png"/>" width="50" height="50"> --%>

<style type="text/css">

.mainDiv
{
	align-items: center;
	text-align: center;
	padding:9%;
}

.formDiv {
	width: 43%;
	height: 400px;
	align-items: center;
	text-align: center;
	margin-left:28%;
	padding:2%;
}

.loginForm {
	width: 80%;
}

.forgot
{
	font-size:14px;
	float:right;
	margin-top: 4px;
	color:grey;
	text-decoration:none;
}
.forgot:hover
{
	color:grey;
	text-decoration:underline;
}

.signUp
{
	color:#478939;
	text-decoration:none;
}
.signUp:hover
{
	color:#478939;
	text-decoration:underline;
}


</style>

</head>
<!-- <body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload=""> -->	
 
 <body>
 <div class="mainDiv">

		<div class="formDiv card">

			<h1>Login</h1>
			<br>

			<form action="login" method="post" class="loginForm form-group">

				<input type="text" id="username" name="username" class="form-control txtbox" placeholder="Username" required="required"/> <br> 
				
				<input type="password" id="password" name="password" class="form-control txtbox" placeholder="Password" required="required"/>  
				
				<!-- <a href="" class="forgot"><b>Forgot Password?</b></a> -->
				
				
				<br/><br/>
				<input type="submit" class="btn btn-success form-control" />
				
				<br/><br/>
				
				<p class="invalid">&nbsp;</p>
				
				<p>Don't have an account? <a href="signUp" class="signUp"><b>Sign Up</b> </a></p> 

			</form>
		</div>

	</div>
</body>
</html>


<!-- 
<script>
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