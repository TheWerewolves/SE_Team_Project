package view;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class AdminButtonPanel extends JPanel {

	private JButton orgTeacherButton;
	private JButton orgClassButton;
	
	
	public AdminButtonPanel(Controller c) {
		
		setSize(330, 130);
		setForeground(Color.GRAY);
		setLayout(null);
		
		orgTeacherButton = new JButton("Orgnize Teacher");
		orgTeacherButton.setBounds(72, 28, 186, 29);
		orgTeacherButton.addActionListener(c);
		add(orgTeacherButton);
		
		orgClassButton = new JButton("Orgnize Class");
		orgClassButton.setBounds(72, 60, 186, 29);
		orgClassButton.addActionListener(c);
		add(orgClassButton);

	}


	public JButton getOrgTeacherButton() {
		return orgTeacherButton;
	}
	public JButton getOrgClassButton() {
		return orgClassButton;
	}

}
