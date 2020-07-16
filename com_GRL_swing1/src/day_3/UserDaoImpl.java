package day_3;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class UserDaoImpl implements UserDao {
JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
public List<User>findAllUser(){
	String sql="select * from Person";
	List<User> list=jt.query(sql,new BeanPropertyRowMapper<User>(User.class));
	return list;
}
}
