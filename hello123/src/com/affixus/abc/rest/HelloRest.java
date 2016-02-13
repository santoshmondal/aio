package com.affixus.abc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.affixus.pojo.Auth;
import com.affixus.util.JsonUtil;

/**
 * http://localhost:8080/hello123/rest/
 *  http://localhost:8080/hello123/rest/get2
 *
 */

@Path("/")
public class HelloRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAuth() {
		Auth auth = new Auth();
		
		String json = JsonUtil.objectToJson(auth);
		return Response.ok(json).build();
	}
	
	@GET
	@Path("/get2")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAuth2() {
		Auth auth = new Auth();
		auth.setUserid("shashi");
		
		String json = JsonUtil.objectToJson(auth);
		return Response.ok(json).build();
	}
}
