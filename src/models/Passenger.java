package models;
import java.util.ArrayList;
import java.util.Arrays;

public class Passenger {
	private final String lastName;
	private final String firstName;
	private Baggage baggage;
	
	public Passenger(String l, String f){
		this.firstName = f;
		this.lastName = l;
	}
		
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public void addBaggage(Baggage b){
		this.baggage = b;
	}
	
	public Baggage getBaggage(){
		return baggage;
	}
	
	/**
	 * Get the total baggage weight of a passenger
	 * @return double
	 */
	public double getBaggageWeight(){
		if(this.baggage!= null)
			return this.baggage.getWeight();
		else return 0;
	}
	
	/**
	 * Get the total baggage volume of a passenger
	 * @return
	 */
	public double getBaggageVolume(){
		if(this.baggage == null)return 0;
		return this.baggage.getVolume();
	}
	
	public String getBaggageDimensions() {
		if(this.baggage!= null) 
			return baggage.getDepth() + "x" + baggage.getHeight() + "x" + baggage.getHeight();
		else
			return "no baggage";
	}
	
	public String toString(){
		return lastName + ", " + firstName;
	}
}
