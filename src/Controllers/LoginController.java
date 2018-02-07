package Controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Airport;
import Models.Passenger;
import Views.LoginGUI;

public class LoginController{
	private final LoginGUI loginGUI;
	private final Airport airport;
	
	public LoginController(LoginGUI loginGUI, Airport airport){
		this.loginGUI = loginGUI;
		this.airport = airport;
		
		//System.out.println(loginGUI.getLoginButton());
		
		
		loginGUI.getLoginButton().addActionListener(e -> {
			//do something here
			Passenger passenger = airport.login(loginGUI.getBookingId(), loginGUI.getLastName());
			if(passenger == null)
				System.out.println("Passenger not found");
			else
				System.out.println("Hello " + passenger.getFirstName() + " "+ passenger.getLastName());
		});
		
		
		/*
		this.loginGUI.addLoginListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Passenger passenger = airport.login(loginGUI.getBookingId(), loginGUI.getLastName());
				if(passenger == null)
					System.out.println("Passenger not found");
				else
					System.out.println("Hello " + passenger.getFirstName() + " "+ passenger.getLastName());
			}
			
		});*/
	}
	
	public void start(){
		EventQueue.invokeLater(() ->{
			this.loginGUI.createAndShowGUI();
		});
	}
	
	
	
}
