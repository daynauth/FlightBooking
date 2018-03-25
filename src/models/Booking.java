package models;

public class Booking extends FlightObservable{
	private final int id;
	private final Passenger passenger;
	private Boolean checkedIn;
	private BaggageFeeCalculator baggageFeeCalculator;
	private double baggageFee;
	
	public Booking(int id, Passenger p, boolean checkedIn){
		this.id = id;
		this.passenger = p;
		this.checkedIn = checkedIn;
		this.baggageFeeCalculator = new BaggageFeeCalculator(0.2, 0.4);
		this.baggageFee = -1;
	}
	
	public int getBookingId(){
		return id;
	}
	
	public Boolean isCheckedIn(){
		return checkedIn;
	}
	
	public double calculateBaggageFee(){	
		return this.baggageFeeCalculator.calculate(passenger.getBaggage());
	}
	
	public double getBaggageFee(){
		if(baggageFee == -1)
			baggageFee = calculateBaggageFee();		
		return baggageFee;
	}
	
	public Passenger getPassenger(){
		return passenger;
	}
	
	/**
	 * Encapsulate the passenger's first name
	 * @return String
	 */
	public String getPassengerFirstName() {
		return passenger.getFirstName();
	}
	
	/**
	 * Encapsulate the passenger's last name
	 * @return String
	 */
	public String getPassengerLastName() {
		return passenger.getLastName();
	}
	
	/**
	 * Encapsulate the passenger's baggage weight
	 * @return double
	 */
	public double getPassengerBaggageWeight() {
		return passenger.getBaggageWeight();
	}
	
	public double getVolume() {
		if(this.checkedIn == false)return 0;
		return passenger.getBaggageVolume();
	}
	
	public void checkIn(){
		if(checkedIn == false){
			checkedIn = true;
			
			
			//notify the flight that a passenger has checked in
			notifyListener();
		}
			
	}
	
	public Boolean login(int id, String lastName){
		return(this.id == id && lastName == this.passenger.getLastName());		
	}	
	
	public String toString() {
		return id + "  " + passenger.getFirstName() + "  " + passenger.getBaggageWeight() + "kg  " + passenger.getBaggageDimensions();
	}
}
