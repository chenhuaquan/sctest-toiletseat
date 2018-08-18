package com.sc.test.seat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StrategyContext {

	private Logger logger = LoggerFactory.getLogger(StrategyContext.class);
	/**
	 * List result for all strategies applied
	 * @return 
	 */
	public Integer[] seeAllStrategies(String input) {
		logger.info("start to execute all strategies for input: {}", input);
		Integer[] result = {0, 0, 0};
		
		//UP strategy
		SeatUpStrategy up = new SeatUpStrategy();
		Integer steps = up.applyStrategy(input);
		result[0] = steps;
		
		//DOWN strategy
		SeatDownStrategy down = new SeatDownStrategy();
		steps = down.applyStrategy(input);
		result[1] = steps;

		//AsIt strategy
		SeatAsItStrategy asit = new SeatAsItStrategy();
		steps = asit.applyStrategy(input);
		result[2] = steps;
		
		return result;
	}
}
