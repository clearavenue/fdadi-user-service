package com.clearavenue.fdadi.service;

import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VersionService {

    private final BuildProperties buildProperties;

    public String version() {
        return String.format("%s : %s", buildProperties.getArtifact(), buildProperties.getVersion());
    }

}