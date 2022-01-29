package com.example.exception;

public class SlotNotAvailableException extends RuntimeException {
	public SlotNotAvailableException() {
		super("Slot is not availble");
	}
}
