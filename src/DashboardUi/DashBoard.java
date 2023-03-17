package DashboardUi;

import java.awt.BorderLayout;
// Import Library
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import CustomerUi.Booking;
import CustomerUi.CustomerProfile;
import ui.MainWindow;

// Main Class
public class DashBoard extends JFrame implements MouseListener, ActionListener {

	// Declaration
	JPanel pnlBackground, pnlHead, pnlBody, pnlClose, pnlMinimize;
	JLabel lblClose, lblMaximize, lblMinimize, lblHead;
	JButton btnBooking, btnServices, btnProfile, btnLogOut, btnClose;

	// Variables
	int uId;
	String uName;

	// Extended class
	public DashBoard(int uId, String uName) {

		this.uId = uId;
		this.uName = uName;

		// Frame set
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setLayout(null);

		Border border = BorderFactory.createLineBorder(Color.BLACK);

		// Main Panel of the frame
		pnlBackground = new JPanel();
		pnlBackground.setBounds(0, 0, 1535, 863);
		pnlBackground.setBorder(border);
		pnlBackground.setLayout(null);

		// Hotel Luton Text Set
		// Head panel for Hotel Luton Label
		pnlHead = new JPanel();
		pnlHead.setBounds(2, 30, 1532, 70);
		pnlHead.setBackground(new Color(45, 244, 255));
		pnlHead.setLayout(null);
		pnlBackground.add(pnlHead);

		lblHead = new JLabel("Hotel Luton");
		lblHead.setBounds(0, 0, 1533, 70);
		lblHead.setHorizontalTextPosition(JLabel.CENTER);
		lblHead.setHorizontalAlignment(JLabel.CENTER);
		lblHead.setVerticalAlignment(JLabel.CENTER);
		lblHead.setFont(new Font("Verdana", Font.BOLD, 30));
		pnlHead.add(lblHead);

		// Hotel Luton Text Set End

		// Panel Body
		pnlBody = new JPanel();
		pnlBody.setBounds(2, 100, 1533, 763);
		pnlBody.setBackground(Color.GRAY);
		pnlBody.setLayout(null);
		pnlBackground.add(pnlBody);
		// End of panel body

		// Close Button set
		pnlClose = new JPanel();
		pnlClose.setBounds(1495, 0, 40, 30);
		pnlClose.addMouseListener(this);
		pnlBackground.add(pnlClose);

		lblClose = new JLabel("X");
		lblClose.setHorizontalTextPosition(JLabel.CENTER);
		lblClose.setHorizontalAlignment(JLabel.CENTER);
		pnlClose.add(lblClose);

		// Close button setup end

		// Minimize Button set
		pnlMinimize = new JPanel();
		pnlMinimize.setBounds(1455, 0, 40, 30);
		pnlMinimize.addMouseListener(this);
		pnlBackground.add(pnlMinimize);

		lblMinimize = new JLabel("-");
		lblMinimize.setHorizontalTextPosition(JLabel.CENTER);
		lblMinimize.setHorizontalAlignment(JLabel.CENTER);
		pnlMinimize.add(lblMinimize);

		// Minimize Button setup end

		// Button Booking

		btnBooking = new JButton();
		btnBooking.setIcon(new ImageIcon(getClass().getResource("/Customer Registration & Check IN.png")));
		btnBooking.setBounds(20, 10, 150, 50);
		btnBooking.setFocusable(false);
		btnBooking.setText("Booking");
		btnBooking.setBorder(null);
		btnBooking.addActionListener(this);
		pnlBody.add(btnBooking);

		// End Button Booking

		// Button Services

		btnServices = new JButton();
		btnServices.setIcon(new ImageIcon(getClass().getResource("/Customer Registration & Check IN.png")));
		btnServices.setBounds(270, 10, 150, 50);
		btnServices.setFocusable(false);
		btnServices.setText("Services");
		btnServices.setBorder(null);
		btnServices.addActionListener(this);
		pnlBody.add(btnServices);

		// End Button Internal Services

		// Profile button
		btnProfile = new JButton();
		btnProfile.setIcon(new ImageIcon(getClass().getResource("/Customer Details Bill.png")));
		btnProfile.setBounds(520, 10, 150, 50);
		btnProfile.setFocusable(false);
		btnProfile.setText("Profile");
		btnProfile.setBorder(null);
		btnProfile.addActionListener(this);
		pnlBody.add(btnProfile);
		// End of Profile button

		// Log Out Button
		btnLogOut = new JButton();
		btnLogOut.setIcon(new ImageIcon(getClass().getResource("/logout.png")));
		btnLogOut.setBounds(770, 10, 150, 50);
		btnLogOut.setFocusable(false);
		btnLogOut.setText("Log Out");
		btnLogOut.setBorder(null);
		btnLogOut.addActionListener(this);
		pnlBody.add(btnLogOut);

		// End Log Out Button

		// Log Out Button
		btnClose = new JButton();
		btnClose.setIcon(new ImageIcon(getClass().getResource("/close.png")));
		btnClose.setBounds(1020, 10, 150, 50);
		btnClose.setFocusable(false);
		btnClose.setText("Close");
		btnClose.setBorder(null);
		btnClose.addActionListener(this);
		pnlBody.add(btnClose);

		// End Log Out Button

		add(pnlBackground); // Adding panel to the main frame

		setVisible(true); // Setting up the visibility of the frame true
	}

	// Function while clicking the mouse button
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == pnlClose) {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "EXIT", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (e.getSource() == pnlMinimize) {
			setState(JFrame.ICONIFIED); // Minimize the application window
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == pnlClose) {
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			pnlClose.setBorder(border);
			pnlClose.setBackground(Color.RED);
		} else if (e.getSource() == pnlMinimize) {
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			pnlMinimize.setBorder(border);
			pnlMinimize.setBackground(Color.GRAY);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == pnlClose) {
			pnlClose.setBorder(null);
			pnlClose.setBackground(null);
		} else if (e.getSource() == pnlMinimize) {
			pnlMinimize.setBorder(null);
			pnlMinimize.setBackground(null);
		}

	}

	// End Mouse Listener

	// JButton action Performed method
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnClose) {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "EXIT", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				dispose();
			}
		} else if (ae.getSource() == btnLogOut) {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Log Out", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				this.dispose();
				new MainWindow();
			}

		} else if (ae.getSource() == btnProfile) {
			new CustomerProfile(uId);
		} else if (ae.getSource() == btnServices) {

		} else if (ae.getSource() == btnBooking) {
			new Booking(this.uId, this.uName);
		}
	}

	// End of JButton action Performed method
	
	public static void main(String args []) {
		new DashBoard(1, "Anmol");
	}
}
