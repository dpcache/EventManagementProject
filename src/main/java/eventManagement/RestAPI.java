package eventManagement;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eventManagement.repository.EventRepository;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestAPI {
	
	//mock data for events
	static ArrayList<Event> events = new ArrayList<Event>();
	
	@Autowired
	EventRepository repo;


	static {
		Event e1 = new Event("CMSC111", "Intro to CS 1", "Beginner Introduction to CS");
		Event e2 = new Event("CMSC112", "Intro to CS 2", "Intermediate Intro to CS");
		Event e3 = new Event("CMSC113", "Intro to CS 3", "Advacned Intro to CS");
		events.add(e1);
		events.add(e2);
		events.add(e3);

	}
	@Autowired
	private EventDAO eventDAO;
	//We have the option to use eventDAO if needed in the future.
	//For now, we use the test data. As we progress, we may incorporate either eventDAO or JPA.
	
	@Autowired
	private CustomerDAO customerDAO;
		
	@CrossOrigin
	@GetMapping("/events")
	public Collection<Event> getAllEvents() {
		return events;
	}
	
	@CrossOrigin
	@GetMapping("/events/{id}")
	public Event getEvent(@PathVariable("id") int id) {
		return events.get(id);
	}
	
	@CrossOrigin
	@PostMapping("/events")
	public Event addNewEvent(@RequestBody Event event) {
		events.add(event);
		return event;
	}
	
	@CrossOrigin
	@PutMapping("/event/{id}")
	public Event updateEvent(@PathVariable("id") int id, Event event) {
		events.add(id, event);
		return event;
	}
	
	@CrossOrigin
	@DeleteMapping("/event/{id}")
	@ResponseBody
	public Event deleteEvent(@PathVariable("id") int id) {
		Event removedEvent = events.remove(id);
		return removedEvent;
	}
	
	
//	//We do not use the dummy data "events" here.
//	@CrossOrigin
//	@PutMapping("event/{id}")
//	public ResponseEntity<?> updateEvent(
//			@RequestBody Event event,
//			@PathVariable("id") int id) {
//		if (event.getId() != id ) {
//			return ResponseEntity.badRequest().build();
//		}
//		event = repo.save(event);
//		return ResponseEntity.ok().build();
//	}

	
	@CrossOrigin
	@GetMapping("/customers")
	public Collection<Customer> getCustomers() {
		return customerDAO.getAllCustomers();
	}
	
}
