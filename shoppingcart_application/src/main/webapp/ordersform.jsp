<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order page</title>
</head>
<body>
<form:form action = "saveorder" modelAttribute="ordersobj">
Enter name:			<form:input path="name"/>
Enter mobilenumber:	<form:input path="mobilenumber"/>
Enter address:		<form:input path="address"/>
<input type="submit">
</form:form>
</body>
</html>