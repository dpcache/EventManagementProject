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
        String sql = "INSERT INTO EVENTS (CODE, TITLE, DESCRIPTION) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, event.getCode(), event.getTitle(), event.getDescription());
        return event;
	}
	
	//updating preexisting data.
	public Event updateEvent(Event event, int id) {
		String sql = "UPDATE EVENTS SET code=?, title=?, description=? WHERE id=?";
		jdbcTemplate.update(sql,event.getCode(), event.getTitle(), event.getDescription(), id);
		return event;
	}
	
	public void deleteEvent(int id) {
		String sql = "DELETE FROM EVENTS WHERE id=?";
		jdbcTemplate.update(sql,id);
		return;
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