import models.Booking;
import models.simulation.AirportQueue;

/**
 * Check in desk to process the first passenger in the line
 * @author roland
 *
 */
public class CheckInDesk implements Runnable {
	private final int id;
	private AirportQueue queue;
	
	
	public CheckInDesk(int id, AirportQueue queue) {
		this.id = id;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(!queue.isEmpty()) {
			try {
				Thread.sleep(100);
				Booking b = this.queue.remove();
				if( b != null) {
					//calculate baggage fee
					double fee = b.getBaggageFee();
					
					System.out.println(b.getPassengerFirstName() +
							" " + b.getPassengerLastName() + 
							" is dropping off 1 bag of " + 
							b.getPassengerBaggageWeight() + "kg. " + 
							"A baggage fee of " + b.getBaggageFee() + 
							" is due.");
					
					b.checkIn();	
				}
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	

}
