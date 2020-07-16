package day_3_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class jdbcTemplate1 {

public static void main(String[] args)
{
	//addPerson();
	//findPersonById();
	//addPerson1();
	//findPersonById();
	//updatePerson();
	//findPersonById();
	//deletePerson();//按id删除
	//findPersonById();
	//deletePerson1();//按姓名删除
	findPersonById();
	//findPersonById1();
}
//成员全部展示
public static void findPersonById() {		
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());		
	String sql = " SELECT *from person";		
	List<Person> list = jt.query(sql, new BeanPropertyRowMapper<Person>(Person.class));		
	for (Person person : list) {			
		System.out.println(person);		
	}	
	}
//按id单个查找	
public static void findPersonById1() 
{
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
  String sql= " SELECT *from person where id='1'";
  List<Person> list = jt.query(sql, new BeanPropertyRowMapper<Person>(Person.class));	
  for (Person person1 : list) {			
	System.out.println(person1 );		
	}	
}
// 添加成员	
 public static void addPerson1(){ 
 JdbcTemplate jt= new JdbcTemplate(JDBCUtils.getDataSource());	
 String sql = "insert into person values" + 
 "( '6','西施','e','111','19','走马观灯','165')"; 
 int update =jt.update(sql); 
 System.out.println(update); 
}	 
 public static void addPerson(){ 
	 JdbcTemplate jt= new JdbcTemplate(JDBCUtils.getDataSource());	
	 String sql = "insert into person values" + 
	 "( '1','貂蝉','a','123','19','花中起舞','170'),"+"( '2','铠','b','456','20','以一打五','170'),"
			 +"( '3','大乔','c','789','18','任意传送','168'),"+"( '4','韩信','d','666','22','一路到家','185')," + "( '5','伽罗','e','999','19','远程输出','172')";
	 int update =jt.update(sql); 
	 System.out.println(update); 
	}	 	
//按id修改密码	
 public static void updatePerson(){ 
JdbcTemplate jt= new JdbcTemplate(JDBCUtils.getDataSource());	 
	 int update = jt.update("update person set password=? where id=?","555",3);	
      System.out.println(update); 
 }
// 按id删除成员	
public static void deletePerson(){ 
JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());	
int update = jt.update("delete from person where id=?",6);	 
 System.out.println(update); }	
//按姓名删除成员
public static void deletePerson1(){ 
JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());	 
 String sql="delete from person where name='伽罗'"; 
int delete =jt.update(sql); 
System.out.println(delete); 
}	 

}
