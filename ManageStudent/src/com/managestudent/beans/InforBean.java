package com.managestudent.beans;

import java.sql.Date;

public class InforBean {
	private Date bday;
	private String gender, addr;
	

	public InforBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InforBean(Date bday, String gender, String addr) {
		super();
		this.addr = addr;
		this.bday = bday;
		this.gender = gender;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
