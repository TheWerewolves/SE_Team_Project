package view;


import Controller.Controller;
import model.Model;

// This is view, which initialize the GUI, and can return different frames.
public class View{
	
	private LoginFrame lf;
	private MenuFrame mf;
	private RequestFrame rf;
	
	
	public View(Model model, Controller controller) {
		
		try {
			lf = new LoginFrame(controller);
			mf = new MenuFrame(controller);
			rf = new RequestFrame(controller);
			
			lf.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Getters
	public LoginFrame getLF() {
		return lf;
	}
	public RequestFrame getRF() {
		return rf;
	}
	public MenuFrame getMF() {
		return mf;
	}

}
