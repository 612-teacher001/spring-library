package com.example.demo.authentication;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {
	
	@Autowired
	HttpSession session;	
	
	@GetMapping("/auth/signup")
	public String entry() {
		return "user/signup";
	}
	
	@GetMapping("/")
	public String index() {
		session.invalidate();
		return "auth/signin";
	}
	
}
