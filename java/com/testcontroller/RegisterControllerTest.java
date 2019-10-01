package com.testcontroller;


import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.swing.text.AbstractDocument.Content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.Returns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.websparrow.controller.UserRegistrataionController;


@RunWith(SpringJUnit4ClassRunner.class)

public class RegisterControllerTest {


	private MockMvc mockMvc;


	@InjectMocks
	private UserRegistrataionController controller;
	
	

	@Before
	public void setUp() {
//		controller = new UserRegistrataionController();
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//
//		messageSource.setBasename("i18n/messages");
//		messageSource.setUseCodeAsDefaultMessage(true);
//		serviceMock=TestContext.todoService();
//		ReflectionTestUtils.setField(controller, "service", serviceMock);
	
	mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
	}

//
//	@Test
//	public void registerControllerShouldReturnTrue() throws Exception {
//		User user = new User("pooja","pooja123");
//		when(serviceMock.registerUser(user)).thenReturn(true);
//
//		mockMvc.perform(get("/"))
//		.andExpect(status().isOk())
//		.andExpect(view().name("/registration"))
//		.andExpect(forwardedUrl("/registration.jsp"))
//		.andExpect(model().attribute("todos", hasSize(1)));
//		verify(serviceMock, times(1)).registerUser(user);
//		verifyNoMoreInteractions(serviceMock);
//	}
	@Test
	public void testHelloWorld() throws Exception
	{
		mockMvc.perform(get("/hello"))
		.andExpect(status().isOk())
		 .andReturn();
		
	}
	
}
