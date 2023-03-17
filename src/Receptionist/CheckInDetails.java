package Receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ReceptionistLibs.ReceptionistJDBC;
import ReceptionistLibs.ReceptionistLibs;

import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CheckInDetails extends JFrame {

	JPanel contentPane;
	JLabel lblHeading;
	JPanel pnlContentBox;
	JScrollPane scrollPane;

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
	public CheckInDetails() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 1450, 800);
		setTitle("CheckIn Guest Details");
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblHeading = new JLabel("Hotel Luton");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblHeading.setBounds(0, 0, 1436, 80);
		contentPane.add(lblHeading);

		pnlContentBox = new JPanel();
		pnlContentBox.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"CheckIn Guest List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlContentBox.setBounds(10, 86, 1426, 667);
		contentPane.add(pnlContentBox);
		pnlContentBox.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 1406, 637);
		pnlContentBox.add(scrollPane);
		displayTable();
		scrollPane.setViewportView(table);

		setVisible(true);
	}

	// Method display Table set
	public void displayTable() {
		obj = new Object[11];
		obj[0] = "Booking ID";
//			obj[1] = "Booking Date";
		obj[1] = "First Name";
		obj[2] = "Last Name";
		obj[3] = "Email";
		obj[4] = "Address";
		obj[5] = "Card Details";
		obj[6] = "Arrival Date";
		obj[7] = "Departure Date";
		obj[8] = "Room Type";
		obj[9] = "Status";
		obj[10] = "Room Number";
		dtm.setColumnIdentifiers(obj);
		refreshTable(); // Calling refresh Table to show the database data into the table
	}
	// Method display Table set

	// Method which retrieve data from database
	public void refreshTable() {
		customerData = new ReceptionistJDBC().getCheckInGuestData();
		dtm.setRowCount(0);
		for (ReceptionistLibs customerData : customerData) {
			Object tmpRow[] = { customerData.getBookingID(), customerData.getFirstName(), customerData.getLastName(),
					customerData.getEmail(), customerData.getAddress(), customerData.getCreditCard(),
					customerData.getCheckIn(), customerData.getCheckOut(), customerData.getRoomType(),
					customerData.getStatus(), customerData.getRoomNumber() };
			dtm.addRow(tmpRow);
		}
	}
	// Method which retrieve data from database

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		new CheckInDetails();
//	}

}
