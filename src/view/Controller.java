package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Model;


public class Controller implements ActionListener {

	private Model model;
	private View view;
	
	
	public Controller(Model model) {
		this.model = model;
		view = null;
	}
	
	public void setView(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == view.getLF().getExitButton()) {
			
			System.exit(0);
			
		} else if(e.getSource() == view.getLF().getLoginButton()) {
			
			int id = view.getLF().getID();
			String password = view.getLF().getPassWord();
			if(model.Login(id, password)) {
				
				view.getMF().setUserName(model.getCurrentUser().getName());
				view.getMF().setUserID(model.getCurrentUser().getID());
				view.getMF().setPermLvl(model.getCurrentUser().getPermLvl());
				
				view.getMF().setLocationRelativeTo(view.getLF());
				view.getLF().setVisible(false);
				view.getMF().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(view.getLF(), "Wrong ID or password, Login failed.");
			}
			
		} else if(e.getSource() == view.getMF().getLogoutButton()) {
			
			System.out.println("logout");
			int confirmed = JOptionPane.showConfirmDialog(view.getMF(), "Are you sure you want to logout?", "Logout Options", JOptionPane.YES_NO_CANCEL_OPTION);
			if(confirmed == 0) {
				view.getLF().setLocationRelativeTo(view.getMF());
				view.getMF().setVisible(false);
				view.getLF().setVisible(true);
			}
			
		} else if(e.getSource() == view.getMF().getRequestButton()) {
			
			view.getRF().setLocationRelativeTo(view.getMF());
			view.getMF().setVisible(false);
			view.getRF().setVisible(true);
			
		} else if(e.getSource() == view.getRF().getClassDetailButton()) {
			
		} else if(e.getSource() == view.getRF().getTeacherDetailButton()) {
			
		} else if(e.getSource() == view.getLF().getExitButton()) {
			
		}
		
	}
	
}
