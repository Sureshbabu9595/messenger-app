package com.message.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.message.messenger.dao.EmailDao;
import com.message.messenger.dto.EmailDTO;
import com.message.messenger.vo.MessageVO;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmailServiceTest {

	private EmailService emailService;

	@Before
	public void setUp() throws Exception {
		emailService = Mockito.mock(EmailService.class);
		EmailDao emailDao = Mockito.mock(EmailDao.class);
		emailService.setEmailDao(emailDao);
	}

	@After
	public void tearDown() throws Exception {
		emailService = null;
	}

	@Test
	public void testSendEmail() {
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setEmailAddress("test@abcmotorcorp.com");
		emailDTO.setEmailContent("Hi There");
		Mockito.when(emailService.sendEmail(emailDTO)).thenReturn(true);
	}

	@Test
	public void testGetMessages() {
		List<MessageVO> messages = new ArrayList<>();
		MessageVO messageVO = new MessageVO();
		messageVO.setEmailAddress("test@abcmotorcorp.com");
		messageVO.setEmailContent("Hi There");
		messages.add(messageVO);
		Mockito.when(emailService.getMessages()).thenReturn(messages);
	}

	public EmailServiceTest() {
		super();
	}
}