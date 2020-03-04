package view;


import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Controller.Controller;

import javax.swing.JButton;


@SuppressWarnings("serial")
public class LoginFrame extends BaseFrame {

	private JTextField idTextField;
	private JPasswordField pwTextField;
	private JButton exitButton;
	private JButton loginButton;


	public LoginFrame(Controller c) {
		
		setTitle("Login");
		
		JLabel idInputField = new JLabel("Staff ID:");
		idInputField.setFont(new Font("Arial", Font.PLAIN, 20));
		idInputField.setBounds(136, 86, 81, 21);
		contentPane.add(idInputField);
		
		JLabel passwordButton = new JLabel("Password:");
		passwordButton.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordButton.setBounds(136, 149, 94, 21);
		contentPane.add(passwordButton);
		
		idTextField = new JTextField();
		idTextField.setColumns(10);
		idTextField.setBounds(252, 78, 207, 37);
		contentPane.add(idTextField);
		
		pwTextField = new JPasswordField();
		pwTextField.setColumns(10);
		pwTextField.setBounds(252, 146, 207, 37);
		contentPane.add(pwTextField);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(86, 270, 123, 29);
		exitButton.addActionListener(c);
		contentPane.add(exitButton);
		
		loginButton = new JButton("Log in");
		loginButton.setBounds(399, 270, 123, 29);
		loginButton.addActionListener(c);
		contentPane.add(loginButton);

		this.getRootPane().setDefaultButton(loginButton);
	}
	
	
	// Getters
	public JButton getExitButton() {
		return exitButton;
	}
	public JButton getLoginButton() {
		return loginButton;
	}
	
	// Return -1 if no user input
	public int getID() {
		String text = idTextField.getText();
		int id = -1;
		try {
			id = Integer.parseInt(text);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public String getPassWord() {
		return String.valueOf(pwTextField.getPassword());
	}
}

