<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
	<title>This is the index page</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/index.css" />">
</head>
<style>
	
</style>
<body>
	<h2 id="header-1" class="jumbotron">Book Selling Website</h2>
	<div id="div-main" class="container">
		<div id="div-1">
			<form id="form-1" action="Library.html" method="POST">
				<input id="email" type="email" name="email" placeholder="Enter your email" required><br>
				<input id="password" type="password" name="password" placeholder="Enter your password" required><br>
				<input id="submit" type="submit" name="login">
			</form><br>
			<a id="forget-password" href="">Forget password</a><br>
			<a id="create-account" href="register">Create account</a>
		</div>

		<div id="div-2" class=>
			<img id="image-1" src="<c:url value="/resources/file/image/index.jpg" />" alt="Something went wrong">
		</div>
	</div>
</body>
</html>