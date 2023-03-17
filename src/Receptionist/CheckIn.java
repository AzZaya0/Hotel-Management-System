// Package Include
package Receptionist;

// Import library
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import ReceptionistLibs.CheckInLibs;
import ReceptionistLibs.ReceptionistJDBC;
import ReceptionistLibs.ReceptionistLibs;

// Main class
public class CheckIn extends JFrame {

	// Declaration
	JPanel contentPane, pnlContent;
	JTextField txtRoomType;
	JTextField txtCardDetails;
	JDateChooser dateCheckIn;
	JLabel lblNewLabel, lblRoomNo, lblRoomType, lblCheckInDate, lblCardDetails;
	JButton btnView, btnCheckin, btnClose, btnClear;
	JComboBox cmbRoomNo;
	JScrollPane scrollPane;

	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);
	Object[] obj;
	ArrayList<CheckInLibs> checkIn;
	ArrayList roomNumber;
	CheckInLibs check = new CheckInLibs();

	/**
	 * Create the frame.
	 */
	public CheckIn() {

		// Frame set
		setTitle("Check In Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 1400, 800);
		ImageIcon img = new ImageIcon(getClass().getResource("/Customer Registration & Check IN.png"));
		setIconImage(img.getImage());
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Customer CheckIn label set
		lblNewLabel = new JLabel("Customer CheckIn");
		lblNewLabel.setBounds(0, 0, 1386, 70);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		// Customer CheckIn label end

		// Content panel set
		pnlContent = new JPanel();
		pnlContent.setBounds(115, 94, 1169, 250);
		pnlContent.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		pnlContent.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(pnlContent);
		pnlContent.setLayout(null);
		// Content panel set end

		// Label room set
		lblRoomNo = new JLabel("Room Number :");
		lblRoomNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRoomNo.setBounds(27, 16, 146, 33);
		pnlContent.add(lblRoomNo);
		// Label room end

		// Label Room type set
		lblRoomType = new JLabel("Room Type :");
		lblRoomType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRoomType.setBounds(27, 89, 146, 33);
		pnlContent.add(lblRoomType);
		// Label Room type end

		// Label Check In set
		lblCheckInDate = new JLabel("Check In Date:");
		lblCheckInDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckInDate.setBounds(676, 16, 146, 33);
		pnlContent.add(lblCheckInDate);
		// Label Check In end

		// Label for card details set
		lblCardDetails = new JLabel("Card Details :");
		lblCardDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCardDetails.setBounds(27, 169, 146, 33);
		pnlContent.add(lblCardDetails);
		// Label for card details end

		// Combo Box set for room number selection
		cmbRoomNo = new JComboBox();
		cmbRoomNo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cmbRoomNo.setBounds(183, 13, 146, 41);
		pnlContent.add(cmbRoomNo);
		// Combo Box for room number selection end

		// Text Box set for room number display
		txtRoomType = new JTextField();
		txtRoomType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtRoomType.setBounds(183, 89, 296, 33);
		txtRoomType.setEditable(false);
		pnlContent.add(txtRoomType);
		txtRoomType.setColumns(10);
		// Text Box for room number end

		// Text Box for card details set
		txtCardDetails = new JTextField();
		txtCardDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCardDetails.setColumns(10);
		txtCardDetails.setBounds(183, 169, 296, 33);
		pnlContent.add(txtCardDetails);
		// Text Box for card details set end

		// Text Box for check In set
		dateCheckIn = new JDateChooser();
		dateCheckIn.setForeground(Color.BLACK);
		dateCheckIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dateCheckIn.setBounds(832, 16, 296, 33);
		pnlContent.add(dateCheckIn);

		// System Date pick
		String date = LocalDate.now().toString();
		java.util.Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String) date.toString());
			dateCheckIn.setDate(date1);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
		}
		// End of date checkIn

		// Text Box for check In end

		// Button set to view check In details
		btnView = new JButton("View CheckIn");
		btnView.setFocusable(false);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckInDetails();
			}
		});
		btnView.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnView.setBounds(762, 89, 175, 43);
		pnlContent.add(btnView);
		// Button to view check In details end

		// Button set to perform check In details
		btnCheckin = new JButton("CheckIn");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check.setRoomNumber(Integer.parseInt(cmbRoomNo.getSelectedItem().toString()));
				ReceptionistJDBC jdbc = new ReceptionistJDBC();
				boolean result = jdbc.updateCheckIn(check);
				if (result==true) {
					JOptionPane.showMessageDialog(null, "CheckIn Guest successfully !!");
					displayTable();
					cmbRoomNo.removeAllItems();
					txtRoomType.setText(null);
					txtCardDetails.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "Failed to CheckIn Guest !!");
				}
			}
		});
		btnCheckin.setFocusable(false);
		btnCheckin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCheckin.setBounds(975, 89, 153, 43);
		pnlContent.add(btnCheckin);
		// Button set to perform check In details end

		// Button use to close the frame set
		btnClose = new JButton("Close");
		btnClose.setFocusable(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Are you Sure?", "EXIT", JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_NO_OPTION) {
					dispose();
				}
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClose.setBounds(975, 169, 153, 44);
		pnlContent.add(btnClose);
		// Button use to close the frame set end

		// Button use to clear the text field set
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbRoomNo.removeAllItems();
				txtRoomType.setText(null);
				txtCardDetails.setText(null);
				new CheckInLibs();
			}
		});
		btnClear.setFocusable(false);
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBounds(762, 170, 175, 43);
		pnlContent.add(btnClear);
		// Button use to clear the text field set end

		// ScrollPane set to scroll the table set
		scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 363, 1174, 390);
		contentPane.add(scrollPane);
		displayTable(); // Call display Table method to display the table row and column data
		scrollPane.setViewportView(table);

		// ScrollPane set to scroll the table set

		// Mouse clicked event to get the selected row data
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				check = new CheckInLibs();
				cmbRoomNo.removeAllItems();
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				check.setBookingID(Integer.parseInt(model.getValueAt(i, 0).toString()));
				
				cmbRoomNo.addItem(model.getValueAt(i, 10).toString());
				String roomType = model.getValueAt(i, 8).toString();
				txtRoomType.setText(roomType);

// ------------------------------------------------ Convert string into date      ------------------------------------
//				String checkIn = model.getValueAt(i, 6).toString();
//				Date date1;
//				try {
//					date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String)checkIn.toString());
//					dateCheckIn.setDate(date1); 
//				} catch (ParseException e) {
//					JOptionPane.showMessageDialog(null,"Error : "+e.getMessage());
//				}

				txtCardDetails.setText(model.getValueAt(i, 5).toString());
				roomNumber = new ArrayList();
				roomNumber = new ReceptionistJDBC().getRoomId(roomType);
				for (int j = 0; j < roomNumber.size(); j++) {
					cmbRoomNo.addItem(roomNumber.get(j).toString());
				}
				check.setTmpRoomNumber(Integer.parseInt(model.getValueAt(i, 10).toString()));
			}

		});
		// Mouse clicked event to get the selected row data end

		setVisible(true); // Frame visibility set true
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
		ArrayList<ReceptionistLibs> cData = new ReceptionistJDBC().getBookedData();
		dtm.setRowCount(0);
		for (ReceptionistLibs customerData : cData) {
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
//		CheckIn frame = new CheckIn();
//	}
}
