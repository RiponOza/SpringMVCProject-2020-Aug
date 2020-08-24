<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Delete Book Page</title>
	
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
	<h2 id="header-1" class="jumbotron">Remove Book Panel</h2>

	<c:if test="${status ne null}">
		<div class="container" align="center" style="color:red;font-size:20px;">${status}</div>
	</c:if>

	<div id="div-main" class="container">
			<div id="div-form">
			<form action="deletebook" method="POST" class="form-group">
				<input type="text" name="Id" class="form-control" placeholder="Enter book id" autocomplete="off" required>
				<input type="submit" name="Delete Book" class="btn btn-primary btn-lg">
			</form>
		</div>
	</div>
</body>
</html>