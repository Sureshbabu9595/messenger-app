package com.message.messenger.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MessengerLoginControllerTest {
	
	private MessengerLoginController messengerLoginController;

	@Before
	public void setUp() throws Exception {
		messengerLoginController = Mockito.mock(MessengerLoginController.class);
	}

	@After
	public void tearDown() throws Exception {
		messengerLoginController = null;
	}

	@Test
	public void testLogin() {
		
	}

}
