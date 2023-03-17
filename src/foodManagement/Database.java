package foodManagement;

import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DBNAME = "HotelLuton1";
	final String HOST = "localhost";
	final int PORT = 3306;
	final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;
	final String USER = "root";
	final String PASSWORD = "";

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName(DRIVER); // loading Driver
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return conn;
	}

}
