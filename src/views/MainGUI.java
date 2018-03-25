package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGUI extends JFrame{
	private JPanel currentPanel;
	
	public MainGUI(){

	}
	
	public void replacePanel(JPanel panel){
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
		//this.pack();
	}
	
	public void showGUI(){
		this.setTitle("Flight CheckIn System");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
