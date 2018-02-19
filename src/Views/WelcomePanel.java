package Views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel{
	private JLabel text;
	private JButton button;
	
	public WelcomePanel(){
		text = new JLabel("Welcome to the airport checkin system");
		this.add(text);
		
		button = new JButton();
		this.add(button);
	}
	
	public void setButton(String text){
		button.setText(text);
	}
	
	public JButton getButton(){
		return button;
	}
	
	public void setButtonListener(ActionListener l){
		button.addActionListener(l);
	}
}
