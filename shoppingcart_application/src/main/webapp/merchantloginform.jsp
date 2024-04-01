<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login here</title>
<style type="text/css">
.an
{
text-decoration: none;
}
</style>
</head>
<body>
<form action="validatemerchant">
${msg}<br>
Enter email:	<input type="email" name="email"><br>
Enter password:	<input type="password" name="password"><br>
<input type="submit">
</form>
<button>
<a class="an" href="addmerchant">SignUp</a>
</button>
</body>
</html>