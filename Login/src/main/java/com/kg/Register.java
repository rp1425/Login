package com.kg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/regForm")
public class Register extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		try {
		String name= req.getParameter("name1");
		String number= req.getParameter("number1");
		String email = req.getParameter("email1");
		
		
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/kg", "root", "root");
				
				PreparedStatement stm = conn.prepareStatement("insert into members values (?,?,?)");
				stm.setString(1, name);
				stm.setString(2, number);
				stm.setString(3, email);
				
				stm.executeUpdate();
				out.print("registered successfully");
			} 
			
			
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>" + e.getMessage() + " </h3>");

		 }
		
	}

}
