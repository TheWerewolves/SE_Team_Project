package view;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class PTTDirectorButtonPanel extends JPanel {

	JButton menuButton;
	JButton saveButton;
	JRadioButton approveRadio;
	JRadioButton notApproveRadio;
	
	
	public PTTDirectorButtonPanel(Controller c) {
		setSize(330,130);
		setForeground(Color.GRAY);
		setLayout(null);
		
		menuButton = new JButton("Menu");
		menuButton.setBounds(28, 72, 123, 29);
		menuButton.addActionListener(c);
		add(menuButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(175, 72, 123, 29);
		saveButton.addActionListener(c);
		add(saveButton);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBounds(15, 15, 300, 42);
		add(selectionPanel);
		selectionPanel.setLayout(null);
		
		approveRadio = new JRadioButton("Approve");
		approveRadio.setBounds(21, 5, 95, 29);
		approveRadio.addActionListener(c);
		selectionPanel.add(approveRadio);
		
		notApproveRadio = new JRadioButton("Not Approve");
		notApproveRadio.setBounds(144, 5, 131, 29);
		notApproveRadio.addActionListener(c);
		selectionPanel.add(notApproveRadio);
	}


	public JButton getMenuButton() {
		return menuButton;
	}
	public JButton getSaveButton() {
		return saveButton;
	}
	public JRadioButton getApproveRadio() {
		return approveRadio;
	}
	public JRadioButton getNotApproveRadio() {
		return notApproveRadio;
	}

	
}
