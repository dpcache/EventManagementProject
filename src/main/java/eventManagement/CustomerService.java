package eventManagement;

import java.util.Collection;

public interface CustomerService {

	Collection<Customer> getCustomers();

	void update(int id, Customer customer);

	void createCustomer(Customer customer);

	void delete(int id);

	Customer getCustomerById(int id);

}