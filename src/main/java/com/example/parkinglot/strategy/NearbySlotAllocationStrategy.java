package com.example.parkinglot.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.example.parkinglot.model.EntryPoint;
import com.example.parkinglot.model.Location;
import com.example.parkinglot.model.Slot;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.repository.SlotRepository;
import com.example.parkinglot.service.LocationService;

public class NearbySlotAllocationStrategy implements SlotAllocationStrategy {
	private SlotRepository slotRepository;
	private LocationService locationService;

	public NearbySlotAllocationStrategy(SlotRepository slotRepository, LocationService locationService) {
		super();
		this.slotRepository = slotRepository;
		this.locationService = locationService;
	}

	@Override
	public Slot getSlot(EntryPoint entryPoint, Vehicle vehicle) {
		List<Slot> slots = slotRepository.getAllSlots();
		PriorityQueue<Slot> pq = new PriorityQueue<>(new Comparator<Slot>() {
			public int compare(Slot slot1, Slot slot2) {
				double distance1 = getDistance(locationService.getLocation(entryPoint),
						locationService.getLocation(slot1));
				double distance2 = getDistance(locationService.getLocation(entryPoint),
						locationService.getLocation(slot2));

				if (distance1 - distance2 < 0)
					return -1;
				if (distance1 - distance2 == 0)
					return 0;
				return 1;
			}
		});

		Slot parkingSlot = null;

		pq.addAll(slots);

		while (!pq.isEmpty()) {
			Slot slot = pq.poll();

			if ((slot.getMaxCapacity() - slot.getCurrentCapacity()) >= vehicle.getSize()) {
				parkingSlot = slot;
				break;
			}
		}

		return parkingSlot;
	}

	private double getDistance(Location location1, Location location2) {
		double x1 = location1.getxAxis();
		double x2 = location2.getxAxis();
		double y1 = location1.getyAxis();
		double y2 = location2.getyAxis();
		double z1 = location1.getFloor();
		double z2 = location2.getFloor();

		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
	}
}
