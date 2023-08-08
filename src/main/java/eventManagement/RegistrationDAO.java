package eventManagement;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDAO implements RegistrationService
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Registration createRegistration(Registration registration) {
        String sql = "INSERT INTO REGISTRATIONS (REGISTRATIONID, EVENT_ID, CUSTOMER_ID REGISTRATION_DATE, NOTES) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, registration.getEvent_id(), registration.getRegistration_date(), registration.getNotes());
        return registration;
	}
	
	public void update(int id, Registration registration) {
		String sql = "UPDATE REGISTRATIONS SET event_id=?, registration_date=?, notes=? WHERE id=?";
		jdbcTemplate.update(sql,registration.getEvent_id(), registration.getRegistration_date(), registration.getNotes(), id);
	}
	
	
	public void delete(int id) {
		String sql = "DELETE FROM REGISTRATIONS WHERE id=?";
		jdbcTemplate.update(sql,id);
	}

	public Collection<Registration> getRegistrations() {
		// Replace this statement with the call to jdbcTemplate.
		
		return jdbcTemplate.query("Select * from REGISTRATIONS", new
				BeanPropertyRowMapper<Registration>(Registration.class));
	}

	public Registration getRegistrationById(int id) {
		String sql = "SELECT * FROM REGISTRATIONS WHERE id = ?";
		List<Registration> registrations = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Registration.class), id);
		return registrations.isEmpty() ? null : registrations.get(0);
	}
}