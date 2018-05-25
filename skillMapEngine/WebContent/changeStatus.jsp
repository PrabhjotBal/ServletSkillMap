<%@page import="java.io.PrintWriter"%>
<%@page import="com.niit.database.MemberCRUDL"%>
<%@page import="com.niit.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<%
	PrintWriter write=response.getWriter();

	Employee employee=new Employee();
	String email=request.getParameter("email");
	employee.setEmail(email);
	MemberCRUDL crudl=new MemberCRUDL();
	RequestDispatcher rd;
	if(crudl.changeStatus(employee))
	{
		write.println("<b>Status Changed</b>");
		rd=request.getRequestDispatcher("hrProfile.jsp");
		rd.forward(request, response);
	}
	else
	{
		write.println("<b>Some error occured</b>");
	}
%>
</body>
</html>