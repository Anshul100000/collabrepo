package org.tests;

public class CabInvoiceGenerator {
	public static final double COST_PER_KM=10.0;
	public static final double COST_PER_MIN=1.0;
	public static final double MIN_FARE=5;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
		return Math.max(totalFare, MIN_FARE);
	}

	/*** Calculate fare for multiple rides. ***/
	public InvoiceSummery calculateFare(Ride[] rides) {
		double totalFare = 0;

		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.DISTANCE, ride.TIME);
		}
		return new InvoiceSummery(rides.length, totalFare);
	}
}