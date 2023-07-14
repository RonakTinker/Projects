package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	
	//made the Constructor private so that no one can create object of it.
	private JdbcUtil() {
		
	}
	
	//loading the Driver.
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//method to get the connection object.
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		
		String fileLoc= "F:\\Full Stack JAVA Developer Course\\Full Stack JAVA Developer Notes\\ProjectsGitHub\\OnlineBookShop\\src\\in\\ineuron\\properties\\application.properties";
	
		FileInputStream fis=new FileInputStream(fileLoc);
		Properties properties=new Properties();
		properties.load(fis);
			
		String url=properties.getProperty("url");
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
			
		return DriverManager.getConnection(url, user, password);
		
	}

}
