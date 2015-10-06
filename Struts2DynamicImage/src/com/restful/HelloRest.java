package com.restful;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

@Path("/")
public class HelloRest {
	@Context
	private HttpServletRequest request;
	@Context
	private UriInfo uriInfo;
	
	
	@GET
	@Path("/hello")
	public Response helloRest() {
		return Response.ok("HELLO WORLD!!").build();
	}
	
	@POST
	@Path("hpost")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response helloPost() {
		System.out.println("HELLO POST");
		try{
			Part part = request.getPart("pic");
			System.out.println(part);
			System.out.println(uriInfo.getQueryParameters().getFirst("fname"));
			System.out.println();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Response.ok("HELLO POST!!").build();
	}
	
	
	@GET
	@Path("/helloGetParam/{uid}")
	public Response helloGetParam() {
		String paaram1 = uriInfo.getQueryParameters().getFirst("fname");
		return Response.ok("helloGetParam!!" + paaram1).build();
	}
	
	@POST
	@Path("/helloPostParam/{uid}")
	public Response helloPostParam(MultivaluedMap<String, String> formParams) {
		System.out.println(formParams);
		
		MultivaluedMap<String, String> pathParameters = uriInfo.getPathParameters();
		String uid = pathParameters.getFirst("uid");
		
		String paaram1 = formParams.getFirst("fname");
		return Response.ok("helloPostParam :: " + paaram1 + " :: " + uid).build();
	}
	
	@POST
	@Path("/helloPostAsBody/{uid}")
	public Response helloPostAsBody(String body) {
		System.out.println(body);
		
		MultivaluedMap<String, String> pathParameters = uriInfo.getPathParameters();
		String uid = pathParameters.getFirst("uid");
		
		return Response.ok("helloPostParam :: " + uid).build();
	}
	
	
	@POST
	@Path("/helloPostAsMultiPart/{uid}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response helloPostAsMultiPart(FormDataMultiPart formParams) {
		MultivaluedMap<String, String> pathParameters = uriInfo.getPathParameters();
		String uid = pathParameters.getFirst("uid");
		
		FormDataBodyPart nameField = formParams.getField("name");
		FormDataBodyPart pic = formParams.getField("pic");
		ContentDisposition contentDisposition = pic.getContentDisposition();
		BodyPartEntity ipic = (BodyPartEntity)pic.getEntity();
		System.out.println(ipic.getInputStream() + "::" + contentDisposition.getFileName());
		
		return Response.ok("helloPostAsMultiPart :: " + uid + " :: " + nameField.getValue()).build();
	}
	
}
