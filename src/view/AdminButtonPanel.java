package view;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class AdminButtonPanel extends JPanel {

	JButton orgTeacherButton;
	JButton orgClassButton;
	JButton menuButton;
	JButton saveButton;
	
	
	public AdminButtonPanel(Controller c) {
		
		setSize(330, 130);
		setForeground(Color.GRAY);
		setLayout(null);
		
		orgTeacherButton = new JButton("Orgnize Teacher");
		orgTeacherButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		orgTeacherButton.setBounds(28, 28, 132, 29);
		orgTeacherButton.addActionListener(c);
		add(orgTeacherButton);
		
		orgClassButton = new JButton("Orgnize Class");
		orgClassButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		orgClassButton.setBounds(175, 28, 123, 29);
		orgClassButton.addActionListener(c);
		add(orgClassButton);
		
		menuButton = new JButton("Menu");
		menuButton.setBounds(28, 72, 132, 29);
		menuButton.addActionListener(c);
		add(menuButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(175, 72, 123, 29);
		saveButton.addActionListener(c);
		add(saveButton);
	}


	public JButton getOrgTeacherButton() {
		return orgTeacherButton;
	}
	public JButton getOrgClassButton() {
		return orgClassButton;
	}
	public JButton getMenuButton() {
		return menuButton;
	}
	public JButton getSaveButton() {
		return saveButton;
	}

}
