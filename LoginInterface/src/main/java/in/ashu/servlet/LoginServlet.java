package in.ashu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.ashu.dao.LoginDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		String found = "";
		
		try {
			found = LoginDAO.oldUser(email, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out = resp.getWriter();
		
		RequestDispatcher rd = req.getRequestDispatcher("studentdashboard.html");
		RequestDispatcher rd1 = req.getRequestDispatcher("facultydashboard.html");
		
		if(found.equals("Student")) {
			rd.forward(req, resp);
		}else if(found.equals("Faculty")) {
			rd1.forward(req,resp);
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Failed! Please try again.');");
			out.println("location='login.html';"); // redirect after alert
			out.println("</script>");
		}
	}
}
