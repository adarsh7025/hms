<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="../rms/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../rms/css/style.css" />
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
	top: 40px;
	left: 40px;
	position: relative;
}

#bill {
	height: 450px;
	width: 400px;
	top: 40px;
	left: 540px;
	position: absolute;
}

h3 {
	color: navy;
	position: center;
}
</style>
<script>
	$(document).ready(function() {
		$("#header").load("jsp/header.jsp");
	});

	function orderDish(id,price,name) {
		
		if($("#order_"+id).get(0)) {
			var quantity = $("#quantityValue_"+id).text();
			quantity++;
			price = price * quantity;
			var replace = true;
		}
		else
			var quantity = 1;
		
		$.ajax({
			type: "POST",
			url: "jsp/order.jsp",
			data: {
				"dishId"					: 	id,
				"dishPrice"					:	price,
				"dishName"					:	name,
				"dishQuantity"				:	quantity
				
			},
			success: function(msg) {
				if(replace) 
					$("#order_"+id).replaceWith(msg);
				else
					$("#bill").append(msg);
			}
		});

	}
</script>
</head>
<body bgcolor="#E6E6FA">
	<div>
		<div id="logo"></div>
		<div id="header"></div>
		<div id="shape">
			<div id="buttons">
				<c:forEach items="${dishes}" var="dish" varStatus="dishCounter">
					<div
						style="top:<c:out value='${20*dishCounter.count}' />px;left:20px;position:relative;">
						<input type="button" class="dishbtn"
							value="<c:out value='${dish.dishName}' />"
							id="button_<c:out value='${dishCounter.count}' />"
							onclick="orderDish(<c:out value='${dish.dishId}' />,<c:out value='${dish.price}' />,'<c:out value='${dish.dishName}' />');" />
					</div>
				</c:forEach>
			</div>
			<!-- template ends -->
<%
 String hiddenFieldValue="addUser";
%>
<!-- Start of admin.jsp code -->
<div id="form">
              <form name="login" id="adduserform" action="../rms/Admin2" method="post">
				<input type="hidden" name="hdField" value="<%=hiddenFieldValue%>" />
		<div id="row">
					
					<div id="cell">
						<h3>User ID</h3>
					</div>
				
					<div id="cell">
					<input type="text" name="username" />
					</div>
					<br>
					
					
					<div id="cell">
						<h3>Password</h3>
					</div>
					
				   <div id="cell">
				   		<input type="password" name="password" />
				   </div>
			</div>
			<br>
			
			<div id="row">
						<div id="cell" >
								<h3>Name&nbsp;&nbsp;</h3>
						</div>
					
						<div id="cell">
								<input type="text" name="name" style="width: 350px;"  />
						</div>
			</div>
			<br>
			
			<div id="row">
				<div id="cell">
					<h3>User Type&nbsp;&nbsp;</h3>
				</div>
				<div id="cell">
					<select name="type">
  							<option value="admin">Admin</option>
  							<option value="manager">Manager</option>
 							 <option value="supervisor">Supervisor</option>
  							<option value="kioskoperator">Kiosk Operator</option>
					</select>
				</div>
		
			
			
		
				<div id="cell">
					<h3>&nbsp;&nbsp;&nbsp;Location&nbsp;&nbsp;</h3>
				</div>
				<div id="cell">
					 <select name="location">
  							<option value="1">Mumbai</option>
  							<option value="2">Vadodara</option>
 							 
					</select>
				</div>
			</div>
			<br>
			
			<div id="row">
						<div id="cell" >
								<h3>Phone Number&nbsp;&nbsp;</h3>
						</div>
					
						<div id="cell">
								<input type="text" name="phonenumber" style="width: 350px;"  />
						</div>
			</div>
			<br>
			
			
			<div>
				<input type="submit" class="btn" value="Add User" />
			</div>
			
				
		
				</form>
				</div>
<!-- end of admin.jsp code -->

			
		</div>
	</div>
</body>
</html>
