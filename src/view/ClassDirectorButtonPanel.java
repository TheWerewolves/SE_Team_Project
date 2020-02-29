package view;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;


@SuppressWarnings("serial")
public class ClassDirectorButtonPanel extends JPanel {

	JButton addReqButton;
	JButton deleteReqButton;
	JButton menuButton;
	JButton sendButton;

	
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
		
		menuButton = new JButton("Menu");
		menuButton.setBounds(28, 72, 123, 29);
		menuButton.addActionListener(c);
		add(menuButton);
		
		sendButton = new JButton("Send");
		sendButton.setBounds(175, 72, 123, 29);
		sendButton.addActionListener(c);
		add(sendButton);
	}


	public JButton getAddReqButton() {
		return addReqButton;
	}
	public JButton getDeleteReqButton() {
		return deleteReqButton;
	}
	public JButton getMenuButton() {
		return menuButton;
	}
	public JButton getSendButton() {
		return sendButton;
	}

}
