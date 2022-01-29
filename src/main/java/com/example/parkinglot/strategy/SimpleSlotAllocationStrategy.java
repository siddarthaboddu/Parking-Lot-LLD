package com.example.parkinglot.strategy;

import java.util.List;

import com.example.parkinglot.exception.SlotNotAvailableException;
import com.example.parkinglot.model.EntryPoint;
import com.example.parkinglot.model.Slot;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.repository.SlotRepository;

public class SimpleSlotAllocationStrategy implements SlotAllocationStrategy {

	private SlotRepository slotRepository;

	public SimpleSlotAllocationStrategy(SlotRepository slotRepository) {
		super();
		this.slotRepository = slotRepository;
	}

	public Slot getSlot(EntryPoint entryPoint, Vehicle vehicle) {
		List<Slot> slots = slotRepository.getAllSlots();

		System.out.println("vehicle: "+vehicle);
		Slot parkingSlot = null;
		for (Slot slot : slots) {
			System.out.println("slot : "+slot.toString());
//			if ((slot.getMaxCapacity() - slot.getCurrentCapacity()) >= vehicle.getSize()) {
			if (slot.getCurrentCapacity() >= vehicle.getSize()) {
				parkingSlot = slot;
				break;
			}
		}

		if(parkingSlot == null) throw new SlotNotAvailableException();
		return parkingSlot;
	}

}
