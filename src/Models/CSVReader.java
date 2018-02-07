package Models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class CSVReader {
	public static void loadFlights(Airport airport){
		String flightFile = "flights.csv";
		String bookingFile = "bookings.csv";
		
		try(Stream<String> stream = Files.lines(Paths.get(flightFile))){
			//read the file in here
			stream.forEach(e ->{
				String[] words = e.split(",");
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
						Boolean.parseBoolean(words[3])
						));
			});
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
