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
	//deletePerson();//��idɾ��
	//findPersonById();
	//deletePerson1();//������ɾ��
	findPersonById();
	//findPersonById1();
}
//��Աȫ��չʾ
public static void findPersonById() {		
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());		
	String sql = " SELECT *from person";		
	List<Person> list = jt.query(sql, new BeanPropertyRowMapper<Person>(Person.class));		
	for (Person person : list) {			
		System.out.println(person);		
	}	
	}
//��id��������	
public static void findPersonById1() 
{
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
  String sql= " SELECT *from person where id='1'";
  List<Person> list = jt.query(sql, new BeanPropertyRowMapper<Person>(Person.class));	
  for (Person person1 : list) {			
	System.out.println(person1 );		
	}	
}
// ��ӳ�Ա	
 public static void addPerson1(){ 
 JdbcTemplate jt= new JdbcTemplate(JDBCUtils.getDataSource());	
 String sql = "insert into person values" + 
 "( '6','��ʩ','e','111','19','����۵�','165')"; 
 int update =jt.update(sql); 
 System.out.println(update); 
}	 
 public static void addPerson(){ 
	 JdbcTemplate jt= new JdbcTemplate(JDBCUtils.getDataSource());	
	 String sql = "insert into person values" + 
	 "( '1','����','a','123','19','��������','170'),"+"( '2','��','b','456','20','��һ����','170'),"
			 +"( '3','����','c','789','18','���⴫��','168'),"+"( '4','����','d','666','22','һ·����','185')," + "( '5','٤��','e','999','19','Զ�����','172')";
	 int update =jt.update(sql); 
	 System.out.println(update); 
	}	 	
//��id�޸�����	
 public static void updatePerson(){ 
JdbcTemplate jt= new JdbcTemplate(JDBCUtils.getDataSource());	 
	 int update = jt.update("update person set password=? where id=?","555",3);	
      System.out.println(update); 
 }
// ��idɾ����Ա	
public static void deletePerson(){ 
JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());	
int update = jt.update("delete from person where id=?",6);	 
 System.out.println(update); }	
//������ɾ����Ա
public static void deletePerson1(){ 
JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());	 
 String sql="delete from person where name='٤��'"; 
int delete =jt.update(sql); 
System.out.println(delete); 
}	 

}
