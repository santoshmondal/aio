package com.rediff.actions;

import com.opensymphony.xwork2.ActionSupport;

public class TestValid extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String hello() {
		System.out.println(name + "::" + id);
		return SUCCESS;
	}

}
