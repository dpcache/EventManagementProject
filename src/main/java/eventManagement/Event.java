package eventManagement;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;

public class Event {
	@Id
	Long id;
	String eventName, performer;
	float price;
	java.sql.Timestamp timeStarted;
	
	public Event() {};
	
	public Event(String eventName, String performer, float price, Timestamp timeStarted) {
		super();
		this.eventName = eventName;
		this.performer = performer;
		this.price = price;
		this.timeStarted = timeStarted;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getPerformer() {
		return performer;
	}
	public void setPerformer(String performer) {
		this.performer = performer;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public java.sql.Timestamp getTimeStarted() {
		return timeStarted;
	}
	public void setTimeStarted(java.sql.Timestamp timeStarted) {
		this.timeStarted = timeStarted;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
