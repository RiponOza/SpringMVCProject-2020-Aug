<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Payment Page</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/paymentPage.css">
</head>
<body>
	<h2 id="header" class="jumbotron">Payment Page</h2>
	<div id="table" class="container">

		<form id="form-1">
		<table class="table table-bordered table-hover ">
			<div id="table-header"><span>Book Information</span></div>
			<tr>
				<td>Buyer Name</td>
				<td>XYZ</td>
			</tr>
			<tr>
				<td>Book Name</td>
				<td>${sessionScope.book_name}</td>
			</tr>
			<tr>
				<td>Price (INR)</td>
				<td>${sessionScope.price}</td>
			</tr>
			<tr>
				<td>Author</td>
				<td>${sessionScope.author}</td>
			</tr>
			<tr>
				<td>Total-Page</td>
				<td>${sessionScope.page}</td>
			</tr>
			<tr>
				<td>Publication</td>
				<td></td>
			</tr>
			<tr>
				<td>Hard Cover</td>
				<td></td>
			</tr>
			<tr>
				<td>Status</td>
				<td></td>
			</tr>
		</table>
		<div id="button" align="center"><a href=""><button class="btn btn-primary btn-lg">Buy</button></a></div>
		</form>
	</div>
	<div id="footer"></div>
</body>
</html>