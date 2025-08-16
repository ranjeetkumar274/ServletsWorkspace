package in.ashu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.ashu.dto.UserDTO;
import in.ashu.util.ConnectionFactory;

public class UserDAO {
	
	private static final String INSERT_SQL = "INSERT INTO user_dtls(user_name, user_email, user_phno) VALUES(?,?,?)";
	private static final String SELECT_SQL = "SELECT * FROM USER_DTLS";

	
	public boolean saveUser(UserDTO userDTO) {
		boolean isSaved = false;
		
		try {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
			pstmt.setString(1, userDTO.getUserName());
			pstmt.setString(2, userDTO.getUserEmail());
			pstmt.setInt(3, userDTO.getUserPhno());
			
			int rows = pstmt.executeUpdate();
			System.out.println("Data is Saveed :)");
			
			if(rows > 0) {
				isSaved = true; 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSaved;
	}
	
	
	public List<UserDTO> getusers(){
		List<UserDTO> users = new ArrayList<>();
		
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_SQL);
			while(rs.next()) {
				
				UserDTO user = new UserDTO();
				
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setUserPhno(rs.getInt("user_phno"));

				
				users.add(user);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
}