package com.example.parkinglot.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.parkinglot.model.Slot;
import com.example.parkinglot.model.SlotLocation;

public class SlotRepository {

	private List<Slot> parkingSlots;

	public SlotRepository() {
		super();
		this.parkingSlots = new ArrayList<>();
	}

	public SlotRepository(int rows, int floors, int maxCapacity) {
		super();
		this.parkingSlots = new ArrayList<>();

		for (int floor = 1; floor <= floors; floor++) {
			for (int row = 1; row <= rows; row++) {
				parkingSlots.add(new Slot(new SlotLocation(row, floor), maxCapacity));
			}
		}
	}

	public void addSlot(Slot slot) {
		parkingSlots.add(slot);
	}

	public void removeSlot(Slot slot) {
		parkingSlots.remove(slot);
	}
	
	public List<Slot> getAllSlots(){
		return new ArrayList<>(parkingSlots);
	}

}
