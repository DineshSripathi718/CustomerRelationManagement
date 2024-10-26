package com.crm.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	@GetMapping("")
	public String home() {
        return "Welcome to CRM Tool!";
    }
	
	@GetMapping("/error")
    public String test() {
        return "404 Error";
    }
	
	@GetMapping("/loginuser")
	public String loginUser() {
        return "user logged in";
    }
}
