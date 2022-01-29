package com.example.parkinglot.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.parkinglot.model.Location;

public class LocationRepository {

	private Map<Object, Location> locationMap; //entry exit slot
	
	public LocationRepository() {
		locationMap = new HashMap<>();
	}
	
	public void addLocation(Object object, Location location) {
		locationMap.put(object, location);
	}
	
	public Location getLocation(Object object) {
		return locationMap.get(object);
	}
}
