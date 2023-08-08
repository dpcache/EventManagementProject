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

	@Override
	public Collection<Registration> getRegistrations() {
		return jdbcTemplate.query("Select * from REGISTRATIONS", new
				BeanPropertyRowMapper<Registration>(Registration.class));
	}

	@Override
	public void update(int id, Registration registration) {
		String sql = "UPDATE REGISTRATIONS SET EVENT_ID=?, CUSTOMER_ID=?, REGISTRATION_DATE=?, NOTES=?";
		jdbcTemplate.update(sql, registration.getEvent_id(), registration.getCustomer_id(), registration.getRegistration_date(), registration.getNotes());
	}

	@Override
	public void createRegistration(Registration registration) {
		System.out.println("Inside createRegistration: " + registration.toString());
        String sql = "INSERT INTO REGISTRATIONS (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, registration.getEvent_id(), registration.getCustomer_id(), registration.getRegistration_date(), registration.getNotes());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM REGISTRATIONS WHERE id=?";
		jdbcTemplate.update(sql,id);
		
	}

	@Override
	public Registration getRegistrationById(int id) {
		String sql = "SELECT * FROM EVENTS WHERE id = ?";
		List<Registration> registrations = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Registration.class), id);
		return registrations.isEmpty() ? null : registrations.get(0);
	}
}