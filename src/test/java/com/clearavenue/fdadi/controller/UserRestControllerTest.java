package com.clearavenue.fdadi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.clearavenue.fdadi.model.UserProfile;
import com.clearavenue.fdadi.model.UserResult;
import com.clearavenue.fdadi.service.UserProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserRestController.class)
@ActiveProfiles("test")
public class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProfileService userProfileService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    BuildProperties buildProperties;

    @Test
    public void deleteAllTest() throws Exception {
        final String expected = "All users deleted";

        final MvcResult result = mockMvc.perform(get("/deleteAll")).andExpect(status().isOk()).andReturn();
        final String actual = result.getResponse().getContentAsString();
        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getUserTestNotFound() throws Exception {
        final MvcResult result = mockMvc.perform(get("/user/DemoUser")).andExpect(status().isOk()).andReturn();
        final UserResult actual = objectMapper.readValue(result.getResponse().getContentAsString(), UserResult.class);
        assertThat(actual.getUser()).isEqualTo(Optional.empty());
    }

    @Test
    public void getUserTestFound() throws Exception {
        final Optional<UserProfile> expected = Optional.of(UserProfile.builder().id(1L).userId("DemoUser").password("DemoPwd").build());

        given(userProfileService.getUser("DemoUser")).willReturn(expected);
        final MvcResult result = mockMvc.perform(get("/user/DemoUser")).andExpect(status().isOk()).andReturn();
        final UserResult actual = objectMapper.readValue(result.getResponse().getContentAsString(), UserResult.class);
        assertThat(actual.getUser()).isEqualTo(expected);
    }

    @Test
    public void saveUser() throws Exception {
        final UserProfile expected = UserProfile.builder().id(1L).userId("DemoUser").password("DemoPwd").build();

        given(userProfileService.saveUser(expected)).willReturn(expected);

        final MvcResult result = mockMvc.perform(post("/saveUser").content(objectMapper.writeValueAsString(expected)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        final UserResult actual = objectMapper.readValue(result.getResponse().getContentAsString(), UserResult.class);
        assertThat(actual.getUser().get()).isEqualTo(expected);
    }

    @Test
    public void saveUserNoPwd() throws Exception {
        final UserProfile user = UserProfile.builder().id(1L).userId("DemoUser").build();

        final MvcResult result = mockMvc.perform(post("/saveUser").content(objectMapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andReturn();
        assertThat(result.getResolvedException()).isInstanceOf(MethodArgumentNotValidException.class);
    }

    @Test
    public void saveUserNoUserId() throws Exception {
        final UserProfile user = UserProfile.builder().id(1L).password("DemoPwd").build();

        final MvcResult result = mockMvc.perform(post("/saveUser").content(objectMapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andReturn();
        assertThat(result.getResolvedException()).isInstanceOf(MethodArgumentNotValidException.class);
    }

}
