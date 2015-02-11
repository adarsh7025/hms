<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
	<script src="js/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<style>
	.dishbtn {
  background: #3498db;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 6;
  -moz-border-radius: 6;
  border-radius: 6px;
  font-family: Georgia;
  color: #ffffff;
  font-size: 15px;
  width: 130px;
  height: 50px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.dishbtn:hover {
  background: #45b3f7;
  background-image: -webkit-linear-gradient(top, #45b3f7, #5783fa);
  background-image: -moz-linear-gradient(top, #45b3f7, #5783fa);
  background-image: -ms-linear-gradient(top, #45b3f7, #5783fa);
  background-image: -o-linear-gradient(top, #45b3f7, #5783fa);
  background-image: linear-gradient(to bottom, #45b3f7, #5783fa);
  text-decoration: none;
}

#buttons {
	height: 600px;
	width: 400px;
	top:40px;
	left:40px;
	position:relative;
}
#bill {
	height: 550px;
	width: 400px;
	top:40px;
	left:540px;
	position:absolute;
}

div.vertical-line{
  width: 1px; /* Line width */
  background-color: red; /* Line color */
  height: 100%; /* Override in-line if you want specific height. */
  position:relative;
}
	
	</style>
<script> 
	$( document ).ready(function() {
       $("#header").load("jsp/header.jsp"); 
    });
    
</script>
</head>
<body bgcolor="#E6E6FA">
	<div>
	<div id="logo"></div>
	<div id="header"></div>
	<div id="shape">
		<div id="buttons" style="border:1px solid red">
			<c:forEach items="${dishes}" var="dish" varStatus="dishCounter">
				<div style="top:<c:out value='${20*dishCounter.count}' />px;left:20px;position:relative;">
					<input type="button" class="dishbtn" value="<c:out value='${dish.dishName}' />" id="button_<c:out value='${dishCounter.count}' />" />
				</div>
			</c:forEach>
		</div>
		
		<div id="bill" style="border:3px solid red">
			<hr style="border: 2px solid red;top:30px;width:398px;position:absolute" />
			<div class="vertical-line" style="height:550px;left:200px;" />
			<div class="vertical-line" style="height:550px;left:100px;" />
		</div>
	</div>
	</div>
</body>
</html>
