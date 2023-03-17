package RegistrationLibs;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mylibs.Room;

public class JDBCRegistration extends Database {
	// Insert Room
	public boolean insert(registration Registration) {
		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO Registration(FirstName,LastName,Address,PostalCode,Gender,PhoneNumber,CreditCard,CvcNumber,Email,UName,Password,UserType) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// insert
			conn = connect();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, Registration.getfName());
			pstat.setString(2, Registration.getlName());
			pstat.setString(3, Registration.getAddress());
			pstat.setInt(4, Registration.getPostalCode());
			pstat.setString(5, Registration.getGender());
			pstat.setString(6, Registration.getPhoneNumber());
			pstat.setString(7, Registration.getCreditCard());
			pstat.setString(8, Registration.getCvcNumber());
			pstat.setString(9, Registration.getEmail());
			pstat.setString(10, Registration.getUserName());
			pstat.setString(11, Registration.getPassword());
			pstat.setString(12, Registration.getType());

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
