package com.kg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[]args) throws SQLException{
		
	
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kg", "root", "root");
	Statement stm = conn.createStatement();
	String query = "TRUNCATE TABLE members";
	stm.execute(query);
	
	System.out.println("created successfully");}
	
}
