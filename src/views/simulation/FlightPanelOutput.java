package views.simulation;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.border.Border;
import models.ViewChangeListener;

public class FlightPanelOutput extends JEditorPane implements ViewChangeListener{	
	public FlightPanelOutput(String type, String text) {
		super(type, text);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		setEditable(false);
		setBorder(BorderFactory.createCompoundBorder(border, 
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	}
	
	public void update(String status) {
		this.setText(status);
	}
}
