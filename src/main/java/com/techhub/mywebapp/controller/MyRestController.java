package com.techhub.mywebapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@Value("${app.version}")
	private String version;

	@GetMapping(value = { "/v", "/version" })
	public String showVersion() {
		return version;
	}
	
	
}
