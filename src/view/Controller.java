package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Date;
import model.Model;
import model.PTTClass;
import model.Request;
import model.staff.Administrator;
import model.staff.ClassDirector;
import model.staff.PTTDirector;


public class Controller implements ActionListener, ListSelectionListener {

	private Model model;
	private View view;
	
	private int currReqIndex = -1;
	
	
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
				JOptionPane.showMessageDialog(view.getLF(), 
						"Wrong ID or password, Login failed.", "Login Failed", JOptionPane.ERROR_MESSAGE);
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

			view.getRF().getRequestList().removeAllElements();
			for(Request r : model.getCurrentUser().getRequest()) {
				view.getRF().getRequestList().addElement(r.getName());
			}
			
			view.getRF().setButtonPanel(this, model.getCurrentUser().getPermLvl());
			
			view.getRF().setLocationRelativeTo(view.getMF());
			view.getMF().setVisible(false);
			view.getRF().setVisible(true);
			
		} else if(e.getSource() == view.getRF().getClassDetailButton()) {
			
			if(currReqIndex == -1) return;
			Request activeRequest = model.getRequest(currReqIndex);
			String detail = "Class Size: " + activeRequest.getPTTClass().getSize() + "\n" +
							"Class Date: " + activeRequest.getPTTClass().getTime() + "\n" +
							"Location:     " +   activeRequest.getPTTClass().getLocation() + "\n" +
							"Semester:   " +   activeRequest.getPTTClass().getSemester();
			
			JOptionPane.showMessageDialog(view.getLF(), detail, "Class Information", JOptionPane.INFORMATION_MESSAGE);
			
		} else if(e.getSource() == view.getRF().getTeacherDetailButton()) {
			
			if(currReqIndex == -1) return;
			Request activeRequest = model.getRequest(currReqIndex);
			String detail = "Teacher ID:   " +   activeRequest.getTeacherID() + "\n" +
							"Teacher Name: " + model.getName(activeRequest.getTeacherID());
			
			JOptionPane.showMessageDialog(view.getLF(), detail, "Teacher Information", JOptionPane.INFORMATION_MESSAGE);
			
		} else if(e.getSource() == view.getRF().getMenuButton()) {
			
			view.getMF().setLocationRelativeTo(view.getRF());
			view.getRF().setVisible(false);
			view.getMF().setVisible(true);
			
		} else if(view.getRF().getButtonPanel() instanceof AdminButtonPanel) {

			AdminButtonPanel bp = (AdminButtonPanel) view.getRF().getButtonPanel();
			if(e.getSource() == bp.getOrgTeacherButton()) {
				
				Object[] idList = model.getTeacherIDList().toArray();
				Object choice = JOptionPane.showInputDialog(view.getRF(), 
						"Please selete a teacher's ID: ", "Orgnize Teacher", JOptionPane.PLAIN_MESSAGE, null, idList, null);
				if(choice != null) {
					int choiceID = (int) choice;
					((Administrator) model.getCurrentUser()).organize(currReqIndex, choiceID);
					view.getRF().setTeacherName(model.getName(choiceID));
				}
				
			} else if(e.getSource() == bp.getOrgClassButton()) {
				
				JTextField classSizeField = new JTextField();
				JTextField classDateField = new JTextField();
				JTextField locationField = new JTextField();
				JTextField semesterField = new JTextField();
				Object[] classOrganizer = {
					"Class Size: ", classSizeField,
					"Date(xx/xx/xxxx): ", classDateField,
					"Location:     ", locationField,
					"Semester:   ", semesterField
				};
				int choice = JOptionPane.showConfirmDialog(view.getRF(), 
						classOrganizer,  "Orgnize Class", JOptionPane.OK_CANCEL_OPTION);
				
				if(choice == JOptionPane.OK_OPTION) {
					
					int classSize = 0;
					Date classDate = null;
					String location = locationField.getText();
					String semester = semesterField.getText();
					try {
						classSize = Integer.parseInt(classSizeField.getText());
						classDate = Date.parseDate(classDateField.getText());
						
						PTTClass pttClass = new PTTClass(classSize, classDate, location, semester);
						((Administrator) model.getCurrentUser()).organize(currReqIndex, pttClass);
						view.getRF().setClassID("" + pttClass.getID());

					} catch (Exception exception) {
						exception.printStackTrace();
						JOptionPane.showMessageDialog(view.getRF(), 
								"Invalid input, please try again.", "Orgnize Class Failed", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
			
		} else if(view.getRF().getButtonPanel() instanceof ClassDirectorButtonPanel) {

			ClassDirectorButtonPanel bp = (ClassDirectorButtonPanel) view.getRF().getButtonPanel();
			if(e.getSource() == bp.getAddReqButton()) {
				
				JTextField nameField = new JTextField();
				JTextArea descriptionArea = new JTextArea(4, 10);
				Object[] requestAdder = {
					"Request Name: ", nameField,
					"Description: ", descriptionArea
				};
				int choice = JOptionPane.showConfirmDialog(view.getRF(), 
						requestAdder,  "Add Request", JOptionPane.OK_CANCEL_OPTION);
				
				if(choice == JOptionPane.OK_OPTION) {
					
					String name = nameField.getText();
					String description = descriptionArea.getText();

					if(name.length() == 0) {
						JOptionPane.showMessageDialog(view.getRF(), 
								"Invalid input, please try again.", "Orgnize Class Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					((ClassDirector) model.getCurrentUser()).addRequest(name, description);
					view.getRF().getRequestList().addElement(name);
					
				}
				
			} else if(e.getSource() == bp.getDeleteReqButton()) {
				
				((ClassDirector) model.getCurrentUser()).deleteRequest(currReqIndex);;
				view.getRF().getRequestList().remove(currReqIndex);
				
				view.getRF().setClassID("");
				view.getRF().setTeacherName("");
				view.getRF().setDescription("");
				
			}
			
		} else if(view.getRF().getButtonPanel() instanceof PTTDirectorButtonPanel) {

			PTTDirectorButtonPanel bp = (PTTDirectorButtonPanel) view.getRF().getButtonPanel();
			if(e.getSource() == bp.getSaveButton()) {
				
				boolean approved = false;
				if(bp.getApproveRadio().isSelected()) approved = true;
				((PTTDirector) model.getCurrentUser()).approved(currReqIndex, approved);
				
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(!e.getValueIsAdjusting()) return;
		
		view.getRF().getButtonPanel().setButtonsEnabled(true);
		
		currReqIndex = view.getRF().getSelectedIndex();
		Request activeRequest = model.getRequest(currReqIndex);
		
		if(activeRequest.getPTTClass() != null) 
			view.getRF().setClassID("" + activeRequest.getPTTClass().getID());
		else
			view.getRF().setClassID("unorganized");
		if(activeRequest.getTeacherID() != -1) 
			view.getRF().setTeacherName(model.getName(activeRequest.getTeacherID()));
		else
			view.getRF().setTeacherName("unorganized");
		view.getRF().setDescription(activeRequest.getDescription());
		
		if(view.getRF().getButtonPanel() instanceof PTTDirectorButtonPanel) {
			PTTDirectorButtonPanel bp = (PTTDirectorButtonPanel) view.getRF().getButtonPanel();
			if(activeRequest.getApproved()) {
				bp.getButtonGroup().setSelected(bp.getApproveRadio().getModel(), true);
			} else {
				bp.getButtonGroup().setSelected(bp.getNotApproveRadio().getModel(), true);
			}
		}
	}
	
}
