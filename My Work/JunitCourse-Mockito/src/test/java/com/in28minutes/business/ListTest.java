package com.in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
	
	List mockList;
	
	@Before
	public void init() {
		mockList = mock(List.class);
	}

	@Test
	public void testListSizeMethod() {	
		
		when(mockList.size()).thenReturn(2);
		assertEquals(mockList.size(), 2);
	}
	
	@Test
	public void testListSizeMethod__ReturnMultipleValues() {
		
		when(mockList.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, mockList.size());
		assertEquals(3, mockList.size());
	}

	@Test
	public void testListGetMethod() {
		
		when(mockList.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mockList.get(0));
	}
	
	@Test
	public void testListGetMethod_AnyIndex() {	
		
		when(mockList.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mockList.get(0));
		assertEquals("in28Minutes", mockList.get(1));
	}
	
	@Test(expected = RuntimeException.class)
	public void testListGetMethod_ThrowAnException() {
		
		when(mockList.get(anyInt())).thenThrow(new RuntimeException("Something"));
		mockList.get(0);
	}
	
	// self-practice
	@Test
	public void testListIndexOfMethod() {
		
		when(mockList.indexOf(anyString())).thenReturn(1);
		assertEquals(1, mockList.indexOf("Hello"));
		assertEquals(1, mockList.indexOf("Hola"));
		assertEquals(1, mockList.indexOf("Bonjour"));
	}

}
