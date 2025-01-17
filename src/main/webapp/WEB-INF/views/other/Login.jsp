<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	 <%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transportation | Login</title>

<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

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

.invalid
{
font-size:14px;
color:red;
}

</style>

</head>
<body>
	<div class="mainDiv">

		<div class="formDiv card">

			<h1>Login</h1>
			<br>

			<form action="login" method="post" class="loginForm form-group">

				<input type="text" id="username" name="username" class="form-control txtbox" placeholder="Username" /> <br> 
				
				<input type="password" id="password" name="password" class="form-control txtbox" placeholder="Password" />  
				
				<!-- <a href="" class="forgot"><b>Forgot Password?</b></a> -->
				
				
				<br/><br/>
				<input type="submit" class="btn btn-success form-control" />
				
				<br/><br/>
				
				<p class="invalid">${invalid}</p>
				
				<p>Don't have an account? <a href="signUp" class="signUp"><b>Sign Up</b> </a></p> 

			</form>
		</div>

	</div>
</body>
</html>