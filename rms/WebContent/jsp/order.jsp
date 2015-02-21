<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<c:if test="${param.action == 'order'}">
		<div id="order_<c:out value='${param.dishId}' />"
			style="width: 398px; top: 0px; height: 30px; position: relative;">
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
					style="left: 40px; top: -10px; color: #2ECCFA; position: absolute;">
					<c:out value='${param.dishQuantity}' />
				</h3>
				<a class="arrow" href="#"
					onclick="reduceQuantity(<c:out value='${param.dishId}' />,<c:out value='${param.dishPrice}' />,<c:out value='${param.dishQuantity}' />)"><img
					src="images/down-arrow.png" name="arrow"
					style="margin-top: 5px; width: 30px; height: 30px;" /></a>
			</div>
			<div id="price_<c:out value='${param.dishId}' />"
				style="left: 311px; top: 0px; width: 88px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
				<h3 id="priceValue_<c:out value='${param.dishId}' />"
					style="right: 25px; top: -10px; color: #2ECCFA; position: absolute;">
					<c:out value='${param.dishPrice}' />
				</h3>
			</div>
		</div>
	</c:if>


	<c:if test="${param.action == 'bill'}">
		<!-- Display the total amount -->
		<div id="statement" style="bottom: 2px; position: absolute;">
			<div id="total_statement"
				style="width: 398px; top: 0px; height: 30px; position: relative;">
				<div id="total_text"
					style="left: -1px; top: 0px; width: 400px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
					<h3
						style="left: 30px; top: -10px; color: #2ECCFA; position: absolute;">
						Total</h3>
				</div>
				<div id="total_amount"
					style="left: 311px; top: 0px; width: 88px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
					<h3
						style="right: 25px; top: -10px; color: #2ECCFA; position: absolute;">
						<c:out value='${param.total}' />
					</h3>
				</div>
			</div>
			<!-- Display the tax amount -->
			<div id="tax_statement"
				style="width: 398px; top: 1px; height: 30px; position: relative;">
				<div id="tax_text"
					style="left: -1px; top: 0px; width: 400px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
					<h3
						style="left: 30px; top: -10px; color: #2ECCFA; position: absolute;">
						Tax&nbsp;&nbsp;(@&nbsp;
						<c:out value="${param.tax}"></c:out>
						%)
					</h3>
				</div>
				<div id="tax_amount"
					style="left: 311px; top: 0px; width: 88px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
					<h3
						style="right: 25px; top: -10px; color: #2ECCFA; position: absolute;">
						<c:out value='${param.taxAmount}' />
					</h3>
				</div>
			</div>
			<!-- Display the bill amount -->
			<div id="bill_statement"
				style="width: 398px; top: 2px; height: 30px; position: relative;">
				<div id="bill_text"
					style="left: -1px; top: 0px; width: 400px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
					<h3
						style="left: 30px; top: -10px; color: #2ECCFA; position: absolute;">
						Bill</h3>
				</div>
				<div id="bill_amount"
					style="left: 311px; top: 0px; width: 88px; height: 30px; border: 1px solid #D8D8D8; position: absolute;">
					<h3
						style="right: 25px; top: -10px; color: #2ECCFA; position: absolute;">
						<c:out value='${param.bill}' />
					</h3>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>
