<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@page isELIgnored="false" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Status</title>

<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


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
<br/>

	<h2>
		${action}
	</h2>
	
<pre style="color:grey;">
${caption}
</pre>
	
	<br/>
	
	<a href="${nextView}"><button type="button" class="btn btn-primary" >Back</button></a>
</div>

</body>
</html>