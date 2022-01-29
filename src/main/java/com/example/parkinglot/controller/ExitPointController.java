package com.example.parkinglot.controller;

import java.util.List;

import com.example.parkinglot.model.ExitPoint;
import com.example.parkinglot.service.ExitPointService;

public class ExitPointController {

	private ExitPointService exitPointService;

	public ExitPointController(ExitPointService exitPointService) {
		super();
		this.exitPointService = exitPointService;
	}
	
	public List<ExitPoint> getAllExitPoints(){
		return exitPointService.getAllExitPoints();
	}
}
