<%@page import="com.jsp.shoppingcart_application.dto.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart items</title>
</head>
<body>
	<%
	List<Item> items = (List<Item>) request.getAttribute("itemlist");
	double totalprice = (Double) request.getAttribute("totalprice");
	%>
	<table cellpadding="20px" border="1">
		<th>Brand</th>
		<th>Category</th>
		<th>Quantity</th>
		<th>Price</th>
		<%
		for (Item i : items) {
		%>
		<tr>
			<td><%=i.getBrand()%></td>
			<td><%=i.getCategory()%></td>
			<td><%=i.getQuantity()%></td>
			<td><%=i.getPrice()%></td>
		</tr>
		<%
		}
		%>
	</table>
	Total Price:<%=totalprice%>
	<a href="addorder">Buy now</a>

</body>
</html>