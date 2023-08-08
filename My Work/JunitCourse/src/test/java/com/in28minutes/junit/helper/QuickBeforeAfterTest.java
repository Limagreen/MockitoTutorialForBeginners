package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	
	@Before
	public void setup() {
		System.out.println("Before Test");
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1 executed"); // generally should use a logger instead
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2 executed");
	}
	
	@After
	public void teardown() {
		System.out.println("After test");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}

}
