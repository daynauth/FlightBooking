package models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Flight extends FlightObservable implements FlightListener {
	private final String id;
	private final String destination;
	private final String carrier;
	private final int maxPassengers;
	private final int maxWeight;
	private final int maxVolume;
	
	private HashMap<Integer, Booking> bookings;
	
	//binding a view to the changes made on the airport
	private List<ViewChangeListener> viewListeners = new ArrayList<>();
	
	private int count;
	private boolean full;
	private String status;
	
	
	
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
	
	public int getCount(){
		return this.count;
	}
	
	public HashMap<Integer, Booking> getBookings() {
		return bookings;
	}

	public Booking getBooking(int bookingId){
		return bookings.get(bookingId);
	}
	
	public void addBooking(Booking b){
		bookings.put(b.getBookingId(), b);
		
		//if the passenger has already checked in then notify the flight
		if(b.isCheckedIn())
			notifyListener();		
		b.addListener(this);
	}
	
	/**
	 * get the total baggage weight of all passengers
	 * @return double
	 */
	public double getTotalWeight(){
		double sum = 0;
		
		for(Integer key: bookings.keySet()){
			sum += bookings.get(key).getPassenger().getBaggageWeight();
		}
		
		
		return sum;
	}
	
	/**
	 * get the total baggage volume of all passengers
	 * @return double
	 */
	public double getTotalVolume(){
		double sum = 0;
		
		for(Integer key: bookings.keySet()){
			sum += bookings.get(key).getVolume();
		}
		
		return sum;
	}	
	
	/**
	 * Get an update from the booking class whenever someone has checked in
	 */
	public void updateCheckIn(){
		count++;
		notifyListener();
		
		viewListeners.forEach(e -> e.update(getStatus()));
	}
	
	
	public String toString(){
		return "Flight Code: " + id;
	}
	
	public String getStatus() {
		return getInfo() + getCheckedInStatus() + getVolumeStatus();
	}
	
	public String getInfo() {
		return "<strong>" + id + " " + carrier +  "</strong>" +  "<br>";
	}
	
	public String getCheckedInStatus() {
		return this.count + " checked in of " + this.maxPassengers + "<br>";
	}
	
	public String getVolumeStatus() {
		String percentage = String.format("%.2f", (this.getTotalVolume()/this.getMaxVolume())*100);
		return "Hold is " + percentage + "% full <br>";
	}
	
	public void addChangeListener(ViewChangeListener v) {
		this.viewListeners.add(v);
	}
}
