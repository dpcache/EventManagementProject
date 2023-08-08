package eventManagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class MockRegistrationService implements RegistrationService {

	
	//mock data for registration
	static ArrayList<Registration> registrations = new ArrayList<Registration>();
	static {
			Registration r1 = new Registration(1, 5, new Date(), "will this work?");
			Registration r2 = new Registration(2, 3, new Date(), "will this work??");
			Registration r3 = new Registration(3, 9, new Date(), "will this work???");
			registrations.add(r1);
			registrations.add(r2);
			registrations.add(r3);
	}

	@Override
	public Collection<Registration> getRegistrations() {
		return registrations;
	}

	@Override
	public void update(int id, Registration registration) {
		//TODO
	}

	@Override
	public void createRegistration(Registration registration) {
		registrations.add(registration);
	}

	@Override
	public void delete(int id) {
		registrations.remove(id);
	}

	@Override
	public Registration getRegistrationById(int id) {
		return registrations.get(id);
	}

	
	
}
