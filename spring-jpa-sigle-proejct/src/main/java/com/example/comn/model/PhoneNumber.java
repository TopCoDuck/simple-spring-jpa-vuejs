package com.example.comn.model;

import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Convert(converter=PhoneNumberConverter.class,attributeName="PHONE_NUMBER")
@Getter
public class PhoneNumber {
	
	private String fNumber;
	
	private String mNumber;
	
	private String lNmber;
	
	public PhoneNumber(String fNumber, String mNumber , String lNumber) {
		this.fNumber = fNumber;
		this.mNumber = mNumber;
		this.lNmber = lNumber;
	}

	public String getFullPhoneNumber() {
		StringBuilder sb = new StringBuilder();
		return sb.append(fNumber)
				 .append(mNumber)
				 .append(lNmber)
				 .toString();
				  
				 
	}
}
