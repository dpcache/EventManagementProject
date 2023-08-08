package eventManagement;

import java.util.Collection;

public interface RegistrationService {

	Collection<Registration> getRegistrations();

	void update(int id, Registration registration);

	void createRegistration(Registration registration);

	void delete(int id);

	Registration getRegistrationById(int id);

}