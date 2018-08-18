package com.sc.test.seat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * When guest leaves, always leave the seat up
 * 
 * @author chenhuaquan
 *
 */
public class SeatUpStrategy extends SeatStrategy implements ISeatStrategy {

	private Logger logger = LoggerFactory.getLogger(SeatUpStrategy.class);


	@Override
	public void leave(SeatState seatState) {
		// always up
		if (seatState.getEndState() != SeatStatus.UP.getValue()) {
			logger.info("{} is end state, not UP, revert it", seatState.getEndState());
			revertSeat(seatState);
			logger.info("Seat state after revert for UP: {}", seatState);
		}
	}

}
