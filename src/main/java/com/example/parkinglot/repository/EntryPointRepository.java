package com.example.parkinglot.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.parkinglot.model.EntryPoint;

public class EntryPointRepository {
	private List<EntryPoint> entryPoints;

	public EntryPointRepository() {
		super();
		this.entryPoints = new ArrayList<>();
	}
	
	public EntryPointRepository(int entryPointCount) {
		super();
		this.entryPoints = new ArrayList<>();
		for(int i=0;i<entryPointCount;i++) {
			this.entryPoints.add(new EntryPoint(i));
		}
	}
	
	public void addEntryPoint(EntryPoint entryPoint) {
		entryPoints.add(entryPoint);
	}

	public List<EntryPoint> getAllEntryPoints() {
		return new ArrayList<>(entryPoints);
	}
}
