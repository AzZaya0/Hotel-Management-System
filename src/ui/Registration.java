package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
// Import library
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import RegistrationLibs.Global;
import RegistrationLibs.JDBCRegistration;
import RegistrationLibs.Validation;
import RegistrationLibs.registration;

// Main Class
public class Registration extends JFrame implements ActionListener, MouseListener {

	// Declaration
	JPanel pnlMain, pnlBody, pnlHead, pnlImgIcon;
	JLabel lblHead, lblFname, lblLname, lblAddress, lblPostCode, lblGender, lblPhoneNumber, lblCreditCard, lblCvcNumber,
			lblEmail, lblUserName, lblPassword, lblConfirmPassword, lblLogIn; // Label for text
	JTextField txtFname, txtLname, txtAddress, txtPostalCode, txtPhoneNumber, txtCreditCard, txtCvcNumber, txtEmail,
			txtUsername;
	JPasswordField txtPassword,txtConfirmPassword;
	JComboBox cmbGender;
	JButton btnRegistration;

	// Constructor
	public Registration() {
		setTitle("Registration"); // Title of the window
		setExtendedState(MAXIMIZED_BOTH); // Maximize the size of the window
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Close operation while closing the window
		setLayout(null);

		pnlMain = new JPanel(); // Initialize and declaration
		pnlMain.setBounds(0, 0, 1550, 850); // Set size of the panel
		pnlMain.setBackground(new Color(0, 204, 255)); // Background Color change using the color code
		pnlMain.setLayout(null); // Set the layout of the panel to null

		pnlHead = new JPanel();
		pnlHead.setBounds(0, 0, 1550, 100);
		pnlHead.setBackground(new Color(0, 0, 0, 180));
		pnlHead.setLayout(new GridBagLayout());
		pnlMain.add(pnlHead);

		lblHead = new JLabel("Customer  Registration");
		lblHead.setForeground(Color.WHITE);
		lblHead.setFont(new Font("Arial Black", Font.BOLD, 30));
		pnlHead.add(lblHead);

		pnlBody = new JPanel(); // Panel Body initialize and memory allocation
		pnlBody.setBounds(500, 200, 1000, 550); // Set size of the panel
		pnlBody.setBackground(new Color(0, 0, 0, 150)); // Background Color change using the color code
		pnlBody.setLayout(null);
		pnlMain.add(pnlBody); // Adding body panel to the main panel

		// JLabel Part

		// First Name Label
		lblFname = new JLabel("First Name : ");
		lblFname.setForeground(Color.WHITE);
		lblFname.setFont(new Font("Lora", Font.BOLD, 16));
		lblFname.setBounds(50, 20, 150, 20);
		pnlBody.add(lblFname);

		// First Name Text Field
		txtFname = new JTextField();
		txtFname.setForeground(Color.BLACK);
		txtFname.setFont(new Font("Lora", Font.BOLD, 16));
		txtFname.setBounds(160, 20, 250, 25);
		pnlBody.add(txtFname);

		// Last Name Label
		lblLname = new JLabel("Last Name : ");
		lblLname.setForeground(Color.WHITE);
		lblLname.setFont(new Font("Lora", Font.BOLD, 16));
		lblLname.setBounds(500, 20, 150, 20);
		pnlBody.add(lblLname);

		// Last Name Text Field
		txtLname = new JTextField();
		txtLname.setForeground(Color.BLACK);
		txtLname.setFont(new Font("Lora", Font.BOLD, 16));
		txtLname.setBounds(660, 20, 250, 25);
		pnlBody.add(txtLname);

		// Address Label
		lblAddress = new JLabel("Address : ");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Lora", Font.BOLD, 16));
		lblAddress.setBounds(50, 90, 150, 20);
		pnlBody.add(lblAddress);

		// Address Text Field
		txtAddress = new JTextField();
		txtAddress.setForeground(Color.BLACK);
		txtAddress.setFont(new Font("Lora", Font.BOLD, 16));
		txtAddress.setBounds(160, 90, 250, 25);
		pnlBody.add(txtAddress);

		// Postal Code Label
		lblPostCode = new JLabel("Postal Code : ");
		lblPostCode.setForeground(Color.WHITE);
		lblPostCode.setFont(new Font("Lora", Font.BOLD, 16));
		lblPostCode.setBounds(500, 90, 150, 20);
		pnlBody.add(lblPostCode);

		// Last Name Text Field
		txtPostalCode = new JTextField();
		txtPostalCode.setForeground(Color.BLACK);
		txtPostalCode.setFont(new Font("Lora", Font.BOLD, 16));
		txtPostalCode.setBounds(660, 90, 250, 25);
		pnlBody.add(txtPostalCode);

		// Gender Label
		lblGender = new JLabel("Gender : ");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Lora", Font.BOLD, 16));
		lblGender.setBounds(50, 160, 150, 20);
		pnlBody.add(lblGender);

		// Gender Text Field
		cmbGender = new JComboBox();
		for (int i = 0; i < Global.Gender.length; i++) {
			cmbGender.addItem(Global.Gender[i]);
		}
		cmbGender.setForeground(Color.BLACK);
		cmbGender.setFont(new Font("Lora", Font.BOLD, 16));
		cmbGender.setBounds(160, 160, 250, 25);
		pnlBody.add(cmbGender);

		// Phone Number Code Label
		lblPhoneNumber = new JLabel("Phone Number : ");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Lora", Font.BOLD, 16));
		lblPhoneNumber.setBounds(500, 160, 150, 20);
		pnlBody.add(lblPhoneNumber);

		// Phone Number Text Field
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setForeground(Color.BLACK);
		txtPhoneNumber.setFont(new Font("Lora", Font.BOLD, 16));
		txtPhoneNumber.setBounds(660, 160, 250, 25);
		pnlBody.add(txtPhoneNumber);

		// Credit Card Label
		lblCreditCard = new JLabel("Credit Card : ");
		lblCreditCard.setForeground(Color.WHITE);
		lblCreditCard.setFont(new Font("Lora", Font.BOLD, 16));
		lblCreditCard.setBounds(50, 230, 150, 20);
		pnlBody.add(lblCreditCard);

		// Credit Card Field
		txtCreditCard = new JTextField();
		txtCreditCard.setForeground(Color.BLACK);
		txtCreditCard.setFont(new Font("Lora", Font.BOLD, 16));
		txtCreditCard.setBounds(160, 230, 250, 25);
		pnlBody.add(txtCreditCard);

		// CVC Number Code Label
		lblCvcNumber = new JLabel("CVC Number : ");
		lblCvcNumber.setForeground(Color.WHITE);
		lblCvcNumber.setFont(new Font("Lora", Font.BOLD, 16));
		lblCvcNumber.setBounds(500, 230, 150, 20);
		pnlBody.add(lblCvcNumber);

		// Phone Number Text Field
		txtCvcNumber = new JTextField();
		txtCvcNumber.setForeground(Color.BLACK);
		txtCvcNumber.setFont(new Font("Lora", Font.BOLD, 16));
		txtCvcNumber.setBounds(660, 230, 250, 25);
		pnlBody.add(txtCvcNumber);

		// Email Label
		lblEmail = new JLabel("Email : ");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Lora", Font.BOLD, 16));
		lblEmail.setBounds(50, 300, 150, 20);
		pnlBody.add(lblEmail);

		// Email Field
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Lora", Font.BOLD, 16));
		txtEmail.setBounds(160, 300, 250, 25);
		pnlBody.add(txtEmail);

		// Username Label
		lblUserName = new JLabel("Username : ");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Lora", Font.BOLD, 16));
		lblUserName.setBounds(500, 300, 150, 20);
		pnlBody.add(lblUserName);

		// Username Text Field
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setFont(new Font("Lora", Font.BOLD, 16));
		txtUsername.setBounds(660, 300, 250, 25);
		pnlBody.add(txtUsername);

		// Password Label
		lblPassword = new JLabel("Password : ");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Lora", Font.BOLD, 16));
		lblPassword.setBounds(50, 370, 150, 20);
		pnlBody.add(lblPassword);

		// Password Field
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setFont(new Font("Lora", Font.BOLD, 16));
		txtPassword.setBounds(160, 370, 250, 25);
		pnlBody.add(txtPassword);

		// Confirm Password Label
		lblConfirmPassword = new JLabel("Confirm Password : ");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Lora", Font.BOLD, 16));
		lblConfirmPassword.setBounds(500, 370, 170, 20);
		pnlBody.add(lblConfirmPassword);

		// Confirm Password Field
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setForeground(Color.BLACK);
		txtConfirmPassword.setFont(new Font("Lora", Font.BOLD, 16));
		txtConfirmPassword.setBounds(660, 370, 250, 25);
		pnlBody.add(txtConfirmPassword);

		// JButton Part

		// Registration Button
		btnRegistration = new JButton("Registration");
		btnRegistration.setBounds(300, 430, 400, 30);
		btnRegistration.setFocusable(false);
		btnRegistration.addActionListener(this);
		pnlBody.add(btnRegistration);

		// Label For LogIn
		lblLogIn = new JLabel("<<  Already a member  >>");
		lblLogIn.setBounds(400, 480, 200, 30);
		lblLogIn.setFont(new Font("Lora", Font.BOLD, 16));
		lblLogIn.setForeground(Color.WHITE);
		lblLogIn.addMouseListener(this);
		pnlBody.add(lblLogIn);

		add(pnlMain); // Adding main panel to the Frame
		setVisible(true); // Visibility of the Frame
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		new MainWindow();
		this.dispose();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnRegistration) {
			registration reg = new registration();
			if ((txtFname.getText() == "") || (txtLname.getText() == "") || (txtAddress.getText() == "")
					|| (txtPostalCode.getText() == "") || (txtPhoneNumber.getText() == "")
					|| (txtCreditCard.getText() == "") || (txtCvcNumber.getText() == "") || (txtEmail.getText() == "")
					|| (txtUsername.getText() == "") || (txtPassword.getText() == "")
					|| (txtConfirmPassword.getText() == "")) {
				JOptionPane.showMessageDialog(null, "Please Fill all the fields");
			} else {
				// First Name validation
				String fname = txtFname.getText();
				Validation val = new Validation();
				boolean resultFName = val.fName(fname);
				if (resultFName == true) {
					// Last Name validation
					String lname = txtLname.getText();
					boolean resultLName = val.lName(lname);
					if (resultLName == true) {
						// Postal Code / Zip Code validation
						int postal = Integer.parseInt(txtPostalCode.getText());
						boolean resultPostal = val.Postal(Integer.toString(postal));
						if (resultPostal == true) {
							// Gender Validation
							String Gender = cmbGender.getSelectedItem().toString();
							boolean resultGender = val.Gender(Gender);
							if (resultGender == true) {
								// Phone Number Validation
								String phoneNumber = txtPhoneNumber.getText();
								boolean resultPhone = val.Phone(phoneNumber);
								if (resultPhone == true) {
									// Credit Card Validation
									String creditCard = txtCreditCard.getText();
									boolean resultCredit = val.CreditCard(creditCard);
									if (resultCredit == true) {
										// CVC Number Validation
										String cvcNumber = txtCvcNumber.getText();
										boolean resultCvc = val.CvcNumber(cvcNumber);
										if (resultCvc == true) {
											// Email Validation Check
											String email = txtEmail.getText();
											boolean resultEmail = val.Email(email);
											if (resultEmail == true) {
												// Username validation check
												String userName = txtUsername.getText();
												boolean resultUser = val.UserName(userName);
												if (resultUser == true) {
													// Password Validation Check
													String password = txtPassword.getText();
													boolean resultPass = val.Password(password);
													if (resultPass == true) {
														String conPassword = txtConfirmPassword.getText();
														if (conPassword.equals(password)) {
															reg.setfName(txtFname.getText());
															reg.setlName(txtLname.getText());
															reg.setAddress(txtAddress.getText());
															reg.setPostalCode(
																	Integer.parseInt(txtPostalCode.getText()));
															reg.setGender(cmbGender.getSelectedItem().toString());
															reg.setPhoneNumber(txtPhoneNumber.getText());
															reg.setCreditCard(txtCreditCard.getText());
															reg.setCvcNumber(txtCvcNumber.getText());
															reg.setEmail(txtEmail.getText());
															reg.setUserName(txtUsername.getText());
															reg.setPassword(txtPassword.getText());
															reg.setConfirmPassword(txtConfirmPassword.getText());
															JDBCRegistration jdbcReg = new JDBCRegistration();
															boolean result = jdbcReg.insert(reg);
															if (result == true) {
																JOptionPane.showMessageDialog(null,
																		"Welcome " + reg.getfName() + " "
																				+ reg.getlName() + " to HotelLuton.");
																txtFname.setText("");
																txtLname.setText("");
																txtAddress.setText("");
																txtPostalCode.setText("");
																cmbGender.setSelectedIndex(0);
																txtPhoneNumber.setText("");
																txtCreditCard.setText("");
																txtCvcNumber.setText("");
																txtEmail.setText("");
																txtUsername.setText("");
																txtPassword.setText("");
																txtConfirmPassword.setText("");
																this.dispose();
																new MainWindow();
															} else {

															}

														} else {
															JOptionPane.showMessageDialog(null,
																	"Password and confirm password does not match");
														}
													} else {
														JOptionPane.showMessageDialog(null, "Invalid Password format");
													}
													// End of password validation
												} else {
													JOptionPane.showMessageDialog(null, "Invalid Username format");
												}
												// End of username validation
											} else {
												JOptionPane.showMessageDialog(null, "Invalid Email");
											}
											// End of email validation
										} else {
											JOptionPane.showMessageDialog(null, "Invalid CVC Number");
										}
										// End of CVC Number Validation check
									} else {
										JOptionPane.showMessageDialog(null, "Invalid Credit Card Information");
									}
									// End of credit card validation
								} else {
									JOptionPane.showMessageDialog(null, "Invalid Phone Number");
								}
								// End of Phone number Validation
							} else {
								JOptionPane.showMessageDialog(null, "Please select a gender");
							}
							// End of Gender validation
						} else {
							JOptionPane.showMessageDialog(null, "Invalid Postal Code");
						}
						// Postal Code / Zip Code Validation
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Last Name");
					}
					// End of Last Name Validation
				} else {
					JOptionPane.showMessageDialog(null, "Invalid First Name");
				}
				// End of First Name Validation

			}

		}

	}

	public static void main(String[] args) {
		new Registration(); // Memory Allocation
	}
	
}
