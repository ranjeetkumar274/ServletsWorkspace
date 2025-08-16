package in.ashu.servlet;

import java.io.IOException;

import in.ashu.dao.UserDAO;
import in.ashu.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/user")
public class UserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
	    int phone = Integer.parseInt(req.getParameter("phone"));
	    
	    UserDTO user = new UserDTO();
	    user.setUserName(name);
	    user.setUserEmail(email);
	    user.setUserPhno(phone);
	    
	    UserDAO dao = new UserDAO();
	    boolean isSaved = dao.saveUser(user);
	    
	    String msg = null;
	    if(isSaved) {
	    	msg = "User Saved !";
	    }else {
	    	msg = "User Not saved !";
	    }
	    
	    req.setAttribute("msg", msg);
	    req.getRequestDispatcher("/index.jsp").forward(req,resp);
	}
}