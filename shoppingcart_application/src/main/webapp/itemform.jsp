<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item form</title>
</head>
<body>
	<form:form action="additemtocart" modelAttribute="itemobj">
	<form:hidden path="pid"/>
Brand:<form:input path="brand" readonly="true" />
Category:<form:input path="category" readonly="true" />
Price:<form:input path="price" readonly="true" />
Enter quantity:<form:input path="quantity" />
		<input type="submit">
	</form:form>
</body>
</html>