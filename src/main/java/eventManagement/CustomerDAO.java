package eventManagement;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO  {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Customer addCustomer(Customer customer) {
        String sql = "INSERT INTO CUSTOMERS (USERID, NAME, EMAIL, TIME) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getId(), customer.getName(), customer.getEmail(), customer.getTimeStarted());
        return customer;
	}

	public Collection<Customer> getAllCustomers() {
		// Replace this statement with the call to jdbcTemplate.
		
		return jdbcTemplate.query("Select * from CUSTOMERS", new
				BeanPropertyRowMapper<Customer>(Customer.class));
	}

	public Customer getCustomer(int id) {
		String sql = "SELECT * FROM CUSTOMERS WHERE id = ?";
		List<Customer> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class), id);
		return customers.isEmpty() ? null : customers.get(0);
	}

}