package com.example.parkinglot.model;

public class Location {

	private double xAxis;
	private double yAxis;
	private double floor;

	public Location(double xAxis, double yAxis, double floor) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.floor = floor;
	}

	public double getxAxis() {
		return xAxis;
	}

	public void setxAxis(double xAxis) {
		this.xAxis = xAxis;
	}

	public double getyAxis() {
		return yAxis;
	}

	public void setyAxis(double yAxis) {
		this.yAxis = yAxis;
	}

	public double getFloor() {
		return floor;
	}

	public void setFloor(double floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Location [xAxis=" + xAxis + ", yAxis=" + yAxis + ", floor=" + floor + "]";
	}

	
}
