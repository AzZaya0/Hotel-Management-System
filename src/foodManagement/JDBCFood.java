package foodManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//room management (Room)
public class JDBCFood extends Database {

	// DELETE Room
	public boolean delete(int fid) {
		Connection conn;
		PreparedStatement pstat;
		String sql = "DELETE FROM Food WHERE id=?";
		boolean result = false;
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, fid);
			pstat.executeUpdate(); // insert,update,delete
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return result;
	}

	// Update Room
	public boolean update(Food food) {
		Connection conn;
		PreparedStatement pstat;
		String sql = "UPDATE Food SET type=?, rate=? WHERE id=?";
		boolean result = false;
		try {
			// insert
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, food.getname());
			pstat.setDouble(2, food.getRate());
			pstat.setInt(4, food.getId());
			pstat.executeUpdate(); // insert,update,delete
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return result;
	}

	// Search Room
	public Food search(int fid) {

		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM Food WHERE id = ?";
		Food room = new Food();

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, fid);
			rs = pstat.executeQuery();
			while (rs.next()) {
				room.setId(rs.getInt("id"));
				room.setname(rs.getString("name"));
				room.setRate(rs.getDouble("rate"));
			}

		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return room;
	}

	// Insert Room
	public boolean insert(Food food) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO Food VALUES(?,?,?)";
		try {
			// insert
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, food.getId());
			pstat.setString(2, food.getname());
			pstat.setDouble(3, food.getRate());
			pstat.executeUpdate(); // insert,update,delete
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return result;
	}
}
