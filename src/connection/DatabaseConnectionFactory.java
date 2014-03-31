package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionFactory {
	private Connection connection;
	private Properties props;
	
	private final String url = "jdbc:postgresql://ec2-54-228-224-40."
			+ "eu-west-1.compute.amazonaws.com:5432/d7vu5vmrh6826v";
	private final String username = "gkqowcfxsywapr";
	private final String password = "uTMYU-2zrRPd3ro5LthO0hXc4C";
	
	public DatabaseConnectionFactory() {
		connection = null;
		props = new Properties();
		props.setProperty("user", username);
		props.setProperty("password", password);
		props.setProperty("ssl", "true");
		props.setProperty("sslfactory",
				"org.postgresql.ssl.NonValidatingFactory");
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC draiverit ei leitud!");
			System.err.println(e);
		}
	}
	
	public Connection getConnection() throws SQLException {
		connection = DriverManager.getConnection(url, props);
		System.out.println("Ühendus loodi.");
		return connection;
	}
	
	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
				System.out.println("Ühendus suleti.");
			} else {
				System.out.println("Üritati sulgeda null väärtusega ühendust");
			}
		} catch(SQLException e) {
			System.out.println("Viga ühenduse sulgemisel!");
			System.err.println(e);
		}
	}
}
