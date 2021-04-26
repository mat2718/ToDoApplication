import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	
	private static Connection conn;
		
		static {
			try {
			// this class is to initiate the only connection with our SQL Server
			FileReader reader = new FileReader("C:\\Users\\MATTH\\eclipse-workspace\\ToDoApplication\\src\\main\\java\\config.properties");
			Properties p = new Properties();
			p.load(reader);
			
			String url =  p.getProperty("DB_URL");  				//"jdbc:postgresql://localhost:5432/postgres"; // sql server link
			String user = p.getProperty("DB_USER");  				//"postgres"; // sql server username
			String password = p.getProperty("DB_PASSWORD");			//""; // sql server password
			
			System.out.println("Connecting...");
			conn = DriverManager.getConnection(url,user,password);
	
			} catch (SQLException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Coonected \r\n");
		}
		
		static Connection getConnection() {
			return conn;
		}
}
