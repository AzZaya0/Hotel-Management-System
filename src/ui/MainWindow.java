package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
// Library import
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DashboardUi.DashBoard;
import Receptionist.Receptionist;
import mylibs.User;
import mylibs.UserJDBC;

// Main Class
public class MainWindow extends JFrame implements ActionListener {

	// Declaration
	JPanel pnlHeader, pnlBody, pnlLogin, pnlLoginText;
	JLabel lblHeader, lblLogin, lblUsername, lblPassword;
	JTextField txtUsername;
	JPasswordField txtPassword;
	JButton btnLogIn, btnRegistration;

	// Border
	Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

	// Main Class Constructor
	public MainWindow() {
		setExtendedState(MAXIMIZED_BOTH); // Frame default size
		setTitle("Hotel Luton"); // Title of the window
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Function while closing the application
		setLayout(null); // Layout use in window

		// Header
		pnlHeader = new JPanel();
		pnlHeader.setBounds(0, 0, 1550, 100);
		pnlHeader.setBackground(new Color(0, 204, 255));
		pnlHeader.setLayout(null);

		lblHeader = new JLabel("WELCOME TO HOTEL LUTON");
		lblHeader.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblHeader.setBounds(500, 20, 600, 60);
		pnlHeader.add(lblHeader);

		// Body
		pnlBody = new JPanel();
		pnlBody.setBounds(0, 100, 1550, 750);
		pnlBody.setBackground(new Color(0, 240, 255));
		pnlBody.setLayout(null);

		// LogIn
		pnlLogin = new JPanel();
		pnlLogin.setBackground(new Color(0, 0, 0, 80));
		pnlLogin.setBounds(500, 130, 500, 500);
		pnlLogin.setBorder(border);
		pnlLogin.setLayout(null);
		pnlBody.add(pnlLogin);

		// LogIn Text Panel
		pnlLoginText = new JPanel();
		pnlLoginText.setBounds(0, 0, 500, 50);
		pnlLoginText.setBorder(border);
		pnlLoginText.setBackground(Color.WHITE);
		pnlLogin.add(pnlLoginText);

		// LogIn Text Label
		lblLogin = new JLabel("LogIn Window");
		lblLogin.setBounds(50, 20, 500, 50);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		pnlLoginText.add(lblLogin);

		// Username
		lblUsername = new JLabel("Username :- ");
		lblUsername.setBounds(50, 150, 150, 50);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 20));
		pnlLogin.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(200, 155, 200, 40);
		txtUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					txtPassword.requestFocus();
				}
			}
		});
		pnlLogin.add(txtUsername);

		// Password
		lblPassword = new JLabel("Password :- ");
		lblPassword.setBounds(50, 250, 150, 50);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
		pnlLogin.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(200, 250, 200, 40);
		txtPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					if (txtUsername.getText() == "" && txtPassword.getText() == "") {
						JOptionPane.showMessageDialog(null, "Please input all the fields.");
					} else {
						User user = new User();
						user.setLoginName(txtUsername.getText());
						user.setLoginPassword(txtPassword.getText());
						user = new UserJDBC().login(user);

						if (user.getUid() > 0) {
							if (user.getRole().equals("admin")) {
								// display manager window
								JOptionPane.showMessageDialog(null, "Successfully LogIn as a Super Admin.");
								new Receptionist();
								dispose();

							} else if (user.getRole().equals("Customer")) {
								JOptionPane.showMessageDialog(null, "Successfully LogIn as a Customer.");
								int uId = user.getUid();
								String uName = user.getLoginName();
								dispose();
								new DashBoard(uId, uName);
							} else if (user.getRole().equals("corpcustomer")) {
								JOptionPane.showMessageDialog(null, "Successfully LogIn as a Corporate Customer.");

							}
						}
					}
				}
			}
		});
		pnlLogin.add(txtPassword);

		// LogIn Button
		btnLogIn = new JButton("LogIn");
		btnLogIn.setBounds(160, 350, 200, 40);
		btnLogIn.setFocusable(false);
		btnLogIn.addActionListener(this);
		pnlLogin.add(btnLogIn);

		// Registration Button
		btnRegistration = new JButton("<< Not Yet Member ? >>");
		btnRegistration.setBounds(160, 410, 200, 40);
		btnRegistration.setFocusable(false);
		btnRegistration.addActionListener(this);
		pnlLogin.add(btnRegistration);

		add(pnlHeader);
		add(pnlBody);
		setVisible(true); // Visibility of the window
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnLogIn) {
			if (txtUsername.getText() == "" && txtPassword.getText() == "") {
				JOptionPane.showMessageDialog(null, "Please input all the fields.");
			} else {
				User user = new User();
				user.setLoginName(txtUsername.getText());
				user.setLoginPassword(txtPassword.getText());
				user = new UserJDBC().login(user);

				if (user.getUid() > 0) {
					if (user.getRole().equals("admin")) {
						// display manager window
						JOptionPane.showMessageDialog(null, "Successfully LogIn as a Super Admin.");
						new Receptionist();
						this.dispose();

					} else if (user.getRole().equals("Customer")) {
						JOptionPane.showMessageDialog(null, "Successfully LogIn as a Customer.");
						int uId = user.getUid();
						String uName = user.getLoginName();
						this.dispose();
						new DashBoard(uId, uName);
					} else if (user.getRole().equals("corpcustomer")) {
						JOptionPane.showMessageDialog(null, "Successfully LogIn as a Corporate Customer.");

					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username and Password !!");
				}
			}

		} else if (ae.getSource() == btnRegistration) {
			new Registration();
			dispose();
		}
	}

	// Main method to run our program
	public static void main(String[] args) {
		new MainWindow();
	}

}
