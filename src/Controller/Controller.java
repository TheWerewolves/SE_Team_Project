package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Database;
import model.Date;
import model.Model;
import model.PTTClass;
import model.Request;
import model.staff.Administrator;
import model.staff.ClassDirector;
import model.staff.PTTDirector;
import view.AdminButtonPanel;
import view.ClassDirectorButtonPanel;
import view.PTTDirectorButtonPanel;
import view.View;

/**
 * The Interaction between Client, Model and View
 */
public class Controller implements ActionListener, ListSelectionListener {

	private Model model;
	private View view;
	
	private Request activeRequest;
	
	
	public Controller(Model model) {
		this.model = model;
		view = null;
	}
	
	public void setView(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//press Exit Button at login Frame
		if(e.getSource() == view.getLF().getExitButton()) {
			
			Database.getInstance().save();
			System.exit(0);
			
		//press Login Button at login Frame
		} else if(e.getSource() == view.getLF().getLoginButton()) {
			
			int id = view.getLF().getID();
			String password = view.getLF().getPassWord();
			
			//log in succeed
			if(model.Login(id, password)) {
				
				view.getMF().setUserName(model.getCurrentUser().getName());
				view.getMF().setUserID(model.getCurrentUser().getID());
				view.getMF().setPermLvl(model.getCurrentUser().getPermLvl());
				
				view.getMF().setLocationRelativeTo(view.getLF());
				view.getLF().setVisible(false);
				view.getMF().setVisible(true);
				
			//log in fail
			} else {
				JOptionPane.showMessageDialog(view.getLF(), 
						"Wrong ID or password, Login failed.", "Login Failed", JOptionPane.ERROR_MESSAGE);
			}
			
		//press logout button at Menu Frame
		} else if(e.getSource() == view.getMF().getLogoutButton()) {

			int confirmed = JOptionPane.showConfirmDialog(view.getMF(), "Are you sure you want to logout?", "Logout Options", JOptionPane.YES_NO_CANCEL_OPTION);
			if(confirmed == 0) {
				model.Logout();
				
				view.getLF().setLocationRelativeTo(view.getMF());
				view.getMF().setVisible(false);
				view.getLF().setVisible(true);
			}
		
		//press request button at Menu Frame
		} else if(e.getSource() == view.getMF().getRequestButton()) {

			view.getRF().getRequestList().removeAllElements();
			for(Request r : model.getCurrentUser().getRequest()) {
				view.getRF().getRequestList().addElement(r.getName());
			}
			
			view.getRF().setButtonPanel(this, model.getCurrentUser().getPermLvl());
			
			view.getRF().setLocationRelativeTo(view.getMF());
			view.getMF().setVisible(false);
			view.getRF().setVisible(true);
			
		//press class detail button at Request Frame
		} else if(e.getSource() == view.getRF().getClassDetailButton()) {
			
			if(activeRequest == null) return;

			String detail = "Class Size: " + activeRequest.getPTTClass().getSize() + "\n" +
							"Class Date: " + activeRequest.getPTTClass().getTime() + "\n" +
							"Location:     " +   activeRequest.getPTTClass().getLocation() + "\n" +
							"Semester:   " +   activeRequest.getPTTClass().getSemester();
			
			JOptionPane.showMessageDialog(view.getLF(), detail, "Class Information", JOptionPane.INFORMATION_MESSAGE);
			
		//press Teacher detail button at Request Frame
		} else if(e.getSource() == view.getRF().getTeacherDetailButton()) {
			
			if(activeRequest == null) return;

			String detail = "Teacher ID:   " +   activeRequest.getTeacherID() + "\n" +
							"Teacher Name: " + model.getName(activeRequest.getTeacherID());
			
			JOptionPane.showMessageDialog(view.getLF(), detail, "Teacher Information", JOptionPane.INFORMATION_MESSAGE);
			
		//press Menu Button at Request Frame
		} else if(e.getSource() == view.getRF().getMenuButton()) {
			
			view.getMF().setLocationRelativeTo(view.getRF());
			view.getRF().setVisible(false);
			view.getMF().setVisible(true);
			
		//If user is Admin
		} else if(view.getRF().getButtonPanel() instanceof AdminButtonPanel) {

			AdminButtonPanel bp = (AdminButtonPanel) view.getRF().getButtonPanel();
			
			//Admin press the orgnize teacher button
			if(e.getSource() == bp.getOrgTeacherButton()) {
				
				Object[] idList = model.getTeacherIDList().toArray();
				Object choice = JOptionPane.showInputDialog(view.getRF(), 
						"Please selete a teacher's ID: ", "Orgnize Teacher", JOptionPane.PLAIN_MESSAGE, null, idList, null);
				if(choice != null) {
					int choiceID = (int) choice;
					((Administrator) model.getCurrentUser()).organize(activeRequest, choiceID);
					view.getRF().setTeacherName(model.getName(choiceID));
					view.getRF().getTeacherDetailButton().setEnabled(true);
				}
			
			//Admin press the orgnize class button
			} else if(e.getSource() == bp.getOrgClassButton()) {
				
				JTextField classSizeField = new JTextField();
				JTextField classDateField = new JTextField();
				JTextField locationField = new JTextField();
				JTextField semesterField = new JTextField();
				
				PTTClass currClass = activeRequest.getPTTClass();
				if(currClass != null) {
					classSizeField.setText("" + currClass.getSize());
					classDateField.setText("" + currClass.getTime());
					locationField.setText(currClass.getLocation());
					semesterField.setText(currClass.getSemester());
				}
				
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
						((Administrator) model.getCurrentUser()).organize(activeRequest, pttClass);
						view.getRF().setClassID("" + pttClass.getID());
						view.getRF().getClassDetailButton().setEnabled(true);

					} catch (Exception exception) {
						exception.printStackTrace();
						JOptionPane.showMessageDialog(view.getRF(), 
								"Invalid input, please try again.", "Orgnize Class Failed", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		
		// If user is Class Director
		} else if(view.getRF().getButtonPanel() instanceof ClassDirectorButtonPanel) {

			ClassDirectorButtonPanel bp = (ClassDirectorButtonPanel) view.getRF().getButtonPanel();
			
			//Class Director press add button
			if(e.getSource() == bp.getAddReqButton()) {
				
				JTextField nameField = new JTextField();
				JTextArea descriptionArea = new JTextArea(4, 10);
				descriptionArea.setLineWrap(true);
				JScrollPane descScrollPane = new JScrollPane();
				descScrollPane.setViewportView(descriptionArea);
				
				Object[] requestAdder = {
					"Request Name: ", nameField,
					"Description: ", descScrollPane
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
				
			//Class Director press delete request button
			} else if(e.getSource() == bp.getDeleteReqButton()) {

				int confirmed = JOptionPane.showConfirmDialog(view.getRF(), "Are you sure you want to delete this request?", "Delete Request Options", JOptionPane.YES_NO_CANCEL_OPTION);
				if(confirmed == 0) {
					((ClassDirector) model.getCurrentUser()).deleteRequest(activeRequest.getID());
					view.getRF().getRequestList().remove(activeRequest.getID());
					
					view.getRF().setClassID("");
					view.getRF().setTeacherName("");
					view.getRF().setDescription("");
				}
				
			}
		
		//If user is PTT Director
		} else if(view.getRF().getButtonPanel() instanceof PTTDirectorButtonPanel) {
			
			PTTDirectorButtonPanel bp = (PTTDirectorButtonPanel) view.getRF().getButtonPanel();
			
			//if PTT Director press save button
			if(e.getSource() == bp.getSaveButton()) {
				
				boolean approved = false;
				if(bp.getApproveRadio().isSelected()) approved = true;
				((PTTDirector) model.getCurrentUser()).approved(activeRequest.getID(), approved);
				
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(!e.getValueIsAdjusting()) return;

		view.getRF().getButtonPanel().setButtonsEnabled(true);
		
		activeRequest = model.getCurrentUser().getRequest().get(view.getRF().getSelectedIndex());
		
		if(activeRequest.getPTTClass() != null) {
			view.getRF().setClassID("" + activeRequest.getPTTClass().getID());
			view.getRF().getClassDetailButton().setEnabled(true);
		} else {
			view.getRF().setClassID("unorganized");
			view.getRF().getClassDetailButton().setEnabled(false);
		}
		
		if(activeRequest.getTeacherID() != -1) {
			view.getRF().setTeacherName(model.getName(activeRequest.getTeacherID()));
			view.getRF().getTeacherDetailButton().setEnabled(true);
		} else {
			view.getRF().setTeacherName("unorganized");
			view.getRF().getTeacherDetailButton().setEnabled(false);
		}

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
