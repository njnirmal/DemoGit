package com.qa.test;

import org.testng.annotations.Test;

public class LoginTest {
	
	
	@Test(priority = 1)
	public void TestOne() {
		System.out.println("First test method");
	}

	
	@Test(priority = 2)
	public void TestTwo() {
		System.out.println("Second test method");
	}
}
