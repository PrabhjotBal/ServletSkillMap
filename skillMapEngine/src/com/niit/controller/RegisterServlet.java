package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.database.MemberCRUDL;
import com.niit.model.Employee;
import com.niit.model.Employer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String result = request.getParameter("type");
		
		switch (result) {
		case "1": {
			String email = request.getParameter("email");

			String employeeName = request.getParameter("employeeName");

			String password = request.getParameter("password");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String phoneNo = request.getParameter("phoneNo");
			String gender = request.getParameter("gender");
			String role = request.getParameter("role");

			Employee employee = new Employee();
			employee.setEmail(email);
			employee.setEmployeeName(employeeName);
			employee.setPassword(password);
			employee.setDateOfBirth(dateOfBirth);
			employee.setPhoneNo(phoneNo);
			employee.setGender(gender);
			employee.setRole(role);
			MemberCRUDL employeeCRUD = new MemberCRUDL();
			RequestDispatcher requestdispatcher;
			if (employeeCRUD.insertEmployee(employee)) {
				out.println("<b>Registration Successful</b>");

				requestdispatcher = request.getRequestDispatcher("index.jsp");

				 requestdispatcher.include(request, response);
			} else {
				out.println("This email is already in use");
				// rd=request.getRequestDispatcher("/registration.jsp");
				// rd.forward(request, response);
			}

			break;
		}
		case "2": {
			
			  String emailEmployer=request.getParameter("employerEmail");
			 String password=request.getParameter("employerPassword");
			 String employerProject=request.getParameter("employerProject");
			  
			  String location=request.getParameter("location");
			 
			  Employer employer=new Employer();
			  employer.setEmail(emailEmployer);
			  employer.setPassword(password);
			  employer.setProjectName(employerProject);
			  employer.setLocation(location);
			  MemberCRUDL crudl=new MemberCRUDL(); 
			  RequestDispatcher rd;
			  if(crudl.insertEmployer(employer)) {
			  out.println("Registration Successful");
			  
			  rd= request.getRequestDispatcher("index.jsp");
			  rd.include(request, response);
			  } 
			  else {
			  out.println("There is some error please fill  again");
			  } 
			  break;
			 
		}
		default: {
			// String test=request.getParameter("type");

			out.println("Some Error occured");

			break;
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
