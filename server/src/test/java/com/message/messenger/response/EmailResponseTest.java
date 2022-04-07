package com.message.messenger.response;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailResponseTest {
	
	private EmailResponse emailResponse;

	@Before
	public void setUp() throws Exception {
		emailResponse = new EmailResponse();
		emailResponse.setCode("200");
		emailResponse.setEmailAddress("test@abcmotorcorp.com");
		emailResponse.setEmailContent("Hi There");
		emailResponse.setStatus("SUCCESS");
	}

	@After
	public void tearDown() throws Exception {
		emailResponse = null;
	}

	@Test
	public void testToString() {
		assertNotNull(emailResponse.toString());
	}

	@Test
	public void testGetEmailAddress() {
		assertNotNull(emailResponse.getEmailAddress());
	}

	@Test
	public void testGetEmailContent() {
		assertNotNull(emailResponse.getEmailContent());
	}
}