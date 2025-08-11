package in.ashu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.ashu.util.ConnectionFactory;

public class RegisterDAO {
	
	private static final String SQL = "INSERT INTO USERS VALUES(?,?,?,?,?,?)";
	
	public static boolean Newuser(String fname, String lname, String email, String pwd, String gender, String role) throws Exception {
		
		Connection con = ConnectionFactory.getDBConnection();
		PreparedStatement pstmt = con.prepareCall(SQL);
		
		pstmt.setString(1, fname);
		pstmt.setString(2, lname);
		pstmt.setString(3, email);
		pstmt.setString(4, pwd);
		pstmt.setString(5, gender);
		pstmt.setString(6, role);
		
		
		int rows = pstmt.executeUpdate();
		con.close();
		
		return rows > 0;
	}
}
