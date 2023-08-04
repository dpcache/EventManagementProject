package eventManagement;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;

//	KEEP BEAN AND API SEPERATE (generally)
public class Registration
{
	@Id
	int id;	//	registrationId in RegistrationAPI.java
	int event_id;
	String registration_date;
	String notes;
	
	public Registration() {}

	public Registration(int id, int event_id, String registration_date, String notes)
	{
		this.id = id;
		this.event_id = event_id;
		this.registration_date = registration_date;
		this.notes = notes;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getEvent_id()
	{
		return event_id;
	}

	public void setEvent_id(int event_id)
	{
		this.event_id = event_id;
	}

	public String getRegistration_date()
	{
		return registration_date;
	}

	public void setRegistration_date(String registration_date) 
	{
		this.registration_date = registration_date;
	}

	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}
}
