package com.example.comn.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PhoneNumberConverter implements AttributeConverter<PhoneNumber, String>{

	@Override
	public String convertToDatabaseColumn(PhoneNumber attribute) {
		if(attribute != null)
			return attribute.getFullPhoneNumber();
		else
			return null;
	}

	@Override
	public PhoneNumber convertToEntityAttribute(String dbData) {
		if(dbData != null) {
			
			if(dbData.length() == 11) {
				return new PhoneNumber(dbData.substring(0,3)
									  ,dbData.substring(3,7)
									  ,dbData.substring(7,11));
			}else{
				return new PhoneNumber(dbData.substring(0,2)
						  			  ,dbData.substring(2,6)
						  			  ,dbData.substring(6,10)) ;
			}
		}else
		 return null;
	}

}
