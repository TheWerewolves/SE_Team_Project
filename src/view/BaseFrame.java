package view;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Database;


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
		
		addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e)
	        {
	            Database.getInstance().save();
	            e.getWindow().dispose();
	        }
	    });
	}

}
