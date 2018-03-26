package views.simulation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class SigninDeskPanel extends JPanel{
	private int size;
	private List<JTextArea> desks;
	
	public SigninDeskPanel(int size) {
		this.size = size;
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		
		desks = generateDesks();
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		for(int i = 0; i< size; i++) {
			gc.gridx = i;
			gc.gridy = 0;
			add(desks.get(i), gc);
		}

		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));		
	}
	
	public List<JTextArea> getDesks(){
		return this.desks;
	}
	
	public List<JTextArea> generateDesks(){
		List<JTextArea> list = new ArrayList<>();
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		
		for(int i = 0; i < size; i++) {
			JTextArea t = new JTextArea();
			t.setEditable(false);
			t.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			t.setLineWrap(true);
			t.setWrapStyleWord(true);
			list.add(t);
		}
		
		return list;
	}
}
