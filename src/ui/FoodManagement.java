package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import RegistrationLibs.Database;
import foodManagement.JDBCFood;
import foodManagement.Food;

//Main Class
public class FoodManagement extends JFrame implements ActionListener {

	// Declaration
	JPanel pnlHead, pnlBody, pnlTable, pnlObjects, pnlBtn; // JPanel
	JLabel lblHead, lblFoodId, lblFoodName, lblFoodPrice; // JLabel
	JTextField txtId, txtPrice, txtType; // JTextArea
	JButton btnAdd, btnSearch, btnUpdate, btnDelete, btnClear, btnClose;

	// Extended class
	public FoodManagement() {
		setTitle("Food Management"); // Title
		setBounds(500, 150, 1000, 600); // Axis and size of the window x-axis,y-axis,width,height
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Default Close operation
		setLayout(null); // Frame Layout

		// Panel Head
		pnlHead = new JPanel(); // Initialize and memory allocation
		pnlHead.setBounds(0, 0, 1000, 50); // Axis and size of the window x-axis,y-axis,width,height
		pnlHead.setBackground(new Color(0, 0, 0)); // Set background color of a header
		pnlHead.setOpaque(true); // Set opaque of a background

		lblHead = new JLabel(); // Initialize and memory allocation
		lblHead.setText("Food Information"); // Set Title of a Label
		lblHead.setFont(new Font("Sanserif", Font.BOLD, 30)); // Change the font style type and size
		lblHead.setForeground(new Color(255, 255, 255)); // Set the color of text
		pnlHead.add(lblHead, CENTER_ALIGNMENT); // Adding label head to the panel head

		pnlBody = new JPanel(); // Initialize and memory allocation
		pnlBody.setBounds(0, 50, 500, 550); // Axis and size of the window x-axis,y-axis,width,height
		pnlBody.setBackground(new Color(0, 204, 255)); // Set the background color of the panel
		pnlBody.setOpaque(true); // Set opaque of a background
		pnlBody.setLayout(null);

		pnlTable = new JPanel(); // Initialize and memory allocation
		pnlTable.setBounds(500, 50, 500, 550); // Axis and size of the window x-axis,y-axis,width,height
		pnlTable.setBackground(new Color(100, 204, 255)); // Set the background color of the panel
		pnlTable.setOpaque(true); // Set opaque of a background
		pnlTable.setLayout(null);

		pnlObjects = new JPanel(); // Initialize and memory allocation
		pnlObjects.setBounds(100, 75, 300, 270); // Axis and size of the window x-axis,y-axis,width,height
		pnlObjects.setBackground(new Color(0, 50, 50)); // Set the background color of the panel
		pnlObjects.setLayout(null); // Set the layout of panel to null
		pnlBody.add(pnlObjects); // adding object panel to the panel body

		pnlBtn = new JPanel(); // Initialize and memory allocation
		pnlBtn.setBounds(100, 350, 300, 100); // Axis and size of the window x-axis,y-axis,width,height
		pnlBtn.setBackground(new Color(255, 255, 255, 80)); // Set the background color of the panel
		pnlBtn.setLayout(null); // Set the layout of panel to null
		pnlBody.add(pnlBtn); // adding object panel to the panel body

		// ID
		lblFoodId = new JLabel(); // Initialize and memory allocation
		lblFoodId.setText("Food_Id : "); // Set Text
		lblFoodId.setBounds(20, 30, 200, 30); // Set axis and size of the window x-axis,y-axis,width,height
		lblFoodId.setForeground(new Color(255, 255, 255)); // Font Color Change
		lblFoodId.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Change the font name, type, size
		pnlObjects.add(lblFoodId); // Adding Food id to the panel objects

		txtId = new JTextField(); // Initialize and memory allocation
		txtId.setBounds(120, 30, 150, 30); // Set axis and size of the window x-axis,y-axis,width,height
		txtId.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Change the font name , type , size
		pnlObjects.add(txtId); // Addimg Id to objects panel

		// Food Type
		lblFoodName = new JLabel(); // Initialize and memory allocation
		lblFoodName.setText("Food Name : "); // Set Text
		lblFoodName.setBounds(20, 80, 200, 30); // Set axis and size of the window x-axis,y-axis,width,height
		lblFoodName.setForeground(new Color(255, 255, 255)); // Change the color of font
		lblFoodName.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Change font name, type, size
		pnlObjects.add(lblFoodName); // Adding types to the onjects

		txtType = new JTextField(); // Initialize and memory allocation
		txtType.setBounds(120, 80, 150, 30); // Set axis and size of the window x-axis,y-axis,width,height
		txtType.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Change the font name, type and size
		pnlObjects.add(txtType); // Adding type to the objects panel

		// Food Price
		lblFoodPrice = new JLabel(); // Initialize and memory allocation
		lblFoodPrice.setText("Food Price : "); // Set text
		lblFoodPrice.setBounds(20, 140, 200, 30); // Set axis and size of the window x-axis,y-axis,width,height
		lblFoodPrice.setForeground(new Color(255, 255, 255)); // Set the font color
		lblFoodPrice.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Set the font name, type and size
		pnlObjects.add(lblFoodPrice); // Adding Food price to the object panel

		txtPrice = new JTextField(); // Initialize and memory allocation
		txtPrice.setBounds(120, 140, 150, 30); // Set
		txtPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlObjects.add(txtPrice);

		// Button
		btnAdd = new JButton("Add"); // Initialize and memory allocation
		btnAdd.setBounds(10, 10, 80, 30);
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(this);
		pnlBtn.add(btnAdd);

		btnSearch = new JButton("Search"); // Initialize and memory allocation
		btnSearch.setBounds(110, 10, 80, 30);
		btnSearch.setFocusable(false);
		btnSearch.addActionListener(this);
		pnlBtn.add(btnSearch);

		btnUpdate = new JButton("Update"); // Initialize and memory allocation
		btnUpdate.setBounds(210, 10, 80, 30);
		btnUpdate.setFocusable(false);
		btnUpdate.addActionListener(this);
		pnlBtn.add(btnUpdate);

		btnDelete = new JButton("Delete"); // Initialize and memory allocation
		btnDelete.setBounds(10, 60, 80, 30);
		btnDelete.setFocusable(false);
		btnDelete.addActionListener(this);
		pnlBtn.add(btnDelete);

		btnClear = new JButton("Clear"); // Initialize and memory allocation
		btnClear.setBounds(110, 60, 80, 30);
		btnClear.setFocusable(false);
		btnClear.addActionListener(this);
		pnlBtn.add(btnClear);

		btnClose = new JButton("Close"); // Initialize and memory allocation
		btnClose.setBounds(210, 60, 80, 30);
		btnClose.setFocusable(false);
		btnClose.addActionListener(this);
		pnlBtn.add(btnClose);

		// Table
		DefaultTableModel dtm = new DefaultTableModel();
		JTable table = new JTable(dtm);
		table.setPreferredScrollableViewportSize(new Dimension(450, 350));
		table.setFillsViewportHeight(true);
		pnlTable.add(new JScrollPane(table));
		dtm.addColumn("Id");
		dtm.addColumn("Name");
		dtm.addColumn("Price");

//		try {
//			Database db = new Database();
//			Connection conn;
//			conn = db.connect();
//			String sql = "SELECT * FROM room";
//			PreparedStatement pstat = conn.prepareStatement(sql);
//			ResultSet rs = pstat.executeQuery();
//
//			while (rs.next()) {
//				String id, type, rate, status;
//				id = rs.getString("id");
//				type = rs.getString("type");
//				rate = rs.getString("rate");
//				status = rs.getString("status");
//				dtm.addRow(new Object[] { id, type, rate, status });
//			}
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
//		}
		// End of Table

		add(pnlHead); // Adding panel head to Frame
		add(pnlBody); // Adding panel body to Frame
		add(pnlTable);
		setVisible(true); // Frame visibility
	}

	public void showTable() {

	}

	// Action Perform
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnClose) {
			System.exit(0);
		} else if (ae.getSource() == btnClear) {
			txtId.setText(null);
			txtType.setText(null);
			txtPrice.setText(null);
		} else if (ae.getSource() == btnAdd) {
			// save record
			Food food = new Food();
			food.setId(Integer.parseInt(txtId.getText()));
			food.setname(txtType.getText());
			food.setRate(Double.parseDouble(txtPrice.getText()));

			JDBCFood jdbc = new JDBCFood();
			boolean result = jdbc.insert(food);
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Food Added Successfully !!");
			} else {
				JOptionPane.showMessageDialog(null, "Failed to Add Food !!");
			}

		} else if (ae.getSource() == btnSearch) {
			// Search record
			boolean result = false;
			Food food = new Food();
			int fid = Integer.parseInt(txtId.getText());

			JDBCFood jdbc = new JDBCFood();
			food = jdbc.search(fid);

			if (food.getId() > 0) {
				// display Food info
				txtType.setText(food.getname());
				txtPrice.setText(Double.toString(food.getRate()));

				result = true;
			}

			if (result == true) {
				JOptionPane.showMessageDialog(null, "Food Found");
			} else {
				JOptionPane.showMessageDialog(null, "Food Not Found");
				txtType.setText(null);
				txtPrice.setText(null);
			}
		} else if (ae.getSource() == btnUpdate) {
			// Edit
			// get Food info
			Food food = new Food();
			food.setId(Integer.parseInt(txtId.getText()));
			food.setname(txtType.getText());
			food.setRate(Double.parseDouble(txtPrice.getText()));

			// send to middle-ware to edit
			JDBCFood jdbc = new JDBCFood();
			boolean result = jdbc.update(food); // send to middle_ware
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Food Updated Successfully !!");
			} else {
				JOptionPane.showMessageDialog(null, "Failed to update Food !!");
			}
		} else if (ae.getSource() == btnDelete) {
			// calling middle ware to delete Food
			int rid = Integer.parseInt(txtId.getText());

			JDBCFood jdbc = new JDBCFood();
			boolean result = jdbc.delete(rid); // send to middle_ware
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Food Deleted Successfully !!");
			} else {
				JOptionPane.showMessageDialog(null, "Failed to delete Food !!");
			}

			txtId.setText(null);
			txtType.setText(null);
			txtPrice.setText(null);
		}

	}

	// Main Function
	public static void main(String[] args) {
		new FoodManagement(); // Memory Allocation

	}

}
