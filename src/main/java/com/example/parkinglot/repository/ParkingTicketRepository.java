package com.example.parkinglot.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.parkinglot.model.ParkingTicket;

public class ParkingTicketRepository {

	private List<ParkingTicket> parkingTickets;
	
	public ParkingTicketRepository() {
		parkingTickets = new ArrayList<>();
	}
	
	public List<ParkingTicket> getAllParkingTickets(){
		return parkingTickets;
	}
	
	public void addParkingTicket(ParkingTicket parkingTicket) {
		parkingTickets.add(parkingTicket);
	}

	public boolean remove(ParkingTicket parkingTicket) {
		return parkingTickets.remove(parkingTicket);
	}
}
