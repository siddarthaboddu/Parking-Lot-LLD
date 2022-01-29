package com.example.parkinglot.repository;

import java.util.ArrayList;
import java.util.List;


import com.example.parkinglot.model.ExitPoint;

public class ExitPointRepository {
	private List<ExitPoint> exitPoints;

	public ExitPointRepository() {
		super();
		this.exitPoints = new ArrayList<>();
	}

	public ExitPointRepository(int existPointCount) {
		super();
		this.exitPoints = new ArrayList<>();
		for(int i=0;i<existPointCount;i++) {
			this.exitPoints.add(new ExitPoint(i));
		}
	}

	public void addEntryPoint(ExitPoint exitPoint) {
		exitPoints.add(exitPoint);
	}

	public List<ExitPoint> getAllExitPoints() {
		return new ArrayList<>(exitPoints);
	}
}
