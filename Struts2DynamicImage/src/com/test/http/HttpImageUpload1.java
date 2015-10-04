package com.test.http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;


/**
 * http://stackoverflow.com/questions/1378920/how-can-i-make-a-multipart-form-data-post-request-using-java
 * @author santoshm
 *
 */
public class HttpImageUpload1 {
	public static void main(String[] args) throws Exception{
		doupload();
	}
	
	public static void doupload() throws Exception{
		URL url = new URL("http://localhost:8080/zoomot_services/zoomot/user/upic/1");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");

		FileBody fileBody = new FileBody(new File("/home/santoshm/Pictures/days.jpg"));
		MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.STRICT);
		multipartEntity.addPart("picFile", fileBody);

		connection.setRequestProperty("Content-Type", multipartEntity.getContentType().getValue());
		OutputStream out = connection.getOutputStream();
		try {
		    multipartEntity.writeTo(out);
		} finally {
		    out.close();
		}
		
		int status = connection.getResponseCode();
		InputStream in = new BufferedInputStream(connection.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		
		connection.disconnect();
	}
}	
