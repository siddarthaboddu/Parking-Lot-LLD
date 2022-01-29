package com.example.parkinglot.model;

import java.time.LocalDateTime;

public class ParkingTicket {

	private Slot slot;
	private Vehicle vehicle;
	private LocalDateTime createTime;

	public ParkingTicket(Slot slot, Vehicle vehicle) {
		super();
		this.slot = slot;
		this.vehicle = vehicle;
		this.createTime = LocalDateTime.now();
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ParkingTicket [slot=" + slot + ", vehicle=" + vehicle + ", createTime=" + createTime + "]";
	}

}
