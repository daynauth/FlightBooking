package Models;
import java.util.ArrayList;
import java.util.HashMap;

public class Flight implements LoginListener{
	private final String id;
	private final String destination;
	private final String carrier;
	private final int maxPassengers;
	private final int maxWeight;
	private final int maxVolume;
	
	private HashMap<Integer, Booking> bookings;
	private LoginListener listener;
	private int count;
	private boolean full;
	
	
	
	public Flight(
			String id, 
			String destination, 
			String carrier, 
			int maxPassengers, 
			int maxWeight, 
			int maxVolume){
		
		this.bookings = new HashMap<>();
		
		this.destination = destination;
		this.id = id;
		this.carrier = carrier;
		this.maxPassengers = maxPassengers;
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
		
		this.count = 0;
		this.full = false;
	}
	
	public String getId(){
		return id;
	}
	
	public String getDestination() {
		return destination;
	}

	public String getCarrier() {
		return carrier;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public int getMaxVolume() {
		return maxVolume;
	}

	public HashMap<Integer, Booking> getBookings() {
		return bookings;
	}

	public Booking getBooking(int bookingId){
		return bookings.get(bookingId);
	}
	
	public void addBooking(Booking b){
		bookings.put(b.getBookingId(), b);
		if(b.isCheckedIn())count++;		
		b.addListener(this);
	}
	
	public void updateCheckIn(){
		count++;
		
		//if the number of checked it is equal to the 
		//maxPassengers then the flight is full
		if(count == maxPassengers){
			
		}
	}
	
	public String toString(){
		return "Flight Code: " + id;
	}
}
