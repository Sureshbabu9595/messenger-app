package com.message.messenger.response;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessengerRESTResponseTest {
	
	private MessengerRESTResponse<String> messengerRESTResponse;

	@Before
	public void setUp() throws Exception {
		messengerRESTResponse = new MessengerRESTResponse<>();
		messengerRESTResponse.setError(true);
		List<String> errors = new ArrayList<>();
		messengerRESTResponse.setErrorMessages(errors);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsError() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetError() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetErrorMessages() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetErrorMessages() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetResponse() {
		fail("Not yet implemented");
	}

}
