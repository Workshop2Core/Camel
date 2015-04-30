package com.javatrainee.batch27.entity;

import java.sql.Timestamp;


public class LoginHistory{
	private long idlogin;

	private Timestamp logintime;

	private String user;

	public long getIdlogin() {
		return this.idlogin;
	}

	public void setIdlogin(long idlogin) {
		this.idlogin = idlogin;
	}

	public Timestamp getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}