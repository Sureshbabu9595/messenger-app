package com.message.messenger.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailRequestTest {

	private EmailRequest emailRequest;

	@Before
	public void setUp() throws Exception {
		emailRequest = new EmailRequest();
		emailRequest.setEmailAddress("John@abcmotorcorp.com");
		emailRequest.setEmailContent("Hi There");
	}

	@After
	public void tearDown() throws Exception {
		emailRequest = null;
	}

	@Test
	public void testGetEmailAddress() {
		assertEquals("John@abcmotorcorp.com", emailRequest.getEmailAddress());
	}

	@Test
	public void testGetEmailContent() {
		assertEquals("Hi There", emailRequest.getEmailContent());
	}

	@Test
	public void testToString() {
		assertNotNull(emailRequest.toString());
	}
}
