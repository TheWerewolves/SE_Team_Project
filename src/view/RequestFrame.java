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


	public RequestFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600,400);
		contentPanel = new JPanel();
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel ButtonPanel = new JPanel(); 
		ButtonPanel.setBounds(228, 194, 350, 150);
		contentPanel.add(ButtonPanel);
		ButtonPanel.setLayout(null);
		
		
		//Add a JList with a scrollBar
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 41, 198, 288);
		contentPanel.add(scrollPane);
		JList<String> requestNameList = new JList<String>();
		requestNameList.setModel(new AbstractListModel<String>() {
			String[] requestNameList = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "1", "2", "3", "4", "5", "6", "7"};
			public int getSize() {
				return requestNameList.length;
			}
			public String getElementAt(int index) {
				return requestNameList[index];
			}
		});
		scrollPane.setViewportView(requestNameList);
		
		
		JLabel requestListLabel = new JLabel("Request List");
		requestListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		requestListLabel.setBounds(15, 15, 198, 21);
		contentPanel.add(requestListLabel);
		
		//Add two button for class and teacher info for the request
		JButton classDetailButton = new JButton("Detail");
		classDetailButton.setBounds(458, 25, 87, 29);
		contentPanel.add(classDetailButton);
		
		JButton teacherDetailButton = new JButton("Detail");
		teacherDetailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		teacherDetailButton.setBounds(458, 61, 87, 29);
		contentPanel.add(teacherDetailButton);
		
		JLabel classIdLabel = new JLabel("Class ID:");
		classIdLabel.setBounds(236, 29, 81, 21);
		contentPanel.add(classIdLabel);
		
		JLabel teacherNameLabel = new JLabel("Teacher Name:");
		teacherNameLabel.setBounds(231, 65, 123, 21);
		contentPanel.add(teacherNameLabel);
		
		
		//Description Label follows a description text area with a scroll bar.
		JLabel descripLabel = new JLabel("Request Description:");
		descripLabel.setBounds(228, 101, 198, 21);
		contentPanel.add(descripLabel);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(228, 126, 335, 54);
		contentPanel.add(scrollPane_1);
		JTextArea descripTextArea = new JTextArea();
		descripTextArea.setBackground(SystemColor.menu);
		descripTextArea.setText("This is the description part of our request, please be careful about this part.");
		descripTextArea.setLineWrap(true);
		descripTextArea.setWrapStyleWord(true);
		scrollPane_1.setColumnHeaderView(descripTextArea);
	}
}
