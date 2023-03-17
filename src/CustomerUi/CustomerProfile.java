package CustomerUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mylibs.User;
import mylibs.UserJDBC;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerProfile extends JFrame {

	JPanel contentPane;
	JTextField txtFname, txtLname, txtEmail, txtCreditCard, txtMobile, txtCid;

	UserJDBC jdbc=new UserJDBC();
	User user = new User();
	/**
	 * Create the frame.
	 */
	public CustomerProfile(int uId) {
		user.setUid(uId);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblProfile.setBounds(10, 10, 466, 55);
		contentPane.add(lblProfile);

		JPanel panel = new JPanel();
		panel.setBounds(10, 75, 466, 427);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblFName = new JLabel("First Name :");
		lblFName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblFName.setBounds(10, 75, 145, 33);
		panel.add(lblFName);

		JLabel lblLName = new JLabel("Last Name :");
		lblLName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLName.setBounds(23, 139, 132, 38);
		panel.add(lblLName);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(23, 197, 132, 38);
		panel.add(lblEmail);

		txtFname = new JTextField();
		txtFname.setEditable(false);
		txtFname.setBounds(163, 77, 211, 33);
		panel.add(txtFname);
		txtFname.setColumns(10);

		JLabel lblCreditCard = new JLabel("Credit Card :");
		lblCreditCard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCreditCard.setBounds(23, 320, 132, 38);
		panel.add(lblCreditCard);

		txtLname = new JTextField();
		txtLname.setEditable(false);
		txtLname.setColumns(10);
		txtLname.setBounds(163, 139, 211, 33);
		panel.add(txtLname);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(163, 202, 211, 33);
		panel.add(txtEmail);

		txtCreditCard = new JTextField();
		txtCreditCard.setColumns(10);
		txtCreditCard.setBounds(163, 325, 211, 33);
		panel.add(txtCreditCard);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFocusable(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setEmail(txtEmail.getText());
				user.setMobile(txtMobile.getText());
				user.setCreditCard(txtCreditCard.getText());
				boolean result = jdbc.ProfileUpdate(user);
				if (result==true) {
					JOptionPane.showMessageDialog(null, "Update Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Failed to Update Details");
				}
				
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(83, 379, 120, 38);
		panel.add(btnUpdate);

		JButton btnClose = new JButton("Close");
		btnClose.setFocusable(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClose.setBounds(236, 379, 120, 38);
		panel.add(btnClose);

		JLabel lblMobile = new JLabel("Mobile :");
		lblMobile.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMobile.setBounds(23, 261, 132, 38);
		panel.add(lblMobile);

		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(163, 266, 211, 33);
		panel.add(txtMobile);

		JLabel lblCustomerId = new JLabel("Customer ID :");
		lblCustomerId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCustomerId.setBounds(10, 32, 145, 33);
		panel.add(lblCustomerId);

		txtCid = new JTextField();
		txtCid.setEditable(false);
		txtCid.setColumns(10);
		txtCid.setBounds(163, 32, 211, 33);
		panel.add(txtCid);

		setVisible(true);
	}
	
	public void showProfile() {
		jdbc.ShowProfile(user);
		txtCid.setText(Integer.toString(user.getUid()));
		txtFname.setText(user.getfName());
		txtLname.setText(user.getlName());
	}

}
