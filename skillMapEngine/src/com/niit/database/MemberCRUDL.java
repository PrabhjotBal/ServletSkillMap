package com.niit.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.niit.model.Employee;
import com.niit.model.Employer;

public class MemberCRUDL {

	public boolean insertEmployee(Employee employee) {
		Connection connect = ConnectionService.connection();

		try {

			PreparedStatement statement = connect.prepareStatement(
					"insert into employeetbl(email,password,employeeName,gender,dateOfBirth,phoneNumber,role,valid) values(?,?,?,?,?,?,?,?)");
			statement.setString(1, employee.getEmail());
			statement.setString(2, employee.getPassword());
			statement.setString(3, employee.getEmployeeName());
			statement.setString(4, employee.getGender());
			statement.setString(5, employee.getDateOfBirth());
			statement.setString(6, employee.getPhoneNo());
			statement.setString(7, employee.getRole());
			statement.setByte(8, (byte) 0);
			int result = statement.executeUpdate();
			if (result >= 1)
				return true;
			else
				return false;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}

	public boolean insertEmployer(Employer employer) {
		Connection connect = ConnectionService.connection();

		try {

			PreparedStatement statement = connect.prepareStatement("insert into employertbl values(?,?,?,?)");
			statement.setString(1, employer.getEmail());
			statement.setString(2, employer.getPassword());
			statement.setString(3, employer.getProjectName());
			statement.setString(4, employer.getLocation());

			int result = statement.executeUpdate();
			if (result >= 1)
				return true;
			else
				return false;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}

	public boolean loginEmployee(Employee employee) {
		Connection connect = ConnectionService.connection();

		try {

			PreparedStatement statement = connect
					.prepareStatement("select email,password from employeetbl where email=? and password=? and role=?");
			statement.setString(1, employee.getEmail());
			statement.setString(2, employee.getPassword());
			statement.setString(3, employee.getRole());
			ResultSet resultset = statement.executeQuery();
			if (resultset.next())
				return true;
			else
				return false;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}
	public boolean loginEmployer(Employer employer) {
		Connection connect = ConnectionService.connection();

		try {

			PreparedStatement statement = connect
					.prepareStatement("select email,password from employertbl where email=? and password=? ");
			statement.setString(1, employer.getEmail());
			statement.setString(2, employer.getPassword());
			
			ResultSet resultset = statement.executeQuery();
			if (resultset.next())
				return true;
			else
				return false;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}

	public void listEmployee(Employee techmentor) {
		Connection connect = ConnectionService.connection();

		try {

			PreparedStatement statement = connect.prepareStatement("select * from employeetbl where email=?");
			statement.setString(1, techmentor.getEmail());

			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				techmentor.setEmail(resultset.getString(1));
				techmentor.setPassword(resultset.getString(2));
				techmentor.setEmployeeName(resultset.getString(3));
				techmentor.setGender(resultset.getString(4));
				techmentor.setDateOfBirth(resultset.getString(5));
				techmentor.setPhoneNo(resultset.getString(6));
				techmentor.setQualification(resultset.getString(8));
				techmentor.setSkills(resultset.getString(9));
				techmentor.setExperience(resultset.getByte(10));
				techmentor.setDesignation(resultset.getString(11));
				techmentor.setSupervisorName(resultset.getString(12));
				techmentor.setLocation(resultset.getString(13));
				techmentor.setAddress(resultset.getString(14));
				techmentor.setCertification(resultset.getString(15));
				techmentor.setIsValid(resultset.getByte(16));

			} else {
				System.out.println("error");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		}

	}

	public boolean updateEmployee(Employee techmentor) {
		Connection connect = ConnectionService.connection();

		try {

			PreparedStatement statement = connect.prepareStatement("update employeetbl set password=?,phoneNumber=?,"
					+ "qualification=?,skills=?,experience=?,designation=?,supervisorName=?,location=?,address=?,certification=? where email=?");
			statement.setString(1, techmentor.getPassword());
			statement.setString(2, techmentor.getPhoneNo());
			statement.setString(3, techmentor.getQualification());
			statement.setString(4, techmentor.getSkills());
			statement.setByte(5, techmentor.getExperience());
			statement.setString(6, techmentor.getDesignation());
			statement.setString(7, techmentor.getSupervisorName());
			statement.setString(8, techmentor.getLocation());
			statement.setString(9, techmentor.getAddress());
			statement.setString(10, techmentor.getCertification());
			statement.setString(11, techmentor.getEmail());
			int result = statement.executeUpdate();
			if (result >= 1)
				return true;
			else
				return false;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}

	/*
	 * public int countProfileCompletion(Employee techmentor) { int count = 1; int i
	 * = 1; String result = ""; Connection connect = ConnectionService.connection();
	 * try {
	 * 
	 * PreparedStatement statement =
	 * connect.prepareStatement("select * from employeetbl where email=?");
	 * statement.setString(1, techmentor.getEmail()); ResultSet resultSet =
	 * statement.executeQuery(); if (resultSet.next()) { while (i <= 16) { result =
	 * resultSet.getString(i); System.out.println(result); if (result == "null") {
	 * count++; } i++; } } return count; } catch (SQLException exception) {
	 * 
	 * System.out.println(exception.getMessage() + " Error in counting"); return
	 * count; } }
	 */
	public boolean appendSkills(Employee techmentor) {
		Connection connect = ConnectionService.connection();

		try {

			PreparedStatement statement = connect
					.prepareStatement("update employeetbl set skills=CONCAT(skills,',',?) where email=?");

			statement.setString(1, techmentor.getSkills());
			statement.setString(2, techmentor.getEmail());

			int result = statement.executeUpdate();
			if (result >= 1)
				return true;
			else
				return false;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}

	public ResultSet listAllEmployee() {
		Connection connect = ConnectionService.connection();

		try {

			PreparedStatement statement = connect.prepareStatement("select * from employeetbl where role='employee' ");

			
			ResultSet resultset = statement.executeQuery();
			
				return resultset;

			
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		return null;
	

	}
	public Boolean changeStatus(Employee employee)
	{
		Connection connect = ConnectionService.connection();
		byte valid=0;
		try {
			PreparedStatement statement = connect
					.prepareStatement("select valid from employeetbl where email=?");
			statement.setString(1, employee.getEmail());
			ResultSet resultset=statement.executeQuery();
			if(resultset.next())
			{
				valid=resultset.getByte(1);
			}
			System.out.println(valid);
			PreparedStatement statement1 = connect
					.prepareStatement("update employeetbl set valid=? where email=?");
			
			
			if(valid==1)
			{
			statement1.setByte(1,(byte) 0);
			}
			else
			{
				statement1.setByte(1,(byte) 1);
			}
			statement1.setString(2, employee.getEmail());

			int result = statement1.executeUpdate();
			if (result >= 1)
				return true;
			else
				return false;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
	}

}