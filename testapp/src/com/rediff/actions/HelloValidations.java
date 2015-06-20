package com.rediff.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloValidations extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String name;

	public String add() {
		System.out.println("ADD :: " + name);
		return SUCCESS;
	}
	
	public String edit() {
		System.out.println("EDIT :: " + name);
		return SUCCESS;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void validate() {
		super.validate();
		if(name == null){
			addFieldError(name, "NAME cant be empty!!");
		}
	}
	
}
