package com.struts.restulttype.test;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private RequestBase req;
	
	
	public String execute(){
		if(req != null) {
			System.out.println(req.getMsg());
			req.setMsg("ANOTHER MESSAGE");
			req.setMode("ANOTHER MODE");
			if(req.getPerson() != null) {
				req.getPerson().setId("1234");
			}
		}
		
		return SUCCESS;
	}


	public RequestBase getReq() {
		return req;
	}


	public void setReq(RequestBase req) {
		this.req = req;
	}

	

}
