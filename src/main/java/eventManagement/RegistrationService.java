package eventManagement;

import java.util.Collection;

public interface RegistrationService {

	Collection<Registration> getRegistrations();

	void update(long id, Registration registration);

	void createRegistration(Registration registration);

	void delete(long id);

	Registration getRegistrationById(long id);

}