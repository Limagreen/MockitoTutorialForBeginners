package com.in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void retrieveTodosRelatedToSpring_usingAMock() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance")); // See JavaDoc 1
		
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredTodos.size()); // should be two entries that pass the filter
		
	}

}

/* JavaDoc 1
 * When todoServiceMock's retrieveTodos() method is called using the argument "Dummy," it should then return the List<String> of "Learn Spring MVC", "Learn Spring", and "Learn to Dance."
*/