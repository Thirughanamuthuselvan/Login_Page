package com.tms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
    	
    	PrintWriter pw=res.getWriter();  
    	res.setContentType("text/html");
	    String username=req.getParameter("uname");
	    String upassword=req.getParameter("pass");
	  
	    Connection con=null;
	    try {
	       con=DBConnection.getCon();
		   Statement ps=con.createStatement();
		   ResultSet rs=ps.executeQuery("select * from loginpage where uname= "+username+" and upass=" +upassword+" ;");
		   System.out.println("1");
		   if(rs.next()) {
			   pw.print("Login Successful..");
			   RequestDispatcher rd=req.getRequestDispatcher("dis");
			   rd.forward(req, res);
		   }
		   else {
			   pw.print("Invalid userlogin..");
			   RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			   rd.include(req, res);
		   }
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
    }


}


