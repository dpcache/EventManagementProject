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
	
	static CustomerService customerService = new MockCustomerService();
	
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
	@PutMapping("/events/{id}")
	public Event updateEvent(@PathVariable("id") int id, Event event) {
		eventService.update(id, event);
		return event;
	}
	
	@CrossOrigin
	@DeleteMapping("/events/{id}")
	public void deleteEvent(@PathVariable("id") int id) {
		System.out.println("In deleteEvent method.");
		eventService.delete(id);
	}
	
	@CrossOrigin
	@GetMapping("/customers")
	public Collection<Customer> getAllCustomers() {
		return customerService.getCustomers();
	}
	
	@CrossOrigin
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		return customerService.getCustomerById(id);
	}
	
	@CrossOrigin
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return customer;
	}
	
	@CrossOrigin
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@PathVariable("id") int id, Customer customer) {
		customerService.update(id, customer);
		return customer;
	}
	
	@CrossOrigin
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
		customerService.delete(id);
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
