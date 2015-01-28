
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Restaurant System</title>
	 <style>
	   #background {
		    position: fixed;
		    top: 0;
		    left: 0;
		    width: 100%;
		    height: 100%;
		    background-image: url('../img/idli.jpg');
		    background-repeat: no-repeat;
		    background-attachment: fixed;
		    background-size: 100%;
		    opacity: 0.4;
		    filter:alpha(opacity=40);
			}
	   bloc {
	        display:block;
	        background-color:#000000;
	        margin: 230px;
	        margin-top: 150px;
	        font-size: 30px;
	        font-color: #FFFFFF;
	        height: 400px;
	        border: 2px solid;
	    	opacity: 0.80;
	    	filter: alpha(opacity=80);
	      	}
	   #form {
		    position: absolute;
		    left: 350px;
		    top: 180px;
		    width: 600px;
			}
	   h3 {
	 		color:#FFFFFF;
	 		}
	   #row {
	        display: table-row;
	    	}
	   #cell {
	        display: table-cell;
	        padding-left: 5px;
	        padding-right: 5px;
	    }
		    .btn {
			  background: #000000;
			  background-image: -webkit-linear-gradient(top, #000000, #000000);
			  background-image: -moz-linear-gradient(top, #000000, #000000);
			  background-image: -ms-linear-gradient(top, #000000, #000000);
			  background-image: -o-linear-gradient(top, #000000, #000000);
			  background-image: linear-gradient(to bottom, #000000, #000000);
			  -webkit-border-radius: 0;
			  -moz-border-radius: 0;
			  border-radius: 0px;
			  font-family: Georgia;
			  color: #ffffff;
			  font-size: 20px;
			  padding: 10px 20px 10px 20px;
			  border: solid #faf7fa 2px;
			  text-decoration: none;
			}
	
		.btn:hover {
			  background: #313959;
			  background-image: -webkit-linear-gradient(top, #313959, #313959);
			  background-image: -moz-linear-gradient(top, #313959, #313959);
			  background-image: -ms-linear-gradient(top, #313959, #313959);
			  background-image: -o-linear-gradient(top, #313959, #313959);
			  background-image: linear-gradient(to bottom, #313959, #313959);
			  text-decoration: none;
		}
		
	 </style>
	</head>
	<body>
		<div id="background">
		</div>
		<bloc>
		</bloc>
		
		<form name="login" id="loginForm">
			<div id="form">
				<div id="row">
					<div id="cell"><h3>Username&nbsp;&nbsp;</h3></div>
					<div id="cell"><input type="text" name="username" /></div>
				</div>
				<br>
				<div id="row">
					<div id="cell"><h3>Password&nbsp;&nbsp;</h3></div>
					<div id="cell"><input type="password" name="password" /></div>
				</div><br>
				<div><input type="button" class="btn" value="Login" /></div>
			</div>
		</form>
	</body>
</html>