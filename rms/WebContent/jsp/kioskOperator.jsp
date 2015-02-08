<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
	<script src="../js/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script> 
	$( document ).ready(function() {
       $("#header").load("header.jsp"); 
    });
    
</script>
</head>
<body bgcolor="#E6E6FA">
	<div>
	<div id="logo"></div>
	<div id="header"></div>
	<div id="shape">
		<div id="buttons" style="top:40px;left:40px;position:relative;">
			<c:forEach var="i" begin="1" end="6">
				<div style="top:<c:out value='${20*i}' />px;left:20px;position:relative;">
				<input type="button" value="Item <c:out value='${i}' />" id="button_<c:out value='${i}' />" />
				</div>
			</c:forEach>
		</div>
	</div>
	</div>
</body>
</html>
