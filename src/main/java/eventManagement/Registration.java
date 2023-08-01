package eventManagement;

import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Table(name = "REGISTRATIONS")

/*
 * @RequestMapping("/api/registrations") {

	@GetMapping
	@GetMapping("/{registrationId}")
	@PostMapping
	@PutMapping("/{eventId}")
	@DeleteMapping("/{eventId}")
 */

/*
 * [{"id":1,"event_id":"1","customer_id":"1","registration_date":"2019-01-15T00:00:00.000+0000","notes":"please email me the event details"},
 * {"id":2,"event_id":"1","customer_id":"2","registration_date":"2019-01-17T00:00:00.000+0000","notes":"looking for info on local hotels"},
 * {"id":3,"event_id":"1","customer_id":"3","registration_date":"2019-01-13T00:00:00.000+0000","notes":"na"},
 * {"id":4,"event_id":"4","customer_id":"100","registration_date":"1969-12-31T23:59:59.999+0000","notes":""},
 * {"id":5,"event_id":"100","customer_id":"101","registration_date":"1969-12-31T23:59:59.999+0000","notes":"No notes"},
 * {"id":6,"event_id":"100","customer_id":100","registration_date":"1969-12-31T23:59:59.999+0000","notes":""},
 * {"id":7,"event_id":"100","customer_id":"100","registration_date":"1969-12-31T23:59:59.999+0000","notes":""},
 * {"id":8,"event_id":"101","customer_id":"2","registration_date":"1969-12-31T23:59:59.999+0000","notes":""}]
 */

//	KEEP BEAN AND API SEPERATE (generally)
public class Registration
{
	@Id
	int id;	//	registrationId in RegistrationAPI.java
	String event_id;
	String registration_date;
	String notes;
	
	public Registration() {}

	public Registration(int id, String event_id, String registration_date, String notes)
	{
		System.out.println("event id is " + event_id);
		System.out.println("registration id is " + registration_date);
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

	public String getEvent_id()
	{
		return event_id;
	}

	public void setEvent_id(String event_id)
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
