package eventManagement;

import java.util.Date;

public class Registration
{
	long id;	
	int eventId;
	int userId;
	java.util.Date reg_date;
	String description;
	
	public Registration() {}

	public Registration(long id, int eventId, int userId, Date reg_date, String description) {
		this.id = id;
		this.eventId = eventId;
		this.userId = userId;
		this.reg_date = reg_date;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public java.util.Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(java.util.Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	
}