import java.util.concurrent.ArrayBlockingQueue;
import Controllers.simulation.SimulationController;
import models.Airport;
import models.Booking;
import models.CSVReader;
import models.simulation.AirportSimulator;
import singleton.TaskLogger;
import views.simulation.SimulationGUI;

public class App {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	        	//write out the log to a file when shut down happens
	           TaskLogger.getInstance().writeToFile("logfile.txt");
	        }
	    }, "Shutdown-thread"));
		
		//set the number of threads for sign in desks
		int numThreads = 3;
		
		//start the simulation
		startSimulation(numThreads);
	}
	
	/**
	 * Stage 1
	 */
	public static void SignIn() {
		//MainGUI gui = new MainGUI();
		//MainController controller = new MainController(airport, gui);
		//controller.start();	
	}
	
	/**
	 * Stage 2
	 * @param num
	 */
	public static void startSimulation(int num) {
		
		//create the airport class and load the data from the csv file
		Airport airport = new Airport();
		CSVReader.loadFlights(airport);
		
		//create the global blocking queue for producer and consumer
		ArrayBlockingQueue<Booking> queue = new ArrayBlockingQueue<Booking>(airport.getNumPassengers());
		
		//airport simulator adds passengers to the queue at random intervals
		AirportSimulator a = new AirportSimulator(airport, queue);
		
		//initialize the ui
		SimulationGUI simUI = new SimulationGUI(num, airport.getFlights().size());
		
		//create and start the producer thread
		Thread t = new Thread(a);
		
		//start the controller
		SimulationController simController = new SimulationController(simUI, airport, queue);
		a.AddObserver(simController);
		t.start();
		simController.start();	
	}

}
