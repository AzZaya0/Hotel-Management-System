package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// Import Library
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Main Class
public class Manager extends JFrame implements ActionListener {

	// Declaration
	JPanel pnlMain, pnlHead, pnlBtn; // JPanel
	JLabel lblTitle; // JTitle
	JButton btnCustomer, btnBooking, btnRoom, btnStaff, btnFood, btnServices;

	// Sub Class
	public Manager() {
		setExtendedState(MAXIMIZED_BOTH); // Full window
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Set the default close operation
		setResizable(false); // Set resize of the window
		setLayout(null); // Set layout of the frame

		pnlMain = new JPanel(); // Initialize and memory allocation
		pnlMain.setBounds(0, 0, 1550, 850); // Set Size of the frame
		pnlMain.setBackground(new Color(0, 204, 255)); // Set the background color of the frame
		pnlMain.setLayout(null);

		pnlHead = new JPanel(); // Initialize and memory allocation
		pnlHead.setBounds(0, 0, 1550, 100); // Set Size of the frame
		pnlHead.setBackground(new Color(0, 0, 0, 180)); // Set the background color of the Panel Head
		pnlHead.setLayout(new GridBagLayout());
		pnlMain.add(pnlHead); // Adding panel Head to the panel main

		lblTitle = new JLabel("Manager Window"); // Initialize and memory allocation
		lblTitle.setFont(new Font("Libre Bodoni", Font.BOLD, 30)); // Font style type and size change
		lblTitle.setForeground(Color.WHITE); // Set the text color
		pnlHead.add(lblTitle); // Adding label to the panel head

		pnlBtn = new JPanel(); // Initialize and declaration
		pnlBtn.setBounds(0, 100, 200, 750); // Set the position and size of the panel button
		pnlBtn.setBackground(new Color(0, 255, 172));
		pnlBtn.setLayout(null);
		pnlMain.add(pnlBtn); // Adding button panel to the main panel

		btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(20, 50, 150, 50);
		btnCustomer.setFont(new Font("Roberto", Font.BOLD, 20));
		btnCustomer.setFocusable(false);
		pnlBtn.add(btnCustomer);

		btnBooking = new JButton("Booking");
		btnBooking.setBounds(20, 150, 150, 50);
		btnBooking.setFont(new Font("Roberto", Font.BOLD, 20));
		btnBooking.setFocusable(false);
		pnlBtn.add(btnBooking);

		btnRoom = new JButton("Room");
		btnRoom.setBounds(20, 250, 150, 50);
		btnRoom.setFont(new Font("Roberto", Font.BOLD, 20));
		btnRoom.setFocusable(false);
		btnRoom.addActionListener(this);
		pnlBtn.add(btnRoom);

		btnStaff = new JButton("Staff");
		btnStaff.setBounds(20, 350, 150, 50);
		btnStaff.setFont(new Font("Roberto", Font.BOLD, 20));
		btnStaff.setFocusable(false);
		pnlBtn.add(btnStaff);

		btnFood = new JButton("Food");
		btnFood.setBounds(20, 450, 150, 50);
		btnFood.setFont(new Font("Roberto", Font.BOLD, 20));
		btnFood.setFocusable(false);
		pnlBtn.add(btnFood);

		btnServices = new JButton("Services");
		btnServices.setBounds(20, 550, 150, 50);
		btnServices.setFont(new Font("Roberto", Font.BOLD, 20));
		btnServices.setFocusable(false);
		pnlBtn.add(btnServices);

		add(pnlMain); // Adding panel to the main frame
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnRoom) {
			new RoomManagement();
		}
	}

	// Main Function
	public static void main(String[] args) {
		new Manager(); // Initialize and memory allocation
	}

}
