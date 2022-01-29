package com.example.parkinglot.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.parkinglot.model.Car;
import com.example.parkinglot.model.Slot;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.repository.SlotRepository;

public class AnalyticsService {

	private SlotRepository slotRepository;

	public AnalyticsService(SlotRepository slotRepository) {
		super();
		this.slotRepository = slotRepository;
	}

	public List<String> getRegistrationNumberOfAllCarsOfColor(String color) {
		List<Slot> slots = slotRepository.getAllSlots();

		List<String> registrationNumbers = new ArrayList<>();

		for (Slot slot : slots) {
			for (Vehicle vehicle : slot.getVehicles()) {
				if (vehicle instanceof Car && vehicle.getColor().equals(color)) {
					registrationNumbers.add(vehicle.getRegistrationNumber());
				}
			}
		}

		return registrationNumbers;
	}

	public Slot getSlotWhereAVehicleIsParked(String registrationNumber) {
		List<Slot> slots = slotRepository.getAllSlots();

		Slot parkedSlot = null;

		for (Slot slot : slots) {
			for (Vehicle vehicle : slot.getVehicles()) {
				if (vehicle.getRegistrationNumber().equals(registrationNumber)) {
					parkedSlot = slot;
					break;
				}
			}
		}
		
		return parkedSlot;
	}

	public List<String> getSlotsNumberWithCarsWithSpecificColor(String color) {
		List<Slot> slots = slotRepository.getAllSlots();
		
		Set<String> slotNumbers = new HashSet<>();
		for(Slot slot : slots) {
			for(Vehicle vehicle : slot.getVehicles()) {
				if(vehicle instanceof Car && vehicle.getColor().equals(color)) {
					slotNumbers.add(slot.getSlotLocation().getSlotNumber());
				}
			}
		}
		
		return new ArrayList<>(slotNumbers);
	}

}
