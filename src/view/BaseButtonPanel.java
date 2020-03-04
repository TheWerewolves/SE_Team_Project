package view;


import java.awt.Color;

import javax.swing.JPanel;

//This is a baseButtonPanel for all different buttonpanel
@SuppressWarnings("serial")
public abstract class BaseButtonPanel extends JPanel {
	
	
	public BaseButtonPanel() {
		
		setSize(330, 130);
		setForeground(Color.GRAY);
		setLayout(null);
	}
	
	//abstract method which is implemented by the child classes.
	public abstract void setButtonsEnabled(boolean enabled);
}
