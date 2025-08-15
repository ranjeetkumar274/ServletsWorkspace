package com.ashu;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		PrintWriter pw = res.getWriter();
		
		LocalTime t = LocalTime.now();
		
		LocalTime t1 = LocalTime.parse("06:00");
		LocalTime t2 = LocalTime.parse("12:00");
		LocalTime t3 = LocalTime.parse("16:00");
		LocalTime t4 = LocalTime.parse("20:00");
		
		if(t.isBefore(t2) && t.isAfter(t1)) {
			pw.append("<h1>Good Morning !</h1>");
		}
		else if(t.isBefore(t3) && t.isAfter(t2)) {
			pw.append("<h1>Good afternoon !</h1>");
		}
		else if(t.isBefore(t4) && t.isAfter(t3)) {
			pw.append("<h1>Good Evening !</h1>");
		}
		else {
			pw.append("<h1>Good Night !</h1>");
		}
	}

}
