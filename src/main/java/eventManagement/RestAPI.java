package eventManagement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestAPI {
	
	@Autowired
	private GameSummaryDAO gameSummaryDAO;
	
	@Autowired
	private EventDAO eventDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@CrossOrigin
	@GetMapping("/gamesummary")
	public Collection<GameSummary> getGameSummarys() {
		return gameSummaryDAO.getAllGameSummarys();
	}
	
	@CrossOrigin
	@GetMapping("/events")
	public Collection<Event> getEvents() {
		return eventDAO.getAllEvents();
	}
	
	@CrossOrigin
	@GetMapping("/customers")
	public Collection<Customer> getCustomers() {
		return customerDAO.getAllCustomers();
	}
	
}
