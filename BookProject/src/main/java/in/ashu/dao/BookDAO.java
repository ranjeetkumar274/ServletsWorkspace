package in.ashu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.ashu.util.ConnectionFactory;

public class BookDAO {
	
	private static final String SQL = "INSERT INTO BOOKS VALUES(?,?,?)";
	
	public boolean saveBook(int bookId, String bookName, double bookPrice) throws Exception{
		
		Connection con = ConnectionFactory.getDBConnection();
		
		PreparedStatement pstmt = con.prepareStatement(SQL);
		
		pstmt.setInt(1,bookId);
		pstmt.setString(2, bookName);
		pstmt.setDouble(3, bookPrice);
		
		int rows = pstmt.executeUpdate();
		
		return rows> 0;
	}
}
