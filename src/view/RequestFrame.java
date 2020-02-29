package view;


import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;


@SuppressWarnings("serial")
public class RequestFrame extends JFrame {

	private JPanel contentPanel;
	JPanel buttonPanel;
	JTextArea descripTextArea;
	JList<String> requestNameList;
	JButton classDetailButton;
	JButton teacherDetailButton;
	

	public RequestFrame(Controller c) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setTitle("Requests");
		
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//Add a JList with a scrollBar
		JScrollPane requestScrollPane = new JScrollPane();
		requestScrollPane.setBounds(15, 41, 198, 288);
		contentPanel.add(requestScrollPane);
		requestNameList = new JList<String>();
		requestNameList.setModel(new AbstractListModel<String>() {
			String[] requestNameList = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
			public int getSize() {
				return requestNameList.length;
			}
			public String getElementAt(int index) {
				return requestNameList[index];
			}
		});
		requestScrollPane.setViewportView(requestNameList);
		
		JLabel requestListLabel = new JLabel("Request List");
		requestListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		requestListLabel.setBounds(15, 15, 198, 21);
		contentPanel.add(requestListLabel);
		JLabel classIdLabel = new JLabel("Class ID:");
		classIdLabel.setBounds(228, 29, 81, 21);
		contentPanel.add(classIdLabel);
		JLabel teacherNameLabel = new JLabel("Teacher Name:");
		teacherNameLabel.setBounds(228, 58, 123, 21);
		contentPanel.add(teacherNameLabel);
		JLabel descripLabel = new JLabel("Request Description:");
		descripLabel.setBounds(228, 87, 198, 21);
		contentPanel.add(descripLabel);
		
		//Add two button for class and teacher info for the request
		classDetailButton = new JButton("Detail");
		classDetailButton.setBounds(458, 25, 80, 24);
		contentPanel.add(classDetailButton);
		teacherDetailButton = new JButton("Detail");
		teacherDetailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		teacherDetailButton.setBounds(458, 55, 80, 24);
		contentPanel.add(teacherDetailButton);
		
		JScrollPane descScrollPane = new JScrollPane();
		descScrollPane.setBounds(228, 110, 335, 80);
		contentPanel.add(descScrollPane);
		
		descripTextArea = new JTextArea();
		descripTextArea.setBackground(SystemColor.menu);
		descripTextArea.setText("This is the description part of our request, please be careful about this part.");
		descripTextArea.setLineWrap(true);
		descripTextArea.setWrapStyleWord(true);
		descScrollPane.setViewportView(descripTextArea);
		
		buttonPanel = new JPanel(); 
		buttonPanel.setBounds(228, 194, 350, 150);
		buttonPanel.setLayout(null);
		contentPanel.add(buttonPanel);
	}


	public JPanel getButtonPanel() {
		return buttonPanel;
	}
	public JButton getClassDetailButton() {
		return classDetailButton;
	}
	public JButton getTeacherDetailButton() {
		return teacherDetailButton;
	}
	
}
