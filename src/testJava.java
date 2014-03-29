import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import connection.DatabaseConnectionFactory;

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
	
	public static String[] getUudisById(int id) {
		DatabaseConnectionFactory dcf = new DatabaseConnectionFactory();
		try {
			Connection con = dcf.getConnection();			
		} catch(SQLException e) {
			return null;
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