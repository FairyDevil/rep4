package day_3_1;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class PersonDaoImpl implements PersonDao {
JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
public List<Person>findAllPerson(){
	String sql="select * from Person";
	List<Person> list=jt.query(sql,new BeanPropertyRowMapper<Person>(Person.class));
	return list;
}
}
