<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Restaurant System</title>
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script>
	$(document).ready(
			function() {
				$(function() {
					$("#header").load("jsp/header.jsp");

				});
				$("#clear").click(function() {
					
					$("#DishName").val("");
					$("#DishName").prop("readonly", false);
					$("#DishCategory").val("");
					$("#DishCategory").prop("readonly", false);
					$("#LocationId").val("");
					$("#LocationId").prop("readonly", false);
					$("#DishQuantity").val("");
					$("#DishQuantity").prop("readonly", false);
					$("#DishUnit").val("");
					$("#DishUnit").prop("readonly", false);
					$("#DishPrice").val("");
					$("#DishPrice").prop("readonly", false);
					
				});

				

			});
</script>
<style>
input[type="text"], select {
	display: block;
	margin: 0;
	width: 100%;
	font-family: sans-serif;
	font-size: 18px;
	appearance: none;
	box-shadow: none;
	border-radius: none;
	padding: 10px;
	border: solid 1px #dcdcdc;
	transition: box-shadow 0.3s, border 0.3s;
}

input[type="text"]:focus, select:focus {
	outline: none;
	border: solid 1px #707070;
	box-shadow: 0 0 5px 1px #969696;
}

h3.inventory-label {
	font: 17px Georgia, serif;
}

.btn {
	-webkit-border-radius: 3;
	-moz-border-radius: 3;
	border-radius: 3px;
	font-family: Arial;
	color: #ffffff;
	font-size: 20px;
	background: #00aeff;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
}

.btn:hover {
	background: #3cb0fd;
	background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
	background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
	text-decoration: none;
}

.ui-menu {
	width: 200px;
}
</style>

</head>
<body>
</head>
<body bgcolor="#E6E6FA">
	<div>
		<div id="logo"></div>
		<div id="header"></div>
		<div id="shape">
			<div id="DishAdd" name="DishAdd">
				
				<form name="dishaddform" action="admin" method="post">
					<h3 class="HDishName"
						style="top: 17px; left: 35px; position: absolute">Dish Name:</h3>
					<input type="text" id="DishName" name="DishName"
						style="top: 60px; left: 30px; width: 100px; height: 20px; position: absolute"
						value="" required />

					<h3 class="HDishPrice"
						style="top: 17px; left: 185px; position: absolute">Dish Price:</h3>
					<input type="text" id="DishPrice" name="DishPrice"
						style="top: 60px; left: 180px; width: 100px; height: 20px; position: absolute"
						value="" required />
						
					

					 <input type="hidden" id="action"name="action" value="addDishSubmit" /> 
					<input type="submit"
					style="top: 130px; left: 30px; position: absolute;" class="btn"
					value="Add Dish " /> &nbsp;&nbsp; <input type="button" id="clear"
					style="top: 130px; left: 180px; position: absolute;" class="btn"
					value="Clear" />
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>
