package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Booking;
import models.Passenger;
import views.CustomPanel;
import views.LoginPanel;
import views.ReceiptPanel;

public class LoginController extends Controller{
	
	private LoginPanel loginPanel;
	private Booking booking;
	
	public LoginController(MainController mainController) {
		super(mainController);

		loginPanel = new LoginPanel();
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
				
				if(booking == null)
					loginPanel.showError("Passenger not found");
				else if(booking.isCheckedIn()){
					loginPanel.showError("You have already checked in");
					loginPanel.clearInputs();
				}
				else
					mainController.setState(new BaggageController(mainController));
			}
		}
	}
}
