package com.sc.test.seat;

/**
 * Interface to generalize the strategy
 * @author chenhuaquan
 *
 */
public interface ISeatStrategy {
	public static final char SEAT_UP = 'U';
	public static final char SEAT_DOWN = 'U';
	
	public void arrive(SeatState seatState, char prefered);
	
	public void leave(SeatState seatState);
	
	public Integer applyStrategy(String input);
	
}
