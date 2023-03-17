package Test;

import javax.swing.JFrame;

public class Win2 extends JFrame{
		Class1 obj3;
		
		public Win2(Class1 obj) {
			obj3=obj;
			setVisible(true);
			System.out.println(obj);
			obj.name="Gyan Rai";
			new Win3(obj);
			dispose();			
		}
		
		

}
