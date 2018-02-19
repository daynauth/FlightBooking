package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Booking;
import Models.Passenger;
import Views.CustomPanel;
import Views.ReceiptPanel;
import Views.LoginPanel;

public class LoginController extends Controller{
	
	private LoginPanel loginPanel;
	
	private ReceiptPanel feePanel;
	private Passenger passenger;
	private Booking booking;
	//private MainController mainController;
	
	public LoginController(MainController mainController) {
		super(mainController);

		loginPanel = new LoginPanel();
		loginPanel.getNameField().setText("Wayne");
		loginPanel.getBookingField().setText("20");
		loginPanel.submitActionListener(new SubmitAction());
	}
	

	public void setPanel(){
		mainController.getGUI().replacePanel(this.loginPanel);
	}
	
	public ActionListener getActionListener(){
		return new SubmitAction();
	}
	
	public class SubmitAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(loginPanel.getBookingId().equals("") || loginPanel.getLastName().equals("")){
				loginPanel.showError("Please fill all fields");
			}
			else{
				//TODO - add validation for integers
				booking = mainController.getAirport().login(Integer.parseInt(loginPanel.getBookingId()), loginPanel.getLastName());
				mainController.addBooking(booking);
				
				if(booking == null){
					loginPanel.showError("Passenger not found");
				}
				else{
					mainController.setState(new BaggageController(mainController));
				}
			}
			
		}
	}
}
