package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.database.MemberCRUDL;
import com.niit.model.Employee;
import com.niit.model.Employer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter write=response.getWriter();
		String email=request.getParameter("username");
		
		String password=request.getParameter("password");
		
		String category=request.getParameter("category");
		switch(category)
		{
		case "employee":
		{

			Employee employee=new Employee();
			employee.setEmail(email);
			employee.setPassword(password);
			employee.setRole(category);
			MemberCRUDL employeeCRUD=new MemberCRUDL();
			RequestDispatcher rd;
			if(employeeCRUD.loginEmployee(employee))
			{	
				HttpSession session=request.getSession(true);  
		        session.setAttribute("user",email); 
				rd = request.getRequestDispatcher("techMentorProfile.jsp");
				rd.forward(request, response);
			}
			else
			{
				rd = request.getRequestDispatcher("index.jsp");
				write.println("<b>Invalid Username/Password</b>");
				rd.include(request, response);
			}
			
			break;
		}
		case "hr":
		{

			Employee employee=new Employee();
			employee.setEmail(email);
			employee.setPassword(password);
			employee.setRole(category);
			MemberCRUDL employeeCRUD=new MemberCRUDL();
			RequestDispatcher rd;
			if(employeeCRUD.loginEmployee(employee))
			{	
				HttpSession session=request.getSession(true);  
		        session.setAttribute("user",email); 
				response.sendRedirect("hrProfile.jsp");
				
			}
			else
			{
				rd = request.getRequestDispatcher("index.jsp");
				write.println("<b>Invalid Username/Password</b>");
				rd.include(request, response);
			}
			

			break;
		}
		default:
		{
			Employer employer=new Employer();
			employer.setEmail(email);
			employer.setPassword(password);
			
			MemberCRUDL employeeCRUD=new MemberCRUDL();
			RequestDispatcher rd;
			if(employeeCRUD.loginEmployer(employer))
			{	
				HttpSession session=request.getSession(true);  
		        session.setAttribute("user",email); 
				response.sendRedirect("employerProfile.jsp");
				
			}
			else
			{
				rd = request.getRequestDispatcher("index.jsp");
				write.println("<b>Invalid Username/Password</b>");
				rd.include(request, response);
			}
			break;
		}
		} 
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
