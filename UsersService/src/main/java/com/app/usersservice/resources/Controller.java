package com.app.usersservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/greet")
	public String greet() {
		return "Get Mapping Working";
	}
}
