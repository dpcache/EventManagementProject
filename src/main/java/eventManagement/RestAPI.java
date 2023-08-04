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
	
	static CustomerService customerService = new MockCustomerService();
	@Autowired
	private EventService eventDao;
	
	@CrossOrigin
	@GetMapping("/events")
	public Collection<Event> getAllEvents() {
		return eventDao.getEvents();
	}
	
	@CrossOrigin
	@GetMapping("/events/{id}")
	public Event getEvent(@PathVariable("id") int id) {
		return eventDao.getEventById(id);
	}
	
	@CrossOrigin
	@PostMapping("/events")
	public Event addNewEvent(@RequestBody Event event) {
//		System.out.println(event.toString());
		eventDao.createEvent(event);
//		System.out.println("I am inside addNewEvent");
//		//eventService.createEvent(event);
		return event;
	}
	
	@CrossOrigin
	@PutMapping("/events/{id}")
	public Event updateEvent(@PathVariable("id") int id, @RequestBody Event event) {
		System.out.println("What is the event's information? Inside updateEvent: " + event.toString());
		
		try {
			Event e = eventDao.getEventById(id);
			System.out.println("inside updateEvent. Trying to create an event: " + e);
			if (e == null) {
				event.setId((long) 0);
				System.out.println("e is null. event is now set with id 0: " + event.toString());
				eventDao.createEvent(event);
			} else {
				//update - figure out if the id is consistent.
				eventDao.update(id, event);
			}
		} catch (Exception e) {
			event.setId((long) 0);
			System.out.println("inside the catch block");
			eventDao.createEvent(event);
		}
		
		return event;
	}
	
	@CrossOrigin
	@DeleteMapping("/events/{id}")
	public void deleteEvent(@PathVariable("id") int id) {
		eventDao.delete(id);
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
	
}
