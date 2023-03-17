package CorporateCustomerUi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class CurporateCustomer {

	JFrame frame;
	JPanel pnlImg = new JPanel();
	JLabel img = new JLabel("");
	JTextField txtName;
	JTextField txtRegNumber;
	JTextField txtContact;
	JTextField txtEmail;
	JTextField txtUserName;
	JPasswordField txtPassword;
	JPasswordField txtConPassword;

	/**
	 * Create the application.
	 */
	public CurporateCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 20, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.shadow"));
		panel.setForeground(UIManager.getColor("Button.focus"));
		panel.setBounds(0, 0, 986, 763);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblHeader = new JLabel("Hotel Luton");
		lblHeader.setFont(new Font("Verdana", Font.BOLD, 30));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(0, 0, 986, 99);
		panel.add(lblHeader);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBox.background"));
		panel_1.setBounds(0, 98, 986, 665);
		panel.add(panel_1);
		panel_1.setLayout(null);
		pnlImg.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnlImg.setBounds(0, 0, 401, 665);
		pnlImg.setBackground(Color.WHITE);
		panel_1.add(pnlImg);
		pnlImg.setLayout(null);
		img.setHorizontalAlignment(SwingConstants.CENTER);
		img.setBounds(50, 160, 300, 300);
		ImageIcon image = new ImageIcon(getClass().getResource("/SidePicture.png"));
		Image tmpimg = (image).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		image = new ImageIcon(tmpimg);
		img.setIcon(image);

		pnlImg.add(img);

		JPanel pnlInput = new JPanel();
		pnlInput.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pnlInput.setBounds(399, 0, 587, 665);
		panel_1.add(pnlInput);
		pnlInput.setLayout(null);

		JLabel lblCompanyName = new JLabel("Company Name : ");
		lblCompanyName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompanyName.setFont(new Font("Verdana", Font.BOLD, 16));
		lblCompanyName.setBounds(10, 112, 226, 40);
		pnlInput.add(lblCompanyName);

		JLabel lblRegNumber = new JLabel("Registration Number : ");
		lblRegNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegNumber.setFont(new Font("Verdana", Font.BOLD, 16));
		lblRegNumber.setBounds(10, 178, 226, 40);
		pnlInput.add(lblRegNumber);

		JLabel lblContactNumber = new JLabel("Contact Number : ");
		lblContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblContactNumber.setFont(new Font("Verdana", Font.BOLD, 16));
		lblContactNumber.setBounds(10, 248, 226, 40);
		pnlInput.add(lblContactNumber);

		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 16));
		lblEmail.setBounds(10, 311, 226, 40);
		pnlInput.add(lblEmail);

		JLabel lblYserName = new JLabel("Username : ");
		lblYserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblYserName.setFont(new Font("Verdana", Font.BOLD, 16));
		lblYserName.setBounds(10, 374, 226, 40);
		pnlInput.add(lblYserName);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPassword.setBounds(10, 444, 226, 40);
		pnlInput.add(lblPassword);

		JLabel lblConPassword = new JLabel("Confirm Password : ");
		lblConPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConPassword.setFont(new Font("Verdana", Font.BOLD, 16));
		lblConPassword.setBounds(10, 504, 226, 40);
		pnlInput.add(lblConPassword);

		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setBounds(213, 112, 342, 40);
		pnlInput.add(txtName);
		txtName.setColumns(10);

		txtRegNumber = new JTextField();
		txtRegNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRegNumber.setColumns(10);
		txtRegNumber.setBounds(213, 178, 342, 40);
		pnlInput.add(txtRegNumber);

		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtContact.setColumns(10);
		txtContact.setBounds(213, 248, 342, 40);
		pnlInput.add(txtContact);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(213, 311, 342, 40);
		pnlInput.add(txtEmail);

		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUserName.setColumns(10);
		txtUserName.setBounds(213, 374, 342, 40);
		pnlInput.add(txtUserName);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPassword.setBounds(213, 444, 342, 40);
		pnlInput.add(txtPassword);

		txtConPassword = new JPasswordField();
		txtConPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtConPassword.setBounds(213, 504, 342, 40);
		pnlInput.add(txtConPassword);

		JButton btnRegistration = new JButton("Register");
		btnRegistration.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtRegNumber.getText().equals("") || txtName.getText().equals("") || txtContact.getText().equals("")
						|| txtEmail.getText().equals("") || txtUserName.getText().equals("")
						|| txtPassword.getText().equals(""))
					;
				{
					JOptionPane.showMessageDialog(null, "Fill all the fields !");
				}

//				CorporateCustomer customer = new CorporateCustomer();
//				customer.setRegNumber(Integer.parseInt(txtRegNumber.getText()));
//				customer.setName(txtName.getText());
//				customer.setContact(txtContact.getText());
//				customer.setEmail(txtEmail.getText());
//				customer.setUsername(txtUserName.getText());
//				customer.setPassword(txtUserName.getText());
//				customer.setConfirmPass(txtConPassword.getText());
//
//				try {
//					MiddleWare middle = new MiddleWare();
//					middle.insert(customer);
//				} catch (Exception ae) {
//					JOptionPane.showMessageDialog(null, "Error : " + ae.getMessage());
//				}
			}

		});
		btnRegistration.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnRegistration.setBounds(82, 574, 132, 40);
		pnlInput.add(btnRegistration);

		JButton btnClose = new JButton("Close");
		btnClose.setFocusable(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "Are you sure?", "EXIT", JOptionPane.YES_NO_OPTION);
				if(i==JOptionPane.YES_OPTION) {
					frame.dispose();
				}
			}
		});
		btnClose.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnClose.setBounds(417, 574, 132, 40);
		pnlInput.add(btnClose);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Clear", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					txtName.setText(null);
					txtRegNumber.setText(null);
					txtContact.setText(null);
					txtEmail.setText(null);
					txtUserName.setText(null);
					txtPassword.setText(null);
					txtConPassword.setText(null);
				}
			}
		});
		btnClear.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnClear.setBounds(254, 574, 132, 40);
		pnlInput.add(btnClear);

		JLabel lblCorpHeader = new JLabel("Corporate Customer Registration");
		lblCorpHeader.setFont(new Font("Verdana", Font.BOLD, 20));
		lblCorpHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorpHeader.setBounds(0, 0, 587, 69);
		pnlInput.add(lblCorpHeader);

		frame.setVisible(true);

	}
}
