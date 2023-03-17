package Receptionist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import CorporateCustomerUi.CurporateCustomer;
import ui.MainWindow;

public class Receptionist extends JFrame {

	JPanel pnlMain;
	

	/**
	 * Create the frame.
	 */
	public Receptionist() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		pnlMain = new JPanel();
		pnlMain.setBackground(Color.CYAN);
		getContentPane().add(pnlMain);
		pnlMain.setLayout(null);
		
		JLabel lblHead = new JLabel("Hotel Online Booking System");
		lblHead.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(0, 0, 1540, 71);
		pnlMain.add(lblHead);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(0, 81, 1540, 58);
		panelBtn.setBackground(new Color(0,0,0,50));
		pnlMain.add(panelBtn);
		panelBtn.setLayout(null);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setFocusable(false);
		btnCheckOut.setFont(new Font("Elephant", Font.PLAIN, 20));
		btnCheckOut.setBounds(369, 10, 150, 38);
		panelBtn.add(btnCheckOut);
		
		JButton btnBillInformation = new JButton("Bill Information");
		btnBillInformation.setFocusable(false);
		btnBillInformation.setFont(new Font("Elephant", Font.PLAIN, 20));
		btnBillInformation.setBounds(550, 10, 207, 38);
		panelBtn.add(btnBillInformation);
		
		JButton btnExtraServices = new JButton("Extra Services");
		btnExtraServices.setFocusable(false);
		btnExtraServices.setFont(new Font("Elephant", Font.PLAIN, 20));
		btnExtraServices.setBounds(784, 10, 207, 38);
		panelBtn.add(btnExtraServices);
		
		JButton btnRestaurant = new JButton("Restaurant Services");
		btnRestaurant.setFocusable(false);
		btnRestaurant.setFont(new Font("Elephant", Font.PLAIN, 20));
		btnRestaurant.setBounds(1028, 10, 253, 38);
		panelBtn.add(btnRestaurant);
		
		JButton btnBarService = new JButton("Bar Service");
		btnBarService.setFocusable(false);
		btnBarService.setFont(new Font("Elephant", Font.PLAIN, 20));
		btnBarService.setBounds(1323, 10, 207, 38);
		panelBtn.add(btnBarService);
		
		JButton btnBooking = new JButton("Booking");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookingConfirmation1();
			}
		});
		btnBooking.setFont(new Font("Elephant", Font.PLAIN, 20));
		btnBooking.setFocusable(false);
		btnBooking.setBounds(10, 10, 150, 38);
		panelBtn.add(btnBooking);
		
		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.setBounds(191, 10, 150, 38);
		panelBtn.add(btnCheckIn);
		btnCheckIn.setFont(new Font("Elephant", Font.PLAIN, 20));
		btnCheckIn.setFocusable(false);
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckIn();
			}
		});
		
		JPanel panelManage = new JPanel();
		panelManage.setBackground(new Color(0,0,0,50));
		panelManage.setBounds(0, 149, 280, 692);
		pnlMain.add(panelManage);
		panelManage.setLayout(null);
		
		JLabel lblManage = new JLabel("Manage Customer");
		lblManage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblManage.setHorizontalAlignment(SwingConstants.CENTER);
		lblManage.setBounds(0, 0, 280, 40);
		panelManage.add(lblManage);
		
		JButton btnNonCorp = new JButton("Non Corporate Customer");
		btnNonCorp.setFocusable(false);
		btnNonCorp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNonCorp.setBackground(Color.GREEN);
		btnNonCorp.setForeground(Color.BLACK);
		btnNonCorp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNonCorp.setBounds(10, 67, 260, 40);
		panelManage.add(btnNonCorp);
		
		JButton btnCorp = new JButton("Corporate Customer");
		btnCorp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CurporateCustomer();
			}
		});
		btnCorp.setFocusable(false);
		btnCorp.setBackground(Color.GREEN);
		btnCorp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCorp.setBounds(10, 136, 260, 40);
		panelManage.add(btnCorp);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Log Out", JOptionPane.YES_NO_OPTION);
				if(confirm==JOptionPane.YES_OPTION) {
					new MainWindow();
					dispose();
				}
			}
		});
		btnNewButton.setBounds(63, 629, 145, 38);
		panelManage.add(btnNewButton);
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Elephant", Font.PLAIN, 20));
		
		setVisible(true);
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		new Receptionist();
//	}
}
