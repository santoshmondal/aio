package com.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class ImageTest {
	public static void main(String[] args) {
		byteArrayToImage();
	}

	public static void byteArrayToImage() {
		byte[] sReturn = null;

		try {
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("imagedb");
			DBCollection collection = db.getCollection("dummyColl");

			DBObject obj = collection.findOne();
			String n = (String) obj.get("name");
			sReturn = (byte[]) obj.get("photo");

			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(sReturn);
			BufferedImage bImageFromConvert = ImageIO.read(in);

			ImageIO.write(bImageFromConvert, "jpg", new File("/home/santoshm/Desktop/1.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
