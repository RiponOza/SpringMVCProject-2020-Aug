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
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Library.css" />">
</head>
<body>
	<h2 id="header" class="container-fluid">Library</h2>
		<c:if test="${bookList ne null}">
			<c:forEach items="${bookList}" var="book">
				<div id="div-main" class="container">
					<div id="div-book-panel">
						<div id="div-image">
							<a href= "<c:url value="payment?book_name=${book.bname}&author=${book.author}&price=${book.price}&page=${book.totalpage}" />" >
								<img id="image-book" src="<c:url value="/resources/file/image/FILE${book.image}" />">	
							</a>
						</div>
						
						<div id="div-book-info">
							<h3 id="header-book">${book.bname}</h3>
							<span id="book-author">${book.author}</span><br>
							<span id="total-page">${book.totalpage} </span><br>
							<span id="book-price">${book.price}</span><br>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
		
		
</body>
</html>