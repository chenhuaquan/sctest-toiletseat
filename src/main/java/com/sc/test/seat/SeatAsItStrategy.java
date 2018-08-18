package com.sc.test.seat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * When guest leaves, leave the seat as you would like to find it
 * 
 * @author chenhuaquan
 *
 */
public class SeatAsItStrategy extends SeatStrategy implements ISeatStrategy {

	private Logger logger = LoggerFactory.getLogger(SeatAsItStrategy.class);


	@Override
	public void leave(SeatState seatState) {
		// no action is taken
		if (seatState.getEndState() != SeatStatus.UP.getValue()) {
			// do nothing
			logger.info("Seat state after doing nothing for AsIt: {}", seatState);
		}
	}

}
