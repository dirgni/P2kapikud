import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class testJava {
	private static final String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
			+ "Fusce nec metus nec odio pharetra ultrices et eget ante. Vivamus adipiscing ante erat, "
			+ "ut molestie sem vulputate eu. Aliquam ipsum urna, facilisis quis sodales eget, fringilla "
			+ "a ipsum. Praesent sapien nulla, mattis vitae scelerisque et, porttitor at nulla. Vestibulum "
			+ "vel turpis congue arcu ornare fermentum sed nec elit. Mauris quis convallis elit. Proin "
			+ "aliquet, sapien non congue pretium, ante libero tristique nulla, id porttitor arcu mauris "
			+ "et massa. Praesent metus est, ultricies id tincidunt id, venenatis nec leo. Aenean eget "
			+ "arcu eget dolor congue commodo et in turpis. Lorem ipsum dolor sit amet, consectetur "
			+ "adipiscing elit. Fusce nec metus nec odio pharetra ultrices et eget ante. Vivamus adipiscing "
			+ "ante erat, ut molestie sem vulputate eu. Aliquam ipsum urna, facilisis quis sodales eget, "
			+ "fringilla a ipsum. Praesent sapien nulla, mattis vitae scelerisque et, porttitor at nulla. "
			+ "Vestibulum vel turpis congue arcu ornare fermentum sed nec elit. Mauris quis convallis elit. "
			+ "Proin aliquet, sapien non congue pretium, ante libero tristique nulla, id porttitor arcu "
			+ "mauris et massa. Praesent metus est, ultricies id tincidunt id, venenatis nec leo. Aenean "
			+ "eget arcu eget dolor congue commodo et in turpis.";

	public static void main(String[] argv) {
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

			System.out.println("Trying out a SQL statement");
			
			
			
			try {
				System.out.println("Setting default");
				PreparedStatement update = con.prepareStatement(
						"ALTER TABLE kommentaar ALTER COLUMN aeg SET DEFAULT now()");
				update.execute();
				
				System.out.println("starting insertion");
				PreparedStatement ps = con.prepareStatement("INSERT INTO uudis "
						+ "(pealkiri, tekst, pilt, ajakirjanikID) "
						+ "VALUES (?, ?, ?, ?)");
				
				System.out.println("1");
				ps.setString(1, "Maasikad on magusad");
				ps.setString(2, "pikk tekst");
				ps.setString(3, "Images\\legkov.jpg");
				ps.setString(4, "1");
				ps.addBatch();
				
				System.out.println("2");
				ps.setString(1, "Lumesõda hoovis");
				ps.setString(2, "pikk tekst");
				ps.setString(3, "Images\\legkov.jpg");
				ps.setString(4, "2");
				ps.addBatch();
				
				System.out.println("3");
				ps.setString(1, "Uudiste uudis");
				ps.setString(2, "pikk tekst");
				ps.setString(3, "Images\\legkov.jpg");
				ps.setString(4, "3");
				ps.addBatch();
				
				ps.executeBatch();

				// printAjakirjanik(con);

			} catch (SQLException e) {
				System.out.println("SQL statement failed:");
				e.printStackTrace();
			}
			// System.out.println("SQL statement worked");
		} else {
			System.out.println("Failed to make connection!");
		}

		try {
			System.out.println("Closing connection...");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection closed. Bye!");
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

}