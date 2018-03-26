package models.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import models.Airport;
import models.Baggage;
import models.Booking;
import singleton.TaskLogger;

/**
 * AirportQueue.java
 * Purpose: To simulate the sign in queue at an airport
 * @author roland
 *
 */

public class AirportQueue {
	private final List<Booking> queue;
	private int count;
	private List<QueueObserver> queueObservers;
	
	public AirportQueue(Airport airport) {
		this.queue = convertToQueue(airport);
		this.count = this.queue.size();
		this.queueObservers = new ArrayList<>();
	}
	
	/**
	 * 'Remove' the item from the queue and decrease the counter
	 * @return Booking
	 */
	public synchronized Booking remove() {
		if(!isEmpty()) {
			--count;
			notifyObserver();
			return this.queue.get(count);
		}
		return null;
	}
	
	public void notifyObserver() {
		queueObservers.forEach(e -> e.updateQueue());
	}
	
	public String getQueueInfo() {
		String peopleMessage = "people";
		if(count < 2) peopleMessage = "person";
		return "There are currently " + count + " " + peopleMessage + " waiting in the queue\n" + getMembersInQueue();
	}
	
	public String getMembersInQueue() {
		String message = "";
		for(int i = count - 1; i >= 0; i--) {
			message += queue.get(i) + "\n";
		}
		return message;
	}
	/**
	 * Check if the queue is empty
	 * @return boolean
	 */
	public synchronized boolean isEmpty() {
		return count == 0;
	}
	
	public Booking peek() {
		int temp = count;
		
		if(!isEmpty())
			return this.queue.get(--temp);
		return null;
	}
	
	public void showQueue() {
		System.out.println("There are " + this.count + " in the queue");
	}
	
	/**
	 * Static method to convert the airport into a single
	 * queue of bookings to be consumed by the checkin counter
	 * @param airport
	 * @return
	 */
	public static List<Booking> convertToQueue(Airport airport) {
		List<Booking> queue = Collections.synchronizedList(new ArrayList<>());
		
		airport.getFlights().forEach((k,v) ->{
			v.getBookings().forEach((r,s) ->{
				s.getPassenger().addBaggage(generateRandomBaggage());
				if(!s.isCheckedIn()) {
					queue.add(s);
					TaskLogger.getInstance().add("QUEUE: " + s);
				}
			});
		});
		
		Collections.shuffle(queue);
		
		return queue;
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
		this.queueObservers.add(o);
	}
}
