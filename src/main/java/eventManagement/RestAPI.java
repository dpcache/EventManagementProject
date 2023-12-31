package eventManagement;

import java.util.Collection;

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
