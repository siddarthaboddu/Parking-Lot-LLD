package com.example.parkinglot.model;

public class SlotLocation {

	private int row;
	private int floor;

	public SlotLocation(int row, int floor) {
		super();
		this.row = row;
		this.floor = floor;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public String getSlotNumber() {
		return floor+"*"+row;
	}

	@Override
	public String toString() {
		return "SlotLocation [row=" + row + ", floor=" + floor + "]";
	}

	
}
