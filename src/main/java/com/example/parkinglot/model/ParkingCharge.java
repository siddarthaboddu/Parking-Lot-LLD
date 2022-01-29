package com.example.parkinglot.model;

public class ParkingCharge {

	private double parkingCharge;
	private ParkingTicket parkingTicket;

	public ParkingCharge(double parkingCharge, ParkingTicket parkingTicket) {
		super();
		this.parkingCharge = parkingCharge;
		this.parkingTicket = parkingTicket;
	}

	public double getParkingCharge() {
		return parkingCharge;
	}

	public void setParkingCharge(double parkingCharge) {
		this.parkingCharge = parkingCharge;
	}

	public ParkingTicket getParkingTicket() {
		return parkingTicket;
	}

	public void setParkingTicket(ParkingTicket parkingTicket) {
		this.parkingTicket = parkingTicket;
	}

	@Override
	public String toString() {
		return "ParkingCharge [parkingCharge=" + parkingCharge + ", parkingTicket=" + parkingTicket + "]";
	}

}
