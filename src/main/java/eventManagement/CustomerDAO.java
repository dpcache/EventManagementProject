package eventManagement;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO implements CustomerService{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Collection<Customer> getCustomers() {
		return jdbcTemplate.query("Select * from CUSTOMERS", new
				BeanPropertyRowMapper<Customer>(Customer.class));
	}

	@Override
	public void update(int id, Customer customer) {
		String sql = "UPDATE CUSTOMERS SET name=?, email=?, password=? WHERE id=?";
		jdbcTemplate.update(sql,customer.getName(), customer.getEmail(), customer.getPassword(), id);
	}

	@Override
	public void createCustomer(Customer customer) {
		System.out.println("Inside createCustomer: " + customer.toString());
        String sql = "INSERT INTO CUSTOMERS (CUSTOMERID, NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getId(), customer.getName(), customer.getEmail(), customer.getPassword());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM CUSTOMERS WHERE id=?";
		jdbcTemplate.update(sql,id);
		
	}

	@Override
	public Customer getCustomerById(int id) {
		String sql = "SELECT * FROM CUSTOMERS WHERE id = ?";
		List<Customer> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class), id);
		return customers.isEmpty() ? null : customers.get(0);
	}

}