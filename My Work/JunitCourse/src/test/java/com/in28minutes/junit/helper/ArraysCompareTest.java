package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void testArraySort_RandomArray() {
		int[] numbers = {1, 3, 4, 2};
		int[] expected = {1, 2, 3, 4};
		
		Arrays.sort(numbers);
		assertArrayEquals(expected ,numbers);
	}
	
	@Test(expected = NullPointerException.class)
	public void testArraySort_NullArray() {
		int[] numbers = null;
		
		Arrays.sort(numbers);
	}

	@Test(timeout = 100)
	public void testSort_Performance() {
		int[] numbers = {5, 3, 4, 1, 2};
		
		for(int i = 0; i < 1000000; i++) {
			numbers[0] = i;
			Arrays.sort(numbers);
		}
	}

}
