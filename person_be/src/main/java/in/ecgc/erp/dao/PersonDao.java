package in.ecgc.erp.dao;

import java.util.List;

import in.ecgc.erp.model.Person;

public interface PersonDao {

	Integer insertPerson(Person person);
	
	List<Person> selectAllPersons();
	
	Person selectPersonById(Integer id);
	
	Integer updatePerson(Person person);
	
	String deletePerson(Integer id);
}
