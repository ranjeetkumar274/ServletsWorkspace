package in.ashu.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	private static DataSource ds = null;
	
	public static Connection getConnection() {
		
		try {
	      if(ds == null) {
	    	  InputStream fis = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
	    	  if (fis == null) {
	    	      throw new FileNotFoundException("db.properties file not found in classpath");
	    	  }
	    	  Properties p = new Properties();
	    	  p.load(fis);

				
				HikariConfig config = new HikariConfig();
				config.setUsername(p.getProperty("db.uname"));
				config.setPassword(p.getProperty("db.pwd"));
				config.setJdbcUrl(p.getProperty("db.url"));
		      config.setDriverClassName(p.getProperty("db.driver"));
		      
	    	  ds = new HikariDataSource(config);
	    	  System.out.println("DataSource is Initialized :)");
	      }
	      return ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("DataSource is Not Initialized :)");
		return null; 
	}
}
