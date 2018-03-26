package views.simulation;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class FlightPanel extends JPanel{
	private int size;
	private List<FlightPanelOutput> flights;
	
	public FlightPanel(int size) {
		this.size = size;
		flights = new ArrayList<>();
		
		generateFlights();
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		for(int i = 0; i< size; i++) {
			gc.gridx = i;
			gc.gridy = 0;
			add(flights.get(i), gc);
		}

		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	}
	
	public List<FlightPanelOutput> getFlights(){
		return this.flights;
	}
	
	public FlightPanelOutput getFlightDisplay(int i) {
		return this.flights.get(i);
	}
	
	private void generateFlights() {	
		for(int i = 0; i< size; i++) 
			flights.add(new FlightPanelOutput("text/html", ""));
	}
	
}
