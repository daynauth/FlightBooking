package Views;

import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPanel extends JPanel implements CustomPanel{
	private JTextField nameField;
	private JTextField bookingField;
	private JLabel nameLabel;
	private JLabel bookingLabel;
	private JButton loginButton;
	
	public LoginPanel(){
		nameField = new JTextField(50);
		bookingField = new JTextField(50);
		nameLabel = new JLabel("Last Name");
		bookingLabel = new JLabel("Booking Id");
		loginButton = new JButton("Login");
		
		this.add(nameLabel);
		this.add(nameField);
		this.add(bookingLabel);
		this.add(bookingField);
		this.add(loginButton);
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
