package view;


import java.awt.Color;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public abstract class BaseButtonPanel extends JPanel {
	
	
	public BaseButtonPanel() {
		
		setSize(330, 130);
		setForeground(Color.GRAY);
		setLayout(null);
	}
	
	
	public abstract void setButtonsEnabled(boolean enabled);
}
