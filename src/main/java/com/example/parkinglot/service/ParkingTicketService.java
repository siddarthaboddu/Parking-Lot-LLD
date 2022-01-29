package com.example.parkinglot.service;

import com.example.parkinglot.model.EntryPoint;
import com.example.parkinglot.model.ExitPoint;
import com.example.parkinglot.model.ParkingCharge;
import com.example.parkinglot.model.ParkingTicket;
import com.example.parkinglot.model.Slot;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.repository.ParkingTicketRepository;
import com.example.parkinglot.strategy.ParkingChargeStrategy;
import com.example.parkinglot.strategy.SlotAllocationStrategy;

public class ParkingTicketService {

	private SlotAllocationStrategy slotAllocationStrategy;
	private ParkingTicketRepository parkingTicketRepository;
	private ParkingChargeStrategy parkingChargeStrategy;

	public ParkingTicketService(SlotAllocationStrategy slotAllocationStrategy,
			ParkingTicketRepository parkingTicketRepository, ParkingChargeStrategy parkingChargeStrategy) {
		super();
		this.slotAllocationStrategy = slotAllocationStrategy;
		this.parkingTicketRepository = parkingTicketRepository;
		this.parkingChargeStrategy = parkingChargeStrategy;
	}

	public ParkingTicket createParkingTicket(EntryPoint entryPoint, Vehicle vehicle) {
		Slot slot = slotAllocationStrategy.getSlot(entryPoint, vehicle);

		slot.setCurrentCapacity(slot.getCurrentCapacity() - vehicle.getSize());
		System.out.println("slot.setCurrentCapacity : "+slot);
		slot.getVehicles().add(vehicle);

		ParkingTicket parkingTicket = new ParkingTicket(slot, vehicle);

		parkingTicketRepository.addParkingTicket(parkingTicket);

		return parkingTicket;
	}

	public ParkingCharge closeParkingTicket(ExitPoint exitPoint, ParkingTicket parkingTicket) {
		ParkingCharge parkingCharge = parkingChargeStrategy.charge(parkingTicket);
		boolean isClosedSuccessfully = parkingTicketRepository.remove(parkingTicket);

		if (isClosedSuccessfully) {
			Slot slot = parkingTicket.getSlot();
			slot.setCurrentCapacity(slot.getCurrentCapacity() + parkingTicket.getVehicle().getSize());
			slot.getVehicles().remove(parkingTicket.getVehicle());
			return parkingCharge;
		} else
			return new ParkingCharge(0, parkingTicket);

	}
}
