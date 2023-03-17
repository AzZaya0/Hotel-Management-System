package mylibs;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OrderFood extends JFrame implements ItemListener {

	 

	 JTextField txtEnterUsername;
	double totalFood,foodSSP=0,foodNDLS=0,foodPZ=0,foodPZ1=0,foodHB=0,foodTTK=0,foodCKN=0,foodSW=0,foodCK=0,
             foodDN=0,foodWF=0,foodCPK=0,foodWINE=0,foodHJCE=0,foodCFE=0;
	
	
	int QtySSP=0,QtyNDLS=0,QtyPZ=0,QtyPZ1=0,QtyHB=0,QtyTTK=0,QtyCKN=0,
			QtySW=0,QtyCK=0,QtyDN=0,QtyWF=0,QtyCPK=0,QtyWINE=0,QtyJCE=0,QtyCFE=0;
	
	
	String totalOrder;
	String strSSP="",strNDLS="",strPZ="",strPZ1="",strHB="",strTTK="",strCKN="",strSW="",strCK="",strDN="",strWF="",
	strCPK="",strWINE="",strJCE="",strCFE="";
	
	
	int PreQtySSP = 1,PreQtyNDLS = 1,PreQtyPZ = 1,PreQtyPZ1 = 1,PreQtyHB = 1,PreQtyTTK = 1,PreQtyCKN = 1,
			PreQtySW = 1,PreQtyCK = 1,PreQtyDN = 1,PreQtyWF = 1,PreQtyCPK = 1,PreQtyWINE = 1,PreQtyJCE = 1,PreQtyCFE = 1;
	

	

	public OrderFood() {

		
		setTitle("Order food as much as you like");
		setBounds(0, 0, 1500, 950);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color (151, 186, 224));
		getContentPane().setLayout(null);
		
		JLabel lbl= new JLabel("WELCOME HOTEL LUTON");
		  lbl.setBounds(300,10,600,50);
		  lbl.setFont(new Font ("Arial",Font.PLAIN,40));
		  getContentPane().add(lbl);
		
		
		
		
		JLabel lbltotalFood = new JLabel(" ");
		lbltotalFood.setBounds(1120, 450, 81, 37);
		getContentPane().add(lbltotalFood);
		
		
		
		JLabel lblOrder = new JLabel("");
		lblOrder.setBounds(6, 630, 1258, 45);
		getContentPane().add(lblOrder);
		
		
		
		
			
		//Food: Sweet Sour Pork 
				JLabel lblSweetSourPork = new JLabel("");
				int widthSSP=68,heightSSP=51;
				ImageIcon imageSSP = new ImageIcon("src/food/SweetSourPork.jpg");
		        imageSSP.setImage(imageSSP.getImage().getScaledInstance(widthSSP,heightSSP,Image.SCALE_DEFAULT));
		        lblSweetSourPork.setIcon(imageSSP);
		        lblSweetSourPork.setSize(widthSSP,heightSSP);
		        lblSweetSourPork.setBounds(46, 83, 81, 65);
		        getContentPane().add(lblSweetSourPork);
				
		        JSpinner spinnerSSP = new JSpinner();
				spinnerSSP.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerSSP.setEnabled(false);
				spinnerSSP.setBounds(78, 184, 56, 23);
				getContentPane().add(spinnerSSP);
			
				
				JCheckBox chckbxSSP = new JCheckBox(" ");
				chckbxSSP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxSSP.isSelected()){
							spinnerSSP.setEnabled(true);
							foodSSP=foodSSP+10;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSSP="Sweet Sour Pork" + "("+String.valueOf(PreQtySSP)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							
							spinnerSSP.setEnabled(false);
							spinnerSSP.setValue(1);
							foodSSP=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSSP=" ";
							PreQtySSP = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
							
						}
					}
				});
				chckbxSSP.setBounds(6, 110, 25, 23);
				getContentPane().add(chckbxSSP);
				
			
				spinnerSSP.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSSP=10;
						 
						 if(chckbxSSP.isSelected()){
							 PreQtySSP=(Integer)spinnerSSP.getValue();
						 if(PreQtySSP>QtySSP){
							 QtySSP = PreQtySSP;
					         foodSSP = RateSSP * PreQtySSP;
					         strSSP="Sweet Sour Pork" + "("+String.valueOf(PreQtySSP)+")";
							 totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							 
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					         }else if(PreQtySSP<=QtySSP){
							 QtySSP = PreQtySSP;
					         foodSSP = RateSSP * PreQtySSP;
					         strSSP="Sweet Sour Pork" + "("+String.valueOf(PreQtySSP)+")";
							 totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							 
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lblOrder.setText(String.valueOf(totalOrder));
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				
				JLabel lblSSP = new JLabel("Sweet Sour Pork ($10)");
				lblSSP.setBounds(21, 160, 137, 12);
				getContentPane().add(lblSSP);
				
				JLabel lblQtySSP = new JLabel("Qty:");
				lblQtySSP.setBounds(44, 187, 31, 19);
				getContentPane().add(lblQtySSP);
				
				
				//FoodL: Noodles
				JLabel Noodles = new JLabel("");
				int widthMPTF=81,heightMPTF=65;
				ImageIcon imageMPTF = new ImageIcon("src/food/noodles.png");
		        imageMPTF.setImage(imageMPTF.getImage().getScaledInstance(widthMPTF,heightMPTF,Image.SCALE_DEFAULT));
		        Noodles.setIcon(imageMPTF);
		        Noodles.setSize(widthMPTF,heightMPTF);
		        Noodles.setBounds(263, 83, 81, 65);
				getContentPane().add(Noodles);
				
				JSpinner spinnerNoodle = new JSpinner();
				spinnerNoodle.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerNoodle.setEnabled(false);
				spinnerNoodle.setBounds(286, 184, 58, 23);
				getContentPane().add(spinnerNoodle);
				
				JCheckBox chckbxNoodle = new JCheckBox("");
				chckbxNoodle.addItemListener(this);
				chckbxNoodle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxNoodle.isSelected()){
							spinnerNoodle.setEnabled(true);
							foodNDLS=foodNDLS+8;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strNDLS="Noobles"+ "("+String.valueOf(PreQtyNDLS)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							lblOrder.setText(null);
							spinnerNoodle.setEnabled(false);
							spinnerNoodle.setValue(1);
							foodNDLS=0;
							PreQtyNDLS = 1;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strNDLS=" ";
							PreQtySSP = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));				}
					}
				});
				chckbxNoodle.setBounds(216, 110, 25, 23);
				getContentPane().add(chckbxNoodle);
				
				spinnerNoodle.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateMPTF=8;
						 if(chckbxNoodle.isSelected()){
							 PreQtyNDLS=(Integer)spinnerNoodle.getValue();
						 if(PreQtyNDLS>QtyNDLS){
							 QtyNDLS = PreQtyNDLS;
					         foodNDLS = RateMPTF * PreQtyNDLS;
								strNDLS="Noodles"+ "("+String.valueOf(PreQtyNDLS)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyNDLS<=QtyNDLS){
							 QtyNDLS = PreQtyNDLS;
					         foodNDLS = RateMPTF * PreQtyNDLS;
								strNDLS="Noodles"+ "("+String.valueOf(PreQtyNDLS)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblNoodle = new JLabel("Noodles ($8)");
				lblNoodle.setBounds(245, 160, 115, 14);
				getContentPane().add(lblNoodle);
				
				JLabel lblQtyNoodle = new JLabel("Qty:");
				lblQtyNoodle.setBounds(253, 187, 36, 19);
				getContentPane().add(lblQtyNoodle);
				
				
				//Food: Pizza
				JLabel lblPizza = new JLabel("");
				int widthSSM=81,heightSSM=65;
				ImageIcon imageSSM = new ImageIcon("src/food/pizza.png");
		        imageSSM.setImage(imageSSM.getImage().getScaledInstance(widthSSM,heightSSM,Image.SCALE_DEFAULT));
		        lblPizza.setIcon(imageSSM);
		        lblPizza.setSize(widthSSM,heightSSM);
				lblPizza.setBounds(493, 83, 81, 65);
				getContentPane().add(lblPizza);
				
				JSpinner spinnerPZ = new JSpinner();
				spinnerPZ.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerPZ.setEnabled(false);
				spinnerPZ.setBounds(514, 183, 56, 23);
				getContentPane().add(spinnerPZ);
				
				JCheckBox chckbxPZ = new JCheckBox("");
				chckbxPZ.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxPZ.isSelected()){
							spinnerPZ.setEnabled(true);
							foodPZ=foodPZ+12;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strPZ="Pizza"+ "("+String.valueOf(PreQtyPZ)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerPZ.setEnabled(false);
							spinnerPZ.setValue(1);
							foodPZ=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strPZ=" ";
							PreQtyPZ = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxPZ.setBounds(433, 110, 25, 23);
				getContentPane().add(chckbxPZ);
				
				spinnerPZ.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSSM=12;
						 if(chckbxPZ.isSelected()){
							 PreQtyPZ=(Integer)spinnerPZ.getValue();
						 if(PreQtyPZ>QtyPZ1){
							 QtyPZ1 = PreQtyPZ;
					         foodPZ = RateSSM * PreQtyPZ;
					         strPZ="Pizza"+ "("+String.valueOf(PreQtyPZ)+")";
					         totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							 lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyPZ<=QtyPZ1){
							 QtyPZ1 = PreQtyPZ;
					         foodPZ = RateSSM * PreQtyPZ;
					         strPZ="Pizza"+ "("+String.valueOf(PreQtyPZ)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblPZ = new JLabel("Pizza ($12)");
				lblPZ.setBounds(482, 160, 92, 12);
				getContentPane().add(lblPZ);
				JLabel lblQtyPZ = new JLabel("Qty:");
				lblQtyPZ.setBounds(483, 184, 31, 20);
				getContentPane().add(lblQtyPZ);
				
				
				//Food: Ramen
				JLabel lblRamen = new JLabel("");
				int widthSS=81,heightSS=65;
				ImageIcon imageSS = new ImageIcon("src/food/ramen.png");
		        imageSS.setImage(imageSS.getImage().getScaledInstance(widthSS,heightSS,Image.SCALE_DEFAULT));
		        lblRamen.setIcon(imageSS);
		        lblRamen.setSize(widthSS,heightSS);
				lblRamen.setBounds(699, 83, 81, 65);
				getContentPane().add(lblRamen);
				
				JSpinner spinnerPZ1 = new JSpinner();
				spinnerPZ1.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerPZ1.setEnabled(false);
				spinnerPZ1.setBounds(711, 184, 56, 23);
				getContentPane().add(spinnerPZ1);
				
				JCheckBox chckbxPZ1 = new JCheckBox("");
				chckbxPZ1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxPZ1.isSelected()){
							spinnerPZ1.setEnabled(true);
							foodPZ1=foodPZ1+7;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));	
							strPZ1="Ramen" + "("+String.valueOf(PreQtyPZ1)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerPZ1.setEnabled(false);
							spinnerPZ1.setValue(1);
							foodPZ1=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strPZ1=" ";
							PreQtyPZ1 = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxPZ1.setBounds(625, 110, 25, 23);
				getContentPane().add(chckbxPZ1);
				
				spinnerPZ1.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSS=7;
						 if(chckbxPZ1.isSelected()){
							 PreQtyPZ1=(Integer)spinnerPZ1.getValue();
						 if(PreQtyPZ1>QtyPZ1){
							 QtyPZ1 = PreQtyPZ1;
					         foodPZ1 = RateSS * PreQtyPZ1;
								strPZ1="Ramen" + "("+String.valueOf(PreQtyPZ1)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyPZ1<=QtyPZ1){
							 QtyPZ1 = PreQtyPZ1;
					         foodPZ1 = RateSS * PreQtyPZ1;
								strPZ1="Ramen" + "("+String.valueOf(PreQtyPZ1)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblPZ1 = new JLabel("Ramen ($7)");
				lblPZ1.setBounds(699, 158, 68, 14);
				getContentPane().add(lblPZ1);
				
				JLabel lblQtyPZ1 = new JLabel("Qty:");
				lblQtyPZ1.setBounds(680, 188, 61, 16);
				getContentPane().add(lblQtyPZ1);
				
				
				//Food:Hamburger
				JLabel lblHamburger = new JLabel("");
				int widthPD=81,heightPD=65;
				ImageIcon imagePD = new ImageIcon("src/food/hamburger.png");
		        imagePD.setImage(imagePD.getImage().getScaledInstance(widthPD,heightPD,Image.SCALE_DEFAULT));
		        lblHamburger.setIcon(imagePD);
		        lblHamburger.setSize(widthPD,heightPD);
				lblHamburger.setBounds(898, 83, 81, 65);
				getContentPane().add(lblHamburger);
				
				JSpinner spinnerHB = new JSpinner();
				spinnerHB.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerHB.setEnabled(false);
				spinnerHB.setBounds(910, 183, 56, 22);
				getContentPane().add(spinnerHB);
				
				JCheckBox chckbxHB = new JCheckBox(" ");
				chckbxHB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxHB.isSelected()){
							spinnerHB.setEnabled(true);
							foodHB=foodHB+12;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strHB="Hamburger" + "("+String.valueOf(PreQtyHB)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerHB.setEnabled(false);
							spinnerHB.setValue(1);
							foodHB=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strHB=" ";
							PreQtyHB = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxHB.setBounds(828, 110, 25, 23);
				getContentPane().add(chckbxHB);
				
				spinnerHB.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RatePD=12;
						 if(chckbxHB.isSelected()){
							 PreQtyHB=(Integer)spinnerHB.getValue();
						 if(PreQtyHB>QtyHB){
							 QtyHB = PreQtyHB;
					         foodHB = RatePD * PreQtyHB;
								strHB="Hamburger" + "("+String.valueOf(PreQtyHB)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyHB<=QtyHB){
							 QtyHB = PreQtyHB;
					         foodHB = RatePD * PreQtyHB;
								strHB="Hamburger" + "("+String.valueOf(PreQtyHB)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblHB = new JLabel("Hamburger ($12)");
				lblHB.setBounds(867, 157, 115, 18);
				getContentPane().add(lblHB);
				
				JLabel lblQtyHB = new JLabel("Qty:");
				lblQtyHB.setBounds(875, 185, 45, 19);
				getContentPane().add(lblQtyHB);
				
				
				//Food: Tteok
				JLabel lblTteok = new JLabel("");
				int widthBBB=81,heightBBB=65;
				ImageIcon imageBBB = new ImageIcon("src/food/tteok.png");
		        imageBBB.setImage(imageBBB.getImage().getScaledInstance(widthBBB,heightBBB,Image.SCALE_DEFAULT));
		        lblTteok.setIcon(imageBBB);
		        lblTteok.setSize(widthBBB,heightBBB);
				lblTteok.setBounds(46, 255, 81, 65);
				getContentPane().add(lblTteok);
				
				JSpinner spinnerTTK = new JSpinner();
				spinnerTTK.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerTTK.setEnabled(false);
				spinnerTTK.setBounds(78, 350, 56, 23);
				getContentPane().add(spinnerTTK);
				
				JCheckBox chckbxTTK = new JCheckBox("");
				chckbxTTK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxTTK.isSelected()){
							spinnerTTK.setEnabled(true);
							foodTTK=foodTTK+14;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strTTK="Tteok" + "("+String.valueOf(PreQtyTTK)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerTTK.setEnabled(false);
							spinnerTTK.setValue(1);
							foodTTK=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strTTK=" ";
							PreQtyTTK = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxTTK.setBounds(6, 284, 25, 23);
				getContentPane().add(chckbxTTK);
				
				spinnerTTK.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateBBB=14;
						 if(chckbxTTK.isSelected()){
							 PreQtyTTK=(Integer)spinnerTTK.getValue();
						 if(PreQtyTTK>QtyTTK){
							 QtyTTK = PreQtyTTK;
					         foodTTK = RateBBB * PreQtyTTK;
								strTTK="Tteok" + "("+String.valueOf(PreQtyTTK)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyTTK<=QtyTTK){
							 QtyTTK = PreQtyTTK;
					         foodTTK = RateBBB * PreQtyTTK;
								strTTK="Tteok" + "("+String.valueOf(PreQtyTTK)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblTTK = new JLabel("Tteok ($14)");
				lblTTK.setBounds(37, 328, 97, 19);
				getContentPane().add(lblTTK);
				
				JLabel lblQtyTTK = new JLabel("Qty:");
				lblQtyTTK.setBounds(44, 352, 38, 20);
				getContentPane().add(lblQtyTTK);
				
				
				//Food: Chicken
				JLabel lblChicken = new JLabel("");
				int widthNM=81,heightNM=65;
				ImageIcon imageNM = new ImageIcon("src/food/roasted-chicken.png");
		        imageNM.setImage(imageNM.getImage().getScaledInstance(widthNM,heightNM,Image.SCALE_DEFAULT));
		        lblChicken.setIcon(imageNM);
		        lblChicken.setSize(widthNM,heightNM);
				lblChicken.setBounds(263, 255, 81, 65);
				getContentPane().add(lblChicken);
				
				JSpinner spinnerCKN = new JSpinner();
				spinnerCKN.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerCKN.setEnabled(false);
				spinnerCKN.setBounds(286, 350, 57, 23);
				getContentPane().add(spinnerCKN);
				
				JCheckBox chckbxCKN = new JCheckBox("");
				chckbxCKN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxCKN.isSelected()){
							spinnerCKN.setEnabled(true);
							foodCKN=foodCKN+18;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCKN="Chicken" + "("+String.valueOf(PreQtyCKN)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else {
							spinnerCKN.setEnabled(false);
							spinnerCKN.setValue(1);
							foodCKN=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCKN=" ";
							PreQtyCKN = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxCKN.setBounds(216, 284, 25, 23);
				getContentPane().add(chckbxCKN);
				
				spinnerCKN.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateNM=18;
						 if(chckbxCKN.isSelected()){
							 PreQtyCKN=(Integer)spinnerCKN.getValue();
						 if(PreQtyCKN>QtyCKN){
							 QtyCKN = PreQtyCKN;
					         foodCKN = RateNM * PreQtyCKN;
								strCKN="Chicken" + "("+String.valueOf(PreQtyCKN)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyCKN<=QtyCKN){
							 QtyCKN = PreQtyCKN;
					         foodCKN = RateNM * PreQtyCKN;
								strCKN="Chicken" + "("+String.valueOf(PreQtyCKN)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblCKN = new JLabel("Chicken ($18)");
				lblCKN.setBounds(245, 324, 118, 23);
				getContentPane().add(lblCKN);
				
				JLabel lblQtyNM = new JLabel("Qty:");
				lblQtyNM.setBounds(255, 354, 36, 19);
				getContentPane().add(lblQtyNM);
				
				
				//Food: Sandwhich
				JLabel lblSandwhich = new JLabel("");
				int widthSF=81,heightSF=65;
				ImageIcon imageSF = new ImageIcon("src/food/sandwhich.png");
		        imageSF.setImage(imageSF.getImage().getScaledInstance(widthSF,heightSF,Image.SCALE_DEFAULT));
		        lblSandwhich.setIcon(imageSF);
		        lblSandwhich.setSize(widthSF,heightSF);
				lblSandwhich.setBounds(493, 255, 81, 65);
				getContentPane().add(lblSandwhich);
				
				JSpinner spinnerSW = new JSpinner();
				spinnerSW.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerSW.setEnabled(false);
				spinnerSW.setBounds(526, 349, 56, 23);
				getContentPane().add(spinnerSW);
				
				JCheckBox chckbxSW = new JCheckBox("");
				chckbxSW.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxSW.isSelected()){
							spinnerSW.setEnabled(true);
							foodSW=foodSW+11;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSW="Sandwhich" + "("+String.valueOf(PreQtySW)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerSW.setEnabled(false);
							spinnerSW.setValue(1);
							foodSW=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSW=" ";
							PreQtySW = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));;
						}
					}
				});
				chckbxSW.setBounds(442, 284, 25, 23);
				getContentPane().add(chckbxSW);
				
				spinnerSW.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSF=11;
						 if(chckbxSW.isSelected()){
							 PreQtySW=(Integer)spinnerSW.getValue();
						 if(PreQtySW>QtySW){
							 QtySW = PreQtySW;
					         foodSW = RateSF * PreQtySW;
								strSW="Sandwhich" + "("+String.valueOf(PreQtySW)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtySW<=QtySW){
							 QtySW = PreQtySW;
					         foodSW = RateSF * PreQtySW;
								strSW="Sandwhich" + "("+String.valueOf(PreQtySW)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblSW = new JLabel("Sandwhich ($11)");
				lblSW.setBounds(463, 324, 153, 23);
				getContentPane().add(lblSW);
				
				JLabel lblQtySW = new JLabel("Qty:");
				lblQtySW.setBounds(491, 353, 36, 19);
				getContentPane().add(lblQtySW);
				
				
				//Dessert :Cake
				JLabel lblCake = new JLabel("");
				int widthSBS=81,heightSBS=65;
				ImageIcon imageSBS = new ImageIcon("src/dessert/cake.png");
		        imageSBS.setImage(imageSBS.getImage().getScaledInstance(widthSBS,heightSBS,Image.SCALE_DEFAULT));
		        lblCake.setIcon(imageSBS);
		        lblCake.setSize(widthSBS,heightSBS);
				lblCake.setBounds(699, 255, 81, 65);
				getContentPane().add(lblCake);
				
				JSpinner spinnerCK = new JSpinner();
				spinnerCK.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerCK.setEnabled(false);
				spinnerCK.setBounds(711, 349, 56, 23);
				getContentPane().add(spinnerCK);
				
				JCheckBox chckbxCK = new JCheckBox("");
				chckbxCK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxCK.isSelected()){
							spinnerCK.setEnabled(true);
							foodCK=foodCK+15;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCK="Cake" + "("+String.valueOf(PreQtyCK)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerCK.setEnabled(false);
							spinnerCK.setValue(1);
							foodCK=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCK=" ";
							PreQtyCK = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxCK.setBounds(625, 284, 25, 23);
				getContentPane().add(chckbxCK);
				
				spinnerCK.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSBS=15;
						 if(chckbxCK.isSelected()){
							 PreQtyCK=(Integer)spinnerCK.getValue();
						 if(PreQtyCK>QtyCK){
							 QtyCK = PreQtyCK;
					         foodCK = RateSBS * PreQtyCK;
								strCK="Cake" + "("+String.valueOf(PreQtyCK)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyCK<=QtyCK){
							 QtyCK = PreQtyCK;
					         foodCK = RateSBS * PreQtyCK;
								strCK="Cake" + "("+String.valueOf(PreQtyCK)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblCK = new JLabel("Cake ($15)");
				lblCK.setBounds(668, 324, 153, 23);
				getContentPane().add(lblCK);
				
				JLabel lblQtyCK = new JLabel("Qty:");
				lblQtyCK.setBounds(680, 354, 61, 16);
				getContentPane().add(lblQtyCK);
				
				
				//Dessert: Donut
				JLabel lblDonut = new JLabel("");
				int widthHS=81,heightHS=65;
				ImageIcon imageHS = new ImageIcon("src/dessert/donut.png");
		        imageHS.setImage(imageHS.getImage().getScaledInstance(widthHS,heightHS,Image.SCALE_DEFAULT));
		        lblDonut.setIcon(imageHS);
		        lblDonut.setSize(widthHS,heightHS);
				lblDonut.setBounds(898, 255, 81, 65);
				getContentPane().add(lblDonut);
				
				JSpinner spinnerDN = new JSpinner();
				spinnerDN.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerDN.setEnabled(false);
				spinnerDN.setBounds(910, 349, 56, 24);
				getContentPane().add(spinnerDN);
				
				JCheckBox chckbxDN = new JCheckBox("");
				chckbxDN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxDN.isSelected()){
							spinnerDN.setEnabled(true);
							foodDN=foodDN+9;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strDN="Donut"+ "("+String.valueOf(PreQtyDN)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerDN.setEnabled(false);
							spinnerDN.setValue(1);
							foodDN=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strDN=" ";
							PreQtyDN = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxDN.setBounds(828, 284, 25, 23);
				getContentPane().add(chckbxDN);
				
				spinnerDN.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateHS=9;
						 if(chckbxDN.isSelected()){
							 PreQtyDN=(Integer)spinnerDN.getValue();
						 if(PreQtyDN>QtyDN){
							 QtyDN = PreQtyDN;
					         foodDN = RateHS * PreQtyDN;
								strDN="Donut"+ "("+String.valueOf(PreQtyDN)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyDN<=QtyDN){
							 QtyDN = PreQtyDN;
					         foodDN = RateHS * PreQtyDN;
								strDN="Donut"+ "("+String.valueOf(PreQtyDN)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblDN = new JLabel("Donut ($9)");
				lblDN.setBounds(867, 328, 128, 19);
				getContentPane().add(lblDN);
				
				JLabel lblQtyDN = new JLabel("Qty:");
				lblQtyDN.setBounds(877, 354, 61, 16);
				getContentPane().add(lblQtyDN);
				
				
				//Dessert: Waffle
				JLabel Waffle = new JLabel("");
				int widthBWB=81,heightBWB=65;
				ImageIcon imageBWB = new ImageIcon("src/dessert/waffle dsrt.png");
		        imageBWB.setImage(imageBWB.getImage().getScaledInstance(widthBWB,heightBWB,Image.SCALE_DEFAULT));
		        Waffle.setIcon(imageBWB);
		        Waffle.setSize(widthBWB,heightBWB);
				Waffle.setBounds(46, 423, 81, 65);
				getContentPane().add(Waffle);
				
				JSpinner spinnerWF = new JSpinner();
				spinnerWF.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerWF.setEnabled(false);
				spinnerWF.setBounds(71, 524, 56, 21);
				getContentPane().add(spinnerWF);
				
				JCheckBox chckbxWF = new JCheckBox("");
				chckbxWF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxWF.isSelected()){
							spinnerWF.setEnabled(true);
							foodWF=foodWF+13;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strWF="Waffle"+ "("+String.valueOf(PreQtyWF)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerWF.setEnabled(false);
							spinnerWF.setValue(1);
							foodWF=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strWF=" ";
							PreQtyWF = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxWF.setBounds(6, 452, 25, 23);
				getContentPane().add(chckbxWF);
				
				spinnerWF.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateBWB=13;
						 if(chckbxWF.isSelected()){
							 PreQtyWF=(Integer)spinnerWF.getValue();
						 if(PreQtyWF>QtyWF){
							 QtyWF = PreQtyWF;
					         foodWF = RateBWB * PreQtyWF;
								strWF="Waffle"+ "("+String.valueOf(PreQtyWF)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyWF<=QtyWF){
							 QtyWF = PreQtyWF;
					         foodWF = RateBWB * PreQtyWF;
								strWF="Waffle"+ "("+String.valueOf(PreQtyWF)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblWF = new JLabel("Waffle ($13)");
				lblWF.setBounds(16, 498, 153, 18);
				getContentPane().add(lblWF);
				
				JLabel lblQtyWF = new JLabel("Qty:");
				lblQtyWF.setBounds(37, 528, 61, 16);
				getContentPane().add(lblQtyWF);
				
				
				//Dessert: Cupcake
				JLabel lblCupcake = new JLabel("");
				int widthKPC=81,heightKPC=65;
				ImageIcon imageKPC = new ImageIcon("src/dessert/cupcake.png");
		        imageKPC.setImage(imageKPC.getImage().getScaledInstance(widthKPC,heightKPC,Image.SCALE_DEFAULT));
		        lblCupcake.setIcon(imageKPC);
		        lblCupcake.setSize(widthKPC,heightKPC);
				lblCupcake.setBounds(263, 423, 81, 65);
				getContentPane().add(lblCupcake);
				
				JSpinner spinnerCPC = new JSpinner();
				spinnerCPC.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerCPC.setEnabled(false);
				spinnerCPC.setBounds(286, 523, 56, 23);
				getContentPane().add(spinnerCPC);
				
				JCheckBox chckbxCPC = new JCheckBox("");
				chckbxCPC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxCPC.isSelected()){
							spinnerCPC.setEnabled(true);
							foodCPK=foodCPK+5;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCPK="Cupcake"+ "("+String.valueOf(PreQtyCPK)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerCPC.setEnabled(false);
							spinnerCPC.setValue(1);
							foodCPK=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCPK=" ";
							PreQtyCPK = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxCPC.setBounds(216, 452, 25, 23);
				getContentPane().add(chckbxCPC);
				
				spinnerCPC.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateKPC=5;
						 if(chckbxCPC.isSelected()){
							 PreQtyCPK=(Integer)spinnerCPC.getValue();
						 if(PreQtyCPK>QtyCPK){
							 QtyCPK = PreQtyCPK;
					         foodCPK = RateKPC * PreQtyCPK;
								strCPK="Cupcake"+ "("+String.valueOf(PreQtyCPK)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyCPK<=QtyCPK){
							 QtyCPK = PreQtyCPK;
					         foodCPK = RateKPC * PreQtyCPK;
								strCPK="Cupcake"+ "("+String.valueOf(PreQtyCPK)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblCPC = new JLabel("Cupcake ($5)");
				lblCPC.setBounds(237, 498, 153, 19);
				getContentPane().add(lblCPC);
				
				JLabel lblQtyCPC = new JLabel("Qty:");
				lblQtyCPC.setBounds(255, 527, 61, 16);
				getContentPane().add(lblQtyCPC);
				
				
				//Drinks: Wine
				JLabel lblWine = new JLabel("");
				int widthJR=81,heightJR=65;
				ImageIcon imageJR = new ImageIcon("src/drinks/wine.png");
		        imageJR.setImage(imageJR.getImage().getScaledInstance(widthJR,heightJR,Image.SCALE_DEFAULT));
		        lblWine.setIcon(imageJR);
		        lblWine.setSize(widthJR,heightJR);
				lblWine.setBounds(493, 423, 81, 65);
				getContentPane().add(lblWine);
				
				JSpinner spinnerW = new JSpinner();
				spinnerW.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerW.setEnabled(false);
				spinnerW.setBounds(526, 523, 56, 23);
				getContentPane().add(spinnerW);
				
				JCheckBox chckbxW = new JCheckBox("");
				chckbxW.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxW.isSelected()){
							spinnerW.setEnabled(true);
							foodWINE=foodWINE+25;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));	
							strWINE="Wine" + "("+String.valueOf(PreQtyWINE)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerW.setEnabled(false);
							spinnerW.setValue(1);
							foodWINE=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strWINE=" ";
							PreQtyWINE = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxW.setBounds(442, 452, 25, 23);
				getContentPane().add(chckbxW);
				
				spinnerW.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateJR=25;
						 if(chckbxW.isSelected()){
							 PreQtyWINE=(Integer)spinnerW.getValue();
						 if(PreQtyWINE>QtyWINE){
							 QtyWINE= PreQtyWINE;
					         foodWINE = RateJR * PreQtyWINE;
								strWINE="Wine" + "("+String.valueOf(PreQtyWINE)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyWINE<=QtyWINE){
							 QtyWINE = PreQtyWINE;
					         foodWINE = RateJR * PreQtyWINE;
								strWINE="Wine" + "("+String.valueOf(PreQtyWINE)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblWJR = new JLabel("Wine ($25)");
				lblWJR.setBounds(473, 498, 137, 18);
				getContentPane().add(lblWJR);
				
				JLabel lblQtyWJR = new JLabel("Qty:");
				lblQtyWJR.setBounds(493, 527, 61, 16);
				getContentPane().add(lblQtyWJR);
				
				
				//Drink: Juice
				JLabel lblJuice = new JLabel("");
				int widthHSMBS=81,heightHSMBS=65;
				ImageIcon imageHSMBS = new ImageIcon("src/drinks/Juice.png");
		        imageHSMBS.setImage(imageHSMBS.getImage().getScaledInstance(widthHSMBS,heightHSMBS,Image.SCALE_DEFAULT));
		        lblJuice.setIcon(imageHSMBS);
		        lblJuice.setSize(widthHSMBS,heightHSMBS);
				lblJuice.setBounds(699, 423, 81, 65);
				getContentPane().add(lblJuice);
				
				JSpinner spinnerJCE = new JSpinner();
				spinnerJCE.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerJCE.setEnabled(false);
				spinnerJCE.setBounds(711, 522, 56, 26);
				getContentPane().add(spinnerJCE);
				
				JCheckBox chckbxJCE = new JCheckBox("");
				chckbxJCE.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxJCE.isSelected()){
							spinnerJCE.setEnabled(true);
							foodHJCE=foodHJCE+8;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));	
							strJCE="Juice" + "("+String.valueOf(PreQtyJCE)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerJCE.setEnabled(false);
							spinnerJCE.setValue(1);
							foodHJCE=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strJCE=" ";
							PreQtyJCE = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxJCE.setBounds(625, 452, 25, 23);
				getContentPane().add(chckbxJCE);
				
				spinnerJCE.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateHSMBS=8;
						 if(chckbxJCE.isSelected()){
							 PreQtyJCE=(Integer)spinnerJCE.getValue();
						 if(PreQtyJCE>QtyJCE){
							 QtyJCE= PreQtyJCE;
					         foodHJCE = RateHSMBS * PreQtyJCE;
								strJCE="Juice" + "("+String.valueOf(PreQtyJCE)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyJCE<=QtyJCE){
							 QtyJCE = PreQtyJCE;
					         foodHJCE = RateHSMBS * PreQtyJCE;
								strJCE="Juice" + "("+String.valueOf(PreQtyJCE)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblJCE = new JLabel("Juice ($8)");
				lblJCE.setBounds(680, 497, 134, 19);
				getContentPane().add(lblJCE);
				
				JLabel lblQtyJCE = new JLabel("Qty:");
				lblQtyJCE.setBounds(680, 527, 61, 16);
				getContentPane().add(lblQtyJCE);
				
				
				//Drinks: Coffee
				JLabel lblCoffee = new JLabel("");
				int widthWN=81,heightWN=65;
				ImageIcon imageWN = new ImageIcon("src/drinks/cofee.png");
		        imageWN.setImage(imageWN.getImage().getScaledInstance(widthWN,heightWN,Image.SCALE_DEFAULT));
		        lblCoffee.setIcon(imageWN);
		        lblCoffee.setSize(widthWN,heightWN);
				lblCoffee.setBounds(898, 423, 81, 65);
				getContentPane().add(lblCoffee);
				
				JSpinner spinnerCFE = new JSpinner();
				spinnerCFE.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerCFE.setEnabled(false);
				spinnerCFE.setBounds(910, 522, 56, 23);
				getContentPane().add(spinnerCFE);
				
				JCheckBox chckbxCFE = new JCheckBox("");
				chckbxCFE.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxCFE.isSelected()){
							spinnerCFE.setEnabled(true);
							foodCFE=foodCFE+11;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCFE="Coffee" + "("+String.valueOf(PreQtyCFE)+")";
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerCFE.setEnabled(false);
							spinnerCFE.setValue(1);
							foodCFE=0;
							totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
							lbltotalFood.setText(String.valueOf(totalFood));
							strCFE=" ";
							PreQtyCFE = 1;
							totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxCFE.setBounds(828, 452, 25, 23);
				getContentPane().add(chckbxCFE);
				
				spinnerCFE.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateWN=11;
						 if(chckbxCFE.isSelected()){
							 PreQtyCFE=(Integer)spinnerCFE.getValue();
						 if(PreQtyCFE>QtyCFE){
							 QtyCFE= PreQtyCFE;
					         foodCFE = RateWN * PreQtyCFE;
								strCFE="Coffee" + "("+String.valueOf(PreQtyCFE)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					     }else if(PreQtyCFE<=QtyCFE){
							 QtyCFE = PreQtyCFE;
					         foodCFE = RateWN * PreQtyCFE;
								strCFE="Coffee" + "("+String.valueOf(PreQtyCFE)+")";
								totalOrder=strSSP+" "+strNDLS+" "+strPZ+" "+strPZ1+" "+strHB+" "+strTTK+" "+strCKN+" "+strSW+" "+strCK+" "+strDN+" "+strWF+" "+strCPK+" "+strWINE+" "+strJCE+" "+strCFE;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodNDLS+foodPZ+foodPZ1+foodHB+foodTTK+foodCKN+foodSW+foodCK+foodDN+foodWF+foodCPK+foodWINE+foodHJCE+foodCFE;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblWN = new JLabel("Coffee ($11)");
				lblWN.setBounds(860, 498, 134, 18);
				getContentPane().add(lblWN);
				
				JLabel lblQtyWN = new JLabel("Qty:");
				lblQtyWN.setBounds(877, 527, 61, 16);
				getContentPane().add(lblQtyWN);
				
				//to set logo
				
				JLabel lblLogo = new JLabel("");
				int widthLG=204,heightLG=125;
				ImageIcon imageLG = new ImageIcon("src/Pictures/AsianFlavors.png");
		        imageLG.setImage(imageLG.getImage().getScaledInstance(widthLG,heightLG,Image.SCALE_DEFAULT));
		        lblLogo.setIcon(imageLG);
		        lblLogo.setSize(widthLG,heightLG);
				lblLogo.setBounds(1060, 110, 204, 125);
				getContentPane().add(lblLogo);
				
				//to set logo
				
				
				JLabel lblLg1 = new JLabel("");
				int widthLG1=204,heightLG1=125;
				ImageIcon imageLG1 = new ImageIcon("src/Pictures/asian.png");
		        imageLG1.setImage(imageLG1.getImage().getScaledInstance(widthLG1,heightLG1,Image.SCALE_DEFAULT));
		        lblLg1.setIcon(imageLG1);
		        lblLg1.setSize(widthLG1,heightLG1);
				lblLg1.setBounds(1060, 300, 304, 145);
				getContentPane().add(lblLg1);

				
				  
				  JLabel lbl3= new JLabel("So eat like there is no tommorow");
				  lbl3.setBounds(100, 700, 1100, 50);
				  lbl3.setFont(new Font ("Arial",Font.PLAIN,50));
				  getContentPane().add(lbl3);
				  
				  JLabel lblBalance = new JLabel("Balance: $");
					lblBalance.setBounds(1060, 454, 81, 27);
					getContentPane().add(lblBalance);
					
					JLabel lbl4= new JLabel(" Username: ");
					  lbl4.setBounds(1054, 494, 281, 57);
					  lbl4.setFont(new Font ("Arial",Font.PLAIN,15));
					  getContentPane().add(lbl4);
					  
					txtEnterUsername = new JTextField();
					txtEnterUsername.setText(" ");
					txtEnterUsername.setBounds(1060, 540, 117, 27);
					getContentPane().add(txtEnterUsername);
					txtEnterUsername.setColumns(10);
					
					
			//	to get payment from user account
					JButton btnPayBalance = new JButton("Pay Balance");
//					btnPayBalance.addActionListener(new ActionListener() {
//						public void actionPerformed(ActionEvent e) {
//							 try{
//					                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
//					                Statement mySt =myConn.createStatement();
//					                String sql= "UPDATE `Restaurant`.`OrderFood` "
//					                		+ "SET `Order`='"+(lblOrder.getText())+"' WHERE `UserName`= '"+txtEnterUsername.getText()+"'";
//				        			
//				                    mySt.executeUpdate(sql);
//				                    try{
//						                Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
//						                Statement St =Conn.createStatement();
//						                String sql1= "UPDATE `Restaurant`.`Register` "
//						                		+ "SET `Deposit`=`Deposit`-'"+(lbltotalFood.getText())+"' WHERE `UserName`= '"+txtEnterUsername.getText()+"'";
//					        			
//					                    St.executeUpdate(sql1);
//					                    try{
//							                Connection SpentConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
//							                Statement SpentSt =SpentConn.createStatement();
//							                String SpentSql= "UPDATE `Restaurant`.`Register` "
//							                		+ "SET `Spent`=`Spent`+'"+(lbltotalFood.getText())+"' WHERE `UserName`= '"+txtEnterUsername.getText()+"'";
//						        			
//						                    SpentSt.executeUpdate(SpentSql);
//						                 
//						                    SpentSt.close();
//						                    SpentConn.close();
//							                
//				   
//							            }catch(Exception ex){
//							            	JOptionPane.showMessageDialog(Dialog, "Failed To Order!", "",JOptionPane.WARNING_MESSAGE);
//							                ex.printStackTrace();
//							            }
//					                    
//					                    St.close();
//					                    Conn.close();
//						                
			//   
//						            }catch(Exception ex){
//						            	JOptionPane.showMessageDialog(Dialog, "Failed To Order!", "",JOptionPane.WARNING_MESSAGE);
//						                ex.printStackTrace();
//						            }
//				                    JOptionPane.showMessageDialog(Dialog, "Successfully Ordered Food!", "",JOptionPane.INFORMATION_MESSAGE);
//				                    mySt.close();
//				                    myConn.close();
//					                
//					                
//					                
//					            }catch(Exception ex){
//					            	JOptionPane.showMessageDialog(Dialog, "Failed To Order!", "",JOptionPane.WARNING_MESSAGE);
//					                ex.printStackTrace();
//					            }
//					        
//						
//						}
//					});
//					                                                                                                                               	
					btnPayBalance.setBounds(1060, 578, 117, 29);
					getContentPane().add(btnPayBalance);
				  
				  
				  
				  
				  //to deposit ammount for user
				  JButton btnDeposit = new JButton("Deposit");
			        btnDeposit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
				            new Deposit().setVisible(true);
						}
					});
					btnDeposit.setBounds(1150, 650, 117, 29);
					getContentPane().add(btnDeposit);
					
					
				  //button for return
					
					JButton btnReturn = new JButton("Return");
					btnReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							System.exit(0);
							
						}
					});
					btnReturn.setBounds(1300, 650, 117, 29);
					getContentPane().add(btnReturn);
					
				  
				  //to set Background image in JFrame
				
				JLabel lblBackground = new JLabel(" ");
				ImageIcon imageBG = new ImageIcon("src/Pictures/blue.jpg");
		       imageBG.setImage(imageBG.getImage().getScaledInstance(1500,1500,Image.SCALE_DEFAULT));
		        lblBackground.setIcon(imageBG);
		        lblBackground.setSize(800,800);
				lblBackground.setBounds(0, 0, 1450, 1500);
				getContentPane().add(lblBackground);
				
				
				
				  
				
				setVisible(true);
						
				
			}

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
		}
			public static void main(String args[]) {
				new OrderFood();
			}
		}
