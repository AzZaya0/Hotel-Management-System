package ServicesLibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Database.Database;

public class ServicesJDBC extends Database {

	// Declaration
	Connection conn;
	PreparedStatement pstat;
	ResultSet rs;

	// Method to fetch the room number of occupied room from database
	public ArrayList showRoomNumber() {
		ArrayList array = new ArrayList();
		String sql = "SELECT id FROM room WHERE status='Occupied'";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			while (rs.next()) {
				int roomNumber = rs.getInt("id");
				array.add(roomNumber);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
		}
		return array;
	}
	// Method to fetch the room number of occupied room from database end

	// Method to fetch the customer data of selected room number from database
	public ArrayList<ServicesLibs> getCustomerDetails(ServicesLibs service) {
		ArrayList<ServicesLibs> array = new ArrayList<ServicesLibs>();
		String sql = "select b.id,c.Id,c.FirstName,b.CheckIn\r\n" + "from bookingtest as b\r\n"
				+ "inner join registration as c \r\n" + "on b.CustomerId = c.Id\r\n" + "where b.RoomNumber=?";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, service.getRoomNumber());
			rs = pstat.executeQuery();

			while (rs.next()) {
				service.setCustomerName(rs.getString("FirstName"));
				service.setBookingId(rs.getInt("id"));
				service.setCheckInDate(rs.getString("CheckIn"));
				array.add(service);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
		}
		return array;
	}
	// Method to fetch the customer data of selected room number from database end

	// Method to fetch the services type from database
	public ArrayList showServiceType() {
		ArrayList array = new ArrayList();
		String sql = "SELECT type from service group by type";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			while (rs.next()) {
				String service = rs.getString("type");
				array.add(service);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
		}
		return array;
	}
	// Method to fetch the services type from database end

	// Fetching service data from database and send to gui for display
	public ArrayList showService(ServicesLibs service) {
		ArrayList array = new ArrayList();
		String sql = "SELECT Name,Rate FROM service where type=?";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, service.getServiceType());
			rs = pstat.executeQuery();

			while (rs.next()) {
				String item = rs.getString("Name");
				array.add(item);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
		}
		return array;
	}
	// End

	// Fetching service data from database and send to gui for display
	public double showServicePrice(ServicesLibs service) {
		double rate = 0;
		String sql = "SELECT Service_id,Rate FROM service where Name=?";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, service.getServices());
			rs = pstat.executeQuery();

			while (rs.next()) {
				rate = rs.getDouble("Rate");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
		}
		return rate;
	}
	// End
	
	// Fetching service data from database and send to gui for display
		public int getServiceId(ServicesLibs service) {
			int serviceId=0;
			String sql = "SELECT Service_id FROM service where Name=?";
			try {
				conn = connect();
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, service.getServices());
				rs = pstat.executeQuery();

				while (rs.next()) {
					serviceId = rs.getInt("Service_id");
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
			}
			return serviceId;
		}
		// End

	public boolean insertService(ServicesLibs service) {
		boolean result = false;
		String sql = "INSERT INTO customer_service(Date,Service_id,Booking_Id) VALUES(?,?,?)";

		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, service.getDate());
			pstat.setInt(2, service.getServiceId());
			pstat.setInt(3, service.getBookingId());
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
		}
		return result;

	}

}
