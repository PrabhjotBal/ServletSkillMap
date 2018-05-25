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

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		
		PrintWriter write = response.getWriter();
		String result = request.getParameter("skills");
		switch (result) {
		case "skills": {
			String skills = request.getParameter("newSkills");
			HttpSession sessionUpdate1 = request.getSession(false);
			String user = (String) sessionUpdate1.getAttribute("user");
			Employee techmentor = new Employee();
			techmentor.setEmail(user);
			techmentor.setSkills(skills);
			MemberCRUDL techmentorCRUDL = new MemberCRUDL();
			RequestDispatcher rd;
			if (techmentorCRUDL.appendSkills(techmentor)) {
				write.println("<b>Update Successful</b>");
				rd=request.getRequestDispatcher("updateSkills.jsp");
				rd.include(request, response);

			} else {
				write.println("<b>Update Error</b>");
				rd=request.getRequestDispatcher("updateSkills.jsp");
				rd.include(request, response);
			} 
			break;
		}
		default: {

			write.println(request.getParameter("skills"));
			HttpSession sessionUpdate2 = request.getSession(false);
			String user = (String) sessionUpdate2.getAttribute("user");
			Employee techmentor = new Employee();
			String password = request.getParameter("password");
			String phoneNo=request.getParameter("phoneNo");
			String qualification=request.getParameter("qualification");
			String skills=request.getParameter("skill");
			byte experience = Byte.parseByte(request.getParameter("experience"));
			String designation=request.getParameter("designation");
			String supervisorName=request.getParameter("supervisorName");
			String location=request.getParameter("location");
			String address=request.getParameter("address");
			String certification=request.getParameter("certification");
			techmentor.setEmail(user);
			techmentor.setPassword(password);
			techmentor.setPhoneNo(phoneNo);
			techmentor.setQualification(qualification);
			techmentor.setSkills(skills);
			techmentor.setExperience(experience);
			techmentor.setDesignation(designation);
			techmentor.setSupervisorName(supervisorName);
			techmentor.setLocation(location);
			techmentor.setAddress(address);
			techmentor.setCertification(certification);
			MemberCRUDL techmentorCRUDL = new MemberCRUDL();
			RequestDispatcher rd;
			if (techmentorCRUDL.updateEmployee(techmentor)) {
				write.println("<b>Update Successful</b>");
				rd=request.getRequestDispatcher("updateProfile.jsp");
				rd.include(request, response);
			} else {
				write.println("Update Error");
				

			}
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
