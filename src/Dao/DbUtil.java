package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

	public static Connection dbConnect(String dbName, String dbUser, String dbPass) {
		Connection con = null;
		try {
			StringBuilder url = new StringBuilder("jdbc:mysql://localhost:3306/");
			url.append(dbName);

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url.toString(), dbUser, dbPass);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver non trouver " + e.getMessage());
		} catch (SQLException c) {
			System.out.println("Connection a la base impossible :" + c.getMessage());
		}
		return con;
	}

	public static void CloseStatemnt(Statement s) {
		try {
			if (s != null) {
				s.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void ClosePreparedStatemnt(PreparedStatement s) {
		try {
			if (s != null) {
				s.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void CloseResultSet(ResultSet s) {
		try {
			if (s != null) {
				s.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
