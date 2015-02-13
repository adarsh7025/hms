<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<div id="order_<c:out value='${param.dishId}' />"
		style="width: 398px; top: 1px; height: 30px; position: relative;">
		<div id="dishName_<c:out value='${param.dishId}' />"
			style="left: -1px; top: 0px; width: 220px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
			<h3 id="nameValue_<c:out value='${param.dishId}' />"
				style="left: 30px; top: -10px; color: #2ECCFA; position: absolute;">
				<c:out value='${param.dishName}' />
			</h3>
		</div>
		<div id="qty_<c:out value='${param.dishId}' />"
			style="left: 220px; top: 0px; width: 89px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
			<h3 id="quantityValue_<c:out value='${param.dishId}' />"
				style="left: 30px; top: -10px; color: #2ECCFA; position: absolute;"><c:out value='${param.dishQuantity}' /></h3>
		</div>
		<div id="price_<c:out value='${param.dishId}' />"
			style="left: 311px; top: 0px; width: 88px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
			<h3 id="priceValue_<c:out value='${param.dishId}' />"
				style="right: 25px; top: -10px; color: #2ECCFA; position: absolute;">
				<c:out value='${param.dishPrice}' />
			</h3>
		</div>
	</div>
</body>
</html>