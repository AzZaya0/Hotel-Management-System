package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
import javax.swing.table.TableModel;

import ReceptionistLibs.ReceptionistJDBC;
import ReceptionistLibs.ReceptionistLibs;
import RegistrationLibs.Database;
import mylibs.Global;
import mylibs.JDBCRoom;
import mylibs.Room;

//Main Class
public class RoomManagement extends JFrame implements ActionListener, ItemListener {

	// Declaration
	JPanel pnlHead, pnlMain, pnlBody, pnlObjects, pnlBtn, pnlBodyTable; // JPanel
	JLabel lblHead, lblRoomId, lblRoomType, lblRoomPrice, lblRoomStatus; // JLabel
	JTextField txtId, txtPrice; // JTextArea
	JComboBox cmbType, cmbStatus; // JComboBox
	JButton btnAdd, btnSearch, btnUpdate, btnDelete, btnClear, btnClose;
	
	// declaration for display Table
		DefaultTableModel dtm = new DefaultTableModel();
		JTable table = new JTable(dtm);
		Object[] obj;
		ArrayList<Room> roomGet;
		// declaration for display Table end

	// Extended class
	public RoomManagement() {
		setTitle("Room Management"); // Title
		setBounds(200, 120, 1000, 500); // Axis and size of the window x-axis,y-axis,width,height
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Default Close operation
		setLayout(null); // Frame Layout

		// Panel Head
		pnlHead = new JPanel(); // Initialize and memory allocation
		pnlHead.setBounds(0, 0, 1000, 50); // Axis and size of the window x-axis,y-axis,width,height
		pnlHead.setBackground(new Color(0, 0, 0)); // Set background color of a header
		pnlHead.setOpaque(true); // Set opaque of a background

		lblHead = new JLabel(); // Initialize and memory allocation
		lblHead.setText("Room Information"); // Set Title of a Label
		lblHead.setFont(new Font("Sanserif", Font.BOLD, 30)); // Change the font style type and size
		lblHead.setForeground(new Color(255, 255, 255)); // Set the color of text
		pnlHead.add(lblHead, CENTER_ALIGNMENT); // Adding label head to the panel head

		// Panel Main
		pnlMain = new JPanel();
		pnlMain.setBounds(0, 50, 1000, 450);
		pnlMain.setBackground(Color.RED);
		pnlMain.setLayout(new GridLayout(1, 2));

		pnlBody = new JPanel(); // Initialize and memory allocation
		pnlBody.setSize(500, 450);
		pnlBody.setBackground(new Color(0, 204, 255));
		pnlBody.setLayout(null);
		pnlMain.add(pnlBody);

		pnlBodyTable = new JPanel(); // Initialize and memory allocation
		pnlBodyTable.setSize(500, 450);
		pnlMain.add(pnlBodyTable);

		pnlObjects = new JPanel(); // Initialize and memory allocation
		pnlObjects.setBounds(100, 20, 300, 270); // Axis and size of the window x-axis,y-axis,width,height
		pnlObjects.setBackground(new Color(0, 50, 50)); // Set the background color of the panel
		pnlObjects.setLayout(null); // Set the layout of panel to null
		pnlBody.add(pnlObjects); // adding object panel to the panel body

		pnlBtn = new JPanel(); // Initialize and memory allocation
		pnlBtn.setBounds(100, 300, 300, 100); // Axis and size of the window x-axis,y-axis,width,height
		pnlBtn.setBackground(new Color(255, 255, 255, 80)); // Set the background color of the panel
		pnlBtn.setLayout(null); // Set the layout of panel to null
		pnlBody.add(pnlBtn); // adding object panel to the panel body

		// ID
		lblRoomId = new JLabel(); // Initialize and memory allocation
		lblRoomId.setText("Id : "); // Set Text
		lblRoomId.setBounds(20, 30, 200, 30); // Set axis and size of the window x-axis,y-axis,width,height
		lblRoomId.setForeground(new Color(255, 255, 255)); // Font Color Change
		lblRoomId.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Change the font name, type, size
		pnlObjects.add(lblRoomId); // Adding room id to the panel objects

		txtId = new JTextField(); // Initialize and memory allocation
		txtId.setBounds(120, 30, 150, 30); // Set axis and size of the window x-axis,y-axis,width,height
		txtId.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Change the font name , type , size
		pnlObjects.add(txtId); // Addimg Id to objects panel

		// Room Type
		lblRoomType = new JLabel(); // Initialize and memory allocation
		lblRoomType.setText("Room Type : "); // Set Text
		lblRoomType.setBounds(20, 80, 200, 30); // Set axis and size of the window x-axis,y-axis,width,height
		lblRoomType.setForeground(new Color(255, 255, 255)); // Change the color of font
		lblRoomType.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Change font name, type, size
		pnlObjects.add(lblRoomType); // Adding types to the onjects

		cmbType = new JComboBox(); // Initialize and memory allocation
		for (int i = 0; i < Global.ROOM_TYPES.length; i++) { // For loop to display all the array items
			cmbType.addItem(Global.ROOM_TYPES[i]);
		}
		cmbType.setBounds(120, 80, 150, 30); // Set axis and size of the window x-axis,y-axis,width,height
		cmbType.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Change the font name, type and size
		cmbType.addItemListener(this); // Adding Actionlistener to the button
		pnlObjects.add(cmbType); // Adding type to the objects panel

		// Room Price
		lblRoomPrice = new JLabel(); // Initialize and memory allocation
		lblRoomPrice.setText("Room Price : "); // Set text
		lblRoomPrice.setBounds(20, 140, 200, 30); // Set axis and size of the window x-axis,y-axis,width,height
		lblRoomPrice.setForeground(new Color(255, 255, 255)); // Set the font color
		lblRoomPrice.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Set the font name, type and size
		pnlObjects.add(lblRoomPrice); // Adding room price to the object panel

		txtPrice = new JTextField(); // Initialize and memory allocation
		txtPrice.setBounds(120, 140, 150, 30); // Set
		txtPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPrice.setEditable(false);
		pnlObjects.add(txtPrice);

		// Room Status
		lblRoomStatus = new JLabel(); // Initialize and memory allocation
		lblRoomStatus.setText("Room Status : ");
		lblRoomStatus.setBounds(20, 200, 200, 30);
		lblRoomStatus.setForeground(new Color(255, 255, 255));
		lblRoomStatus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pnlObjects.add(lblRoomStatus);

		cmbStatus = new JComboBox(); // Initialize and memory allocation
		for (int i = 0; i < Global.ROOM_STATUS.length; i++) {
			cmbStatus.addItem(Global.ROOM_STATUS[i]);
		}
		cmbStatus.setBounds(120, 200, 150, 30);
		cmbStatus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pnlObjects.add(cmbStatus);

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
		

		// End Table

		add(pnlHead); // Adding panel head to Frame
		add(pnlMain);
		
		table.setPreferredScrollableViewportSize(new Dimension(450,350));
		table.setFillsViewportHeight(true);
		displayTable();
		pnlBodyTable.add(new JScrollPane(table));
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				txtId.setText(model.getValueAt(i, 0).toString());
				
				String type = model.getValueAt(i, 1).toString();
				if(type.equals("Single")) {
					cmbType.setSelectedIndex(0);
				}else if(type.equals("Double")) {
					cmbType.setSelectedIndex(1);
				}else if(type.equals("Twin")) {
					cmbType.setSelectedIndex(2);
				}
				
				txtPrice.setText(model.getValueAt(i, 2).toString());
				
				String status = model.getValueAt(i, 3).toString();
				if(status.equals("Available")) {
					cmbStatus.setSelectedIndex(0);
				}else if(status.equals("Booked")) {
					cmbStatus.setSelectedIndex(1);
				}else if(status.equals("Occupied")) {
					cmbStatus.setSelectedIndex(2);
				}
				
			}
		});

		setVisible(true); // Frame visibility
		
	}
	
	// Method display Table set
	public void displayTable() {
		obj = new Object[4];
		obj[0] = "Room Number";
		obj[1] = "Type";
		obj[2] = "Price";
		obj[3] = "Status";
		dtm.setColumnIdentifiers(obj);
		refreshTable(); // Calling refresh Table to show the database data into the table
	}
	// Method display Table set

	// Method which retrieve data from database
	public void refreshTable() {
		roomGet = new JDBCRoom().searchAll();
		dtm.setRowCount(0);
		for (Room room : roomGet) {
			Object tmpRow[] = {room.getId(),room.getType(),room.getRate(),room.getStatus()};
			dtm.addRow(tmpRow);
		}
	}
	// Method which retrieve data from database
	
	

	// Action Perform
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnClose) {
			this.dispose();
		} else if (ae.getSource() == btnClear) {
			txtId.setText(null);
			cmbType.setSelectedIndex(0);
			txtPrice.setText(null);
			cmbStatus.setSelectedIndex(0);
		} else if (ae.getSource() == btnAdd) {
			// save record
			Room room = new Room();
			room.setId(Integer.parseInt(txtId.getText()));
			room.setType(cmbType.getSelectedItem().toString());
			room.setRate(Double.parseDouble(txtPrice.getText()));
			room.setStatus(cmbStatus.getSelectedItem().toString());

			JDBCRoom jdbc = new JDBCRoom();
			boolean result = jdbc.insert(room);
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Room Added Successfully !!");
				refreshTable();
				txtId.setText(null);
				cmbType.setSelectedIndex(0);
				txtPrice.setText(null);
				cmbStatus.setSelectedIndex(0);
			} else {
				JOptionPane.showMessageDialog(null, "Failed to Add Room !!");
			}

		} else if (ae.getSource() == btnSearch) {
			// Search record
			boolean result = false;
			Room room = new Room();
			int rid = Integer.parseInt(txtId.getText());

			JDBCRoom jdbc = new JDBCRoom();
			room = jdbc.search(rid);

			if (room.getId() > 0) {
				// display room info
				String type = room.getType();
				if (type.equals("Single")) {
					cmbType.setSelectedIndex(0);
				} else if (type.equals("Double")) {
					cmbType.setSelectedIndex(1);
				} else if (type.equals("Deluxe")) {
					cmbType.setSelectedIndex(2);
				}

				double rate = room.getRate();
				txtPrice.setText(Double.toString(rate));

				String status = room.getStatus();
				// CW
				if (status.equals("Available")) {
					cmbStatus.setSelectedIndex(0);
				} else {
					cmbStatus.setSelectedIndex(1);
				}
				result = true;
			}

			if (result == true) {
				JOptionPane.showMessageDialog(null, "Room Found");
			} else {
				JOptionPane.showMessageDialog(null, "Room Not Found");
				cmbType.setSelectedIndex(0);
				txtPrice.setText(null);
				cmbStatus.setSelectedIndex(0);
			}
		} else if (ae.getSource() == btnUpdate) {
			// Edit
			// get room info
			Room room = new Room();
			room.setId(Integer.parseInt(txtId.getText()));
			room.setType(cmbType.getSelectedItem().toString());
			room.setRate(Double.parseDouble(txtPrice.getText()));
			room.setStatus(cmbStatus.getSelectedItem().toString());

			// send to middle-ware to edit
			JDBCRoom jdbc = new JDBCRoom();
			boolean result = jdbc.update(room); // send to middle_ware
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Room Updated Successfully !!");
				refreshTable();
				txtId.setText(null);
				cmbType.setSelectedIndex(0);
				txtPrice.setText(null);
				cmbStatus.setSelectedIndex(0);
			} else {
				JOptionPane.showMessageDialog(null, "Failed to update room !!");
			}
		} else if (ae.getSource() == btnDelete) {
			// calling middle ware to delete room
			Room room = new Room();
			int rid = Integer.parseInt(txtId.getText());

			JDBCRoom jdbc = new JDBCRoom();
			boolean result = jdbc.delete(rid); // send to middle_ware
			if (result == true) {
				JOptionPane.showMessageDialog(null, "Room Deleted Successfully !!");
				refreshTable();
				txtId.setText(null);
				cmbType.setSelectedIndex(0);
				txtPrice.setText(null);
				cmbStatus.setSelectedIndex(0);
			} else {
				JOptionPane.showMessageDialog(null, "Failed to delete room !!");
			}

			txtId.setText(null);
			cmbType.setSelectedIndex(0);
			txtPrice.setText(null);
			cmbStatus.setSelectedIndex(0);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbType) {
			int index = cmbType.getSelectedIndex();
			txtPrice.setText(Double.toString(Global.ROOM_RATE[index]));
		}

	}
	

	// Main Function
	public static void main(String[] args) {
		new RoomManagement(); // Memory Allocation
	}

}
