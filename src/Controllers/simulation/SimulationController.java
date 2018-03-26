package Controllers.simulation;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

import models.Airport;
import models.Booking;
import models.Flight;
import models.simulation.AirportSimulator;
import models.simulation.QueueObserver;
import threads.CheckedInDesk;
import views.simulation.FlightPanelOutput;
import views.simulation.SimulationGUI;

public class SimulationController extends QueueObserver {
	private final Airport airport;
	private final List<Flight> flights;
	private final SimulationGUI simUI;
	//private AirportQueue queue;
	ArrayBlockingQueue<Booking> queue;
	private List<CheckedInDesk> deskList;
	private List<FlightPanelOutput> flightPanels;
	
	public SimulationController(SimulationGUI simUI, Airport airport, ArrayBlockingQueue<Booking> queue) {
		this.airport = airport;
		this.flights = airport.getFlightList();
		this.simUI = simUI;
		this.flightPanels = simUI.getFlightPanel().getFlights();
		
		
		//setup out airport queue
		this.queue = queue;
	
				
		deskList = new ArrayList<>();

		generateDeskList();
		executeDeskThreads();
		generateFlightList();
		
		
		new Timer().schedule(new TimerTask() {
			public void run() {
				executeDeskThreads();
			}
		}, 5000);
	}
	
	public void start() {
		EventQueue.invokeLater(() ->{
			this.simUI.showGUI();
		});	
	}
	
	public void generateDeskList() {
		int size = simUI.getNumDesks();
		
		for(int i = 0; i < size; i++)
			deskList.add(new CheckedInDesk(queue, simUI.getDeskOutput(i), i));
		
		deskList.forEach(e->e.AddObserver(this));
	}
	
	/**
	 * bind the each flight to a flight desk
	 */
	public void generateFlightList() {
		int size = simUI.getNumFlights();
		
		for(int i = 0; i < flights.size(); i++) {
			flightPanels.get(i).update(flights.get(i).getStatus());		
			flights.get(i).addChangeListener(flightPanels.get(i));
		}
		
	}
	
	
	public void executeDeskThreads() {
		deskList.forEach(e -> e.execute());
	}
	
	
	public void shutDownThreads() {
		deskList.forEach(e -> e.cancel(true));
	}

	@Override
	public void updateQueue() {
		String message = AirportSimulator.getQueueInfo(queue);
		this.simUI.updateQueuePanel(message);
	}
	
	
	
	public String toString() {
		return "Simulation controller";
	}
}
