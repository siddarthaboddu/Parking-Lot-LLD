package com.example.parkinglot.exception;

public class SlotNotAvailableException extends RuntimeException {
	public SlotNotAvailableException() {
		super("Slot is not availble");
	}
}
