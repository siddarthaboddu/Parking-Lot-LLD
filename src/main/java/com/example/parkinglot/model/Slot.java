package com.example.parkinglot.model;

import java.util.ArrayList;
import java.util.List;

public class Slot {

	private SlotLocation slotLocation;
	private List<Vehicle> vehicles;
	private int maxCapacity;
	private int currentCapacity;

	public Slot(SlotLocation slotLocation, List<Vehicle> vehicles) {
		super();
		this.slotLocation = slotLocation;
		this.vehicles = vehicles;
	}

	public Slot(SlotLocation slotLocation, int maxCapacity) {
		super();
		this.slotLocation = slotLocation;
		this.vehicles = new ArrayList<>();
		this.maxCapacity = maxCapacity;
		this.currentCapacity = maxCapacity;
	}

	public SlotLocation getSlotLocation() {
		return slotLocation;
	}

	public void setSlotLocation(SlotLocation slotLocation) {
		this.slotLocation = slotLocation;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	@Override
	public String toString() {
		return "Slot [slotLocation=" + slotLocation + ", vehicles=" + vehicles + ", maxCapacity=" + maxCapacity
				+ ", currentCapacity=" + currentCapacity + "]";
	}

	
}
