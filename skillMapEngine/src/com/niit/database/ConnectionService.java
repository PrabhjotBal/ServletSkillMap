package com.niit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

	private static Connection conObj;
	public ConnectionService()
	{
		
	}
	public static Connection connection()
	{
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		conObj=DriverManager.getConnection("jdbc:mysql://localhost/skillmapenginedb","root","");
		return conObj;
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		catch(SQLException ex)
		{
			System.out.println(""+ex.getMessage());
			return null;
		}
		
	}
}
