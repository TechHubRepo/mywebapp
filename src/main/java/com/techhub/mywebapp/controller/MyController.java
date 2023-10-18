package com.techhub.mywebapp.controller;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

	@Value("${app.version}")
	private String version;

	@GetMapping(value = "/")
	public String index(HttpServletRequest request) {
		LOGGER.info("||******* WELCOME *******||");
		LOGGER.info("||******* Showing INDEX PAGE *******||");
		String hostName = null;
		String hostIP = null;
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			hostName = inetAddress.getHostName();
			hostIP = inetAddress.getHostAddress();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		request.setAttribute("host_name", hostName);
		request.setAttribute("host_ip", hostIP);
		request.setAttribute("version", version);
		return "index";
	}

	@GetMapping("/show-another")
	public String showAnother() {
		LOGGER.info("||******* WELCOME *******||");
		LOGGER.info("||******* Showing ANOTHER PAGE *******||");
		return "another";
	}
}
