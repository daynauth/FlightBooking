package Views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginGUI extends JFrame{
	private JTextField nameField;
	private JTextField bookingField;
	private JLabel nameLabel;
	private JLabel bookingLabel;
	private JButton loginButton;
	private JPanel panel;
	
	public LoginGUI(){
		nameField = new JTextField(50);
		bookingField = new JTextField(50);
		nameLabel = new JLabel("Last Name");
		bookingLabel = new JLabel("Booking Id");
		loginButton = new JButton("Login");
		
		panel = new JPanel();
		
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(bookingLabel);
		panel.add(bookingField);
		panel.add(loginButton);
		
		this.setContentPane(panel);
	}
	
	public void createAndShowGUI(){
		setTitle("Login to system");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		

	}
	
	public void addLoginListener(ActionListener ac){
		this.loginButton.addActionListener(ac);
	}
	
	public JButton getLoginButton(){
		return loginButton;
	}
	
	public JTextField getLastNameField(){
		return nameField;
	}
	
	public String getLastName(){
		return nameField.getText();
	}
	
	public String getBookingId(){
		return bookingField.getText();
	}
	
	public void showError(String message){
		JOptionPane.showMessageDialog(this, message);
	}
	
	public JPanel getPanel(){
		return this.panel;
	}
}
