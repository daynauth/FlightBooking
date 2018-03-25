package models;

import java.util.ArrayList;
import java.util.List;

public abstract class FlightObservable {
	protected List<FlightListener> listeners = new ArrayList<>();
	protected String status = "";
	
	public void addListener(FlightListener l){
		listeners.add(l);
	}
	
	public void removeListener(FlightListener l) {
		listeners.remove(l);
	}
	
	public void notifyListener(){		
		listeners.forEach( e->e.updateCheckIn());
	}
	
}
