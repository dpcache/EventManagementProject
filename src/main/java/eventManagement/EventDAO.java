package eventManagement;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAO implements EventService{

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void createEvent(Event event) {
        String sql = "INSERT INTO EVENTS (CODE, TITLE, DESCRIPTION) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, event.getCode(), event.getTitle(), event.getDescription());
	}
	
	public void update(int id, Event event) {
		String sql = "UPDATE EVENTS SET code=?, title=?, description=? WHERE id=?";
		jdbcTemplate.update(sql,event.getCode(), event.getTitle(), event.getDescription(), id);
	}
	
	
	public void delete(int id) {
		String sql = "DELETE FROM EVENTS WHERE id=?";
		jdbcTemplate.update(sql,id);
	}

	public Collection<Event> getEvents() {
		// Replace this statement with the call to jdbcTemplate.
		
		return jdbcTemplate.query("Select * from EVENTS", new
				BeanPropertyRowMapper<Event>(Event.class));
	}

	public Event getEventById(int id) {
		String sql = "SELECT * FROM EVENTS WHERE id = ?";
		List<Event> events = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Event.class), id);
		return events.isEmpty() ? null : events.get(0);
	}


}