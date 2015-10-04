package com.test.http;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * http://stackoverflow.com/questions/1378920/how-can-i-make-a-multipart-form-data-post-request-using-java
 * http://www.codejava.net/java-se/networking/an-http-utility-class-to-send-getpost-request
 * GET with PARAMETER
 * POST with PARAMETER
 * POST with BODY
 * POST with entity image/textfile/mp3
 * POST with mulitple entity  
 * 
 * PARAMETER WD ENTITY
 */
public class HttpImageUpload {

	public static void main(String[] args) {
		uploadImageHttpUrlConnection();
	}

	public static void uploadImageHttpUrlConnection() {
		String charset = "UTF-8";
        File uploadFile1 = new File("/home/santoshm/Pictures/days.jpg");
        File uploadFile2 = new File("/home/santoshm/Pictures/clock.jpg");
        String requestURL = "http://localhost:8080/zoomot_services/zoomot/user/hello/1";
 
        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
             
            //multipart.addHeaderField("User-Agent", "CodeJava");
            //multipart.addHeaderField("Test-Header", "Header-Value");
             
            //multipart.addFormField("description", "Cool Pictures");
            //multipart.addFormField("keywords", "Java,upload,Spring");
             
            //multipart.addFilePart("picFile", uploadFile1);
            // multipart.addFilePart("fileUpload", uploadFile2);
 
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
             
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
	}
}
