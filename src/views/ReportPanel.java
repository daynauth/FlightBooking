package views;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReportPanel extends JPanel {
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton returnButton;
	
	public ReportPanel() {
		this.textArea = new JTextArea(60, 60);
		this.scrollPane = new JScrollPane(this.textArea);
		
		setPreferredSize(new Dimension(60, 60));
		
		this.add(this.scrollPane);
		
		returnButton = new JButton("Return");
		this.add(returnButton);
	}
	
	public void setText(String text) {
		this.textArea.setText(text);
	}
	
	public void setButtonListener(ActionListener l){
		returnButton.addActionListener(l);
	}
}
