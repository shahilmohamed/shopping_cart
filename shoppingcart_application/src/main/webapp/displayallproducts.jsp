<%@page import="com.jsp.shoppingcart_application.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
</head>
<body>
	<%
	List<Product> products = (List<Product>) request.getAttribute("productslist");
	%>
	<table cellpadding="20px" border="1">
		<th>brand</th>
		<th>category</th>
		<th>price</th>
		<th>add</th>
		<%
		for (Product p : products) {
		%>
		<tr>
			<td><%=p.getBrand() %></td>
			<td><%=p.getCategory() %></td>
			<td><%=p.getPrice() %></td>
			<td><a href="additemtocart?id=<%=p.getId()%>">Add to cart</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>