package com.in28minutes.mockito;

//import static org.hamcrest.Matchers.arrayContaining;
//import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
//import static org.hamcrest.Matchers.arrayWithSize;
//import static org.hamcrest.Matchers.everyItem;
//import static org.hamcrest.Matchers.greaterThan;
//import static org.hamcrest.Matchers.hasItems;
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.isEmptyOrNullString;
//import static org.hamcrest.Matchers.isEmptyString;
//import static org.hamcrest.Matchers.lessThan;

//import all static methods from the Matchers class, as opposed to one by one like above
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);
		
		// Some common matchers
		assertThat(scores, hasSize(4)); // there are four elements in the list
		assertThat(scores, hasItems(99, 100));
		assertThat(scores, everyItem(greaterThan(90)));
		assertThat(scores, everyItem(lessThan(190)));
		
		// Some String matcher
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		// Some Array matchers
		Integer[] marks = {1, 2, 3};
		
		assertThat(marks, arrayWithSize(3)); // confirm it's an array, with 3 elements
		assertThat(marks, arrayContaining(1, 2, 3)); // confirm it's an array, with these elements
		assertThat(marks, arrayContainingInAnyOrder(2, 1, 3));
		
	}

}
