package eventManagement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eventManagement.repository.EventRepository;

@Component
public class EventValet implements EventService {

	@Autowired
	EventRepository repo;
	
	@Override
	public Collection<Event> getEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(int id, Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Event getEventById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
