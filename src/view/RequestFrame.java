package view;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Controller.Controller;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.SystemColor;

// This is the request Frame where user can check, and do operation to the requests.
@SuppressWarnings({"serial", "unused"})
public class RequestFrame extends BaseFrame {
	
	private DefaultListModel<String> requestList;

	private JList<String> requestNameList;
	private JScrollPane descScrollPane;
	private BaseButtonPanel buttonPanel;
	
	private JButton classDetailButton;
	private JButton teacherDetailButton;
	private JButton menuButton;
	
	private JLabel classIdLabel;
	private JLabel teacherNameLabel;
	private JTextArea descripTextArea;

	
	public RequestFrame(Controller c) {

		setTitle("Requests");
		
		//Add a JList with a scrollBar
		JScrollPane requestScrollPane = new JScrollPane();
		requestScrollPane.setBounds(15, 41, 198, 288);
		contentPane.add(requestScrollPane);
		
		requestList = new DefaultListModel<String>();
		requestNameList = new JList<String>(requestList);
		requestNameList.addListSelectionListener(c);
		requestNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		requestNameList.setDragEnabled(false);
		requestScrollPane.setViewportView(requestNameList);
		
		JLabel requestListLabel = new JLabel("Request List");
		requestListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		requestListLabel.setBounds(15, 15, 198, 21);
		contentPane.add(requestListLabel);
		classIdLabel = new JLabel("Class ID: ");
		classIdLabel.setBounds(228, 29, 150, 21);
		contentPane.add(classIdLabel);
		teacherNameLabel = new JLabel("Teacher: ");
		teacherNameLabel.setBounds(228, 58, 150, 21);
		contentPane.add(teacherNameLabel);
		JLabel descripLabel = new JLabel("Request Description:");
		descripLabel.setBounds(228, 87, 198, 21);
		contentPane.add(descripLabel);
		
		//Add two button for class and teacher info for the request
		classDetailButton = new JButton("Detail");
		classDetailButton.setBounds(458, 25, 80, 24);
		classDetailButton.addActionListener(c);
		classDetailButton.setEnabled(false);
		contentPane.add(classDetailButton);
		
		teacherDetailButton = new JButton("Detail");
		teacherDetailButton.setBounds(458, 55, 80, 24);
		teacherDetailButton.addActionListener(c);
		teacherDetailButton.setEnabled(false);
		contentPane.add(teacherDetailButton);
		
		//The testArea which contain description of request which have a scroll bar.
		descScrollPane = new JScrollPane();
		descScrollPane.setBounds(228, 110, 335, 80);
		contentPane.add(descScrollPane);
		
		descripTextArea = new JTextArea();
		descripTextArea.setBackground(SystemColor.menu);
		descripTextArea.setLineWrap(true);
		descripTextArea.setWrapStyleWord(true);
		descScrollPane.setViewportView(descripTextArea);
		
		//there is a button which can return to the menu
		menuButton = new JButton("Return to Menu");
		menuButton.setBounds(300, 286, 186, 29);
		menuButton.addActionListener(c);
		contentPane.add(menuButton);
		
		buttonPanel = new TeacherButtonPanel();
		contentPane.add(buttonPanel);
	}

	
	public void setClassID(String id) {
		classIdLabel.setText("Class ID:   " + id);
	}
	
	public void setTeacherName(String name) {
		teacherNameLabel.setText("Teacher:   " + name);
	}
	
	public void setDescription(String desc) {
		descripTextArea.setText(desc);
		descripTextArea.setCaretPosition(0);
	}
	
	public void setButtonPanel(Controller c, String permLvl) {

		contentPane.remove(buttonPanel);

		if(permLvl.equals("Administrator")) {
			buttonPanel = new AdminButtonPanel(c);
			
		} else if(permLvl.equals("ClassDirector")) {
			buttonPanel = new ClassDirectorButtonPanel(c);
			
		} else if(permLvl.equals("PTTDirector")) {
			buttonPanel = new PTTDirectorButtonPanel(c);
			
		} else {
			buttonPanel = new TeacherButtonPanel();
		}
		
		buttonPanel.setLocation(228, 194);
		contentPane.add(buttonPanel);
		contentPane.repaint();
		
	}
	
	public JButton getClassDetailButton() {
		return classDetailButton;
	}
	public JButton getTeacherDetailButton() {
		return teacherDetailButton;
	}
	public JButton getMenuButton() {
		return menuButton;
	}
	public BaseButtonPanel getButtonPanel() {
		return buttonPanel;
	}
	public DefaultListModel<String> getRequestList() {
		return requestList;
	}
	public int getSelectedIndex() {
		return requestNameList.getSelectedIndex();
	}
	public JScrollPane getDescScrollPane() {
		return descScrollPane;
	}
	
}
