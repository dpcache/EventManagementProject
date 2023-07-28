package eventManagement;

import java.util.Collection;

public interface EventService {

	Collection<Event> getEvents();

	void update(int id, Event event);

	void createEvent(Event event);

	void delete(int id);

	Event getEventById(int id);

}