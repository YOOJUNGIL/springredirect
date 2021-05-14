package com.myalley.springskill.junit;

import org.junit.Test;

public class JunitTest {
	
	@Test
	public void testSum() {
		Calculator calc = new Calculator();
		int sum = calc.sum(5, 4);
		System.out.println("sum = " + sum);
		//assertEquals(9, sum, 0);
	}
	
	@Test
	public void testSum2() {
		Calculator calc = new Calculator();
		int sum = calc.sum(9, 1);
		System.out.println("sum = " + sum);
		//assertEquals(9, sum, 0);
	}
	
}
