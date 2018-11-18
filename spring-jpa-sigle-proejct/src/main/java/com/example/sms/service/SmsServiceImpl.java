package com.example.sms.service;

import com.example.sms.model.Sms;

/*
 * 테스트용 SMS 모듈
 */
public class SmsServiceImpl implements SmslService<Sms>{
	
	public void send(Sms mail) {
		System.out.println("TO : " + mail.getTo());
		System.out.println("FROM : " + mail.getFrom());
		System.out.println("TITLE : " + mail.getTitle());
		System.out.println("MESSAGE : " + mail.getMessage());
	}
	
}
