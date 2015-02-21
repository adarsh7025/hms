
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant System</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="background"></div>
	<bloc> </bloc>

	<form name="login" id="loginForm" action="../rms/AuthenticateUser" method="post">
		<div id="form">
			<div id="row">
				<div id="cell">
					<h3 class="login-label">Username&nbsp;&nbsp;</h3>
				</div>
				<div id="cell">
					<input type="text" name="username" />
				</div>
			</div>
			<br>
			<div id="row">
				<div id="cell">
					<h3 class="login-label">Password&nbsp;&nbsp;</h3>
				</div>
				<div id="cell">
					<input type="password" name="password" />
				</div>
			</div>
			<br>
			<div>
				<input type="submit" class="btn" value="Login" />
			</div>
		</div>
	</form>
</body>
</html>
