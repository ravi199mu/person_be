package in.ecgc.erp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setEmail(rs.getString("email"));
		p.setDomain(rs.getString("domain"));
		p.setFileId(rs.getString("fileid"));
//		FileItem fileItem = new DiskFileItem("fileData", "application/pdf",true, outputFile.getName(), 100000000, new java.io.File(System.getProperty("java.io.tmpdir")));              
//		MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
		
		p.setResume((MultipartFile)rs.getBlob("resume"));
		
		return p;
	}

}
