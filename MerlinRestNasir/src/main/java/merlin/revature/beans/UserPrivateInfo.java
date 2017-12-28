package merlin.revature.beans;

public class UserPrivateInfo {
	
	private int userId;
	private String username, password, phone, address, city, state, email;
	
	public UserPrivateInfo(int userId, String username, String password, String phone, String address, String city, String state, String email) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
