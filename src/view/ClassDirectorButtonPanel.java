package view;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;


@SuppressWarnings("serial")
public class ClassDirectorButtonPanel extends JPanel {

	private JButton addReqButton;
	private JButton deleteReqButton;

	
	public ClassDirectorButtonPanel(Controller c) {
		setSize(330,130);
		setForeground(Color.GRAY);
		setLayout(null);
		
		addReqButton = new JButton("Add Req");
		addReqButton.setBounds(28, 28, 123, 29);
		addReqButton.addActionListener(c);
		add(addReqButton);
		
		deleteReqButton = new JButton("Delete Req");
		deleteReqButton.setBounds(175, 28, 123, 29);
		deleteReqButton.addActionListener(c);
		add(deleteReqButton);
		
	}


	public JButton getAddReqButton() {
		return addReqButton;
	}
	public JButton getDeleteReqButton() {
		return deleteReqButton;
	}

}
