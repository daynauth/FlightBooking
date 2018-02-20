package Models;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	/**
	 * Get the total baggage weight of a passenger
	 * @return double
	 */
	public double getBaggageWeight(){
		double sum = 0;

		for(int i = 0; i < baggages.size(); i++){
			sum += baggages.get(i).getWeight();
		}
		
		return sum;
	}
	
	/**
	 * Get the total baggage volume of a passenger
	 * @return
	 */
	public double getBaggageVolume(){
		double sum = 0;

		for(int i = 0; i < baggages.size(); i++){
			sum += baggages.get(i).getVolume();
		}
		
		return sum;	
	}
	
	public String toString(){
		return lastName + ", " + firstName;
	}
}
