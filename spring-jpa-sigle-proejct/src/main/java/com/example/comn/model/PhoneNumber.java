package com.example.comn.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/***
 * TODO: Spring BeanUtils 때문에 기본 생성자 public
 * Class org.springframework.beans.BeanUtils can not access a member of class com.example.comn.model.PhoneNumber with modifiers "protected"
 * @author us
 *
 */
@Getter
@Setter
@ToString
public class PhoneNumber {
	
	private String fNumber;
	
	private String mNumber;
	
	private String lNmber;

	public PhoneNumber() {
		
	}
	
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
