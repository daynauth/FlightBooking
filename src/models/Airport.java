package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Airport implements FlightListener{
	private HashMap<String, Flight> flights;
	private HashMap<Integer, String> flightIndex; 
	private int count;
	private Boolean fullyBooked;
	
	public Airport(){
		flights = new HashMap<>();
		flightIndex = new HashMap<>();
		count = 0;		
		fullyBooked = false;
		
	}
	
	public void addFlight(Flight f){
		flights.put(f.getId(), f);
		f.addListener(this);
	}
	
	public Flight getFlight(String flightCode){
		//if null throw exception
		return flights.get(flightCode);
	}
	
	public HashMap<String, Flight> getFlights(){
		return flights;
	}
	
	public List<Flight> getFlightList(){
		return new ArrayList<Flight>(flights.values());
	}
	
	/**
	 * 
	 * @param flightCode
	 * @param b
	 */
	public void addBooking(String flightCode, Booking b){
		flights.get(flightCode).addBooking(b);
		flightIndex.put(b.getBookingId(), flightCode);
		
		count++;
	}
	
	public int getCount(){
		return this.count;
	}
	
	/*output method to show details of a flight*/
	public void showFlights(){
		flights.forEach((key, value) ->{
			System.out.println(value);
		});
	}
	
	
	/**
	 * Check if the all the airlines are fullycheckedin
	 * @return Boolean
	 */
	public Boolean isFullyBooked(){
		return this.fullyBooked;
	}
	
	public Booking login(int bookingId, String lastName){
		String flightkey = flightIndex.get(bookingId);

		Booking booking = null;
		
		if(flightkey != null){
			Booking b = flights.get(flightkey).getBooking(bookingId);
			
			//don't let checked in passengers sign in
			if(b != null && b.getPassenger().getLastName().equals(lastName)){
				booking = b;
			}
		}
		return booking;
	}

	@Override
	public void updateCheckIn() {		
		count--;
		
		if(count == 0)
			this.fullyBooked = true;
		
	}
	
	
	public String generateReport(){
		Report report = new Report(this);
		return report.generate();
	}
}
