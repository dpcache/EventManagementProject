package eventManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
@Entity
@Table(name="EVENTS")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String code;
	String title;
	String description;
	public Event() {};
	

	public Event(String code, String title, String description) {
		super();
		this.code = code;
		this.title = title;
		this.description = description;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
