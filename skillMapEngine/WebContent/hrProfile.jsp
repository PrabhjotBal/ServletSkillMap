<%@page import="java.sql.ResultSet"%>
<%@page import="com.niit.database.MemberCRUDL"%>
<%@page import="com.niit.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR Profile</title>

<link rel="stylesheet" type="text/css" href="css/w3.css">
</head>
<body>
<sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/skillmapenginedb"
        user="root" password=""
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM employeetbl where role='employee';
    </sql:query>

<div class="w3-blue w3-xxlarge w3-center">HR Profile</div>
<form action="LogOutServlet" method="post">
<input type="submit" value="Logout" class="w3-right w3-button w3-red"/>
</form>
<table class="" style="width:800px;margin:auto;" border="1" cellpadding="">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>Email</th>
                <th>EmployeeName</th>
                <th>Gender</th>
                <th>Phone Number</th>
                <th>Qualification</th>
                <th>Skills</th>
                <th>Experience</th>
                <th>Designation</th>
                <th>Supervisor Name</th>
                <th>Current Location</th>
                <th>Certification</th>
                <th>Verified</th>
                <th>Status</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.employeeName}" /></td>
                    <td><c:out value="${user.gender}" /></td>
                    <td><c:out value="${user.phoneNumber}" /></td>
                    <td><c:out value="${user.qualification}" /></td>
                    <td><c:out value="${user.skills}" /></td>
                    <td><c:out value="${user.experience}" /></td>
                    <td><c:out value="${user.designation}" /></td>
                    <td><c:out value="${user.supervisorName}" /></td>
                    <td><c:out value="${user.location}" /></td>
                    <td><c:out value="${user.certification}" /></td>
                    <td><c:out value="${user.valid}" /></td>
                    <td><a href="changeStatus.jsp?email=<c:out value='${user.email}' />">Change</a></td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>