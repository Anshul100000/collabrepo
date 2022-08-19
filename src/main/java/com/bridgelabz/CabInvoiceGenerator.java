package com.bridgelabz;

class CabInvoiceGenerator {
	public static final double COST_PER_KM=10.0;
	public static final double COST_PER_MIN=1.0;
	public static final double MIN_FARE=5;

	 double calculateFare(double distance, int time){
	        double totalFare=((distance*COST_PER_KM)+(time*MIN_FARE));
	        if (totalFare>MIN_FARE)
	            return totalFare;
	        else {
	            return MIN_FARE;
	        }
	    }
	    public static void main(String[] args) {
	        System.out.println("Welcome to cab invoice generator problem");
	    }
	}