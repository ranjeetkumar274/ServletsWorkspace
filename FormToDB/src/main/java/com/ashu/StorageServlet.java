package com.ashu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class StorageServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		PrintWriter pw = res.getWriter();
		
		String bookId = req.getParameter("bookId");
		String bookName = req.getParameter("bookName");
		String bookPrice = req.getParameter("bookPrice");
		
		
		try {
			Connection con = ConnectionFactory.getDBConnection();
			
			String sql = "INSERT INTO BOOKS VALUES(?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(bookId));
			pstmt.setString(2, bookName);
			pstmt.setDouble(3,Double.parseDouble(bookPrice));
			
			
			int rows = pstmt.executeUpdate();
			
			con.close();
			
			 if (rows > 0) {
	                pw.println("✅ Book inserted successfully!");
	            } else {
	                pw.println("⚠️ Book insertion failed.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            pw.println("❌ An error occurred: " + e.getMessage());
	        }
	    }
	}

