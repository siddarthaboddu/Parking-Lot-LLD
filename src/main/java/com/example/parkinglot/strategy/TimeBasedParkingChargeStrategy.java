package com.example.parkinglot.strategy;

import java.time.LocalDateTime;

import com.example.parkinglot.model.ParkingCharge;
import com.example.parkinglot.model.ParkingTicket;

public class TimeBasedParkingChargeStrategy implements ParkingChargeStrategy {

	@Override
	public ParkingCharge charge(ParkingTicket parkingTicket) {
		
		LocalDateTime parkingTime = parkingTicket.getCreateTime();
		LocalDateTime now = LocalDateTime.now();
		
		double charge = now.getHour() - parkingTime.getHour() + (10*parkingTicket.getVehicle().getSize()); //bike =1 car
		
		ParkingCharge parkingCharge = new ParkingCharge(charge, parkingTicket);
		return parkingCharge;
	}

}
