package com.example.sms.model;

import lombok.Getter;

@Getter
public class Sms {
	
	
	private String to;
	private String from;
	private String title;
	private String message;
	
	public Sms setFrom(String from) {
		this.from = from;
		return this;
	}
	public Sms setTo(String to) {
		this.to = to;
		return this;
	}
	
	public Sms setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public Sms setMessage(String message) {
		this.message = message;
		return this;
	}
	
}
