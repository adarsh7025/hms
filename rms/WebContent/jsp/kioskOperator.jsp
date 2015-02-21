<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Restaurant System</title>
<script src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/jquery-ui.js"></script>
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
</style>

<script>
	$(document).ready(function() {
		 $(function() {
			 $("#header").load("jsp/header.jsp");
			 var save = '<c:out value='${billSaveStatus}' />';
			 if(save == 'true')
	            $( "#dialog-true" ).dialog({
	               autoOpen: true, 
	               open: function(event, ui){
	            	     setTimeout("$('#dialog-true').dialog('close')",1500);
	            	    }
	            });
			 else if(save == 'false')
				 $( "#dialog-false" ).dialog({
		               autoOpen: true,  
		               open: function(event, ui){
		            	     setTimeout("$('#dialog-false').dialog('close')",1500);
		            	    }
		            });
	         });
		
	});
	
	function orderDish(id,price,name) {
		var oldPrice = 0;
		if($("#order_"+id).get(0)) {
			var quantity = $("#quantityValue_"+id).text();
			quantity++;
			oldPrice = $.trim($("#priceValue_"+id).text());
			price = price * quantity;
			var replace = true;
		}
		else
			var quantity = 1;
			
		 var search = $("#dishId").val().search(id);
		if(search == -1)
			$("#dishId").val($("#dishId").val() + id + ",") ;
		// ajax call to add order
		$.ajax({
			type: "POST",
			url: "jsp/order.jsp",
			data: {
				"action"					:	"order",
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
				 showAmount(oldPrice,price);
				},
		});//first ajax call ends

	}
	
	function showAmount(oldPrice,price) {
		var tax = parseFloat($("#tax").val());
		$("#total").val($("#total").val() - parseFloat(oldPrice) + price);
		var total = parseFloat($("#total").val());
		if(total == 0) {
			$("#statement").remove();
			return;
		}
		var taxAmount = Math.round((total * (tax/100))*100)/100;
		$("#taxAmount").val(taxAmount);
		$("#totalBill").val(Math.round((total + taxAmount)*100)/100);
		var bill =$("#totalBill").val(); 
		// ajax call to add total, tax and bill amount
		$.ajax({
			type: "POST",
			url: "jsp/order.jsp",
			data: {
				"action"					: 	"bill",
				"total"						:	total,
				"taxAmount"					:	taxAmount,
				"bill"						:	bill,
				"tax"						:	tax
			},
			success: function(msg2) {
				if($("#statement").get(0)) 
					$("#statement").replaceWith(msg2);
				else
					$("#bill").append(msg2);
			},
		});//second ajax call ends
		
	}
	
	function generateBill() {
		if(!$("#statement").get(0))
			return false;
		
		var dishIds = $("#dishId").val();
		var ids = dishIds.split(",");
		for(var i=0;i<ids.length-1;i++) {
			if($("#nameValue_"+ids[i]).get(0)) {
				$("#name").val($("#name").val() + $.trim($("#nameValue_" +ids[i]).text()) + ",");
				$("#quantity").val($("#quantity").val() + $.trim($("#quantityValue_" +ids[i]).text()) + ",");
				$("#price").val($("#price").val() + $.trim($("#priceValue_" +ids[i]).text()) + ",");
			}
		}
		return true;
	}
	
	function reduceQuantity(dishId,dishPrice,dishQuantity) {
		 var quantity =  parseFloat($.trim($("#quantityValue_"+dishId).text()));
		 var oldPrice = parseFloat($.trim($("#priceValue_"+dishId).text()));
		 var dishPrice = oldPrice / quantity;
		 quantity--;
		 oldPrice = oldPrice - dishPrice;
		 if(quantity == 0)
			 $("#order_"+dishId).remove();
		 else {
			 $("#quantityValue_"+dishId).text(quantity);
			 $("#priceValue_"+dishId).text(oldPrice);
		 }
		 showAmount(oldPrice,(oldPrice-dishPrice));
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
			<form name="biller" method="post" action="KioskOperatorControl"
				onsubmit="return generateBill();">
				<div id="bill" style="border: 1px solid #D8D8D8;">
					<div
						style="top: -1px; width: 398px; height: 38px; position: relative;">
						<div
							style="left: -1px; top: 0px; width: 220px; height: 38px; border: 1px solid #D8D8D8; position: absolute;">
							<h3
								style="left: 80px; top: 0px; color: #2ECCFA; position: absolute;">ITEM</h3>
						</div>
						<div
							style="left: 220px; top: 0px; width: 89px; height: 38px; border: 1px solid #D8D8D8; position: absolute;">
							<h3
								style="left: 20px; top: 0px; color: #2ECCFA; position: absolute;">QTY.</h3>
						</div>
						<div
							style="left: 311px; top: 0px; width: 88px; height: 38px; border: 1px solid #D8D8D8; position: absolute;">
							<h3
								style="left: 2px; top: 0px; color: #2ECCFA; position: absolute;">AMOUNT</h3>
						</div>
					</div>



				</div>
				<div
					style="left: 540px; top: 500px; width: 100px; height: 50px; position: absolute;">
					<input type="submit" class="dishbtn" value="Bill"
						style="width: 100px;" />
				</div>
				<input type="hidden" name="action" value="addBill" /> <input
					type="hidden" name="dishId" id="dishId" value="" /> <input
					type="hidden" name="name" id="name" value="" /> <input
					type="hidden" name="quantity" id="quantity" value="" /> <input
					type="hidden" name="price" id="price" value="" /> <input
					type="hidden" name="tax" id="tax" value="<c:out value='${tax}' />" />
				<input type="hidden" name="total" id="total" value="" /> <input
					type="hidden" name="taxAmount" id="taxAmount" value="" /> <input
					type="hidden" name="totalBill" id="totalBill" value="" />
				<div id="dialog-true" style="display: none;">Bill successfully
					generated.</div>
				<div id="dialog-false" style="display: none;">Failed to
					generate bill.</div>
			</form>
		</div>
	</div>
</body>
</html>
