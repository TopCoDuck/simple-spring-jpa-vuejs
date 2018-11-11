package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyInfoController {
	
	@RequestMapping("my-info")
	public  String list(HttpServletRequest request){
		System.out.println(request.getSession().getAttribute("test"));
		return "";
	}

}
