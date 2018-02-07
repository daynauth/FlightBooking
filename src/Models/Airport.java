package Models;

import java.util.HashMap;

public class Airport implements FlightObserver{
	private HashMap<String, Flight> flights;
	private HashMap<Integer, String> flightIndex; 
	private int count;
	
	public Airport(){
		flights = new HashMap<>();
		flightIndex = new HashMap<>();
		
		CSVReader.loadFlights(this);
		count = 0;
	}
	
	public void addFlight(Flight f){
		flights.put(f.getId(), f);
	}
	
	public Flight getFlight(String flightCode){
		//if null throw exception
		return flights.get(flightCode);
	}
	
	public void update(){
		count++;
		
		if(count >= flights.size()){
			//alert its observer
		}
	}
	
	/*
	 * Add booking to a particular flight
	 * */
	public void addBooking(String flightCode, Booking b){
		flights.get(flightCode).addBooking(b);
		flightIndex.put(b.getBookingId(), flightCode);
	}
	
	/*output method to show details of a flight*/
	public void showFlights(){
		flights.forEach((key, value) ->{
			System.out.println(value);
		});
	}
	
	public Passenger login(int bookingId, String lastName){
		String flightkey = flightIndex.get(bookingId);
		Passenger p = flights.get(flightkey).getBooking(bookingId).getPassenger();
				
		if(p != null && p.getLastName().equals(lastName))
			return p;
		else
			return null;
		
	}
}
