/**
 * 
 */
package CustomerUi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import Database.Database;



/**
 * @author Anonymous
 *
 */
public class Booking extends JFrame implements ActionListener, ItemListener {

	JPanel pnlMain, pnlBooking, pnlField, pnlTable, pnlNewBooking;
	JLabel lblBooking, lblNewBooking, lblArrivalDate, lblDepartureDate, lblRoomNum, lblRoomPrice, lblServices;
	JTextField txtPrice;
	JComboBox cmbRoomType;
	JDateChooser dateArrival, dateDeparture;
	JButton btnAdd, btnUpdate, btnDelete, btnClose, btnClear;
	
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);

	int userId;
	String userName;
//	bookingLibs book = new bookingLibs();

	public Booking(int id, String uName) {
		userId = id;
		userName = uName;
		// Form Design Part
		setBounds(100, 250, 1300, 700);
		ImageIcon img = new ImageIcon(getClass().getResource("/Customer Registration & Check IN.png"));
		setTitle("Booking Table");
		setIconImage(img.getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		// JPanel for main panel
		pnlMain = new JPanel();
		pnlMain.setLayout(null);
		pnlMain.setBackground(new Color(200, 244, 255));
		add(pnlMain, BorderLayout.CENTER);
		// End JPanel for main panel

		// Panel Set for the Booking
		pnlBooking = new JPanel();
		pnlBooking.setBounds(0, 0, 1300, 100);
		pnlBooking.setBackground(new Color(0, 0, 0, 0));
		pnlBooking.setLayout(null);
		pnlMain.add(pnlBooking);

		// Label set for the Booking Text
		lblBooking = new JLabel("Booking Window");
		lblBooking.setBounds(0, 0, 1300, 100);
		lblBooking.setHorizontalTextPosition(JLabel.CENTER);
		lblBooking.setHorizontalAlignment(JLabel.CENTER);
		lblBooking.setVerticalAlignment(JLabel.CENTER);
		lblBooking.setFont(new Font("Verdana", Font.BOLD, 35));
		pnlBooking.add(lblBooking);
		// Label set for the Booking Text End

		// Field for the label text-field and Button
		pnlField = new JPanel();
		pnlField.setBounds(20, 110, 400, 530);
		pnlField.setBackground(Color.WHITE);
		pnlField.setLayout(null);
		pnlMain.add(pnlField);

		pnlNewBooking = new JPanel();
		pnlNewBooking.setBounds(0, 0, 400, 50);
		pnlField.add(pnlNewBooking);

		lblNewBooking = new JLabel("New Booking");
		lblNewBooking.setBounds(0, 0, 400, 50);
		lblNewBooking.setHorizontalTextPosition(JLabel.CENTER);
		lblNewBooking.setHorizontalAlignment(JLabel.CENTER);
		lblNewBooking.setVerticalAlignment(JLabel.CENTER);
		lblNewBooking.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlNewBooking.add(lblNewBooking);

		// Check In
		lblArrivalDate = new JLabel("Check In Date : ");
		lblArrivalDate.setBounds(5, 70, 200, 50);
		lblArrivalDate.setFont(new Font("Verdana", Font.BOLD, 18));
		pnlField.add(lblArrivalDate);

		dateArrival = new JDateChooser();
		dateArrival.setBounds(200, 85, 180, 40);
		dateArrival.setDateFormatString("yyyy-MM-dd");
		pnlField.add(dateArrival);
		// Check In End

		// Check Out Date
		lblDepartureDate = new JLabel("Check Out Date : ");
		lblDepartureDate.setBounds(5, 130, 200, 50);
		lblDepartureDate.setFont(new Font("Verdana", Font.BOLD, 18));
		pnlField.add(lblDepartureDate);

		dateDeparture = new JDateChooser();
		dateDeparture.setBounds(200, 140, 180, 40);
		dateDeparture.setDateFormatString("yyyy-MM-dd");
		pnlField.add(dateDeparture);
		// Check Out End

		// Room Type combo box
		lblRoomNum = new JLabel("Room Type : ");
		lblRoomNum.setBounds(5, 200, 200, 50);
		lblRoomNum.setFont(new Font("Verdana", Font.BOLD, 18));
		pnlField.add(lblRoomNum);

		cmbRoomType = new JComboBox();
		/*
		 * for (int i = 0; i < GlobalRoom.ROOM_TYPES.length; i++) {
		 * cmbRoomType.addItem(GlobalRoom.ROOM_TYPES[i]); }
		 */
		cmbRoomType.setBounds(200, 200, 180, 40);
		cmbRoomType.setFont(new Font("Verdana", Font.BOLD, 18));
		cmbRoomType.addItemListener(this);
		pnlField.add(cmbRoomType);
		// Room Type combo box End

		// Room Price
		lblRoomPrice = new JLabel("Room Price : ");
		lblRoomPrice.setBounds(5, 260, 200, 50);
		lblRoomPrice.setFont(new Font("Verdana", Font.BOLD, 18));
		pnlField.add(lblRoomPrice);

		txtPrice = new JTextField();
		txtPrice.setBounds(200, 260, 180, 40);
		txtPrice.setEditable(false);
		pnlField.add(txtPrice);
		// Room Price End

		// JButton set

		// Booking Button
		btnAdd = new JButton("Add");
		btnAdd.setBounds(20, 410, 150, 40);
		btnAdd.setFocusable(false);
		btnAdd.setBackground(Color.RED);
		btnAdd.addActionListener(this);
		pnlField.add(btnAdd);

		// Booking Button End

		// Booking Update Button
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(200, 410, 150, 40);
		btnUpdate.setFocusable(false);
		btnUpdate.setBackground(Color.GREEN);
		btnUpdate.addActionListener(this);
		pnlField.add(btnUpdate);

		// Booking Update Button End

		// Booking Delete Button
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(20, 470, 150, 40);
		btnDelete.setFocusable(false);
		btnDelete.setBackground(Color.BLUE);
		btnDelete.addActionListener(this);
		pnlField.add(btnDelete);

		// Booking Delete Button End

		// Booking Button
		btnClose = new JButton("Close");
		btnClose.setBounds(200, 470, 150, 40);
		btnClose.setFocusable(false);
		btnClose.setBackground(Color.ORANGE);
		btnClose.addActionListener(this);
		pnlField.add(btnClose);

		// Booking Button End

		// JButton End

		// Field for the label text-field and Button End


		// Panel Set for the Booking End

		pnlTable = new JPanel();
		pnlTable.setBounds(430, 110, 840, 530);
		pnlMain.add(pnlTable);

		table.setPreferredScrollableViewportSize(new Dimension(820, 500));
		table.setFillsViewportHeight(true);
		pnlTable.add(new JScrollPane(table));
		dtm.addColumn("Booking Id");
		dtm.addColumn("CheckIn");
		dtm.addColumn("CheckOut");
		dtm.addColumn("Room Type");
		dtm.addColumn("Room Price");
		dtm.addColumn("Status");
		dtm.addColumn("Room Number");

		display(); // there is no error to display

		/*
		 * table.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { int i =
		 * table.getSelectedRow(); TableModel model = table.getModel(); int bookingID =
		 * Integer.parseInt(model.getValueAt(i, 0).toString()); String arrivalDate =
		 * model.getValueAt(i, 1).toString(); String departureDate = model.getValueAt(i,
		 * 2).toString(); String roomType = model.getValueAt(i, 3).toString(); double
		 * price = Double.parseDouble(model.getValueAt(i, 4).toString());
		 * book.setBookingStatus(model.getValueAt(i, 5).toString()); int roomNumber =
		 * Integer.parseInt(model.getValueAt(i, 6).toString()); try { Date date1 = new
		 * SimpleDateFormat("yyyy-MM-dd").parse((String)arrivalDate.toString());
		 * dateArrival.setDate(date1); Date date2 = new
		 * SimpleDateFormat("yyyy-MM-dd").parse((String)departureDate.toString());
		 * dateDeparture.setDate(date2); } catch (ParseException ae) {
		 * System.out.println("Error : "+ae.getMessage()); }
		 * 
		 * if (roomType.equals("Single")) { cmbRoomType.setSelectedIndex(1); } else if
		 * (roomType.equals("Double")) { cmbRoomType.setSelectedIndex(2); } else if
		 * (roomType.equals("Twin")) { cmbRoomType.setSelectedIndex(3); }
		 * txtPrice.setText(Double.toString(price)); book.setBookingId(bookingID);
		 * book.setRoomId(roomNumber); } });
		 */
		setVisible(true);
		// End Design Part
	}



	// Display Table and data
	private void display() {
		// table = new JTable(dtm);
		try {
			dtm.setRowCount(0);
			Database db = new Database();
			Connection conn;
			conn = db.connect();
			String sql = "SELECT * FROM BookingTest WHERE CustomerId=?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, userId);
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				int bookingId,roomNumber;
				String checkIn, checkOut, roomType, roomPrice, status;
				bookingId = rs.getInt("Id");
				checkIn = rs.getString("CheckIn");
				checkOut = rs.getString("CheckOut");
				roomType = rs.getString("RoomType");
				roomPrice = rs.getString("RoomPrice");
				status = rs.getString("BookingStatus");
				roomNumber = rs.getInt("RoomNumber");
				Object tmpRow[] = { bookingId, checkIn, checkOut, roomType, roomPrice, status, roomNumber };
				dtm.addRow(tmpRow);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in display : " + e.getMessage());
		}

	}
	// End line of display table and data

	

	// Combo Box Item Listener Part
	/*
	 * @Override public void itemStateChanged(ItemEvent ae) { if (ae.getSource() ==
	 * cmbRoomType) { int index = cmbRoomType.getSelectedIndex();
	 * txtPrice.setText(Double.toString(GlobalRoom.ROOM_Price[index])); } } // Combo
	 * Box Item Listener Part END
	 * 
	 */

	public static void main (String[]args) {
		new Booking(1, "azzaya");
		
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
