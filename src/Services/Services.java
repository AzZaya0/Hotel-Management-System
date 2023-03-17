package Services;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ReceptionistLibs.ReceptionistLibs;
import ServicesLibs.ServicesJDBC;
import ServicesLibs.ServicesLibs;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Services extends JFrame implements ItemListener {

	// Declaration
	JPanel contentPane;
	JTextField txtCustomerName, txtCheckIn, txtDate, txtBookingId, txtPrice, txtQuantity;
	JPanel pnlHead, pnlMiddle;
	JLabel lblRoom, lblCustomerName, lblCheckIn, lblDate, lblBookingId, lblNewLabel, lblPrice, lblQuantity;
	JButton btnAdd, btnClear;
	JComboBox cmbRoom, cmbServices;
	JLabel lblServicesType;
	JComboBox cmbServicesType;
	JButton btnHistory;

	// Declaration initializer and memory allocation
	ServicesJDBC jdbc = new ServicesJDBC();
	ServicesLibs libs = new ServicesLibs();

	// Arraylist declaration
	ArrayList array;
	ArrayList<ServicesLibs> arrayList = new ArrayList<ServicesLibs>();

	// declaration for display Table
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);
	Object[] obj;
	private JTextField textField;
	// declaration for display Table end

	/**
	 * Create the frame.
	 */
	public Services() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Services Window");
		setBounds(200, 20, 1093, 840);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlHead = new JPanel();
		pnlHead.setBorder(new LineBorder(Color.BLACK));
		pnlHead.setBackground(Color.CYAN);
		pnlHead.setBounds(10, 0, 1051, 252);
		contentPane.add(pnlHead);
		pnlHead.setLayout(null);

		lblRoom = new JLabel("Room :");
		lblRoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRoom.setBounds(75, 70, 166, 35);
		pnlHead.add(lblRoom);

		cmbRoom = new JComboBox();
		showRoomNumber();
		cmbRoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmbRoom.setBounds(251, 70, 157, 35);
		cmbRoom.addItemListener(this);
		pnlHead.add(cmbRoom);

		lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCustomerName.setBounds(75, 125, 166, 35);
		pnlHead.add(lblCustomerName);

		txtCustomerName = new JTextField();
		txtCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCustomerName.setEditable(false);
		txtCustomerName.setBounds(251, 125, 157, 35);
		pnlHead.add(txtCustomerName);
		txtCustomerName.setColumns(10);

		lblCheckIn = new JLabel("Check In Date :");
		lblCheckIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckIn.setBounds(75, 192, 166, 35);
		pnlHead.add(lblCheckIn);

		txtCheckIn = new JTextField();
		txtCheckIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCheckIn.setEditable(false);
		txtCheckIn.setColumns(10);
		txtCheckIn.setBounds(251, 192, 157, 35);
		pnlHead.add(txtCheckIn);

		lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDate.setBounds(500, 70, 166, 35);
		pnlHead.add(lblDate);

		txtDate = new JTextField();
		txtDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(690, 70, 157, 35);
		pnlHead.add(txtDate);

		lblBookingId = new JLabel("Booking ID :");
		lblBookingId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBookingId.setBounds(500, 125, 166, 35);
		pnlHead.add(lblBookingId);

		txtBookingId = new JTextField();
		txtBookingId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBookingId.setEditable(false);
		txtBookingId.setColumns(10);
		txtBookingId.setBounds(690, 125, 157, 35);
		pnlHead.add(txtBookingId);

		btnHistory = new JButton("History");
		btnHistory.setFocusable(false);
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnHistory.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHistory.setBounds(882, 65, 146, 41);
		pnlHead.add(btnHistory);

		pnlMiddle = new JPanel();
		pnlMiddle.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlMiddle.setBackground(Color.GREEN);
		pnlMiddle.setBounds(10, 255, 1051, 131);
		contentPane.add(pnlMiddle);
		pnlMiddle.setLayout(null);

		lblNewLabel = new JLabel("Services :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(413, 20, 95, 35);
		pnlMiddle.add(lblNewLabel);

		lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrice.setBounds(21, 73, 129, 35);
		pnlMiddle.add(lblPrice);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(175, 75, 201, 35);
		pnlMiddle.add(txtPrice);


		lblServicesType = new JLabel("Services Type :");
		lblServicesType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblServicesType.setBounds(21, 20, 144, 35);
		pnlMiddle.add(lblServicesType);

		cmbServicesType = new JComboBox();
		showServicesType();
		cmbServicesType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmbServicesType.setBounds(175, 22, 201, 35);
		cmbServicesType.addItemListener(this);
		pnlMiddle.add(cmbServicesType);

		cmbServices = new JComboBox();
		cmbServices.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmbServices.setBounds(518, 22, 201, 35);
		cmbServices.addItemListener(this);
		pnlMiddle.add(cmbServices);

		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libs.setBookingId(Integer.parseInt(txtBookingId.getText()));
				libs.setDate(txtDate.getText());
				libs.setRoomNumber(Integer.parseInt(cmbRoom.getSelectedItem().toString()));
				libs.setCustomerName(txtCustomerName.getText());
				libs.setServiceType(cmbServicesType.getSelectedItem().toString());
				libs.setServices(cmbServices.getSelectedItem().toString());
				libs.setPrice(Double.parseDouble(txtPrice.getText()));
				
				boolean result=jdbc.insertService(libs);
				if (result==true) {
					JOptionPane.showMessageDialog(null, "Successfully inserted.");
				} else {
					JOptionPane.showMessageDialog(null, "Failed to insert data.");
				}

			}
		});
		btnAdd.setFocusable(false);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(757, 75, 122, 35);
		pnlMiddle.add(btnAdd);

		btnClear = new JButton("CANCEL");
		btnClear.setFocusable(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbRoom.setSelectedIndex(0);
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBounds(905, 75, 122, 35);
		pnlMiddle.add(btnClear);

		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 396, 1051, 397);
		contentPane.add(scrollPane);
		displayTable();
		scrollPane.setViewportView(table);

		setVisible(true);
	}

	// Method display Table set
	public void displayTable() {
		obj = new Object[6];
		obj[0] = "Booking ID";
		obj[1] = "Room No";
		obj[2] = "Name";
		obj[3] = "Service Type";
		obj[4] = "Service Name";
		obj[5] = "Price";
		dtm.setColumnIdentifiers(obj);
	}
	// Method display Table set

	// Getting room data from middleware
	public void showRoomNumber() {
		cmbRoom.addItem("Select");
		array = jdbc.showRoomNumber();
		for (int i = 0; i < array.size(); i++) {
			cmbRoom.addItem(array.get(i));
		}
	}
	// Getting room data from middleware end

	// Fetching the data of customer by passing room number to middleware
	public void showUserInfo() {
		array = jdbc.getCustomerDetails(libs);
		for (int i = 0; i < array.size(); i++) {
			txtDate.setText(LocalDate.now().toString());
			txtCustomerName.setText(libs.getCustomerName());
			txtBookingId.setText(Integer.toString(libs.getBookingId()));
			txtCheckIn.setText(libs.getCheckInDate());
		}
	}
	// Fetching the data of customer by passing room number end

	// Fetching user data while selecting the room number
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbRoom) {
			libs.setRoomNumber(Integer.parseInt(cmbRoom.getSelectedItem().toString()));
			showUserInfo();
		} else if (e.getSource() == cmbServicesType) {
			libs.setServiceType(cmbServicesType.getSelectedItem().toString());
			showService();
		} else if (e.getSource() == cmbServices) {
			if (cmbServices.getSelectedIndex() > 0) {
				libs.setServices(cmbServices.getSelectedItem().toString());
				showServicePrice();
				getServiceId();
			} else {
				txtPrice.setText(null);
			}
		}
	}

	// Getting room data from middleware
	public void showServicesType() {
		cmbServicesType.addItem("Select");
		array = jdbc.showServiceType();
		for (int i = 0; i < array.size(); i++) {
			cmbServicesType.addItem(array.get(i));
		}
	}
	// Getting room data from middleware end

	// Requesting service by sending services type to middleware
	public void showService() {
		cmbServices.removeAllItems();
		cmbServices.addItem("Select");
		array = jdbc.showService(libs);
		for (int i = 0; i < array.size(); i++) {
			cmbServices.addItem(array.get(i));
		}
	}
	// Requesting service by sending services type to middleware end

	// Requesting service by sending services type to middleware
	public void showServicePrice() {
		double rate = jdbc.showServicePrice(libs);
		txtPrice.setText(Double.toString(rate));
	}
	// Requesting service by sending services type to middleware end

	// Requesting service by sending services type to middleware
	public void getServiceId() {
		int id = jdbc.getServiceId(libs);
		libs.setServiceId(id);
		System.out.println(id);
	}
	// Requesting service by sending services type to middleware end

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Services(); // Memory allocation
	}

}
