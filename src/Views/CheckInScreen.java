package Views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckInScreen extends JFrame implements ActionListener {
	JTextField surname;
	JTextField weight;
	JTextField height;
	JTextField width;
	JTextField depth;
	
	public CheckInScreen(){
		
		this.setTitle("CheckInScreen");
		
		this.setSize(500,300);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(7,2));
		
		JLabel bookingCodeLabel = new JLabel("Booking Code");
		this.add(bookingCodeLabel);
		JTextField bookingCode = new JTextField();
		this.add(bookingCode);
				
		JLabel surnameLabel = new JLabel("Surname");
		this.add(surnameLabel);		
		surname = new JTextField();
		this.add(surname);
		
		JLabel weightLabel = new JLabel("Bag Weight (kg)");
		this.add(weightLabel);
		
		weight = new JTextField();
		this.add(weight);
		
		JLabel heightLabel = new JLabel("Bag Height (cm)");
		this.add(heightLabel);
		height = new JTextField();
		this.add(height);
		
		JLabel widthLabel = new JLabel("Bag Width (cm)");
		this.add(widthLabel);
		width = new JTextField();
		this.add(width);
		
		JLabel depthLabel = new JLabel("Bag Depth (cm)");
		this.add(depthLabel);
		depth = new JTextField();
		this.add(depth);
		
		
		JButton okay = new JButton("Okay");
		this.add(okay);
		okay.addActionListener(this);		
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int intWeight = Integer.parseInt(weight.getText()); 
		
		int result = JOptionPane.showConfirmDialog(this,
				"Weight of Bag: " + intWeight +
				"\nExcess Baggage Fee(£): some_variable.",
				"Are you sure you wish to proceed?",
				JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.YES_OPTION) {
			System.out.println("Clicked yes");
			
			  JOptionPane.showMessageDialog(this,
						"Thank you. "+surname.getText()+" you have now checked in");
			
			
		} else {
			System.out.println("Clicked no");
		}
		
		
		
		
		/*
		  JOptionPane.showMessageDialog(this,
				"Passenger Not Found!",
				"Please re-enter details.",
				JOptionPane.ERROR_MESSAGE);
		*/
		
	}
	

}
