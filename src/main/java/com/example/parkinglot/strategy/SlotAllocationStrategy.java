package com.example.parkinglot.strategy;

import com.example.parkinglot.model.EntryPoint;
import com.example.parkinglot.model.Slot;
import com.example.parkinglot.model.Vehicle;

public interface SlotAllocationStrategy {

	public Slot getSlot(EntryPoint entryPoint, Vehicle vehicle);
}
