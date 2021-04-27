package com.clearavenue.fdadi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class VersionServiceTest {

    @Autowired
    VersionService versionService;

    @Autowired
    BuildProperties buildProperties;

    @Test
    public void testVersion() {
        final String expected = String.format("%s : %s", buildProperties.getArtifact(), buildProperties.getVersion());
        final String actual = versionService.version();

        assertEquals(expected, actual);
    }
}
