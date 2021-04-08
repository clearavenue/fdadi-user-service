package com.clearavenue.fdadi.controller;

import com.clearavenue.fdadi.service.VersionService;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class VersionController {

	private final VersionService versionService;

	@GetMapping("/version")
	public String getVersion() {
		return versionService.version();
	}
}