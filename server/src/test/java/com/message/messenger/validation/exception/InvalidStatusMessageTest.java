package com.message.messenger.validation.exception;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InvalidStatusMessageTest {

	private InvalidStatusMessage invalidStatusMessage;

	@Before
	public void setUp() throws Exception {
		invalidStatusMessage = new InvalidStatusMessage("Invalid Contract");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(invalidStatusMessage);
	}

}
