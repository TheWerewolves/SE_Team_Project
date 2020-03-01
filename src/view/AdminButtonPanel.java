package view;


import javax.swing.JButton;


@SuppressWarnings("serial")
public class AdminButtonPanel extends BaseButtonPanel {

	private JButton orgTeacherButton;
	private JButton orgClassButton;
	
	
	public AdminButtonPanel(Controller c) {

		orgTeacherButton = new JButton("Orgnize Teacher");
		orgTeacherButton.setBounds(72, 28, 186, 29);
		orgTeacherButton.addActionListener(c);
		add(orgTeacherButton);
		
		orgClassButton = new JButton("Orgnize Class");
		orgClassButton.setBounds(72, 60, 186, 29);
		orgClassButton.addActionListener(c);
		add(orgClassButton);

		setButtonsEnabled(false);
	}


	public JButton getOrgTeacherButton() {
		return orgTeacherButton;
	}
	public JButton getOrgClassButton() {
		return orgClassButton;
	}

	@Override
	public void setButtonsEnabled(boolean enabled) {
		orgTeacherButton.setEnabled(enabled);
		orgClassButton.setEnabled(enabled);
	}

}
