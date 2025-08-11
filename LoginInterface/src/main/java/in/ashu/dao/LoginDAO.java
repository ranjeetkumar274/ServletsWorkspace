package in.ashu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.ashu.util.ConnectionFactory;

public class LoginDAO {
	
	private static final String SQL_SEARCH = "SELECT * FROM USERS WHERE EMAIL = ? AND PWD = ?";
	
	
	public static String oldUser(String email, String pwd) throws Exception{
		
		Connection con = ConnectionFactory.getDBConnection();
		
		PreparedStatement pstmt = con.prepareStatement(SQL_SEARCH);
		
		pstmt.setString(1, email);
		pstmt.setString(2, pwd);
		
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Data stored in Resultset");
		
		if(rs.next()) {
			return rs.getString("ROLE");
		}
		return "None";
		
	}
}
