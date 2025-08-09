package in.ashu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
    private static DataSource datasource = null;

    static {
        try {
            Properties p = new Properties();
            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            if (input == null) {
                System.out.println("❌ Could not find db.properties in classpath!");
                throw new RuntimeException("db.properties missing");
            } else {
                System.out.println("✅ db.properties loaded successfully!");
                p.load(input); // Load into the object you will use!
                input.close();
            }
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            String url = p.getProperty("db.url");
            String uname = p.getProperty("db.uname");
            String pwd = p.getProperty("db.pwd");
            String poolsize = p.getProperty("db.poolsize", "10");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(uname);
            config.setPassword(pwd);
            config.setMaximumPoolSize(Integer.parseInt(poolsize));

            datasource = new HikariDataSource(config);
            System.out.println("✅ DataSource initialized");

        } catch (Exception e) {
            System.err.println("❌ Error initializing DataSource:");
            e.printStackTrace();
        }
    }

    public static Connection getDBConnection() throws Exception {
        if (datasource == null) {
            throw new IllegalStateException("❌ DataSource is not initialized.");
        }
        return datasource.getConnection();
    }
}

