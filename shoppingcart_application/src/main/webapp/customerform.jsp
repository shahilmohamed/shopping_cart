<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp here</title>
</head>
<body>
<form:form action="savecustomer" modelAttribute="customerobj">
Enter name:		<form:input path="name"/><br>
Enter email:	<form:input path="email"/><br>
Enter password:	<form:input path="password"/><br>
Enter mobile:	<form:input path="mobilenumber"/><br>
<input type="submit">
</form:form>
</body>
</html>