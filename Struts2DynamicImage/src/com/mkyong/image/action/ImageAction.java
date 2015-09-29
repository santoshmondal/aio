package com.mkyong.image.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.bson.types.Binary;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements ServletRequestAware {

	byte[] imageInByte = null;
	String imageId;

	private HttpServletRequest servletRequest;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public ImageAction() {
		System.out.println("ImageAction");
	}

	public String execute() {
		return SUCCESS;
	}

	public byte[] getCustomImageInBytes1() {

		System.out.println("imageId" + imageId);

		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(getImageFile(this.imageId));
			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imageInByte;
	}
	
	public byte[] getCustomImageInBytes() {

		System.out.println("imageId " + imageId );
		try {
			imageInByte = readMongo();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return imageInByte;
	}

	private File getImageFile(String imageId) {
		String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
		File file = new File(filePath + "/Image/", imageId);
		System.out.println(file.toString());
		return file;
	}

	public String getCustomContentType() {
		return "image/jpeg";
	}

	public String getCustomContentDisposition() {
		return "anyname.jpg";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;

	}
	
	private void mongoInsert() {
		try{
			Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("imagedb");
            DBCollection collection = db.getCollection("dummyColl");
             
            String filename = "/home/santoshm/Pictures/days.jpg";
            String empname ="ABC";
             
            File imageFile = new File(filename);
            FileInputStream f = new FileInputStream(imageFile);
 
            byte b[] = new byte[f.available()];
            f.read(b);
 
            Binary data = new Binary(b);
            BasicDBObject o = new BasicDBObject();
            o.append("name",empname).append("photo",data);
            collection.insert(o);
            System.out.println("Inserted record.");
 
            f.close();
		} catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	private byte[] readMongo() {
		byte[] sReturn = null;
		
		try{
			Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("imagedb");
            DBCollection collection = db.getCollection("dummyColl");

            DBObject obj = collection.findOne();
            String n = (String)obj.get("name");
            sReturn = (byte[])obj.get("photo");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return sReturn;
	}

	public static void main(String[] args) {
		ImageAction ref = new ImageAction();
		//ref.mongoInsert();
		ref.readMongo();
	}
}