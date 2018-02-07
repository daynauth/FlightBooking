package Models;
public class Booking{
	private final int id;
	private final Passenger passenger;
	private Boolean checkedIn;
	private LoginListener listener;
	private BaggageFee baggagefee;
	
	public Booking(int id, Passenger p, boolean checkedIn){
		this.id = id;
		this.passenger = p;
		this.checkedIn = checkedIn;
		this.baggagefee = new BaggageFee(0.2, 0.4);
	}
	
	public int getBookingId(){
		return id;
	}
	
	public Boolean isCheckedIn(){
		return checkedIn;
	}
	
	public double getBaggageFee(){
		double fee = 0;
		
		for(int i = 0; i < passenger.getNumBaggage(); i++){
			fee += baggagefee.calculate(passenger.getBaggages().get(i));
		}
		
		return fee;
	}
	
	public Passenger getPassenger(){
		return passenger;
	}
	
	public void checkIn(){
		if(checkedIn != true){
			checkedIn = true;
			notifyListener();
		}
			
	}
	
	public Boolean login(int id, String lastName){
		return(this.id == id && lastName == this.passenger.getLastName());		
	}
	
	
	public void addListener(LoginListener l){
		listener = l;
	}
	
	public void notifyListener(){
		listener.updateCheckIn();
	}
	
	
}
