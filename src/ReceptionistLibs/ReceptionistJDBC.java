package ReceptionistLibs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Database.Database;

public class ReceptionistJDBC extends Database {
	Connection conn;
	PreparedStatement pstat;
	ResultSet rs;

	public ArrayList<ReceptionistLibs> getPendingBookingData() {
		ArrayList<ReceptionistLibs> customerData = new ArrayList<ReceptionistLibs>();
		String sql = "SELECT b.Id,c.Id,b.RoomNumber,c.FirstName,c.LastName,c.Email,c.Address,c.CreditCard,b.CheckIn,b.CheckOut,b.RoomType,b.BookingStatus\r\n"
				+ " From Registration as c\r\n" + " INNER JOIN BookingTest as b on\r\n" + " c.Id=b.CustomerId\r\n"
				+ " WHERE b.BookingStatus='Pending';";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			while (rs.next()) {
				ReceptionistLibs getdbData = new ReceptionistLibs(rs.getInt("Id"), rs.getInt("Id"),
						rs.getInt("RoomNumber"), rs.getString("FirstName"), rs.getString("LastName"),
						rs.getString("Email"), rs.getString("Address"), rs.getString("CreditCard"),
						rs.getString("CheckIn"), rs.getString("CheckOut"), rs.getString("RoomType"),
						rs.getString("BookingStatus"));
				customerData.add(getdbData);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
		}

		return customerData;
	}

	// Search room number
	public ArrayList getRoomId(String type) {
		ArrayList checkIn = new ArrayList();
		String sql = "SELECT id FROM room WHERE type=? AND status='Available'";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, type);
			rs = pstat.executeQuery();
			while (rs.next()) {
				String checkLib = rs.getString("id");
				checkIn.add(checkLib);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
		}
		return checkIn;
	}
	// End of search room

	// Update booking status of the customer
	public boolean updateRoom(int bookingId, int roomId) {
		boolean result = false;
		String sql = "UPDATE BookingTest SET BookingStatus='Booked' , RoomNumber=? WHERE Id=?";
		String sql1 = "UPDATE BookingTest SET BookingStatus='Room Not Available' WHERE Id=?";
		String sql2 = "UPDATE room SET status='Booked' WHERE Id=?";
		try {

			if (roomId > 0) {
				conn = connect();
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, roomId);
				pstat.setInt(2, bookingId);
				pstat.executeUpdate();
				pstat.close();
				conn.close();

				conn = connect();
				pstat = conn.prepareStatement(sql2);
				pstat.setInt(1, roomId);
				pstat.executeUpdate();
				pstat.close();
				conn.close();
			} else {
				conn = connect();
				pstat = conn.prepareStatement(sql1);
				pstat.setInt(1, bookingId);
				pstat.executeUpdate();
				pstat.close();
				conn.close();
			}

			result = true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
		}
		return result;
	}
	// End of the update booking

	
	// Retrieve Booked data of a customer
		public ArrayList<ReceptionistLibs> getBooked() {
			ArrayList<ReceptionistLibs> customerData = new ArrayList<ReceptionistLibs>();
			String date = LocalDate.now().toString();
			String sql = "SELECT b.Id,c.Id,b.RoomNumber,c.FirstName,c.LastName,c.Email,c.Address,c.CreditCard,b.CheckIn,b.CheckOut,b.RoomType,b.BookingStatus\r\n"
					+ " From Registration as c\r\n" + " INNER JOIN BookingTest as b on\r\n" + " c.Id=b.CustomerId\r\n"
					+ " WHERE b.BookingStatus='Booked'";
			try {
				conn = connect();
				pstat = conn.prepareStatement(sql);
				rs = pstat.executeQuery();

				while (rs.next()) {
					ReceptionistLibs getdbData = new ReceptionistLibs(rs.getInt("Id"), rs.getInt("Id"),
							rs.getInt("RoomNumber"), rs.getString("FirstName"), rs.getString("LastName"),
							rs.getString("Email"), rs.getString("Address"), rs.getString("CreditCard"),
							rs.getString("CheckIn"), rs.getString("CheckOut"), rs.getString("RoomType"),
							rs.getString("BookingStatus"));
					customerData.add(getdbData);
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
			}

			return customerData;
		}
	
	// Retrieve Booked data of a customer on a system date
	public ArrayList<ReceptionistLibs> getBookedData() {
		ArrayList<ReceptionistLibs> customerData = new ArrayList<ReceptionistLibs>();
		String date = LocalDate.now().toString();
		String sql = "SELECT b.Id,c.Id,b.RoomNumber,c.FirstName,c.LastName,c.Email,c.Address,c.CreditCard,b.CheckIn,b.CheckOut,b.RoomType,b.BookingStatus\r\n"
				+ " From Registration as c\r\n" + " INNER JOIN BookingTest as b on\r\n" + " c.Id=b.CustomerId\r\n"
				+ " WHERE b.BookingStatus='Booked' AND b.CheckIn=?";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, date);
			rs = pstat.executeQuery();

			while (rs.next()) {
				ReceptionistLibs getdbData = new ReceptionistLibs(rs.getInt("Id"), rs.getInt("Id"),
						rs.getInt("RoomNumber"), rs.getString("FirstName"), rs.getString("LastName"),
						rs.getString("Email"), rs.getString("Address"), rs.getString("CreditCard"),
						rs.getString("CheckIn"), rs.getString("CheckOut"), rs.getString("RoomType"),
						rs.getString("BookingStatus"));
				customerData.add(getdbData);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
		}

		return customerData;
	}

	// Update checkIn status of the customer
	public boolean updateCheckIn(CheckInLibs checkin) {
		boolean result = false;
		String sql = "UPDATE BookingTest SET BookingStatus='Check In' , RoomNumber=? WHERE Id=?";
		String sql2 = "UPDATE room SET status = 'Available' WHERE id = ?";
		String sql3 = "UPDATE room SET status = 'Occupied' WHERE id = ?";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, checkin.getRoomNumber());
			pstat.setInt(2, checkin.getBookingID());
			pstat.executeUpdate();
			pstat.close();
			conn.close();

			conn = connect();
			pstat = conn.prepareStatement(sql2);
			pstat.setInt(1, checkin.getTmpRoomNumber());
			pstat.executeUpdate();
			pstat.close();
			conn.close();

			conn = connect();
			pstat = conn.prepareStatement(sql3);
			pstat.setInt(1, checkin.getRoomNumber());
			pstat.executeUpdate();
			pstat.close();
			conn.close();

			result = true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
		}
		return result;
	}
	// End of the update booking

	// Retrieve Booked data of a customer
	public ArrayList<ReceptionistLibs> getCheckInGuestData() {
		ArrayList<ReceptionistLibs> customerData = new ArrayList<ReceptionistLibs>();
		String sql = "SELECT b.Id,c.Id,b.RoomNumber,c.FirstName,c.LastName,c.Email,c.Address,c.CreditCard,b.CheckIn,b.CheckOut,b.RoomType,b.BookingStatus\r\n"
				+ " From Registration as c\r\n" + " INNER JOIN BookingTest as b on\r\n" + " c.Id=b.CustomerId\r\n"
				+ " WHERE b.BookingStatus='Check In';";
		try {
			conn = connect();
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			while (rs.next()) {
				ReceptionistLibs getdbData = new ReceptionistLibs(rs.getInt("Id"), rs.getInt("Id"),
						rs.getInt("RoomNumber"), rs.getString("FirstName"), rs.getString("LastName"),
						rs.getString("Email"), rs.getString("Address"), rs.getString("CreditCard"),
						rs.getString("CheckIn"), rs.getString("CheckOut"), rs.getString("RoomType"),
						rs.getString("BookingStatus"));
				customerData.add(getdbData);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
		}

		return customerData;
	}
}
