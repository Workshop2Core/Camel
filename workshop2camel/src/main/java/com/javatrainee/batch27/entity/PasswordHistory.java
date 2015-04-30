package com.javatrainee.batch27.entity;

import java.sql.Timestamp;


public class PasswordHistory{

	private long idpassword;

	private String oldpwd;

	private Timestamp timechange;

	private String user;

	public long getIdpassword() {
		return this.idpassword;
	}

	public void setIdpassword(long idpassword) {
		this.idpassword = idpassword;
	}

	public String getOldpwd() {
		return this.oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public Timestamp getTimechange() {
		return this.timechange;
	}

	public void setTimechange(Timestamp timechange) {
		this.timechange = timechange;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}