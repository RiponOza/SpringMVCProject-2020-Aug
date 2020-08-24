<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin Login Page</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/adminLogin.css" />">
</head>
<body>
	<div id="header" class="jumbotron"><h2 >User registration form</h2></div>
	<c:if test="${status ne null}">
		<div align="center" class="container" style="font-size:20px;color:red;">${status}</div>
	</c:if>
	<div id="table" align="center" class="container form-group">
		<div id="form-header">Enter your details</div>
		<form action="editlibrary" method="POST">
			<table id="table" class="table table-bordered">
				<tbody>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email" placeholder="Enter your email" class="form-control" autocomplete="off" required></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" placeholder="Enter your password" class="form-control" required></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="register" class="btn btn-primary btn-lg">
	</form>
	</div>
</body>
</html>