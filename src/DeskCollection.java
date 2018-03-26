import java.util.ArrayList;
import java.util.List;

import models.simulation.AirportQueue;

public class DeskCollection {
	private List<Thread> desks;
	
	public DeskCollection(int size, AirportQueue queue) {
		this.desks = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
			this.desks.add(new Thread(new CheckInDesk(i, queue)));
		}
	}
	
	public void initialize() {
		this.desks.forEach(e -> e.start());
	}
	
	public int getLength() {
		return desks.size();
	}
}
