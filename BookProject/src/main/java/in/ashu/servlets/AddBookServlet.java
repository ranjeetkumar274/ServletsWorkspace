package in.ashu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.ashu.dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookServlet")
public class AddBookServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			int bookId = Integer.parseInt(req.getParameter("bookId"));
			String bookName = req.getParameter("bookName");
			double bookPrice = Double.parseDouble(req.getParameter("bookPrice"));
			
			BookDAO dao = new BookDAO();
			boolean status = dao.saveBook(bookId, bookName, bookPrice);
			
			PrintWriter pw = res.getWriter();
			String response = null;
			if(status) {
				response = "Your book is Inserted Successfully";
			}else {
				response = "record Insertion failed";
			}
			
			pw.append(response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
