package Models;

public abstract class FlightObservable {
	protected FlightListener listener;
	
	public void addListener(FlightListener l){
		this.listener = l;
	}
	
	public void notifyListener(){
		listener.updateCheckIn();
	}
}
