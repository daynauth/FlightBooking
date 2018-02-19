package Models;

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
		double fee = 0;
		
		for(int i = 0; i < passenger.getNumBaggage(); i++){
			fee += baggageFeeCalculator.calculate(passenger.getBaggages().get(i));
		}
				
		
		return fee;
	}
	
	public double getBaggageFee(){
		if(baggageFee == -1)
			baggageFee = calculateBaggageFee();		
		return baggageFee;
	}
	
	public Passenger getPassenger(){
		return passenger;
	}
	
	public void checkIn(){
		if(checkedIn != true){
			checkedIn = true;
			
			
			//notify the flight that a passenger has checked in
			notifyListener();
		}
			
	}
	
	public Boolean login(int id, String lastName){
		return(this.id == id && lastName == this.passenger.getLastName());		
	}	
}
