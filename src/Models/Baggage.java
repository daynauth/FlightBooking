package Models;

public class Baggage {
	private double width;
	private double height;
	private double depth;
	private double weight;
	
	
	
	public Baggage(double width, double height, double length, double weight) {
		this.width = width;
		this.height = height;
		this.depth = length;
		this.weight = weight;
	}

	public double getVolume(){
		return width * height * depth;
	}
	
	public double getWeight(){
		return weight;
	}
}
