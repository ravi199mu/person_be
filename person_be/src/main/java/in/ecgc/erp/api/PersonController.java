package in.ecgc.erp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.ecgc.erp.model.Person;
import in.ecgc.erp.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> savePersonDetails(@RequestBody Person person){
			Integer personId = personService.addPerson(person);
			if(personId > 0) {
				Person personDetails = personService.getPersonById(personId);
				return ResponseEntity.ok(personDetails);
			}
			return (ResponseEntity<Person>) ResponseEntity.notFound();
	}
	
	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> updatePersonDetails(@RequestBody Person person){
			Integer personId = personService.modifyPerson(person);
			if(personId > 0) {
				Person updatePersonDetails = personService.getPersonById(personId);
				return ResponseEntity.ok(updatePersonDetails);
			}
			return (ResponseEntity<Person>) ResponseEntity.notFound();
	}
	

	@GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getAllPersonList(){
		return ResponseEntity.ok(personService.getAllPersons());
	}
	
	@GetMapping(value="/get/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getPersonDetailsUsingId(@PathVariable Integer id){
		return ResponseEntity.ok(personService.getPersonById(id));
	}
	
	@DeleteMapping(value = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> deletePersonById(@PathVariable Integer id){
		String removePerson = personService.removePerson(id);
		if(removePerson!=null) {
			return ResponseEntity.ok(personService.getAllPersons());
		}
		return (ResponseEntity<List<Person>>) ResponseEntity.notFound();
	}
	
	@PostMapping(value = "/upload")
	public ResponseEntity<String> uploadResume(@RequestParam MultipartFile file,@RequestParam("personId") Integer id){
		String uploadStatus = personService.uploadResume(file, id);
		if(uploadStatus.equals("uploaded")) {
			return (ResponseEntity<String>) ResponseEntity.ok("success");
		}
		
		return (ResponseEntity<String>) ResponseEntity.ok("failed");
	}
	
	
	@GetMapping(value = "/download/{personId}")
	public ResponseEntity<String> downloadResume(@PathVariable("personId") Integer id){
		String downloadStatus = personService.downloadResume(id);
		
		
		return (ResponseEntity<String>) ResponseEntity.ok("failed");
	}
}
