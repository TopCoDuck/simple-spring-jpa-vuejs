package com.example.sms.service;

import com.example.sms.model.Sms;

/*
 * �׽�Ʈ�� SMS ���
 */
public class SmsServiceImpl implements SmslService<Sms>{
	
	public void send(Sms mail) {
		System.out.println("TO : " + mail.getTo());
		System.out.println("FROM : " + mail.getFrom());
		System.out.println("TITLE : " + mail.getTitle());
		System.out.println("MESSAGE : " + mail.getMessage());
	}
	
}
