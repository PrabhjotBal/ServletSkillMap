<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<link rel="stylesheet" type="text/css" href="css/w3.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script>
$(document).ready(function()
		{
	
		$("#category").change(function()
				{
			if($("#category").val()=="1")
				{
				$("#typeSelectedEmployee").val("1");
				$("#employeePanel").show();
				$("#employerPanel").hide();
				}
			else if($("#category").val()=="2")
				{
				$("#typeSelectedEmployer").val("2");
				$("#employeePanel").hide();
				$("#employerPanel").show();
				
				}
			else
				{
				$("#employeePanel").hide();
				$("#employerPanel").hide();
				
				}
				});
		});
</script>
</head>

<body>

<div class="w3-blue w3-xxlarge w3-center">Registration</div>


<table style="margin:50px auto 30px;">
<tr><td>Who are you?</td>
		<td>
		<select id="category">
		<option value="-1">--Select--</option>
		<option value="1">Employee</option>
		<option value="2">Employer</option>
		</select></td></tr></table>
	<form action="RegisterServlet" method="post">
	<input type="hidden" id="typeSelectedEmployee" name="type" value=""/>
		<div id="employeePanel" style="margin:auto; width:800px; display:none;" >
	<table style="margin:auto;" cellpadding="10">
	<tr><td>Email</td><td><input type="email" name="email" required/></td></tr>
	<tr><td>Password</td><td><input type="password" name="password" required/></td></tr>
	<tr><td>Name</td><td><input type="text" name="employeeName" required/></td></tr>
	<tr><td>Gender</td><td><input type="radio" value="male" name="gender" checked/>Male&nbsp;&nbsp;&nbsp;<input type="radio" value="female" name="gender"/>Female</td></tr>
	<tr><td>Date of Birth</td><td><input type="date" name="dateOfBirth" required/></td></tr>
	<tr><td>Phone No.</td><td><input type="tel" name="phoneNo" maxlength="10" required/></td></tr>
	<tr><td>Role</td><td>
						<select name="role" required>
							<option disabled="disabled">-Select-</option>
							<option value="employee">TechMentor</option>
							<option value="hr">HR</option>
						</select></td></tr>
	<tr><td><input type="reset" value="clear" class="w3-gray"/></td><td><input type="submit" value="Register" class="w3-bar w3-green"/></td></tr>
	</table>
	</form>
</div>

<div id="employerPanel" style="margin:auto; width:300px; display:none;">
<form action="RegisterServlet" method="post" style="margin:auto;">
<input type="hidden" id="typeSelectedEmployer" name="type" value=""/>
<table cellpadding="10">
	<tr><td>Email</td><td><input type="text" name="employerEmail" required/></td></tr>
	<tr><td>Password</td><td><input type="password" name="employerPassword" required/></td></tr>
	<tr><td>Project Name</td><td><input type="text" name="employerProject" required /></td></tr>
	
	<tr><td>Location</td><td><input type="text" name="location" required/></td></tr>
	<tr><td><input type="reset" value="Clear" class="w3-gray"/></td><td><input type="submit" value="Register" class="w3-bar w3-green"/></td></tr>
</table>
</form>
</div>
</body>
</html>