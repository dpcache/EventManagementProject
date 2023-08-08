package eventManagement;

import java.util.Date;

import org.springframework.data.annotation.Id;

//	KEEP BEAN AND API SEPERATE (generally)
public class Registration
{
	@Id
	int id;	//	registrationId in RegistrationAPI.java
	int event_id;
	int customer_id;
	
	public Registration() {}
	
	public Registration(int id, int event_id, int customer_id, Date registration_date, String notes)
	{
		this.id = id;
		this.event_id = event_id;
		this.customer_id = customer_id;
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

	public int getCustomer_id()
	{
		return customer_id;
	}

	public void setCustomer_id(int customer_id)
	{
		this.customer_id = customer_id;
	}

	public java.util.Date getRegistration_date()
	{
		return registration_date;
	}

	public void setRegistration_date(java.util.Date registration_date) 
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

	java.util.Date registration_date;
	String notes;

}