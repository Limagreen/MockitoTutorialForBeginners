package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoService;

// TodoBusinessImpl is our SystemUnderTest (SUT)
// TodoService is a Dependency required by that SUT

public class TodoBusinessImpl {
	
	private TodoService todoService;

	// constructor
	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		
		List<String> filteredTodos = new ArrayList<String>();
		
		// for the purposes of this work, we pretend retrieveTodos fetches data from an API
		for (String todo : todoService.retrieveTodos(user)) {
			if(todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		
		return filteredTodos;
	}
	
	public void deleteTodosNotRelatedToSpring(String user){
		
		// for the purposes of this work, we pretend retrieveTodos fetches data from an API
		for (String todo : todoService.retrieveTodos(user)) {
			if(!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}

	}
}