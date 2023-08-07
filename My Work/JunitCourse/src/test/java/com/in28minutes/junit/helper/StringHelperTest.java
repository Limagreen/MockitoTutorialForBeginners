package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	private StringHelper helper = new StringHelper();
	
	@Test
	public void test() {
		
		String expected = "CD";
		String actual = helper.truncateAInFirst2Positions("AACD");
		
		assertEquals(expected, actual);
	}

}
