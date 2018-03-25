package models;

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

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
