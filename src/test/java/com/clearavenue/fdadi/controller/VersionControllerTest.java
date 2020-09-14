package com.clearavenue.fdadi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.clearavenue.fdadi.service.VersionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.clearavenue.fdadi.service.UserProfileService;

@WebMvcTest(VersionController.class)
@ActiveProfiles("test")
public class VersionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	BuildProperties buildProperties;

	@MockBean
	UserProfileService userProfileService;

	@MockBean
	VersionService versionService;


	@Test
	public void getVersion() throws Exception {
		mockMvc.perform(get("/version")).andExpect(status().isOk()).andReturn();
	}
}
