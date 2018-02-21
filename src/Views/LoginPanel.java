package Views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JPanel implements CustomPanel{
	private JTextField nameField;
	private JTextField bookingField;
	private JLabel nameLabel;
	private JLabel bookingLabel;
	private JButton loginButton;
	private JLabel intro;
	
	public LoginPanel(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.NONE;
		
		//First Row
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		intro = new JLabel("Please enter your credentials");
		this.add(intro, gc);
		
		//Second Row
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.gridwidth = 1;
		bookingLabel = new JLabel("Booking Id");
		gc.anchor = GridBagConstraints.LINE_END;
		this.add(bookingLabel, gc);
		
		gc.gridy = 1;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		bookingField = new JTextField(20);
		this.add(bookingField, gc);
		
		//Third Row
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 2;
		nameLabel = new JLabel("Last Name");
		gc.anchor = GridBagConstraints.LINE_END;
		this.add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		nameField = new JTextField(20);
		this.add(nameField, gc);
			
		
		//Fourth Row
		gc.weightx = 1;
		gc.weighty = 0.5;
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		loginButton = new JButton("Login");
		this.add(loginButton, gc);
	
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getBookingField() {
		return bookingField;
	}

	public void setBookingField(JTextField bookingField) {
		this.bookingField = bookingField;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getBookingLabel() {
		return bookingLabel;
	}

	public void setBookingLabel(JLabel bookingLabel) {
		this.bookingLabel = bookingLabel;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}
	
	public void submitActionListener(ActionListener e){
		loginButton.addActionListener(e);
	}
	
	public String getBookingId(){
		return bookingField.getText();
	}
	
	public String getLastName(){
		return nameField.getText();
	}
	
	public void showError(String message){
		JOptionPane.showMessageDialog(this, message);
	}
	
	public void clearInputs(){
		nameField.setText("");
		bookingField.setText("");
	}
}
