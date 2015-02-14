<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>


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


</style>

</head>
<body bgcolor="#E6E6FA">
	<div align="center">
		<div id="logo"></div>
		<div id="header"></div>
		<div id="shape">
							
            <div id="form">
              <form name="login" id="loginForm" action="../rms/Admin" method="post">
				<div id="row">
					<div id="cell">
						<h3>User ID&nbsp;&nbsp;</h3>
					</div>
				<div id="cell">
					<input type="text" name="username" />
				</div>
				</div>
			<br>
			
			<div id="row">
				<div id="cell">
					<h3>Password&nbsp;&nbsp;</h3>
				</div>
				<div id="cell">
					<input type="password" name="password" />
				</div>
			</div>
			<br>
			
			  <div id="row">
				<div id="cell">
					<h3>Name&nbsp;&nbsp;</h3>
				</div>
				<div id="cell">
					<input type="text" name="name" />
				</div>
			</div>
			<br>
			
			<div id="row">
				<div id="cell">
					<h3>Type&nbsp;&nbsp;</h3>
				</div>
				<div id="cell">
					<select name="type">
  							<option value="admin">Admin</option>
  							<option value="manager">Manager</option>
 							 <option value="supervisor">Supervisor</option>
  							<option value="kioskoperator">Kiosk Operator</option>
					</select>
				</div>
			</div>
			<br>
			
			<div id="row">
				<div id="cell">
					<h3>Location&nbsp;&nbsp;</h3>
				</div>
				<div id="cell">
					 <select name="location">
  							<option value="mumbai">Mumbai</option>
  							<option value="vadodara">Vadodara</option>
 							 
					</select>
				</div>
			</div>
			<br>
			
			
			<div id="row">
				<div id="cell">
					<h3>Phone Number&nbsp;&nbsp;</h3>
				</div>
				<div id="cell">
					  <input type="text" name="phonenumber" />
				</div>
			</div>
			<br>
			
			<div>
				<input type="submit" class="btn" value="Add User" />
			</div>
			</form>
		</div>
				
		

			
		</div>
	</div>
</body>
</html>
