package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCon {
	public static void main(String[] args) {
		String sql = "select product_name from products where product_id = 1";
		String product_name = "Laptop";
		String category = "Electronics";
		int price = 500;
		int stock_quantity = 100;
		String sqlInsert = "INSERT INTO products (product_name, category, price, stock_quantity) VALUES (?, ?, ?, ?);";
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
			
			PreparedStatement prepSt = con.prepareStatement(sqlInsert);
			
			prepSt.setString(1, product_name);
			prepSt.setString(2, category);
			prepSt.setInt(3, price);
			prepSt.setInt(4, stock_quantity);
			
			int n = prepSt.executeUpdate();
			
			System.out.println(n);
			
			
			prepSt.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
