package com.tms;

import java.io.IOException;
import java.io.PrintWriter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
	        
		PrintWriter pw=res.getWriter();  
    	res.setContentType("text/html");
    	Connection con=DBConnection.getCon();
    	try {
			PreparedStatement ps=con.prepareStatement("select * from Student_Details");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				pw.println("Student id:\t"+rs.getString(1));
				pw.println("Student Name:\t"+rs.getString(2));
				pw.println("Dept:\t"+rs.getString(3));
				pw.println();
			}
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
