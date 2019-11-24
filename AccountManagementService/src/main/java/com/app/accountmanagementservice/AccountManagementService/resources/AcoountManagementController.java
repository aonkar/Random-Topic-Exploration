package com.app.accountmanagementservice.AccountManagementService.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcoountManagementController {

	@GetMapping("/greet")
	public String greet() {
		return "Get Mapping Working!!";
	}
	
}
