package com.rediff.db;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	
	// input
	private String username;
	private String password;
	private String email;
	private String contactno;
	
	private String opr;
	
	
	// outupt
	private String msg;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getOpr() {
		return opr;
	}
	public void setOpr(String opr) {
		this.opr = opr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
