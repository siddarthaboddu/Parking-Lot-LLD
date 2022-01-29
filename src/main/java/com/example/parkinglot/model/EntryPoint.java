package com.example.parkinglot.model;

public class EntryPoint {

	private int entryPointNumber;
	
	public EntryPoint(int entryPointNumber) {
		super();
		this.entryPointNumber = entryPointNumber;
	}

	public int getEntryPointNumber() {
		return entryPointNumber;
	}

	public void setEntryPointNumber(int entryPointNumber) {
		this.entryPointNumber = entryPointNumber;
	}

	@Override
	public String toString() {
		return "EntryPoint [entryPointNumber=" + entryPointNumber + "]";
	}

	
}
