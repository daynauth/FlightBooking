package Controllers.simulation;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import models.Airport;
import models.Flight;
import models.simulation.AirportQueue;
import models.simulation.QueueObserver;
import threads.CheckedInDesk;
import views.simulation.FlightPanelOutput;
import views.simulation.SimulationGUI;

public class SimulationController extends QueueObserver {
	private final Airport airport;
	private final List<Flight> flights;
	private final SimulationGUI simUI;
	private AirportQueue queue;
	private List<CheckedInDesk> deskList;
	private List<FlightPanelOutput> flightPanels;
	
	public SimulationController(SimulationGUI simUI, Airport airport) {
		this.airport = airport;
		this.flights = airport.getFlightList();
		this.simUI = simUI;
		this.flightPanels = simUI.getFlightPanel().getFlights();
		
		this.queue = new AirportQueue(airport);
		this.queue.AddObserver(this);		
		deskList = new ArrayList<>();

		generateDeskList();
		executeDeskThreads();
		generateFlightList();
	}
	
	public void start() {
		EventQueue.invokeLater(() ->{
			this.simUI.showGUI();
		});	
	}
	
	public void generateDeskList() {
		int size = simUI.getNumDesks();
		
		for(int i = 0; i < size; i++) 
			deskList.add(new CheckedInDesk(queue, simUI.getDeskOutput(i)));
	}
	
	/**
	 * bind the each flight to a flight desk
	 */
	public void generateFlightList() {
		int size = simUI.getNumFlights();
		
		for(int i = 0; i < flights.size(); i++) {
			flightPanels.get(i).update(flights.get(i).getStatus());
			
			flights.get(i).addChangeListener(flightPanels.get(i));
			//flightPanels.get(i).bindFlight(flights.get(i));
			//flightPanels.get(i).updateDisplay();
		}
		
	}
	
	public void updateFlightDisplay() {
		
	}
	
	public void executeDeskThreads() {
		deskList.forEach(e -> e.execute());
	}

	@Override
	public void updateQueue() {
		this.simUI.updateQueuePanel(queue.getQueueInfo());
	}
}
