package com.example.comn.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
