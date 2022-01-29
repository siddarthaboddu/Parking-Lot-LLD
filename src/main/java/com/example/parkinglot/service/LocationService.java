package com.example.parkinglot.service;

import com.example.parkinglot.model.Location;
import com.example.parkinglot.repository.LocationRepository;

public class LocationService {

	private LocationRepository locationRepository;

	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	public Location getLocation(Object object) {
		return locationRepository.getLocation(object);
	}

}
