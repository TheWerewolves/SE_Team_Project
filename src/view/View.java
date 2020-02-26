package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View{
	
	//The Constructor
		public View() {
			
			try {
				Login_Frame loginFrame = new Login_Frame();
				loginFrame.setVisible(true);
				loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
