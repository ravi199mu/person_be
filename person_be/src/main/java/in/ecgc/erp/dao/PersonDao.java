package in.ecgc.erp.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.ecgc.erp.model.Person;

public interface PersonDao {

	Integer insertPerson(Person person);
	
	List<Person> selectAllPersons();
	
	Person selectPersonById(Integer id);
	
	Integer updatePerson(Person person);
	
	String deletePerson(Integer id);
	
	String uploadResume(MultipartFile file, Integer personId);
	
	Person downloadResume(Integer id);
}
