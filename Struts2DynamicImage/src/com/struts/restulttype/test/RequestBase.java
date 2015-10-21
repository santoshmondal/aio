package com.struts.restulttype.test;

import java.io.Serializable;
import java.util.List;

public class RequestBase implements Serializable {
	private static final long serialVersionUID = 1L;

	private Person person;
	private String mode;
	private String msg;
	private List<String> msgs;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
	public List<String> getMsgs() {
		return msgs;
	}

	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}

}
