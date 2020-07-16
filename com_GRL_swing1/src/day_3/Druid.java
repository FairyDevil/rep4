package day_3;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Druid {
 private static final char[] password = null;
private static final char[] Property = null;
private static final String sql = null;

public static void main (String[] args) throws Exception{
  Properties pro = new Properties();
  InputStream resourceAsStream = Druid.class.getClassLoader().getResourceAsStream("jdbc_properties");
  pro.load(resourceAsStream);
  String Property = pro.getProperty("name");
  String password = pro.getProperty("password");
  System.out.println(password);
  System.out.println(Property);
  DataSource datasourse = DruidDataSourceFactory.createDataSource(pro);
  System.out.println(datasourse.getConnection());
  Connection connection = datasourse.getConnection();
  Statement createStatement = connection.createStatement();
  /*ResultSet re = createStatement.executeQuery(sql);
  while (re.next()) {
   String name = re.getString("name");
   String address = re.getString("address");
   Integer age = re.getInt("age");
   System.out.println(name+address+age);
   
  }*/
  connection.close();
 }

}