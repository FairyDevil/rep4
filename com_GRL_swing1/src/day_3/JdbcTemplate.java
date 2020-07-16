package day_3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcTemplate {

public static void main(String[] args)
{
	UserDao ud=new UserDaoImpl();
	List<User>list=ud.findAllUser();
	for(User i:list)
	{
		System.out.println(i);
	}
}
}
