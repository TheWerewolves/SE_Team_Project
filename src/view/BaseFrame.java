package view;


import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class BaseFrame extends JFrame {

	protected JPanel contentPane;
	
	
	public BaseFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
}
