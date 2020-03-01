package view;


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class MenuFrame extends BaseFrame {

	private JButton logoutButton;
	private JButton requestButton;
	private JLabel helloLabel;
	private JLabel userInfoLabel;
	private JLabel permLvlLabel;

	
	public MenuFrame(Controller c) {

		setTitle("Main Menu");
		
		//set a Panel which show the user information
		//There are 3 labels in this panel
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(73, 55, 439, 144);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 2));
		
		helloLabel = new JLabel("Hi! Welcome to PTT System Interface!");
		helloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(helloLabel);
		
		userInfoLabel = new JLabel("User Staff ID: ");
		userInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(userInfoLabel);
		
		permLvlLabel = new JLabel("User Permission level: ");
		permLvlLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(permLvlLabel);
		
		logoutButton = new JButton("Log out");
		logoutButton.setBounds(73, 269, 123, 29);
		logoutButton.addActionListener(c);
		contentPane.add(logoutButton);
		
		requestButton = new JButton("Requests");
		requestButton.setBounds(389, 269, 123, 29);
		requestButton.addActionListener(c);
		contentPane.add(requestButton);
		
		this.getRootPane().setDefaultButton(requestButton);
	}


	public JButton getLogoutButton() {
		return logoutButton;
	}
	public JButton getRequestButton() {
		return requestButton;
	}
	
	public void setUserName(String name) {
		helloLabel.setText("Hi " + name + "! Welcome to PTT System Interface!");
	}
	public void setUserID(int userID) {
		userInfoLabel.setText("User Staff ID: " + userID);
	}
	public void setPermLvl(String permLvl) {
		permLvlLabel.setText("User Permission level: " + permLvl);
	}
}
