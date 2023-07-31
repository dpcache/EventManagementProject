package eventManagement;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/registrations") 

public class RegistrationAPI
{
//	@PostMapping
//	@PutMapping("/{eventId}")
//	@DeleteMapping("/{eventId}")
	
	@GetMapping
	//	return all registrations
	public Collection<Registration> getAllRegistrations()
	{	
		return null;
	}
	
	//	return registrations with a specific registrationId (id)
	@GetMapping("/{registrationId}")
	public Registration getRegistrationId(@PathVariable("registrationId") int registrationId)
	{
		return null;
	}
	
//	public 
}