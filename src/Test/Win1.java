package Test;

import javax.swing.JFrame;

public class Win1 extends JFrame{
	
	public Win1() {
		setVisible(true);
		Class1 obj1 = new Class1();
		obj1.id=10;
		obj1.name="Anmol";
		new Win2(obj1);
		dispose();		
	}

	public static void main(String[] args) {
		new Win1();
	}
}
