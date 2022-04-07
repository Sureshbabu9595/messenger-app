package com.message.messenger.dto;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.message.messenger.request.EmailRequest;

public class EmailDTOTest {
	
	private EmailDTO emailDTO;

	public EmailDTOTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		emailDTO = new EmailDTO();
		emailDTO.setEmailAddress("john@abcmotorcorp.com");
		emailDTO.setEmailContent("Hi There");
	}

	@After
	public void tearDown() throws Exception {
		emailDTO = null;
	}

	@Test
	public void testGetters() {
		assertEquals("john@abcmotorcorp.com", emailDTO.getEmailAddress());
		assertEquals("Hi There", emailDTO.getEmailContent());
		EmailRequest emailRequest = new EmailRequest();
		emailRequest.setEmailAddress("john@abcmotorcorp.com");
		emailRequest.setEmailContent("Hi There");
		emailDTO.toDTO(emailRequest);
		emailDTO.toString();
	}

}
