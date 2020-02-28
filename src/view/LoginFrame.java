package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	public LoginFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idInputField = new JLabel("Staff ID");
		idInputField.setFont(new Font("Arial", Font.PLAIN, 20));
		idInputField.setBounds(136, 86, 81, 21);
		contentPane.add(idInputField);
		
		textField = new JTextField();
		textField.setBounds(252, 78, 207, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(86, 270, 123, 29);
		contentPane.add(exitButton);
		
		JButton loginButton = new JButton("Log in");
		loginButton.setBounds(399, 270, 123, 29);
		contentPane.add(loginButton);
		
		JLabel passwordButton = new JLabel("Password");
		passwordButton.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordButton.setBounds(136, 149, 94, 21);
		contentPane.add(passwordButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(252, 146, 207, 37);
		contentPane.add(textField_1);
		
		setResizable(false);
	}
}
