package in.ashu.dto;

public class UserDTO {
	
	
	private Integer userId;
	private String userName;
	private String userEmail;
	private Integer userPhno;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public Integer getUserPhno() {
		return userPhno;
	}
	public void setUserPhno(Integer userPhno) {
		this.userPhno = userPhno;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
