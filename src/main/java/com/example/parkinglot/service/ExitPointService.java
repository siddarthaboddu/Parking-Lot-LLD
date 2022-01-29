package com.example.parkinglot.service;

import java.util.List;

import com.example.parkinglot.model.ExitPoint;
import com.example.parkinglot.repository.ExitPointRepository;

public class ExitPointService {

	private ExitPointRepository exitPointRepository;

	public ExitPointService(ExitPointRepository exitPointRepository) {
		super();
		this.exitPointRepository = exitPointRepository;
	}

	public List<ExitPoint> getAllExitPoints() {
		return exitPointRepository.getAllExitPoints();
	}
	
	
}
