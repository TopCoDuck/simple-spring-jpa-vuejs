package com.example.comn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class CommModel {
	
	@Column(name = "CREATE_ID",updatable=false)
	private String createId;
	
	@Column(name = "CREATE_DTTM",updatable=false)
	private Date createDttm;

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public Date getCreateDttm() {
		return createDttm;
	}

	public void setCreateDttm(Date createDttm) {
		this.createDttm = createDttm;
	}
}
