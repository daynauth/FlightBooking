import Models.*;
import Views.*;
import Controllers.*;

public class App {

	public static void main(String[] args) {
		Airport airport = new Airport();
		CSVReader.loadFlights(airport);
		
		MainGUI gui = new MainGUI();
		MainController controller = new MainController(airport, gui);
		controller.start();
	}

}
