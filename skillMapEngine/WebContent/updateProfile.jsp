<%@page import="com.niit.database.MemberCRUDL"%>
<%@page import="com.niit.model.Employee"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
<link rel="stylesheet" type="text/css" href="css/w3.css">
</head>
<body>
<div class="w3-blue w3-xxlarge w3-center">Update Page</div>
<%
HttpSession sessionUpdate= request.getSession(false);
String user=(String)sessionUpdate.getAttribute("user");
PrintWriter write=response.getWriter();

Employee techmentor=new Employee();
techmentor.setEmail(user);
MemberCRUDL techmentorCRUDL=new MemberCRUDL();
techmentorCRUDL.listEmployee(techmentor);
String email=techmentor.getEmail();
String password=techmentor.getPassword();
String employeeName=techmentor.getEmployeeName();
String gender=techmentor.getGender();
String dateOfBirth=techmentor.getDateOfBirth();
String phoneNo=techmentor.getPhoneNo();
String address=techmentor.getAddress();
String qualification=techmentor.getQualification();
String skills=techmentor.getSkills();
byte experience=techmentor.getExperience();
String designation=techmentor.getDesignation();
String supervisorName=techmentor.getSupervisorName();
String location=techmentor.getLocation();
String certification=techmentor.getCertification();
byte validStatus=techmentor.getIsValid();
String isValid="";
if(validStatus==(byte)0)
{
		isValid="Pending";
}
else
{
	isValid="Approved";
}

%>
<a href="techMentorProfile.jsp" class="w3-button w3-orange" style="position:relative;top:20px;">Back</a>
<form action="LogOutServlet" method="post">
<input type="submit" value="Logout" class="w3-right w3-button w3-red"/>
</form>
		<form action="UpdateServlet" method="post">
		<input type="hidden" name="skills" value=""/>
			<table style="margin:100px auto;">
				<tr><td>Email</td><td><input type="text" value="<%=email %>" name="email" disabled="disabled"/></td></tr>
				<tr><td>Password</td><td><input type="text" value="<%=password %>" name="password"/></td></tr>
				<tr><td>Employee Name</td><td><input type="text" value="<%=employeeName %>" name="email" disabled="disabled"/></td></tr>
				<tr><td>Gender</td><td><input type="text" value="<%=gender %>" name="gender" disabled="disabled"/></td></tr>
				<tr><td>Date of Birth</td><td><input type="text" value="<%=dateOfBirth %>" name="dateOfBirth" disabled="disabled"/></td></tr>
				<tr><td>Phone no.</td><td><input type="text" value="<%=phoneNo %>" name="phoneNo"/></td></tr>
				<tr><td>Address</td><td><textarea name="address"> <%=address %> </textarea></td></tr>
				<tr><td>Qualification</td><td><input type="text" value="<%=qualification %>" name="qualification"/></td></tr>
				<tr><td>Skills</td><td><input type="text" value="<%=skills %>" name="skill"/></td></tr>
				<tr><td>Experience (in months)</td><td><input type="number" min="0" max="500" value="<%=experience %>" name="experience"/></td></tr>
				<tr><td>Designation</td><td><input type="text" value="<%=designation %>" name="designation"/></td></tr>
				<tr><td>Supervisor Name</td><td><input type="text" value="<%=supervisorName %>" name="supervisorName"/></td></tr>
				<tr><td>Current Location</td><td><input type="text" value="<%=location %>" name="location"/></td></tr>
				<tr><td>Certifications</td><td><input type="text" value="<%=certification %>" name="certification"/></td></tr>
				<tr><td>Validation Status</td><td><input type="text" value="<%=isValid %>" name="isValid" disabled="disabled"/></td></tr>
				
				<tr><td></td><td><input type="submit" value="Update"/></td></tr>
			</table>
		</form>
</body>
</html>