package Models;

public class Baggage {
	private double width;
	private double height;
	private double length;
	private double weight;
	
	
	
	public Baggage(double width, double height, double length, double weight) {
		this.width = width;
		this.height = height;
		this.length = length;
		this.weight = weight;
	}

	public double getVolume(){
		return width * height * length;
	}
	
	public double getWeight(){
		return weight;
	}
}
