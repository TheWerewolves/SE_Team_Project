package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class MenuFrame extends JFrame {

	private JPanel contentPanel;

	
	public MenuFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//set a Panel which show the user information
		//There are 3 labels in this panel
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(73, 55, 439, 144);
		contentPanel.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 2));
		
		JLabel helloLabel = new JLabel("Hi! Welcome to PTT System Interface!");
		helloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(helloLabel);
		
		JLabel userInfoLabel = new JLabel("User Staff ID is: 12345");
		userInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(userInfoLabel);
		
		JLabel permLvlLabel = new JLabel("User Permission level is: Teacher");
		permLvlLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(permLvlLabel);
		
		JButton logoutButton = new JButton("Log out");
		logoutButton.setBounds(73, 269, 123, 29);
		contentPanel.add(logoutButton);
		
		JButton requestButton = new JButton("Requests");
		requestButton.setBounds(389, 269, 123, 29);
		contentPanel.add(requestButton);
	}
}
