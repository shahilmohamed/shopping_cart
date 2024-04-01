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
	List<Product> product = (List<Product>) request.getAttribute("viewobj");
	%>
	<table cellpadding="20px" border="1">
		<tr>
			<th>Id</th>
			<th>Brand</th>
			<th>Category</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		for (Product p : product) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getBrand()%></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getStock()%></td>
			<td><a href="update.jsp?id=<%=p.getId() %>">update</a></td>
			<td><a href="delete.jsp?id=<%=p.getId() %>">delete</a></td>
		</tr>
		<%
		}
		%>
		<br>
		<a href="addproduct">Add product</a>
	</table>
</body>
</html>