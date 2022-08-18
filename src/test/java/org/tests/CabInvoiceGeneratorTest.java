package org.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class CabInvoiceGeneratorTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGeneratorTest invoiceGenerator = new CabInvoiceGeneratorTest();
		double distance = 1.0;
		int time = 10;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(20.0, fare, 0.0);
	}
	private double calculateFare(double distance, int time) {
				return 0;
	}	
}

