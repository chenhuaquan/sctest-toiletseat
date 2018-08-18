package com.sc.test.seat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SeatStrategy implements ISeatStrategy {

	private Logger logger = LoggerFactory.getLogger(SeatStrategy.class);
	
	/**
	 * Revert the seat status  'U' -> 'D' or 'D' -> 'U'
	 * @param seatState
	 */
	protected void revertSeat(SeatState seatState) {
		SeatStatus reverted = seatState.getEndState() == SeatStatus.UP.getValue() ? SeatStatus.DOWN : SeatStatus.UP;
		seatState.setEndState(reverted.getValue());
		seatState.increaseAdjustment();
	}
	
	public Integer applyStrategy(String input) {
		logger.info("Seat strategy for input: {}", input);

		SeatState seatState = new SeatState();
		seatState.setEndState(input.charAt(0));
		seatState.setNumAdjustment(0);

		for (int i = 1; i < input.length(); i++) {
			logger.info("----- ({})", i);
			char c = input.charAt(i);
			arrive(seatState, c);
			leave(seatState);
		}

		return seatState.getNumAdjustment();
	}	
	
	@Override
	public void arrive(SeatState seatState, char prefered) {
		if (prefered == seatState.getEndState()) {
			logger.info("Expected {} vs. given {}. That's OK", prefered, seatState.getEndState());
		} else {
			logger.info("Expected {} vs. given {}, revert it", prefered, seatState.getEndState());
			revertSeat(seatState);
			logger.info("Seat state after revert: {}", seatState);
		}
		
	}	
}
