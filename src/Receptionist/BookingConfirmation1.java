package Receptionist;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ReceptionistLibs.ReceptionistJDBC;
import ReceptionistLibs.ReceptionistLibs;

public class BookingConfirmation1 extends JFrame {

	JPanel pnlMain,pnlFields;
	JLabel BG, lblHead, lblBookingDate, lblCheckoutDate, lblRoomNumber,lblBookingID,lblCheckinDate,lblRoomType,lblCreditCard;
	JTextField txtBookingId,
	 txtCheckIn,
	 txtRoomType,
	 txtCreditCard,
	 txtBookingDate,
	 txtCheckOutDate;
	
	JButton btnBook, btnCancel, btnViewBook, btnClose;
	JComboBox cmbRoom;
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
	public BookingConfirmation1() {
		setTitle("Booking Confirmation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(20, 20, 900, 750);
		setLocationRelativeTo(null);
		setResizable(false);
		
		pnlMain = new JPanel();
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlMain);
		pnlMain.setLayout(null);

		 pnlFields = new JPanel();
		pnlFields.setBounds(50, 94, 800, 252);
		pnlFields.setBackground(new Color(166, 137, 225,200));
		pnlMain.add(pnlFields);
		pnlFields.setLayout(null);

		
	
		
		lblBookingID = new JLabel("Booking ID :");
		lblBookingID.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookingID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBookingID.setBounds(21, 21, 145, 29);
		lblBookingID.setForeground(Color.white);
		pnlFields.add(lblBookingID);

		txtBookingId = new JTextField();
		txtBookingId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBookingId.setEditable(false);
		txtBookingId.setBounds(176, 23, 150, 29);
		pnlFields.add(txtBookingId);
		txtBookingId.setColumns(10);

		 lblCheckinDate = new JLabel("CheckIn Date :");
		lblCheckinDate.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblCheckinDate.setForeground(Color.white);
		lblCheckinDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckinDate.setBounds(21, 79, 145, 29);
		pnlFields.add(lblCheckinDate);

		 lblRoomType = new JLabel("Room Type :");
		lblRoomType.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoomType.setForeground(Color.white);
		lblRoomType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRoomType.setBounds(21, 139, 145, 29);
		pnlFields.add(lblRoomType);

		 lblCreditCard = new JLabel("Credit Card :");
		lblCreditCard.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreditCard.setForeground(Color.white);
		lblCreditCard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCreditCard.setBounds(415, 139, 145, 29 );
		pnlFields.add(lblCreditCard);

		txtCheckIn = new JTextField();
		txtCheckIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCheckIn.setEditable(false);
		txtCheckIn.setColumns(10);
		txtCheckIn.setBounds(176, 81, 150, 29);
		pnlFields.add(txtCheckIn);

		txtRoomType = new JTextField();
		txtRoomType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtRoomType.setEditable(false);
		txtRoomType.setColumns(10);
		txtRoomType.setBounds(176, 141, 150, 29);
		pnlFields.add(txtRoomType);

		txtCreditCard = new JTextField();
		txtCreditCard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCreditCard.setEditable(false);
		txtCreditCard.setColumns(10);
		txtCreditCard.setBounds(570, 139, 200, 29 );
		pnlFields.add(txtCreditCard);

		lblBookingDate = new JLabel("Booking Date :");
		lblBookingDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookingDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBookingDate.setForeground(Color.white);
		lblBookingDate.setBounds(415, 21, 145, 29);
		pnlFields.add(lblBookingDate);

		lblCheckoutDate = new JLabel("CheckOut Date :");
		lblCheckoutDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblCheckoutDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckoutDate.setBounds(415, 79, 145, 29);
		lblCheckoutDate.setForeground(Color.white);
		pnlFields.add(lblCheckoutDate);

		lblRoomNumber = new JLabel("Room Number :");
		lblRoomNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoomNumber.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRoomNumber.setForeground(Color.white);
		lblRoomNumber.setBounds(201, 197, 141, 29);
		pnlFields.add(lblRoomNumber);

		txtBookingDate = new JTextField();
		txtBookingDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBookingDate.setEditable(false);
		txtBookingDate.setColumns(10);
		txtBookingDate.setBounds(570, 21, 150, 29);
		pnlFields.add(txtBookingDate);

		txtCheckOutDate = new JTextField();
		txtCheckOutDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCheckOutDate.setEditable(false);
		txtCheckOutDate.setColumns(10);
		txtCheckOutDate.setBounds(570, 79, 150, 29);
		pnlFields.add(txtCheckOutDate);

		cmbRoom = new JComboBox();
		cmbRoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
	
		cmbRoom.setBounds(356, 199, 150, 29);
		pnlFields.add(cmbRoom);

		btnBook = new JButton("Book");
		btnBook.setFocusable(false);
		btnBook.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBook.setBounds(515, 191, 105, 45);
		btnBook.setBackground(new Color(255,255,255));
		btnBook.setBorder(BorderFactory.createLineBorder(Color.black, 3));

		pnlFields.add(btnBook);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookingID = Integer.parseInt(txtBookingId.getText());
				int roomNumber = Integer.parseInt(cmbRoom.getSelectedItem().toString());
				boolean result = new ReceptionistJDBC().updateRoom(bookingID, roomNumber);
				if (result == true) {
					JOptionPane.showMessageDialog(null, "Successfully allocate a room.");
					txtBookingId.setText(null);
					txtBookingDate.setText(null);
					txtCheckIn.setText(null);
					txtCheckOutDate.setText(null);
					txtRoomType.setText(null);
					cmbRoom.setSelectedIndex(0);
					txtCreditCard.setText(null);
					refreshTable();
				} else {
					JOptionPane.showMessageDialog(null, "Failed to allocate a room.");
				}
			}
		});
		

		btnCancel = new JButton("Cancel");
		btnCancel.setFocusable(false);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCancel.setBackground(new Color(255,255,255));
		btnCancel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

		btnCancel.setBounds(50, 191, 145, 45);
		pnlFields.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				int bookingID = Integer.parseInt(txtBookingId.getText());
				boolean result = new ReceptionistJDBC().updateRoom(bookingID,0);
				if (result == true) {
					JOptionPane.showMessageDialog(null, "Successfully update a status.");
					txtBookingId.setText(null);
					txtBookingDate.setText(null);
					txtCheckIn.setText(null);
					txtCheckOutDate.setText(null);
					txtRoomType.setText(null);
					txtCreditCard.setText(null);
					refreshTable();
				} else {
					JOptionPane.showMessageDialog(null, "Failed to update status.");
				}
			}
		});
	

		btnViewBook = new JButton("View Booking");
		btnViewBook.setFocusable(false);
		btnViewBook.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnViewBook.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		btnViewBook.setBackground(new Color(255,255,255,200));
		btnViewBook.setBounds(700, 31, 135, 45);
		pnlMain.add(btnViewBook);

		btnClose = new JButton("CLOSE");
		btnClose.setFocusable(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sure = JOptionPane.showConfirmDialog(null, "Are your sure you want to close?", "EXIT",
						JOptionPane.YES_NO_OPTION);
				if (sure == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClose.setFocusable(false);
		btnClose.setBounds(987, 197, 145, 45);
		pnlFields.add(btnClose);

		lblHead = new JLabel("Booking Confirmation ");
		lblHead.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblHead.setForeground(Color.white);
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(0, 0, 466, 103);
		pnlMain.add(lblHead);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 363, 800, 320);
		pnlMain.add(scrollPane);
		displayTable();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				cmbRoom.removeAllItems();
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				txtBookingId.setText(model.getValueAt(i, 0).toString());
				txtCheckIn.setText(model.getValueAt(i, 6).toString());
				txtCheckOutDate.setText(model.getValueAt(i, 7).toString());
				String roomType = model.getValueAt(i, 8).toString();
				txtRoomType.setText(roomType);

				roomNumber = new ReceptionistJDBC().getRoomId(roomType);
				for (int j = 0; j < roomNumber.size(); j++) {
					cmbRoom.addItem(roomNumber.get(j).toString());
				}

				txtCreditCard.setText(model.getValueAt(i, 5).toString());
			}
		});

		
		
//		BG = new JLabel();
//		Image img1 = new ImageIcon(this.getClass().getResource("b1.jpg")).getImage();
//		BG.setIcon(new ImageIcon(img1));
//		BG.setBounds(0, 0,900,750);
//		pnlMain.add(BG);
		
		
		setVisible(true);
	}

	// Method display Table set
	public void displayTable() {
		obj = new Object[10];
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
		dtm.setColumnIdentifiers(obj);
		refreshTable(); // Calling refresh Table to show the database data into the table
	}
	// Method display Table set

	// Method which retrieve data from database
	public void refreshTable() {
		customerData = new ReceptionistJDBC().getPendingBookingData();
		dtm.setRowCount(0);
		for (ReceptionistLibs customerData : customerData) {
			Object tmpRow[] = { customerData.getBookingID(), customerData.getFirstName(), customerData.getLastName(),
					customerData.getEmail(), customerData.getAddress(), customerData.getCreditCard(),
					customerData.getCheckIn(), customerData.getCheckOut(), customerData.getRoomType(),
					customerData.getStatus() };
			dtm.addRow(tmpRow);
		}
	}
	// Method which retrieve data from database


	public static void main(String[] args) {
		new BookingConfirmation1();
	}
}
