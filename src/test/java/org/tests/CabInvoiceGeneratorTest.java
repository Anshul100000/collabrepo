package org.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
public class CabInvoiceGeneratorTest {

	CabInvoiceGenerator invoiceGenerator;

	@Before
	public void initialize() {
		invoiceGenerator = new CabInvoiceGenerator();
	}

	@Test
	public void givenDistanceTime_shouldReturnFare() {
		double fare = invoiceGenerator.calculateFare(2.0, 5);
		assertEquals(fare, 25);
	}

	@Test
	public void givenDistanceTime_shouldReturn_minimumFare() {
		double fare = invoiceGenerator.calculateFare(0.2, 1);
		assertEquals(fare, 5);
	}
	/** STEP-2:- Multiple Rides. **/
	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.3, 2) };

		InvoiceSummery invoiceSummary = invoiceGenerator.calculateFare(rides);
		InvoiceSummery expectedInvoiceSummary = new InvoiceSummery(2, 30);
		assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
	@Test
	public void givenRideRepository_whenGivenUserID_shouldReturnInvoice() {
		HashMap<Integer, Ride[]> rideRepo = new HashMap<Integer, Ride[]>();

		Ride[] ride1 = {new Ride(2.0 , 5) , new Ride(0.2 , 1)};
		Ride[] ride2 = {new Ride(10.0 , 2) , new Ride(5.0 , 1)};
		Ride[] ride3 = {new Ride(7.0 , 3) , new Ride(5.0 , 1)};
		Ride[] ride4 = {new Ride(4.0 , 3) , new Ride(5.0 , 4)};

		rideRepo.put(1, ride1);
		rideRepo.put(2, ride2);
		rideRepo.put(3, ride3);
		rideRepo.put(4, ride4);

		int userID = 1;

		RideRepo rideRepository = new RideRepo();

		InvoiceSummery invoiceSummary = rideRepository.calculateFare();       //actual output

		InvoiceSummery expectedInvoiceSummary = new InvoiceSummery(2, 30.0);  //expected output as number of rides(2) in userID=1, total fare as 30.0. 
		assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}