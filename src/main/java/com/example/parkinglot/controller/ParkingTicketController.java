package com.example.parkinglot.controller;

import com.example.parkinglot.model.EntryPoint;
import com.example.parkinglot.model.ExitPoint;
import com.example.parkinglot.model.ParkingCharge;
import com.example.parkinglot.model.ParkingTicket;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.service.ParkingTicketService;

public class ParkingTicketController {

	private ParkingTicketService parkingTicketService;

	public ParkingTicketController(ParkingTicketService parkingTicketService) {
		super();
		this.parkingTicketService = parkingTicketService;
	}

	public ParkingTicket createParkingTicket(EntryPoint entryPoint, Vehicle vehicle) {
		return parkingTicketService.createParkingTicket(entryPoint, vehicle);
	}
	
	public ParkingCharge closeParkingTicket(ExitPoint exitPoint, ParkingTicket parkingTicket) {
		return parkingTicketService.closeParkingTicket(exitPoint, parkingTicket);
	}
}
