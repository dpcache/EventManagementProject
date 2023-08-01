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

	public List<Registration> getAllRegistrations()
	{
		return jdbcTemplate.query("Select * FROM REGISTRATIONS",
				new BeanPropertyRowMapper<Registration>(Registration.class));
	}
	
	public Registration getRegistrationById(int id)
	{
		String sql = "Select * FROM REGISTRATIONS WHERE id = ?";
		List<Registration> registrations = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<>(Registration.class), id);
		return registrations.isEmpty() ? null : registrations.get(0);
	}
}