package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {

	private StringHelper helper = new StringHelper();
	
	@Before
	public void setup() {
		helper = new StringHelper(); // overkill, because we're not storing anything in this object
	}
	
	/** Section: truncateAInFirst2Positions()
	 * // AACD => CD, ACD => CD, CDEF => CDEF, CDAA => CDAA
	*/
	@Test
	public void testTruncateAInFirst2Positions_AInFirst2Positions() {
		
		// variables instead of inline arguments for demonstrative purposes
		String expected = "CD";
		String actual = helper.truncateAInFirst2Positions("AACD");
		
		assertEquals(expected, actual);
	}

	@Test
	public void testTruncateAInFirst2Positions_AInFirstPosition() {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_NoA() {
		assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AInLast2Positions() {
		assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
	}
	
	/** Section: areFirstAndLastTwoCharactersTheSame()
	 * ABCD => false, ABAB => true, AB => true, A => false 
	*/
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_AllLettersAreDifferent() {
		assertFalse("Condition Failed", helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_TrueWith4Letters() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_TrueWith2Letters() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}

}
