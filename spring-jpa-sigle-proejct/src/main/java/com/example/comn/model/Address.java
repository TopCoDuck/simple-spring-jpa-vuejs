package com.example.comn.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
public class Address {
	@Column(name="ZIP_CODE")
	private String zipCode;
	@Column(name="ZIP_INFO")
	private String zipInfo;
	@Column(name="ZIP_INFO_DETAIL")
	private String zipInfoDetail;
}
