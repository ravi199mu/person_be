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
		
		p.setFileName(rs.getString("filename"));
		p.setFileType(rs.getString("filetype"));
		p.setResume(rs.getBytes("resume"));
		return p;
	}

}
