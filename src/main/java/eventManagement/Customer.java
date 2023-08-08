package eventManagement;

import java.sql.Timestamp;

public class Customer {
	
	// Name, Email, Password
	private Long id;
	private String name, email, password;
	//private java.sql.Timestamp timeStarted;
	
	public Customer() {};

	public Customer(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Customer(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
//	public java.sql.Timestamp getTimeStarted() {
//		return timeStarted;
//	}
//
//	public void setTimeStarted(java.sql.Timestamp timeStarted) {
//		this.timeStarted = timeStarted;
//	}
	
}
