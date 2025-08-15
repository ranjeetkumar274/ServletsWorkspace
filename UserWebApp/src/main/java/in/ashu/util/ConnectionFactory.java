package in.ashu.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;

public class ConnectionFactory {
	
	private static DataSource ds = null;
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			
			File f = new File("/home/ashu/Desktop/Books/UserWebApp/src/main/webapp/WEB-INF/classes/db.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			
			HikariConfig config = new HikariConfig();
			config.setUsername(p.getProperty("db.username"));
			config.setUsername(p.getProperty("db.username"));
			config.setUsername(p.getProperty("db.username"));
			config.setUsername(p.getProperty("db.username"));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
