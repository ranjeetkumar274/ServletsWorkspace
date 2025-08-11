package in.ashu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.ashu.dao.RegisterDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		String role = req.getParameter("role");
		
		boolean status = false;
		try {
			status = RegisterDAO.Newuser(fname, lname, email, pwd, gender, role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter pw = resp.getWriter();
		String response = null;
		if(status) {
			response = "You are Registered Succesfully. Please Login again!";
		}else {
			response = "Something Went Wrong , Register Again!!";
		}
		
		pw.append(response);
	}
}
