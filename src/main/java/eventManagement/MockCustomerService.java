package eventManagement;

import java.util.ArrayList;
import java.util.Collection;

public class MockCustomerService implements CustomerService {

	
	//mock data for customers
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	static {
		Customer e1 = new Customer(1, "Bob", "bob@gmail.com", "Begi555nner");
		Customer e2 = new Customer(2, "Tom", "jesse@gmail.com", "123Intermediate");
		Customer e3 = new Customer(3, "JPotato", "potato@gmail.com", "4dvacned");
		customers.add(e1);
		customers.add(e2);
		customers.add(e3);
	}

	@Override
	public Collection<Customer> getCustomers() {
		return customers;
	}

	@Override
	public void update(int id, Customer Customer) {
		//TODO
	}

	@Override
	public void createCustomer(Customer Customer) {
		customers.add(Customer);
	}

	@Override
	public void delete(int id) {
		customers.remove(id);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customers.get(id);
	}

	
	
}
