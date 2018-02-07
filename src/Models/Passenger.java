package Models;
import java.util.ArrayList;

public class Passenger {
	private final String lastName;
	private final String firstName;
	private ArrayList<Baggage> baggages;
	
	public Passenger(String l, String f){
		this.firstName = f;
		this.lastName = l;
		
		this.baggages = new ArrayList<>();
	}
	
	public int getNumBaggage(){
		return baggages.size();
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void addBaggage(Baggage b){
		baggages.add(b);
	}
	
	public ArrayList<Baggage> getBaggages(){
		return baggages;
	}
	
	public String toString(){
		return lastName + ", " + firstName;
	}
}
