<%@page import="javax.naming.ldap.Rdn"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tech Mentor</title>

<link rel="stylesheet" type="text/css" href="css/w3.css">
</head>
<body>

<div class="w3-blue w3-xxlarge w3-center">Profile Page</div>

<%
PrintWriter write=response.getWriter();
HttpSession techUserSession=request.getSession(false);
if(session.getAttribute("user")!=null)
{
String user=(String)session.getAttribute("user");

}
else
{
	String redirectURL = "index.jsp";
    response.sendRedirect(redirectURL);
}
%>
<br/>
		Welcome <b>${user}</b>
<form action="LogOutServlet" method="post">
<input type="submit" value="Logout" class="w3-right w3-button w3-red w3-margin"/>
</form>
<div>
<table style="margin:200px auto;">
<tr>
	<td><a href="updateProfile.jsp" class="w3-button w3-green w3-xxxlarge"/>Update Profile</a></td>
	<td><a href="updateSkills.jsp" class="w3-button w3-yellow w3-xxxlarge"/>Update Skills</a></td>
</tr>
</table>

</div>
</body>
</html>