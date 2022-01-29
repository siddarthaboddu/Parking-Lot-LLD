package com.example.parkinglot.model;

public abstract class Vehicle {

	private String registrationNumber;
	private String color;
	private int size;
	
	
	public Vehicle(String registrationNumber, String color, int size) {
		super();
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.size = size;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "Vehicle [registrationNumber=" + registrationNumber + ", color=" + color + ", size=" + size + "]";
	}

	
}
