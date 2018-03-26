package models.simulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import models.Airport;
import models.Baggage;
import models.Booking;
import singleton.TaskLogger;

public class AirportSimulator implements Runnable{
	private Airport airport;
	private BlockingQueue<Booking> queue;
	private List<QueueObserver> queueObservers = new ArrayList<>();
	
	
	public AirportSimulator(Airport airport, BlockingQueue<Booking> queue) {
		this.airport = airport;
		this.queue = queue; 
	}
	
	
	public void generateQueue() {
		Random random = new Random();
		
		airport.getFlights().forEach((k,v) ->{
			v.getBookings().forEach((r,s) ->{
				try {
					Thread.sleep(random.nextInt(3000));
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				s.getPassenger().addBaggage(generateRandomBaggage());
				if(!s.isCheckedIn()) {
					try {
						queue.put(s);
						
						//notify the controller of the change
						notifyObserver();
						
						//log the task
						TaskLogger.getInstance().add("JOIN QUEUE: " + s);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				}
			});
		});
	}
	
	public void notifyObserver() {
		queueObservers.forEach(e -> e.updateQueue());
	}
	
	public void run() {
		generateQueue();
	}
	
	public static Baggage generateRandomBaggage() {
		int width = randomDimension(1, 30);
		int height = randomDimension(1, 40);
		int depth = randomDimension(1, 30);
		int weight = randomDimension(1, 100);
		
		return new Baggage(width, height, depth, weight);
	}
	
	public static int randomDimension(int min, int max) {
		Random r = new Random();
		return r.nextInt(max) + min;
	}
	
	public void AddObserver(QueueObserver o) {
		queueObservers.add(o);
	}
	
	public static String getQueueInfo(ArrayBlockingQueue<Booking> q) {
		String peopleMessage = "people";
		if(q.size() < 2) peopleMessage = "person";
		return "There are currently " + q.size() + " " + peopleMessage + " waiting in the queue\n" + getMembersInQueue(q);
	}
	
	public static String getMembersInQueue(ArrayBlockingQueue<Booking> q) {
		String message = "";
		
		Iterator<Booking> ite = q.iterator();
		while(ite.hasNext()) {
			message+=ite.next() + "\n";
		}
		
		return message;
	}
}
