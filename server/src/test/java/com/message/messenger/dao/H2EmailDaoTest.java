package com.message.messenger.dao;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.message.messenger.dto.EmailDTO;
import com.message.messenger.vo.MessageVO;

@RunWith(MockitoJUnitRunner.Silent.class)
public class H2EmailDaoTest {

	@InjectMocks
	private H2EmailDao h2EmailDao;

	@Mock
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Mock
	private EmailDTO emailDTO;

	@Test
	public void testSendEmail() {
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setEmailAddress("suresh@abcmotorcorp.com");
		emailDTO.setEmailContent("Hi There");
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),
				Mockito.any(BeanPropertySqlParameterSource.class))).thenReturn(0);
		boolean sendMessage = h2EmailDao.sendEmail(emailDTO);
		assertFalse(sendMessage);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetMessages() {
		List<MessageVO> mockMessages = new ArrayList<>();
		MessageVO messageVO = new MessageVO();
		messageVO.setEmailAddress("suresh@abcmotorcorp.com");
		messageVO.setEmailContent("Hi There");
		mockMessages.add(messageVO);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = Mockito.mock(NamedParameterJdbcTemplate.class);
		Mockito.when(namedParameterJdbcTemplate.query(Mockito.anyString(), Mockito.any(ResultSetExtractor.class))).thenReturn(mockMessages);
		List<MessageVO> messages = h2EmailDao.getMessages();
		assertNull(messages);
	}
}