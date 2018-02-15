package Views;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {
	public GUI(){
		this.setTitle("Welcome");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,300);
		JLabel welcome = new JLabel("<html><font size=18><p align=center>Welcome to the Flight Booking System</p></font></html>");
		
		this.add(welcome,BorderLayout.NORTH);
		
		JButton enter = new JButton("Enter");
		enter.addActionListener(this);
		JPanel flowPanel = new JPanel(new FlowLayout());
		
	    flowPanel.add(enter);
	    this.add(flowPanel, BorderLayout.CENTER);
		
		//this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new CheckInScreen();
		this.setVisible(false);
		
	}

}
