package models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import exceptions.AirlineCodeException;
import exceptions.FlightIntegerException;


public class CSVReader {
	public static void loadFlights(Airport airport){
		String flightFile = "flights.csv";
		String bookingFile = "bookings.csv";
		
		try(Stream<String> stream = Files.lines(Paths.get(flightFile))){
			//read the file in here
			stream.forEach(e ->{
				String[] words = e.split(",");
				
				//handle exception for Flight information
				if(!words[0].matches("^[a-b0-9A-Z]*$"))
					try {
						throw new AirlineCodeException("Airline code must be alphanumeric");
					} catch (AirlineCodeException e1) {
						e1.printStackTrace();
					}
				
				if(!words[3].matches("^[0-9]*$"))
					try {
						throw new FlightIntegerException("Number of Passengers Must be a number");
					} catch (FlightIntegerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				if(!words[4].matches("^[0-9]*$"))
					try {
						throw new FlightIntegerException("MAx Weight must be a number");
					} catch (FlightIntegerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				if(!words[5].matches("^[0-9]*$"))
					try {
						throw new FlightIntegerException("MAx Weight must be a number");
					} catch (FlightIntegerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				airport.addFlight(
						new Flight(
								words[0], 
								words[1], 
								words[2], 
								Integer.parseInt(words[3].trim()), 
								Integer.parseInt(words[4].trim()), 
								Integer.parseInt(words[5].trim())));
			});
		}catch(IOException e){
			e.printStackTrace();
			e.getMessage();
		}
		
		try(Stream<String> stream = Files.lines(Paths.get(bookingFile))){
			stream.forEach(e ->{
				String[] words = e.split(",");
				
				airport.addBooking(words[3], new Booking(
						Integer.parseInt(words[0]), 
						new Passenger(words[1], words[2]), 
						Boolean.parseBoolean(words[4])
						));
			});
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
