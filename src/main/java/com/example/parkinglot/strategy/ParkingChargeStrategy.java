package com.example.parkinglot.strategy;

import com.example.parkinglot.model.ParkingCharge;
import com.example.parkinglot.model.ParkingTicket;

public interface ParkingChargeStrategy {

	ParkingCharge charge(ParkingTicket parkingTicket);

}
