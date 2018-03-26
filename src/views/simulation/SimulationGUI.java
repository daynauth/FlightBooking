package views.simulation;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SimulationGUI extends JFrame{
	private SigninDeskPanel signinPanel;
	private QueuePanel queuePanel;
	private FlightPanel flightPanel;
	private final int numDesks;
	private final int numFlights;
	private static final int width = 800;
	private static final int height = 600;
	
	public SimulationGUI(int numDesks, int numFlights) {
		this.numDesks = numDesks;
		this.numFlights = numFlights;
		
		//create the sign in desks
		this.signinPanel = new SigninDeskPanel(numDesks);
		
		//create the queue panel
		this.queuePanel = new QueuePanel();
		this.queuePanel.getTextArea().setPreferredSize(new Dimension(width,height/3));
		
		//create flight panels
		this.flightPanel = new FlightPanel(numFlights);
		this.flightPanel.getFlights().forEach(e ->{
			e.setPreferredSize(new Dimension(width/numFlights, height/3));
		});
		
		
		setupPanels();
	}
	
	public QueuePanel getQueuePanel() {
		return queuePanel;
	}

	public void setQueuePanel(QueuePanel queuePanel) {
		this.queuePanel = queuePanel;
	}

	public FlightPanel getFlightPanel() {
		return flightPanel;
	}

	public void setFlightPanel(FlightPanel flightPanel) {
		this.flightPanel = flightPanel;
	}

	public int getNumDesks() {
		return this.numDesks;
	}
	
	public int getNumFlights() {
		return this.numFlights;
	}
	
	public void showGUI(){
		this.setTitle("CheckIn Simulation System");
		this.setSize(width, height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public void setupPanels() {
		setLayout(new BorderLayout());
		add(signinPanel, BorderLayout.CENTER);
		add(queuePanel, BorderLayout.PAGE_START);
		add(flightPanel, BorderLayout.PAGE_END);
		
	}
	
	public SigninDeskPanel getSigninPanel() {
		return this.signinPanel;
	}
	
	public JTextArea getDeskOutput(int i) {
		return this.signinPanel.getDesks().get(i);
	}

	public void setSigninPanel(SigninDeskPanel signinPanel) {
		this.signinPanel = signinPanel;
	}
	
	public void updateQueuePanel(String message) {
		this.queuePanel.getTextArea().setText(message);
	}
	
}
