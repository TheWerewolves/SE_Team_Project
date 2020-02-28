package view;


import javax.swing.JFrame;


public class View{
	
	//The Constructor
		public View() {
			
			try {
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
				loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
