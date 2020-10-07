package in.ecgc.erp.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

public class Person {

	private Integer id;
	private String name;
	private String email;
	private String domain;

//	@JsonIgnore
//	private MultipartFile resume;

	private String fileId;
	private String fileName;
	private String fileType;
	private byte[] resume;

	public Person() {

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

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", domain=" + domain + ", fileId=" + fileId
				+ ", fileName=" + fileName + ", fileType=" + fileType + ", resume=" + Arrays.toString(resume) + "]";
	}
	
	 

}
