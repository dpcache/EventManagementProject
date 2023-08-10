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
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private RegistrationService registrationService;
	
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
	public Registration updateRegistrations(@PathVariable("id") int id, @RequestBody Registration registration)
	{
		try {
			Registration r = registrationService.getRegistrationById(id);
			System.out.println("inside updateRegistration. Trying to create a registration: " + r);
			if (r == null) {
				registration.setId(0);
				System.out.println("r is null. registration is now set with id 0: " + registration.toString());
				registrationService.createRegistration(registration);
			} else {
				//update - figure out if the id is consistent.
				registrationService.update(id, registration);
				System.out.println("oooooooooooooooooooo can u see into my eyes");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			registration.setId(0);
			System.out.println("inside the catch block");
			registrationService.createRegistration(registration);
		}
		
		return registration;
	}
	
	@CrossOrigin
	@DeleteMapping("/registrations/{id}")
	public void deleteRegistration(@PathVariable("id") int id)
	{
		System.out.println("In deleteEvent method.");
		registrationService.delete(id);
	}
	
	@Autowired
	private CustomerService customerService;
	
	@CrossOrigin
	@GetMapping("/customers")
	public Collection<Customer> getAllCustomers() {
		return customerService.getCustomers();
	}
	
	@CrossOrigin
	@GetMapping("/customerlist")
	public CustomerList getAllCustomersAsList() {
		
		Collection<Customer> customers = customerService.getCustomers();
		CustomerList customerList = new CustomerList(customers);
		return customerList;
	}
	
	@CrossOrigin
	@PostMapping("/privatecustomer")
	public Customer addCustomerForRegistration(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return customer;
	}
	
	@CrossOrigin
	@GetMapping("/customers/{id}")
	public Customer getCustomers(@PathVariable("id") int id) {
		return customerService.getCustomerById(id);
	}
	
	@CrossOrigin
	@PostMapping("/customers")
	public Customer addNewCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return customer;
	}
	
	@CrossOrigin
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		System.out.println("What is the event's information? Inside updateEvent: " + customer.toString());
		
		try {
			Event e = eventService.getEventById(id);
			System.out.println("inside updateEvent. Trying to create an event: " + e);
			if (e == null) {
				customer.setId((long) 0);
				System.out.println("e is null. event is now set with id 0: " + customer.toString());
				customerService.createCustomer(customer);
			} else {
				//update - figure out if the id is consistent.
				customerService.update(id, customer);
			}
		} catch (Exception e) {
			customer.setId((long) 0);
			System.out.println("inside the catch block");
			customerService.createCustomer(customer);
		}
		
		return customer;
	}
	
	@CrossOrigin
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
		customerService.delete(id);
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
