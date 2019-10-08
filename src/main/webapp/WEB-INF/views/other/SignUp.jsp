<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transportation | Sign up</title>

<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<style type="text/css">

.mainDiv
{
	width:100%;
	height:100%;
	padding:7%;
}


.box
{
	
	heigth:300px;
	
	
	margin-left: 7%;
}

.lcontent
{
	height:300px;
	align-items: center;
	align-content: center;
	text-align:center;
}

.rcontent
{
	height:300px;
	align-items: center;
	align-content: center;
	text-align:center;
}

.pic
{
	width:100%;
	height:70%;
	padding-top:10%;
	
}
</style>

</head>
<body>
	
	<div class="container mainDiv">
	
		<div class="row" style="margin-top:50px;">
			<div class="col-lg-5 box left">
			
			<form action="customerRegistration" method="post" class="card lcontent form-group">
			
				<div class="pic">
				
				<img src="<c:url value="/images/customer.png"/>" height="100%" width="50%" />
				
				</div>
				
				<br/>
				<input type="submit" value="Register as Customer" class="btn btn-success">
			</form>
			
			</div>
			
			<div class="col-lg-5 box right">
			
			<form action="transporterRegistration" method="post" class="card rcontent form-group">
				
				<div class="pic">
					
					<img src="<c:url value="/images/transporter.png"/>" height="100%" width="50%" />
				
					
				</div>
				
				<br/>
				<input type="submit" value="Register as Transporter" class="btn btn-success">
			</form>
			
			</div>
			
		</div>
		
	
	</div>
	
</body>
</html>