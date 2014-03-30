import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import connection.DatabaseConnectionFactory;

public class testJava {
	public static void main(String[] argv) {
		
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
	
	

}