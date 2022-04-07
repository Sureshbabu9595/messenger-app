package com.message.messenger.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.message.messenger.dto.EmailDTO;
import com.message.messenger.vo.MessageVO;

public class EmailDaoTest {

	private EmailDao emailDao;

	public EmailDaoTest() {
		super();
	}

	@Before
	public void setUp() {
		emailDao = new EmailDao();
	}

	@After
	public void tearDown() {
		emailDao = null;
	}

	@Test
	public void testSendEmail() {
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setEmailAddress("suresh@abcmotorcorp.com");
		emailDTO.setEmailContent("Hi There!");
		assertTrue(emailDao.sendEmail(emailDTO));
	}

	@Test
	public void testGetMessages() {
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setEmailAddress("suresh@abcmotorcorp.com");
		emailDTO.setEmailContent("Hi There!");
		emailDao.sendEmail(emailDTO);
		List<MessageVO> messages = emailDao.getMessages();
		assertTrue(!messages.isEmpty());
	}

}
