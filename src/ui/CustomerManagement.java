package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CustomerManagement extends JFrame{
	
	JPanel pnlHead,pnlMain;
	JLabel lblHead;
	
	public CustomerManagement() {
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(null);
		
		// Heading Decoration
		pnlHead = new JPanel();
		pnlHead.setBounds(0, 0, 1550, 100);
		pnlHead.setBackground(new Color(0,255,211));
		pnlHead.setLayout(null);
		
		// End Heading Decoration
		
		// Heading Text
		lblHead = new JLabel("Customer Management Window");
		lblHead.setBounds(0, 0, 1550, 100);
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHead.setFont(new Font("Times New Roman",Font.BOLD,30));
		pnlHead.add(lblHead);
		// End of heading text
		
		// Main Panel for body part
		pnlMain = new JPanel();
		pnlMain.setBounds(0, 100, 1550, 740);
		pnlMain.setBackground(new Color(255,251,0));
		// End of Main panel
		
		
		add(pnlHead);
		add(pnlMain);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new CustomerManagement();
	}

}
