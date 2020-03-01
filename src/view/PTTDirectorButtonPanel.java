package view;


import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class PTTDirectorButtonPanel extends JPanel {

	private JRadioButton approveRadio;
	private JRadioButton notApproveRadio;
	
	
	public PTTDirectorButtonPanel(Controller c) {
		setSize(330,130);
		setForeground(Color.GRAY);
		setLayout(null);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBounds(15, 15, 300, 42);
		add(selectionPanel);
		selectionPanel.setLayout(null);
		
		approveRadio = new JRadioButton("Approve");
		approveRadio.setBounds(37, 5, 95, 29);
		approveRadio.addActionListener(c);
		selectionPanel.add(approveRadio);
		
		notApproveRadio = new JRadioButton("Not Approve");
		notApproveRadio.setBounds(160, 5, 131, 29);
		notApproveRadio.addActionListener(c);
		selectionPanel.add(notApproveRadio);
	}


	public JRadioButton getApproveRadio() {
		return approveRadio;
	}
	public JRadioButton getNotApproveRadio() {
		return notApproveRadio;
	}

	
}
