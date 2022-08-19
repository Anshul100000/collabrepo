package org.tests;
import java.util.HashMap;
public class RideRepo {
	private HashMap<Integer , Ride[]> RIDE_REPOSITORY;
	private Integer USER_ID = null;
	
	/** Parameterized Constructor. 
	 * @return **/
	public void RideRepository(HashMap<Integer, Ride[]> RIDE_REPOSITORY, Integer USER_ID) {
		this.RIDE_REPOSITORY = RIDE_REPOSITORY;
		this.USER_ID = USER_ID;
	}	

	/** Calculation of total Fare. **/
	public InvoiceSummery calculateFare() {
		if(this.USER_ID == null || this.RIDE_REPOSITORY.get(USER_ID) == null) {
			throw new NullPointerException("Null value is not allowed,");
		}
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		Ride[] userRideDetails = this.RIDE_REPOSITORY.get(USER_ID);
		
		double totalFare = 0;
		
		for (Ride ride : userRideDetails) {
			totalFare += invoiceGenerator.calculateFare(ride.DISTANCE, ride.TIME);   //Gives total Fare.
		}
		return new InvoiceSummery(userRideDetails.length, totalFare);
	}
}