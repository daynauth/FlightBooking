package Views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Models.Booking;
import Models.Passenger;

public class BaggagePanel extends JPanel{
	private JLabel welcome;
	private JTextField height;
	private JTextField width;
	private JTextField depth;
	private JTextField weight;
	private JLabel weightLabel;
	private JLabel heightLabel;
	private JLabel widthLabel;
	private JLabel depthLabel;
	private JButton okay;
	
	
	public BaggagePanel(){
		welcome = new JLabel("Welcome");
		this.add(welcome);
		
		weightLabel = new JLabel("Bag Weight (kg)");
		this.add(weightLabel);
		
		weight = new JTextField(50);
		this.add(weight);
		
		heightLabel = new JLabel("Bag Height (cm)");
		this.add(heightLabel);
		
		height = new JTextField(50);
		this.add(height);
		
		widthLabel = new JLabel("Bag Width (cm)");
		this.add(widthLabel);
		
		width = new JTextField(50);
		this.add(width);
		
		depthLabel = new JLabel("Bag Depth (cm)");
		this.add(depthLabel);
		
		depth = new JTextField(50);
		this.add(depth);
		
		okay = new JButton("Okay");
		this.add(okay);
		
	}
		
	
	public int getBaggageHeight(){
		return Integer.parseInt(this.height.getText());
	}
	
	public int getBaggageWidth(){
		return Integer.parseInt(this.width.getText());
	}
	
	public int getBaggageDepth(){
		return Integer.parseInt(this.depth.getText());
	}
	
	public int getBaggageWeight(){
		return Integer.parseInt(this.weight.getText());
	}
	
	
	public void setWelcome(Booking b){
		welcome.setText("Welcome, " + b.getPassenger().getFirstName() + " " + b.getPassenger().getLastName());
	}
	
	
	public void setSubmitListener(ActionListener e){
		this.okay.addActionListener(e);
	}

}
