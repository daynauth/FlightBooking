import Models.*;
import Views.*;
import Controllers.*;

public class App {

	public static void main(String[] args) {
		Airport airport = new Airport();
		LoginGUI loginGui = new LoginGUI();
		
		LoginController loginController = new LoginController(loginGui, airport);
		loginController.start();
	}

}
