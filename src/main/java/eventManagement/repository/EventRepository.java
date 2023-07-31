package eventManagement.repository;

import org.springframework.data.repository.CrudRepository;

import eventManagement.Event;


public interface EventRepository extends CrudRepository<Event, Long> {

}