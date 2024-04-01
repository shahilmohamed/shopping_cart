<%@page import="com.jsp.shoppingcart_application.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merchant operations</title>
<style type="text/css">
.an
{
text-decoration: none;
}
</style>
</head>
<body>
${msg}
<% Merchant m = (Merchant) session.getAttribute("merchantinfo");
if(m!=null){
%>
	<h3>Merchant operations</h3>
	<button>
		<a href="addproduct" class="an">Add product</a>
	</button>
	<br>
	<button>
		<a href="viewproduct" class="an">View all products</a>
	</button>
	<%} 
	else
	{%>
	<a href="merchantloginform.jsp">Login first</a>
	<%} %>
</body>
</html>