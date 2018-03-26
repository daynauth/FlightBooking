package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import models.Booking;
import models.simulation.QueueObserver;
import singleton.TaskLogger;

public class CheckedInDesk extends SwingWorker<Void, String>{
	private ArrayBlockingQueue<Booking> queue;
	private int id;
	private JTextArea textArea;
	private final int max = 8000;
	private final int min = 3000;
	private List<QueueObserver> queueObservers = new ArrayList<>();
	
	public CheckedInDesk(ArrayBlockingQueue<Booking> queue, JTextArea textArea, int id) {
		this.queue = queue;
		this.textArea = textArea;
		this.id = id;
	}

	@Override
	protected Void doInBackground() throws Exception {
		Random r = new Random();
		while(true) {
			Thread.sleep(r.nextInt(max - min) + min);
			Booking b = queue.remove();
			
			if( b != null) {				
				publish(getMessage(b));
				b.checkIn();
				notifyObserver();
				TaskLogger.getInstance().add("CHECKEDIN: " + b);
			}
		}
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
		"A baggage fee of " + String.format( "%.2f", b.getBaggageFee() ) + 
		" is due.\n";
	}
	
	public void notifyObserver() {
		queueObservers.forEach(e -> e.updateQueue());
	}
	
	public void AddObserver(QueueObserver o) {
		queueObservers.add(o);
	}

	@Override
	protected void done() {
		publish("Desk " + id + " is closed");
	}
	
	

}
