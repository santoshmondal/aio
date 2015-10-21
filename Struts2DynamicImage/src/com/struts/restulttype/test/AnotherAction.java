package com.struts.restulttype.test;

import com.opensymphony.xwork2.ActionSupport;

public class AnotherAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private RequestBase req;
	
	public String execute(){
		if(req.getPerson() != null) {
			System.out.println(req.getPerson());
		}
		
		return NONE;
	}

	public RequestBase getReq() {
		return req;
	}

	public void setReq(RequestBase req) {
		this.req = req;
	}

	
}
