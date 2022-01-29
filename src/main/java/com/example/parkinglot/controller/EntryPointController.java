package com.example.parkinglot.controller;

import java.util.List;

import com.example.parkinglot.model.EntryPoint;
import com.example.parkinglot.service.EntryPointService;

public class EntryPointController {

	private EntryPointService entryPointService;

	public EntryPointController(EntryPointService entryPointService) {
		super();
		this.entryPointService = entryPointService;
	}

	public List<EntryPoint> getAllEntryPoints() {
		return entryPointService.getAllEntryPoints();
	}

}
