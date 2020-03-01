package view;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class PTTDirectorButtonPanel extends BaseButtonPanel {

	private ButtonGroup buttonGroup;
	
	private JRadioButton approveRadio;
	private JRadioButton notApproveRadio;
	
	private JButton saveButton;
	
	
	public PTTDirectorButtonPanel(Controller c) {
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBounds(15, 25, 300, 0);
		add(selectionPanel);
		selectionPanel.setLayout(null);
		
		approveRadio = new JRadioButton("Approve");
		approveRadio.setBounds(55, 10, 95, 29);
		approveRadio.addActionListener(c);
		add(approveRadio);
		
		notApproveRadio = new JRadioButton("Not Approve");
		notApproveRadio.setBounds(175, 10, 131, 29);
		notApproveRadio.addActionListener(c);
		add(notApproveRadio);
		
		saveButton = new JButton("Save Request");
		saveButton.setBounds(72, 60, 186, 29);
		saveButton.addActionListener(c);
		add(saveButton);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(approveRadio);
		buttonGroup.add(notApproveRadio);
		
		setButtonsEnabled(false);
	}


	
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	public JRadioButton getApproveRadio() {
		return approveRadio;
	}
	public JRadioButton getNotApproveRadio() {
		return notApproveRadio;
	}
	public JButton getSaveButton() {
		return saveButton;
	}


	@Override
	public void setButtonsEnabled(boolean enabled) {
		approveRadio.setEnabled(enabled);
		notApproveRadio.setEnabled(enabled);
		saveButton.setEnabled(enabled);
	}
	
}
