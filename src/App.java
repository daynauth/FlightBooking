import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import Controllers.simulation.SimulationController;
import models.Airport;
import models.Booking;
import models.CSVReader;
import models.simulation.AirportSimulator;
import singleton.TaskLogger;
import views.MainGUI;
import views.simulation.SimulationGUI;

public class App {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	        	//write out the log to a file when shut down happens
	           TaskLogger.getInstance().writeToFile("logfile.txt");
	        }
	    }, "Shutdown-thread"));
		
		startSimulation();
		//MainGUI gui = new MainGUI();
		//MainController controller = new MainController(airport, gui);
		//controller.start();
	}
	
	
	public static void startSimulation() {
		//create the airport class and load the data from the csv file
		Airport airport = new Airport();
		CSVReader.loadFlights(airport);
		
		ArrayBlockingQueue<Booking> queue = new ArrayBlockingQueue<Booking>(airport.getNumPassengers());
		AirportSimulator a = new AirportSimulator(airport, queue);
		

		
		SimulationGUI simUI = new SimulationGUI(3, airport.getFlights().size());
		
		
		Thread t = new Thread(a);
		SimulationController simController = new SimulationController(simUI, airport, queue);
		a.AddObserver(simController);
		
		t.start();
		
		
		
		simController.start();	
		
		
	}

}
