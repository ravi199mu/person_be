package in.ecgc.erp.model;

public class Person {

	private Integer id;
	private String name;
	private String email;
	private String domain;
	
	
	
	public Person() {
		
	}

	public Person(Integer id, String name, String email, String domain) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.domain = domain;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", domain=" + domain + "]";
	}
	
	
}
