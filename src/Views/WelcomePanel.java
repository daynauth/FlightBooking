package Views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel{
	private JLabel text;
	private JButton button;
	
	public WelcomePanel(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		text = new JLabel("Welcome to the airport checkin system");
		this.add(text, gc);
		
		
		gc.gridx = 0;
		gc.gridy = 1;
		button = new JButton();
		this.add(button, gc);
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
