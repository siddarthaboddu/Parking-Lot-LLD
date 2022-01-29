package com.example.parkinglot.model;

public class ExitPoint {

	private int exitPointNumber;

	public ExitPoint(int exitPointNumber) {
		super();
		this.exitPointNumber = exitPointNumber;
	}

	public int getExitPointNumber() {
		return exitPointNumber;
	}

	public void setExitPointNumber(int exitPointNumber) {
		this.exitPointNumber = exitPointNumber;
	}

	@Override
	public String toString() {
		return "ExitPoint [exitPointNumber=" + exitPointNumber + "]";
	}

	
}
