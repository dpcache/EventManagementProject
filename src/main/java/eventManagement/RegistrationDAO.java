package eventManagement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDAO implements RegistrationService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Collection<Registration> getRegistrations() {
		return jdbcTemplate.query("Select * from REGISTRATIONS", new
				BeanPropertyRowMapper<Registration>(Registration.class));
	}

	@Override
	public void update(long id, Registration registration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createRegistration(Registration registration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Registration getRegistrationById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}