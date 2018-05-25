<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SkillMapEngine</title>
<link rel="stylesheet" type="text/css" href="css/w3.css">
<style>
	body
	{
		margin:0;
	}
</style>
</head>
<body>
<div class="w3-container w3-center w3-blue">
<h1 >Skill Map Engine</h1>
</div>
<form action="LoginServlet" method="post">
<table style="margin:200px auto;" cellpadding="10">
<tr><td>Username</td><td><input type="text" name="username" required/></td></tr>
<tr><td>Password</td><td><input type="password" name="password" required/></td></tr>
<tr><td>Category</td><td>
<select name="category">
<option value="0">--Select--</option>
<option value="employee">Employee</option>
<option value="hr">HR</option>
<option value="employer">Employer</option>
</select></td></tr>
<tr><td></td><td><input type="submit" value="Login" class="w3-bar w3-green"/></td></tr>
<tr><td></td><td>Not a User?<a href="registration.jsp">Register here</a></td></tr>
</table>
</form>
</body>
</html>