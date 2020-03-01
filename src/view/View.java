package view;


import model.Model;


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
//			rf.setVisible(true);
			
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
