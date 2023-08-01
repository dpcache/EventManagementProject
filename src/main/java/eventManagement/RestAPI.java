package eventManagement;

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
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestAPI {
	
	static EventService eventService = new MockEventService();
	static RegistrationService registrationService = new MockRegistrationService();
	@Autowired
	private RegistrationDAO registrationDAO;

//		@PostMapping
//		@PutMapping("/{eventId}")
//		@DeleteMapping("/{eventId}")
		
	
	//	return all registrations
	@CrossOrigin
	@GetMapping("/registrations")
	public Collection<Registration> getAllRegistrations()
	{
		System.out.println("testttttt");
		return registrationDAO.getAllRegistrations();
	}

	// TODO: this
	//	return registrations with a specific registrationId (id)
	@GetMapping("/{registrationId}")
	public Registration getRegistrationId(@PathVariable("registrationId") int registrationId)
	{
		System.out.println("We in registrationId");
		return null;
	}
	
	@CrossOrigin
	@GetMapping("/events")
	public Collection<Event> getAllEvents() {
		return eventService.getEvents();
	}
	
	@CrossOrigin
	@GetMapping("/events/{id}")
	public Event getEvent(@PathVariable("id") int id) {
		return eventService.getEventById(id);
	}
	
	@CrossOrigin
	@PostMapping("/events")
	public Event addNewEvent(@RequestBody Event event) {
		eventService.createEvent(event);
		return event;
	}
	
	@CrossOrigin
	@PutMapping("/event/{id}")
	public Event updateEvent(@PathVariable("id") int id, Event event) {
		eventService.update(id, event);
		return event;
	}
	
	@CrossOrigin
	@DeleteMapping("/event/{id}")
	public void deleteEvent(@PathVariable("id") int id) {
		eventService.delete(id);
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
	
}
