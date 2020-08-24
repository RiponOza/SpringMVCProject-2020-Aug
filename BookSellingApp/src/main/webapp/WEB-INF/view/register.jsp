<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>This is the index page</title>
	
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/register.css" />">
</head>
<body>
	<h2 id="header-1" class="jumbotron">Book Selling Website</h2>
	
	<c:if test="${user ne null}">
		<div align="center" style="color:red;font-size: 20px;">
			<span>${status}</span>
		</div>
	</c:if>

	<div id="div-main" class="container">
			<div id="div-form">
			<form action="saveuser" method="POST" class="form-group">
				<input type="text" name="fname" class="form-control" placeholder="Enter your first name" required>
				<input type="text" name="lname" class="form-control" placeholder="Enter your last name" required>
				<input type="email" name="email" class="form-control" placeholder="Enter your email" required>
				<input type="text" name="phone" class="form-control" placeholder="Enter your mobile numbe" required>
				<input type="password" name="password" class="form-control" placeholder="Enter your password" required>
				<input type="password" name="confirm-password" class="form-control" placeholder="Enter your password again" required>
				<input type="radio" name="gender" class="form-check-input" value="male"> Male <br>
				<input type="radio" name="gender" class="form-check-input" value="female"> Female<br>
				<input type="radio" name="gender" class="form-check-input" value="other"> Other<br>
				<input type="submit" value="submit" class="btn btn-primary">
			</form>
		</div>

		<div id="div-2" class=>
			<img id="image-1" src="<c:url value="/resources/file/image/index.jpg" />" alt="Something went wrong">
		</div>
	</div>
</body>
</html>