package eventManagement;

import java.sql.Timestamp;

public class Customer {
	
	Long id;
	String name, email;
	java.sql.Timestamp timeStarted;
	
	public Customer() {};
	
	public Customer(Long id, String name, String email, Timestamp timeStarted) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.timeStarted = timeStarted;
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
	public java.sql.Timestamp getTimeStarted() {
		return timeStarted;
	}
	public void setTimeStarted(java.sql.Timestamp timeStarted) {
		this.timeStarted = timeStarted;
	}
	
}
