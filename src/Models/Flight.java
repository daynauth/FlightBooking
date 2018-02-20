package Models;
import java.util.HashMap;

public class Flight extends FlightObservable implements FlightListener {
	private final String id;
	private final String destination;
	private final String carrier;
	private final int maxPassengers;
	private final int maxWeight;
	private final int maxVolume;
	
	private HashMap<Integer, Booking> bookings;
	private FlightListener listener;
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
		
		for(int i = 0; i< bookings.size(); i++){
			sum += bookings.get(i).getPassenger().getBaggageWeight();
		}
		
		return sum;
	}
	
	/**
	 * get the total baggage volume of all passengers
	 * @return double
	 */
	public double getTotalVolume(){
		double sum = 0;
		
		for(int i = 0; i< bookings.size(); i++){
			sum += bookings.get(i).getPassenger().getBaggageVolume();
		}
		
		return sum;
	}	
	
	/**
	 * Get an update from the booking class whenever someone has checked in
	 */
	public void updateCheckIn(){
		count++;
		
		//if the number of checked it is equal to the 
		//maxPassengers then the flight is full
		//if(count == maxPassengers || count == bookings.size())
		
		//notify the airport that a passenger have been booked
		notifyListener();	
	}
	
	
	public String toString(){
		return "Flight Code: " + id;
	}
}
