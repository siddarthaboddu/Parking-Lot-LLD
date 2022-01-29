package com.example.parkinglot.service;

import java.util.List;

import com.example.parkinglot.model.EntryPoint;
import com.example.parkinglot.repository.EntryPointRepository;

public class EntryPointService {

	private EntryPointRepository entryPointRepository;

	public EntryPointService(EntryPointRepository entryPointRepository) {
		super();
		this.entryPointRepository = entryPointRepository;
	}

	public List<EntryPoint> getAllEntryPoints() {
		return entryPointRepository.getAllEntryPoints();
	}

}
