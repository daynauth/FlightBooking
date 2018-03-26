import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Airport;
import models.Baggage;
import models.BaggageFeeCalculator;
import models.Booking;
import models.Passenger;
public class Tests {
	@Test
	void test1() {
		Airport a = new Airport();
		Passenger p = new Passenger("Wayne","Bruce");
		Booking b = new Booking(20, p, false);
		assertEquals("fail for login",b,a.login(20, p.getLastName()));
		
	}
	@SuppressWarnings("deprecation")
	@Test
	void test2() {
		BaggageFeeCalculator b = new BaggageFeeCalculator(0.2,0.4);
		Baggage bag = new Baggage(20,20,20,20);
		double answer = 0;		
		assertEquals("Wrong fee", answer, b.calculate(bag));

	}
	@SuppressWarnings("deprecation")
	@Test
	void test3() {
		BaggageFeeCalculator b = new BaggageFeeCalculator(0.2,0.4);
		Baggage bag = new Baggage(20,20,20,21);
		assertEquals("Wrong fee",0.2,b.calculate(bag));
	}
	@Test
	void test4() {
		Passenger p = new Passenger("Wayne","Bruce");
		Booking b = new Booking(20, p, false);
		b.checkIn();
		assertEquals("fail check in",true,b.isCheckedIn());	
	}
}
