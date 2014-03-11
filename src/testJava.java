import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
 
public class testJava {
 
	public static void main(String[] argv) {
 
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 /*
			connection = DriverManager.getConnection(
					"jdbc:postgresql://ec2-54-228-224-40.eu-west-1.compute.amazonaws.com:5432/d7vu5vmrh6826v", 
					"gkqowcfxsywapr",
					"uTMYU-2zrRPd3ro5LthO0hXc4C");
 */
			
			String url = "jdbc:postgresql://ec2-54-228-224-40.eu-west-1.compute.amazonaws.com:5432/d7vu5vmrh6826v";
			Properties props = new Properties();
			props.setProperty("user","gkqowcfxsywapr");
			props.setProperty("password","uTMYU-2zrRPd3ro5LthO0hXc4C");
			props.setProperty("ssl","true");
			/**
			 * Järgmine rida võtab pmst SSL turva maha. 
			 * Tuleks luua mingi SSLFactory objekt, mis 
			 * sertifikaate toodaks nagu ma aru saan...
			 * - Madis
			 */
			props.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
			System.out.println("1");
			connection = DriverManager.getConnection(url, props);
			System.out.println("2");
			
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
 
}