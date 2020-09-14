package in.ecgc.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ecgc.erp.dao.PersonDao;
import in.ecgc.erp.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao dao;

	@Override
	public Integer addPerson(Person person) {
		return dao.insertPerson(person);
	}

	@Override
	public List<Person> getAllPersons() {
		return dao.selectAllPersons();
	}

	@Override
	public Person getPersonById(Integer id) {
		return dao.selectPersonById(id);
	}

	@Override
	public Integer modifyPerson(Person person) {
		return dao.updatePerson(person);
	}

	@Override
	public String removePerson(Integer id) {
		return dao.deletePerson(id);
	}

}
