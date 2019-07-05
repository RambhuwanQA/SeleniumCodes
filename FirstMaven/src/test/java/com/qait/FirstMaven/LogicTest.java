package com.qait.FirstMaven;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class LogicTest {

	@Test
	public void testAdditionLogic() {
		assertEquals(new Logic().getAddition(5, 4), 9);

	}
	@Test
	public void testDisplay() {
		assertEquals(new Logic().disPlay("ram"), "ram");
	}

}
