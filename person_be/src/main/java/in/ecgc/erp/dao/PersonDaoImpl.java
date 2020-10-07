package in.ecgc.erp.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Types;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import in.ecgc.erp.model.Person;
import in.ecgc.erp.model.PersonRowMapper;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbc;
	
	public PersonDaoImpl(DataSource dataSource) {
		this.namedJdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Integer insertPerson(Person person) {
		String sql = "insert into person(name,email,domain) values(:name,:email,:domain)";
		MapSqlParameterSource pSource = new MapSqlParameterSource();
		pSource.addValue("name", person.getName());
		pSource.addValue("email", person.getEmail());
		pSource.addValue("domain", person.getDomain());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int result = namedJdbc.update(sql, pSource, keyHolder,new String[] {"id"});
		if(result > 0) {
			return keyHolder.getKey().intValue();
		}else {
			return null;
		}
	}

	@Override
	public List<Person> selectAllPersons() {
		String sql = "select * from person";
		RowMapper<Person> rowMapper = new PersonRowMapper();
		List<Person> list = namedJdbc.query(sql, rowMapper);
		return list;
	}

	@Override
	public Person selectPersonById(Integer id) {
		String sql = "select * from person where id = :id";
		Person person = namedJdbc.queryForObject(sql, new MapSqlParameterSource("id",id), new PersonRowMapper());
		return person;
	}

	@Override
	public Integer updatePerson(Person person) {
		String sql = "update person set name=:name,email=:email,domain=:domain where id=:id";;
		int result = namedJdbc.update(sql, new MapSqlParameterSource("name",person.getName())
											.addValue("email", person.getEmail())
											.addValue("domain", person.getDomain())
											.addValue("id", person.getId()));
		if(result > 0) {
			return person.getId();
		}
		return null;
	}

	@Override
	public String deletePerson(Integer id) {
		String sql = "delete from person where id =:id";

		int result = namedJdbc.update(sql,
				new MapSqlParameterSource("id", id));
		if (result > 0) {
			return "Person with id : "+id+" deleted successfully";
		}
		return null;
	}

	@Override
	public String uploadResume(byte[] resume,String ft,String fn,Integer personId) {
		
		String fileId = "file"+new Random().nextInt(1000);
	
		
		String sql = "update person set resume=:resume,fileid=:fileid,filename=:filename,filetype=:filetype where id=:id";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("resume",  new SqlLobValue(new ByteArrayInputStream(resume), 
				   resume.length, new DefaultLobHandler()), Types.BLOB);
		map.addValue("fileid", fileId);
		map.addValue("filename", fn);
		map.addValue("filetype", ft);
		map.addValue("id", personId);
		
		int result= namedJdbc.update(sql, map);
		if(result > 0) {
			return "uploaded";
		}
		return "failed";
	}

	@Override
	public Person downloadResume(Integer id) {
		String sql = "select * from person where id=:id";
		
		Person person = namedJdbc.queryForObject(sql, new MapSqlParameterSource("id",id), new PersonRowMapper());
		return person;
	}

}
