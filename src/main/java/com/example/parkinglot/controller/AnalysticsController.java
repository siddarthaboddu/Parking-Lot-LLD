package com.example.parkinglot.controller;

import java.util.List;

import com.example.parkinglot.model.Slot;
import com.example.parkinglot.service.AnalyticsService;

public class AnalysticsController {

	private AnalyticsService analyticsService;

	public AnalysticsController(AnalyticsService analyticsService) {
		super();
		this.analyticsService = analyticsService;
	}

	public List<String> getRegistrationNumberOfAllCarsOfColor(String color) {
		return analyticsService.getRegistrationNumberOfAllCarsOfColor(color);
	}
	
	public Slot getSlotWhereAVehicleIsParked(String registrationNumber) {
		return analyticsService.getSlotWhereAVehicleIsParked(registrationNumber);
	}
	
	public List<String> getSlotsNumberWithCarsWithSpecificColor(String color){
		return analyticsService.getSlotsNumberWithCarsWithSpecificColor(color);
	}
}
