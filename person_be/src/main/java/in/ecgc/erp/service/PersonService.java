package in.ecgc.erp.service;

import java.util.List;

import in.ecgc.erp.model.Person;

public interface PersonService {


	Integer addPerson(Person person);
	
	List<Person> getAllPersons();
	
	Person getPersonById(Integer id);
	
	Integer modifyPerson(Person person);
	
	String removePerson(Integer id);
}
