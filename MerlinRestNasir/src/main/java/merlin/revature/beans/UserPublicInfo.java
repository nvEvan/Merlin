package merlin.revature.beans;

public class UserPublicInfo {
	
	private int userId;
	private String username, fname, lname;

	public UserPublicInfo(int userId, String username, String fname, String lname) {
		this.userId = userId;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

}
