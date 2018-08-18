package com.sc.test.seat;

import lombok.Data;

/**
 * This class is to manage Seat State
 * @author chenhuaquan
 *
 */
@Data
public class SeatState {
	private char endState;
	private Integer numAdjustment = 0;
	
	/**
	 * Increase counter for seat adjustment
	 */
	public void increaseAdjustment() {
		++numAdjustment;
	}

	
}
