package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	private StringHelper helper = new StringHelper();
	private String input;
	private String expectedOutput;
	
	public StringHelperParameterizedTest(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testConditions() {
		
		// in each pair, the first value is the parameter and the second is the expected output
		String inputOutputPairs[][] = { 
			{"AACD", "CD"},
			{"ACD", "CD"}
		};
		
		return Arrays.asList(inputOutputPairs);
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AInFirst2Positions() {		
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}

	@Test
	public void testTruncateAInFirst2Positions_AInFirstPosition() {
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}
	
	

}
