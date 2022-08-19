package org.tests;

import static org.junit.Assert.assertEquals;

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
}