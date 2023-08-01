package eventManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDAO 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//	this works 7/31/2023 5:03 PM except eventId and date is null ???????
	public List<Registration> getAllRegistrations()
	{
		return jdbcTemplate.query("Select * from REGISTRATIONS", new BeanPropertyRowMapper<Registration>(Registration.class));
		// FIXME: Date comes up as null
		// FIXME: Eventid comes up as 0
	}
}