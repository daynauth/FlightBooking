package threads;

import java.util.List;
import java.util.Random;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import models.Booking;
import models.simulation.AirportQueue;
import singleton.TaskLogger;

public class CheckedInDesk extends SwingWorker<Void, String>{
	private AirportQueue queue;
	private JTextArea textArea;
	private final int max = 8000;
	private final int min = 4000;
	
	public CheckedInDesk(AirportQueue queue, JTextArea textArea) {
		this.queue = queue;
		this.textArea = textArea;
	}

	@Override
	protected Void doInBackground() throws Exception {
		Random r = new Random();
		while(!queue.isEmpty()) {
			Thread.sleep(r.nextInt(max - min) + min);
			Booking b = queue.remove();
			
			if( b != null) {				
				publish(getMessage(b));
				b.checkIn();
				TaskLogger.getInstance().add("CHECKEDIN: " + b);
			}
		}
		return null;
	}
	
	@Override
	protected void process(List<String> chunks) {
		textArea.setText(chunks.get(chunks.size() - 1));
	}
	
	public String getMessage(Booking b) {
		return b.getPassengerFirstName() +
		" " + b.getPassengerLastName() + 
		" is dropping off 1 bag of " + 
		b.getPassengerBaggageWeight() + "kg. " + 
		"A baggage fee of " + b.getBaggageFee() + 
		" is due.\n";
	}

}
