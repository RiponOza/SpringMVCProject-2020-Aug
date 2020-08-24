<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Edit Library</title>
	
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
	<h2 id="header-1" class="jumbotron">Edit Library</h2>

    <div class="container">
        <form action="addbookview" method="POST" class="form-group">
            <input type="submit" value="Add Book" class= "btn btn-primary btn-lg">
        </form>
    
        <form action="deletebookview" method="POST">
            <input type="submit" value="Remove Book"  class="btn btn-primary btn-lg">
        </form>
    
    </div>
    
</body>
</html>