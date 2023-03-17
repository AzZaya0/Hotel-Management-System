package RBSLibs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BarGui extends JFrame {

	JPanel contentPane;
	JTextField txtCustomerName, txtCheckIn, txtDate, txtBookingId, txtPrice, txtQuantity;
	JPanel panel, panel_1;
	JLabel lblRoom, lblCustomerName, lblCheckIn, lblDate, lblBookingId, lblItem, lblPrice, lblQuantity;
	JButton btnAdd, btnClear;
	JComboBox cmbRoom, cmbItems;
	JTable table;
    JButton btnHistory;

	/**
	 * Create the frame.
	 */
	public BarGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bar Window");
		setBounds(200, 20, 1093, 840);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK));
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 0, 1051, 252);
		contentPane.add(panel);
		panel.setLayout(null);

		lblRoom = new JLabel("Room :");
		lblRoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRoom.setBounds(75, 70, 166, 35);
		panel.add(lblRoom);

		cmbRoom = new JComboBox();
		cmbRoom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmbRoom.setBounds(251, 70, 157, 35);
		panel.add(cmbRoom);

		lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCustomerName.setBounds(75, 125, 166, 35);
		panel.add(lblCustomerName);

		txtCustomerName = new JTextField();
		txtCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCustomerName.setEditable(false);
		txtCustomerName.setBounds(251, 125, 157, 35);
		panel.add(txtCustomerName);
		txtCustomerName.setColumns(10);

		lblCheckIn = new JLabel("Check In :");
		lblCheckIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCheckIn.setBounds(75, 192, 166, 35);
		panel.add(lblCheckIn);

		txtCheckIn = new JTextField();
		txtCheckIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCheckIn.setEditable(false);
		txtCheckIn.setColumns(10);
		txtCheckIn.setBounds(251, 192, 157, 35);
		panel.add(txtCheckIn);

		lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDate.setBounds(500, 70, 166, 35);
		panel.add(lblDate);

		txtDate = new JTextField();
		txtDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(690, 70, 157, 35);
		panel.add(txtDate);

		lblBookingId = new JLabel("Booking ID :");
		lblBookingId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBookingId.setBounds(500, 125, 166, 35);
		panel.add(lblBookingId);

		txtBookingId = new JTextField();
		txtBookingId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBookingId.setEditable(false);
		txtBookingId.setColumns(10);
		txtBookingId.setBounds(690, 125, 157, 35);
		panel.add(txtBookingId);
		
		btnHistory = new JButton("History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnHistory.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHistory.setBounds(882, 65, 146, 41);
		panel.add(btnHistory);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(10, 255, 1051, 131);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblItem = new JLabel("Items :");
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblItem.setBounds(75, 20, 129, 35);
		panel_1.add(lblItem);

		cmbItems = new JComboBox();
		cmbItems.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmbItems.setBounds(254, 22, 164, 35);
		panel_1.add(cmbItems);

		lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrice.setBounds(75, 73, 129, 35);
		panel_1.add(lblPrice);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(254, 75, 164, 35);
		panel_1.add(txtPrice);

		lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuantity.setBounds(502, 20, 129, 35);
		panel_1.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtQuantity.setEditable(false);
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(696, 22, 164, 35);
		panel_1.add(txtQuantity);

		btnAdd = new JButton("ADD");
		btnAdd.setFocusable(false);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(561, 86, 122, 35);
		panel_1.add(btnAdd);

		btnClear = new JButton("CLEAR");
		btnClear.setFocusable(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbRoom.setSelectedIndex(0);
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBounds(738, 86, 122, 35);
		panel_1.add(btnClear);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 396, 1051, 397);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new BarGui();
	}
}
