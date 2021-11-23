package com.clearavenue.fdadi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class VersionServiceTest {

	@InjectMocks
	VersionService versionService;

	@Mock
	BuildProperties buildProperties;

	@Test
	public void testVersion() {
		final String expected = String.format("%s : %s", buildProperties.getArtifact(), buildProperties.getVersion());
		final String actual = versionService.version();

		assertEquals(expected, actual);
	}
}
