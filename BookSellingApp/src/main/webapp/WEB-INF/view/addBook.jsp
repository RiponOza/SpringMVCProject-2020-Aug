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
	<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
	<h2 id="header-1" class="jumbotron">Add Book Panel</h2>

	<c:if test="${status ne null}">
		<div align="center" style="color:red;font-size:25px;padding:10px;">${status}</div>
	</c:if>
	<c:if test="${imageStatus ne null}">
		<div align="center" style="color:red;font-size:25px;padding:10px;">${imageStatus}</div>
	</c:if>

	<div id="div-main" class="container">
			<div id="div-form">
			<form action="addbook" method="POST" class="form-group" enctype="multipart/form-data">
				<input type="text" name="Id" class="form-control" placeholder="Enter book id" autocomplete="off" required>
				<input type="text" name="bname" class="form-control" placeholder="Enter book name" autocomplete="off" required>
				<input type="text" name="author" class="form-control" placeholder="Enter author name" autocomplete="off" required>
				<input type="text" name="price" class="form-control" placeholder="Enter book price" autocomplete="off" required>
				<input type="text" name="totalpage" class="form-control" placeholder="Enter total page count" autocomplete="off" required>
				<input type="file" name="BookImage">
				<input type="submit" name="Add Book" class="btn btn-primary btn-lg">
			</form>
		</div>
	</div>
</body>
</html>