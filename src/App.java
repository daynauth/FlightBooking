import java.util.logging.Logger;

import Controllers.simulation.SimulationController;
import models.Airport;
import models.CSVReader;
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
	    
		Airport airport = new Airport();
		CSVReader.loadFlights(airport);
		
		
		//AirportQueue queue = new AirportQueue(airport);

		
		SimulationGUI simUI = new SimulationGUI(3, airport.getFlights().size());
		SimulationController simController = new SimulationController(simUI, airport);
		simController.start();
		
		//MainGUI gui = new MainGUI();
		//MainController controller = new MainController(airport, gui);
		//controller.start();
	}

}
