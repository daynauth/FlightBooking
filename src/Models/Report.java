package Models;

import java.util.HashMap;

public class Report {
	private Airport airport;
	
	public Report(Airport airport){
		this.airport = airport;
	}
	
	public void generate(){
		HashMap<String, Flight> flights = airport.getFlights();
		for(String key: flights.keySet()){
			System.out.println(displayFlightRecord(flights.get(key)));
		}
	}
	
	private String displayFlightRecord(Flight flight){
		return "Flight ID: " + flight.getId() + "\n" + 
				getFlightSummary(flight) + getDivider();
	}
	
	private String getFlightSummary(Flight flight){
		if(flight != null) {
			return numCheckedIn(flight) + flightBaggageWeight(flight) + 
					flightBaggageVolume(flight); 
		}
		return "";		
	}
	
	private String numCheckedIn(Flight flight){
		return "Checked In: " + flight.getCount() + "\n";
	}
	
	private String flightBaggageWeight(Flight flight){
		return "Total Baggage Weight: " + flight.getTotalWeight() + "\n";
	}
	
	private String flightBaggageVolume(Flight flight){
		return "Total Baggage Weight: " + flight.getTotalVolume() + "\n";
	}
	
	private String getDivider(){
		return "\n--------------------------------------------------\n";
	}
	
}
