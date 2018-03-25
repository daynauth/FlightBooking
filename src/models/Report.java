package models;

import java.util.HashMap;

public class Report {
	private Airport airport;
	
	public Report(Airport airport){
		this.airport = airport;
	}
	
	public String generate(){
		String text = "";
		HashMap<String, Flight> flights = airport.getFlights();
		for(String key: flights.keySet()){
			if(flights.get(key).getBookings().size() != 0);
				text += displayFlightRecord(flights.get(key));
		}
		return text;
	}
	
	private String displayFlightRecord(Flight flight){
		return "Flight ID: " + flight.getId() + "\n" + 
				getFlightSummary(flight) + getDivider();
	}
	
	private String getFlightSummary(Flight flight){
		if(flight != null || flight.getBookings().size() != 0) {
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
		return "Total Baggage Volume: " + flight.getTotalVolume() + "\n";
	}
	
	private String getDivider(){
		return "\n--------------------------------------------------\n";
	}
	
}
