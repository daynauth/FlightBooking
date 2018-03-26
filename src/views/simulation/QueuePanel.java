package views.simulation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class QueuePanel extends JPanel {
	private JTextArea textArea;
	
	public QueuePanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		textArea = new JTextArea();
		add(textArea, gc);
		
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	}
	
	public JTextArea getTextArea() {
		return this.textArea;
	}
}
