package view;


import javax.swing.JButton;

import Controller.Controller;

//This is the buttonPanel that class director see in the Request Frame
@SuppressWarnings("serial")
public class ClassDirectorButtonPanel extends BaseButtonPanel {

	private JButton addReqButton;
	private JButton deleteReqButton;

	
	public ClassDirectorButtonPanel(Controller c) {
		
		addReqButton = new JButton("Add Req");
		addReqButton.setBounds(28, 28, 123, 29);
		addReqButton.addActionListener(c);
		add(addReqButton);
		
		deleteReqButton = new JButton("Delete Req");
		deleteReqButton.setBounds(175, 28, 123, 29);
		deleteReqButton.addActionListener(c);
		add(deleteReqButton);
		
		deleteReqButton.setEnabled(false);
	}


	public JButton getAddReqButton() {
		return addReqButton;
	}
	public JButton getDeleteReqButton() {
		return deleteReqButton;
	}

	@Override
	public void setButtonsEnabled(boolean enabled) {
		addReqButton.setEnabled(enabled);
		deleteReqButton.setEnabled(enabled);
	}

}
