package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	private StringHelper helper = new StringHelper();
	
	@Test
	public void testTruncateAInFirst2Positions_AInFirst2Positions () {
		
		// variables instead of inline arguments for demonstrative purposes
		String expected = "CD";
		String actual = helper.truncateAInFirst2Positions("AACD");
		
		assertEquals(expected, actual);
	}

	@Test
	public void testTruncateAInFirst2Positions_AInFirstPosition () {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
}
