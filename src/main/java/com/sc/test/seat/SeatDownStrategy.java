package com.sc.test.seat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * When guest leaves, always leave the seat down
 * 
 * @author chenhuaquan
 *
 */
public class SeatDownStrategy extends SeatStrategy implements ISeatStrategy {

	private Logger logger = LoggerFactory.getLogger(SeatDownStrategy.class);


	@Override
	public void leave(SeatState seatState) {
		// always up
		if (seatState.getEndState() != SeatStatus.DOWN.getValue()) {
			logger.info("{} is end state, not DOWN, revert it", seatState.getEndState());
			revertSeat(seatState);
			logger.info("Seat state after revert for DOWN: {}", seatState);
		}
	}

}
