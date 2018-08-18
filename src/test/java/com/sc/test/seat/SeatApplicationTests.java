package com.sc.test.seat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeatApplicationTests {

	@Autowired
	StrategyContext context;


	@Before
	public void before() {
	}

	@Test
	public void testProvidedByPaper() {
		Integer[] aryResult = context.seeAllStrategies("UUUDDUDU");
		
		Integer[] expecteds = {6, 7, 4};
		
		Assert.assertArrayEquals(expecteds , aryResult);
	}

	@Test
	public void testAllUp() {
		Integer[] aryResult = context.seeAllStrategies("UUUUUUUU");
		
		Integer[] expecteds = {0, 13, 0};
		
		Assert.assertArrayEquals(expecteds , aryResult);
	}

	@Test
	public void testAllDown() {
		Integer[] aryResult = context.seeAllStrategies("DDDDDDDD");
		
		Integer[] expecteds = {13, 0, 0};
		
		Assert.assertArrayEquals(expecteds , aryResult);
	}
	
	
	
	
	
	
}
