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
	
	static RegistrationService registrationService = new MockRegistrationService();

//		@PostMapping				// create registration object
//		@PutMapping("/{eventId}")	// update/set id equivalent
//		@DeleteMapping("/{eventId}")// delete
		
	
	//	return all registrations
	@CrossOrigin
	@GetMapping("/registrations")
	public Collection<Registration> getAllRegistrations()
	{
		return registrationService.getRegistrations();
	}

	//	return registrations with a specific registrationId (id)
	@CrossOrigin
	@GetMapping("/registrations/{id}")
	public Registration getRegistration(@PathVariable("id") int id)
	{
		return registrationService.getRegistrationById(id);
	}

	@CrossOrigin
	@PostMapping("/registrations")
	public Registration addNewRegistrations(@RequestBody Registration registration)
	{
		registrationService.createRegistration(registration);
		return registration;
	}
	
	@CrossOrigin
	@PutMapping("/registrations/{id}")
	public Registration updateRegistrations(@PathVariable("id") int id, Registration registrations)
	{
		registrationService.update(id, registrations);
		return registrations;
	}
	
	@CrossOrigin
	@DeleteMapping("/registrations/{id}")
	public void deleteRegistration(@PathVariable("id") int id)
	{
		System.out.println("In deleteEvent method.");
		registrationService.delete(id);
	}
	
	static CustomerService customerService = new MockCustomerService();
	@Autowired
	private EventService eventService;
	
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
//		System.out.println(event.toString());
		eventService.createEvent(event);
//		System.out.println("I am inside addNewEvent");
//		//eventService.createEvent(event);
		return event;
	}
	
	@CrossOrigin
	@PutMapping("/events/{id}")
	public Event updateEvent(@PathVariable("id") int id, @RequestBody Event event) {
		System.out.println("What is the event's information? Inside updateEvent: " + event.toString());
		
		try {
			Event e = eventService.getEventById(id);
			System.out.println("inside updateEvent. Trying to create an event: " + e);
			if (e == null) {
				event.setId((long) 0);
				System.out.println("e is null. event is now set with id 0: " + event.toString());
				eventService.createEvent(event);
			} else {
				//update - figure out if the id is consistent.
				eventService.update(id, event);
			}
		} catch (Exception e) {
			event.setId((long) 0);
			System.out.println("inside the catch block");
			eventService.createEvent(event);
		}
		
		return event;
	}
	
	@CrossOrigin
	@DeleteMapping("/events/{id}")
	public void deleteEvent(@PathVariable("id") int id) {
		eventService.delete(id);
	}
	
	
}
