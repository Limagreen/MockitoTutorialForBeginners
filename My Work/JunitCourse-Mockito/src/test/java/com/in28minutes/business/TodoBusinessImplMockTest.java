package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void retrieveTodosRelatedToSpring_usingAMock() {

		TodoService todoServiceMock = mock(TodoService.class);
		when(todoServiceMock.retrieveTodos("Dummy"))
				.thenReturn(Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance")); // See JavaDoc 1

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size()); // should be two entries that pass the filter

	}

	@Test
	public void retrieveTodosRelatedToSpring_usingBDDMock() {

		// Given
		TodoService todoServiceMock = mock(TodoService.class);
		given(todoServiceMock.retrieveTodos("Dummy"))
				.willReturn(Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance")); // See JavaDoc 2
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		// Then
		assertThat(filteredTodos.size(), is(2)); // See JavaDoc 3

	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_UsingBDDMockito() {

		// Given
		TodoService todoServiceMock = mock(TodoService.class);
		given(todoServiceMock.retrieveTodos("Dummy"))
				.willReturn(Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance")); // See JavaDoc 2
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then
		verify(todoServiceMock).deleteTodo("Learn to Dance");
		verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");

	}

}

/*
 * JavaDoc 1 When todoServiceMock's retrieveTodos() method is called using the
 * argument "Dummy," it should then return the List<String> of
 * "Learn Spring MVC", "Learn Spring", and "Learn to Dance."
 */
/*
 * JavaDoc 2 This method setup - given().willReturn() - is functionally identical to when().thenReturn(). It's simply renamed by BDDMockito to help visualize the flow of a Behavior-Driven Development test scenario.
 */
/*
 * JavaDoc 3 BDDMockito lets you replace assertEquals() and its siblings with assertThat(actualValue, is(expectedValue)); This is again to make the syntax visually more representative of BDD.
 */