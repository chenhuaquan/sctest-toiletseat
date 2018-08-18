package com.sc.test.seat;

public enum SeatStatus {
	UP('U'),
	DOWN('D');
	
	private final char value;
	SeatStatus(char v) {
		this.value = v;
	}
	
	public char getValue() {
		return this.value;
	}
}
