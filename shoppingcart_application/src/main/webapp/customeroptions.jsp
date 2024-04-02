<%@page import="com.jsp.shoppingcart_application.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer operations</title>
</head>
<body>
<%Customer c = (Customer) session.getAttribute("customerinfo");
if(c!=null){%>
<h1>${msg }</h1>
<h1><a href="fetchallproducts">View All Products</a></h1>
<h1><a href="">View Product By Brand</a></h1>
<h1><a href="">View Product By Category</a></h1>
<h1><a href="">View Product By Price Range</a></h1>
<%} %>
</body>
</html>