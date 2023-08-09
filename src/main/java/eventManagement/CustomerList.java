package eventManagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerList {
    private Collection<Customer> customers;

    public CustomerList() {
        customers = new ArrayList<>();
    }

	public CustomerList(Collection<Customer> customers) {
		super();
		this.customers = customers;
	}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}

    // standard constructor and getter/setter
}
