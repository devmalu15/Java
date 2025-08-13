package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCon {
	public static void main(String[] args) {
		String sql = "select product_name from products where product_id = 1";
		String url = "jdbc:postgresql://localhost/jdbcPractice";
		String username = "postgres";
		String password = "devmalu";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			result.next();
			String productName = result.getString(1);
			System.out.println(productName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
