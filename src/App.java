import Models.*;
import Views.*;
import Controllers.*;

public class App {

	public static void main(String[] args) {
		Airport airport = new Airport();
		/*
		if(airport.login(50, "as") == null){
			System.out.println("passenger not found");
		}
		else{
			System.out.println("passenger found");
		}*/
		
		
		//System.out.println("count: " + airport.getCount());
		
		MainGUI gui = new MainGUI();
		MainController controller = new MainController(airport, gui);
		controller.start();
	}

}
