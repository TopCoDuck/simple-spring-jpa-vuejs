package com.example.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordManger  extends BCryptPasswordEncoder{
	private PasswordManger () {
		super(10);
	}
}
