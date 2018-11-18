package com.example.sms.service;

public interface SmslService<T> {
	void send(T mail);
}
