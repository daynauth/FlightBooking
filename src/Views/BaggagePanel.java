package Views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JLabel weightError;
	private JLabel heightError;
	private JLabel depthError;
	private JLabel widthError;
	private JButton okay;
	
	
	public BaggagePanel(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.NONE;
		
		//First Row
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 3;
		welcome = new JLabel("Welcome");
		this.add(welcome, gc);
		
		//Second Row
		gc.gridwidth = 1;
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		weightLabel = new JLabel("Bag Weight (kg)");
		this.add(weightLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		weight = new JTextField(20);
		this.add(weight, gc);
		
//		gc.gridx = 2;
//		gc.gridy = 1;
//		weightError = new JLabel("An Integer should be entered here");
//		weightError.setVisible(false);
//		this.add(weightError, gc);
		
		//Third Row
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 2;
		heightLabel = new JLabel("Bag Height (cm)");
		this.add(heightLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		height = new JTextField(20);
		this.add(height, gc);
		
//		gc.gridx = 2;
//		gc.gridy = 2;
//		heightError = new JLabel("An Integer should be entered here");
//		this.add(heightError, gc);
		
		//Fourth Row
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 3;
		widthLabel = new JLabel("Bag Width (cm)");
		this.add(widthLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		width = new JTextField(20);
		this.add(width, gc);
		
//		gc.gridx = 2;
//		gc.gridy = 3;
//		widthError = new JLabel("An Integer should be entered here");
//		widthError.setVisible(false);
//		this.add(widthError, gc);
		
		//Fifth Row
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 4;
		depthLabel = new JLabel("Bag Depth (cm)");
		this.add(depthLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		depth = new JTextField(20);
		this.add(depth, gc);
		
//		gc.gridx = 2;
//		gc.gridy = 4;
//		depthError = new JLabel("An Integer should be entered here");
//		depthError.setVisible(false);
//		this.add(depthError, gc);
		
		//Sixth Row
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 1;
		gc.gridy = 5;
		okay = new JButton("Okay");
		this.add(okay, gc);
		
		
		//error section
		JPanel errorPanel = new JPanel();
		gc.gridx = 2;
		gc.gridy = 0;
		

	
		gc.gridx = 2;
		gc.gridy = 1;
		weightError = new JLabel("An Integer should be entered here");
		weightError.setVisible(false);
		weightError.setForeground(Color.RED);
		this.add(weightError, gc);
	
		gc.gridx = 2;
		gc.gridy = 2;
		heightError = new JLabel("An Integer should be entered here");
		heightError.setVisible(false);
		heightError.setForeground(Color.RED);
		this.add(heightError, gc);
		
		gc.gridx = 2;
		gc.gridy = 3;
		widthError = new JLabel("An Integer should be entered here");
		widthError.setVisible(false);
		widthError.setForeground(Color.RED);
		this.add(widthError, gc);
		
		gc.gridx = 2;
		gc.gridy = 4;
		depthError = new JLabel("An Integer should be entered here");
		depthError.setVisible(false);
		depthError.setForeground(Color.RED);
		this.add(depthError, gc);
		
		//gc2.gridx = 0;
		//gc2.gridy = 2;
		//depthError = new JLabel("An Integer should be entered here");
		//depthError.setVisible(false);
		//errorPanel.add(depthError, gc2);
		
		this.add(errorPanel, gc);
		
		
	}
		
	
	public int getBaggageHeight(){
		return filter(this.height.getText());
	}
	
	public int getBaggageWidth(){
		return filter(this.width.getText());
	}
	
	public int getBaggageDepth(){
		return filter(this.depth.getText());
	}
	
	public int getBaggageWeight(){
		return filter(this.weight.getText());
	}
	
	public int filter(String s) {
		if(s.matches("^[0-9]+$")) return Integer.parseInt(s);
		else return -1;
	}
	
	
	
	public JLabel getWeightError() {
		return weightError;
	}


	public void setWeightError(JLabel weightError) {
		this.weightError = weightError;
	}


	public JLabel getHeightError() {
		return heightError;
	}


	public void setHeightError(JLabel heightError) {
		this.heightError = heightError;
	}


	public JLabel getDepthError() {
		return depthError;
	}


	public void setDepthError(JLabel depthError) {
		this.depthError = depthError;
	}


	public JLabel getWidthError() {
		return widthError;
	}


	public void setWidthError(JLabel widthError) {
		this.widthError = widthError;
	}


	public void setWelcome(Booking b){
		welcome.setText("Welcome, " + b.getPassenger().getFirstName() + " " + b.getPassenger().getLastName());
	}
	
	
	public void setSubmitListener(ActionListener e){
		this.okay.addActionListener(e);
	}
	
	public void showError(String message){
		JOptionPane.showMessageDialog(this, message);
	}

}
