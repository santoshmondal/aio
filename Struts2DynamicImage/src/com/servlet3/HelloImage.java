package com.servlet3;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * Servlet implementation class HelloImage
 */
@WebServlet("/HelloImage")
public class HelloImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");

		try {
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("imagedb");
			DBCollection collection = db.getCollection("dummyColl");

			DBObject obj = collection.findOne();
			String n = (String) obj.get("name");
			byte[] sReturn = (byte[]) obj.get("photo");

			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(sReturn);
			BufferedImage bImageFromConvert = ImageIO.read(in);

			OutputStream out = response.getOutputStream();
			ImageIO.write(bImageFromConvert, "jpg", out);

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
