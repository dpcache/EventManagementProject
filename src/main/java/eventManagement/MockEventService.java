package eventManagement;

import java.util.ArrayList;
import java.util.Collection;

public class MockEventService implements EventService {

	
	//mock data for events
	static ArrayList<Event> events = new ArrayList<Event>();
	
	static {
		Event e1 = new Event("CMSC111", "Intro to CS 1", "Beginner Introduction to CS");
		Event e2 = new Event("CMSC112", "Intro to CS 2", "Intermediate Intro to CS");
		Event e3 = new Event("CMSC113", "Intro to CS 3", "Advacned Intro to CS");
		events.add(e1);
		events.add(e2);
		events.add(e3);
	}

	@Override
	public Collection<Event> getEvents() {
		return events;
	}

	@Override
	public void update(int id, Event event) {
		//TODO
	}

	@Override
	public void createEvent(Event event) {
		events.add(event);
	}

	@Override
	public void delete(int id) {
		events.remove(id);
	}

	@Override
	public Event getEventById(int id) {
		return events.get(id);
	}

	
	
}
