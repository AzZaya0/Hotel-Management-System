package Receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ReceptionistLibs.ReceptionistJDBC;
import ReceptionistLibs.ReceptionistLibs;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class BookingDetails extends JFrame {

	JPanel contentPane;

	// declaration for display Table
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);
	Object[] obj;
	ArrayList<ReceptionistLibs> customerData;
	ArrayList roomNumber;
	// declaration for display Table end

	/**
	 * Create the frame.
	 */
	public BookingDetails() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 1400, 800);
		setTitle("Booked Customer Details : ");
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Booked Customer Details :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 98, 1376, 655);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 1356, 625);
		panel.add(scrollPane);
		displayTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Hotel Luton");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 1366, 78);
		contentPane.add(lblNewLabel);

		setVisible(true);
	}

	// Method display Table set
	public void displayTable() {
		obj = new Object[11];
		obj[0] = "Booking ID";
//		obj[1] = "Booking Date";
		obj[1] = "First Name";
		obj[2] = "Last Name";
		obj[3] = "Email";
		obj[4] = "Address";
		obj[5] = "Card Details";
		obj[6] = "Arrival Date";
		obj[7] = "Departure Date";
		obj[8] = "Room Type";
		obj[9] = "Status";
		obj[10]="Room Number";
		dtm.setColumnIdentifiers(obj);
		refreshTable(); // Calling refresh Table to show the database data into the table
	}
	// Method display Table set

	// Method which retrieve data from database
	public void refreshTable() {
		customerData = new ReceptionistJDBC().getBooked();
		dtm.setRowCount(0);
		for (ReceptionistLibs customerData : customerData) {
			Object tmpRow[] = { customerData.getBookingID(), customerData.getFirstName(), customerData.getLastName(),
					customerData.getEmail(), customerData.getAddress(), customerData.getCreditCard(),
					customerData.getCheckIn(), customerData.getCheckOut(), customerData.getRoomType(),
					customerData.getStatus() , customerData.getRoomNumber()};
			dtm.addRow(tmpRow);
		}
	}
	// Method which retrieve data from database

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		new BookingDetails();
//	}
}
