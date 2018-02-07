package Models;
public class BaggageFee {
	private double ratePerKg;
	private double ratePerM2;
	
	public BaggageFee(double rateK, double rateM){
		this.ratePerKg = rateK;
		this.ratePerM2 = rateM;
	}
	
	public double calculate(Baggage b){
		return ratePerKg * b.getWeight() + ratePerM2 * b.getVolume();
	}
}
