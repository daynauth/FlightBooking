package Models;
public class BaggageFeeCalculator {
	private double ratePerKg;
	private double ratePerM2;
	
	public BaggageFeeCalculator(double rateK, double rateM){
		this.ratePerKg = rateK;
		this.ratePerM2 = rateM;
	}
	
	public double calculate(Baggage b){
		double rate;
		double weightFee = 0;
		double volumeFee = 0;
		
		if(b.getWeight() > 20){
			weightFee += (b.getWeight() - 20) * ratePerKg;
		}
		
		//TODO - Flight class should probably dictate this
		//set the maximum volume to check in
		double maxVolume = 60 * 40 * 100;
		if(b.getVolume() > maxVolume){
			volumeFee += (b.getVolume() - maxVolume) * ratePerM2; 
		}
		
		return weightFee + volumeFee;
	}
}
