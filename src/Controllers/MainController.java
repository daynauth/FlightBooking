package Controllers;

import java.awt.EventQueue;

import Models.Airport;
import Models.Booking;
import Views.MainGUI;

public class MainController{                                                                                                                                                     
	private Controller currentController;
	private Booking booking;
	
	
	private Airport airport;
	private MainGUI gui;
	
	public MainController(Airport airport, MainGUI gui){
		this.airport = airport;
		this.gui = gui;
		
		
		Controller welcomeController = new WelcomeController(this);
		setState(welcomeController);
	}
	
	/**
	 * Check if the airport has all of their flights full
	 * @return
	 */
	public Boolean checkFull(){
		return this.airport.isFullyBooked();
	}
	
	public void start(){
		EventQueue.invokeLater(() ->{
			this.gui.showGUI();
		});
	}
	
	public Airport getAirport(){
		return this.airport;
	}
	
	public MainGUI getGUI(){
		return this.gui;
	}
	
	public void setState(Controller s){
		this.currentController = s;
		currentController.setPanel();
	}
	
	public void addBooking(Booking b){
		this.booking = b;
	}
	
	public Booking getBooking(){
		return this.booking;
	}
}
