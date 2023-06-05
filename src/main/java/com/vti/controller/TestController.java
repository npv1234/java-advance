package com.vti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestController {
	
	@GetMapping
	public String test() {
		return "Test API";
	}
}

// /A/H3/10(request mapping)

// HTTP method: GET; POST; PUT; DELETE; PATCH
