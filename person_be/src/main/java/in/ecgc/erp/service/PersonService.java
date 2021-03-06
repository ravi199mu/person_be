package in.ecgc.erp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.ecgc.erp.model.Person;

public interface PersonService {


	Integer addPerson(Person person);
	
	List<Person> getAllPersons();
	
	Person getPersonById(Integer id);
	
	Integer modifyPerson(Person person);
	
	String removePerson(Integer id);
	
	String uploadResume(byte[] file,String ft,String fn, Integer personId);

	Person downloadResume(Integer id);
}
