package eventManagement;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAO  {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Event addEvent(Event event) {
        String sql = "INSERT INTO EVENTS (EVENTNAME, PERFORMER, PRICE, TIMEPLAYED) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, event.getEventName(), event.getPerformer(), event.getPrice(), event.getTimeStarted());
        return event;
	}

	public Collection<Event> getAllEvents() {
		// Replace this statement with the call to jdbcTemplate.
		
		return jdbcTemplate.query("Select * from EVENTS", new
				BeanPropertyRowMapper<Event>(Event.class));
	}

	public Event getEvent(int id) {
		String sql = "SELECT * FROM EVENTS WHERE id = ?";
		List<Event> events = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Event.class), id);
		return events.isEmpty() ? null : events.get(0);
	}

}