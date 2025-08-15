package com.ashu;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/msg")
public class MessageServlet extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException{
		String name = req.getParameter("name");
		PrintWriter pw = res.getWriter();
		pw.append(name+" Good Night !");
	}
	
}
