package com.in28minutes.data.api;

import java.util.List;

// External Service - Lets say this comes from WunderList
public interface TodoService {
	// for the purposes of this work, we pretend retrieveTodos fetches data from an API
	public List<String> retrieveTodos(String user);
	
	public void deleteTodo(String todo);
}