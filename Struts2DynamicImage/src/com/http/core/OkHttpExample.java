package com.http.core;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class OkHttpExample {
	private static final OkHttpClient client = new OkHttpClient();
	public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=UTF-8");

	public static void main(String[] args) throws Exception {
		// doGetRequest();
		// doPostRequest();
		// doPostRequestBodyAsString();
		//doPostRequestMultipart(); 
		postingAFile();
	}

	public static void doGetRequest() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("fname", "JAVA PROGRAMMING");
		String postParams = getPostDataString(params);

		String url = "http://localhost:8080/Struts2DynamicImage/rest/helloGetParam/1?";
		Request.Builder rBuilder = new Request.Builder();
		Request request = rBuilder.url(url + postParams).build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			throw new IOException("Unexpected code " + response);
		}

		Headers responseHeaders = response.headers();
		for (int i = 0; i < responseHeaders.size(); i++) {
			System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
		}

		System.out.println(response.body().string());
	}

	public static void doPostRequestBodyAsString() throws Exception {
		String url = "http://localhost:8080/Struts2DynamicImage/rest/helloPostAsBody/3";
		String postBody = "{'name':'java'}";

		Request request = new Request.Builder().url(url).post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		System.out.println(response.body().string());
	}

	public static void doPostRequest() throws Exception {
		String url = "http://localhost:8080/Struts2DynamicImage/rest/helloPostParam/1";

		FormEncodingBuilder ref = new FormEncodingBuilder();
		ref.add("fname", "JAVA PROGRAMMING");
		RequestBody formBody = ref.build();

		Request request = new Request.Builder().url(url).post(formBody).build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		System.out.println(response.body().string());
	}

	public static void doPostRequestMultipart() throws Exception {
		MediaType MEDIA_TYPE_PNG = MediaType.parse("image/jpeg");

		String imgFile = "/home/santoshm/Pictures/days.jpg";
		File imageFile = new File(imgFile);

		RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM)
				.addPart(Headers.of("Content-Disposition", "form-data; name=\"name\""),
						RequestBody.create(null, "Square Logo"))
				.addPart(Headers.of("Content-Disposition", "form-data; name=\"fname\""),
						RequestBody.create(null, "Square Logo"))
				.addPart(Headers.of("Content-Disposition", "form-data; name=\"pic\""),
						RequestBody.create(MEDIA_TYPE_PNG, imageFile))
				.build();

		String url = "http://localhost:8080/Struts2DynamicImage/rest/helloPostAsMultiPart/1";
		Request request = new Request.Builder().url(url).post(requestBody).build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		System.out.println(response.body().string());
	}

	public static void postingAFile() throws Exception{
		File file = new File("/home/santoshm/Pictures/days.jpg");

		String url = "http://localhost:8080/Struts2DynamicImage/rest/helloPostFile/1";
		Request request = new Request.Builder().url(url)
				.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file)).build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		System.out.println(response.body().string());
	}

	private static String getPostDataString(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (first) {
				first = false;
			} else {
				result.append("&");
			}

			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}

		return result.toString();
	}
}
