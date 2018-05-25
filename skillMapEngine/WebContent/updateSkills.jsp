
<%@page import="com.niit.database.MemberCRUDL"%>
<%@page import="com.niit.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Skills</title>
<link rel="stylesheet" type="text/css" href="css/w3.css">
</head>
<body>
<%
HttpSession sessionUpdate= request.getSession(false);
String user=(String)sessionUpdate.getAttribute("user");


Employee techmentor=new Employee();
techmentor.setEmail(user);
MemberCRUDL techmentorCRUDL=new MemberCRUDL();
techmentorCRUDL.listEmployee(techmentor);
String skills=techmentor.getSkills();

%>

<div class="w3-blue w3-xxlarge w3-center">Update Skills</div>

<form action="LogOutServlet" method="post">
<input type="submit" value="Logout" class="w3-right w3-button w3-red w3-margin"/>
</form>
<form action="UpdateServlet" action="post">

<input type="hidden" name="skills" value="skills"/>
<table style="margin:100px auto;width:500px" cellpadding="20">
<tr><td>Current Skills:</td><td><b><%=skills%></b></td></tr>

<tr><td>Concatenate Skills:</td><td><input type="text" name="newSkills"/></td></tr>
<tr><td></td><td><input type="submit" value="Add" class="w3-green w3-bar"/></td></tr>
</table>
</form>
</body>
</html>