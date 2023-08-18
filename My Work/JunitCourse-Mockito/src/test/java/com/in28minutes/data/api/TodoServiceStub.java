package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

// A "stub" is a sample implementation of an interface or dependency intended for use in unit tests. Typically, this is so you can have it return dummy/test data for use in your tests.
public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user){
		
		// Arrays.asList() lets us build out an array and then convert it into a list
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}
	
}
