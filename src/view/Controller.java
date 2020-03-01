package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Model;
import model.Request;


public class Controller implements ActionListener, ListSelectionListener {

	private Model model;
	private View view;
	
	private Request activeRequest = null;
	
	
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
				JOptionPane.showMessageDialog(view.getLF(), "Wrong ID or password, Login failed.", "Login Failed", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if(e.getSource() == view.getMF().getLogoutButton()) {

			int confirmed = JOptionPane.showConfirmDialog(view.getMF(), "Are you sure you want to logout?", "Logout Options", JOptionPane.YES_NO_CANCEL_OPTION);
			if(confirmed == 0) {
				model.Logout();
				
				view.getLF().setLocationRelativeTo(view.getMF());
				view.getMF().setVisible(false);
				view.getLF().setVisible(true);
			}
			
		} else if(e.getSource() == view.getMF().getRequestButton()) {

			for(Request r : model.getCurrentUser().getRequest()) {
				view.getRF().getRequestList().addElement(r.getName());
			}
			
			view.getRF().setButtonPanel(this, model.getCurrentUser().getPermLvl());
			
			view.getRF().setLocationRelativeTo(view.getMF());
			view.getMF().setVisible(false);
			view.getRF().setVisible(true);
			
		} else if(e.getSource() == view.getRF().getClassDetailButton()) {
			
			if(activeRequest == null) return;
			String detail = "Class Size: " + activeRequest.getPTTClass().getSize() + "\n" +
							"Class Date: " + activeRequest.getPTTClass().getTime() + "\n" +
							"Location:     " +   activeRequest.getPTTClass().getLocation() + "\n" +
							"Semester:    " +   activeRequest.getPTTClass().getSemester();
			
			JOptionPane.showMessageDialog(view.getLF(), detail, "Class Information", JOptionPane.INFORMATION_MESSAGE);
			
		} else if(e.getSource() == view.getRF().getTeacherDetailButton()) {
			
			if(activeRequest == null) return;
			String detail = "Teacher ID:   " +   activeRequest.getTeacherID() + "\n" +
							"Teacher Name: " + model.getName(activeRequest.getTeacherID());
			
			JOptionPane.showMessageDialog(view.getLF(), detail, "Teacher Information", JOptionPane.INFORMATION_MESSAGE);
			
		} else if(e.getSource() == view.getRF().getMenuButton()) {
			
			view.getMF().setLocationRelativeTo(view.getRF());
			view.getRF().setVisible(false);
			view.getMF().setVisible(true);
			
		} else if(!(view.getRF().getButtonPanel() instanceof JPanel)) {
			
			if(view.getRF().getButtonPanel() instanceof AdminButtonPanel) {
				AdminButtonPanel bp = (AdminButtonPanel) view.getRF().getButtonPanel();
				if(e.getSource() == bp.getOrgClassButton()) {
					
					view.getRF().setButtonPanel(this, "PTTDirector");
					
				}
			}
			
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		int selectedIndex = view.getRF().getSelectedIndex();
		activeRequest = model.getRequest(selectedIndex);
		
		view.getRF().setClassID(activeRequest.getPTTClass().getID());
		view.getRF().setTeacherName(model.getName(activeRequest.getTeacherID()));
		view.getRF().setDescription(activeRequest.getDescription());
	}
	
}
