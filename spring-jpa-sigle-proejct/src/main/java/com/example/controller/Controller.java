package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Security �׽�Ʈ�� Controller
 */
@RestController
public class Controller {
	@RequestMapping("/")
	public String test() {
		return "test";
	}
	@RequestMapping("/security")
	public String security() {
		return "security";
	}
}
