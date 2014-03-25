import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class testJava {
	public static void main(String[] argv) {
		getUudisById(1);
	}

	private static void printAjakirjanik(Connection con) throws SQLException {
		PreparedStatement stm = con
				.prepareStatement("SELECT id, eesnimi, perenimi, parool FROM ajakirjanik");
		ResultSet rs = stm.executeQuery();

		System.out.println("id\teesnimi\tperenimi\tparool");

		while (rs.next()) {
			int id = rs.getInt("id");
			String eesnimi = rs.getString("eesnimi");
			String perenimi = rs.getString("perenimi");
			String parool = rs.getString("parool");
			System.out
					.printf("%d\t%s\t%s\t%s\n", id, eesnimi, perenimi, parool);
		}
	}

	private static Connection con() throws ClassNotFoundException, SQLException {
		// Register the driver
		Class.forName("org.postgresql.Driver");

		Connection connection = null;

		String url = "jdbc:postgresql://ec2-54-228-224-40.eu-west-1.compute.amazonaws.com:5432/d7vu5vmrh6826v";
		Properties props = new Properties();
		props.setProperty("user", "gkqowcfxsywapr");
		props.setProperty("password", "uTMYU-2zrRPd3ro5LthO0hXc4C");
		props.setProperty("ssl", "true");
		// Järgmine rida võtab pmst SSL turva maha. Tuleks luua mingi
		// SSLSocketFactory objekt, mis sertifikaate toodaks nagu ma aru saan...
		props.setProperty("sslfactory",
				"org.postgresql.ssl.NonValidatingFactory");
		connection = DriverManager.getConnection(url, props);

		return connection;
	}
	
	public static String[] getUudisById(int id) {
		Connection con = null;
		try {
			con = con();
		} catch (ClassNotFoundException e) {
			System.out.println("PostgreSQL JDBC Driver not found!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		
		if (con != null) {
			System.out.println("Connection established!");

			try {
				PreparedStatement ps = con.prepareStatement(
						"SELECT pealkiri, tekst, pilt FROM uudis"
						+ "WHERE id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				rs.next();
				String pealkiri = rs.getString(1);
				String tekst = rs.getString(2);
 				String pilt = rs.getString(3);
 				String[] vastus = {pealkiri, tekst, pilt};

				if (con != null) {
					con.close();
				}
				
				return vastus;
			} catch (SQLException e) {
				System.out.println("SQL statement failed:");
				e.printStackTrace();
			}
			// System.out.println("SQL statement worked");
		} else {
			System.err.println("Failed to make connection!");
		}
		
		return null;
	}

}