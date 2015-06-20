package com.rediff;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HelloTest {
	public static final String WORKING_PATH = "/home/santoshm/Desktop/rule.txt";
	
	public static void main(String[] args) throws Exception{
		List<String> list = new ArrayList<String>();
		list.add("JAI");
		list.add(null);
		System.out.println(list);
	}

	public static void encodeDecode() throws UnsupportedEncodingException {
		String str = "santosh !@#$%";
		String encode = URLEncoder.encode(str, "UTF-8");
		System.out.println(encode);
		
		System.out.println(URLDecoder.decode("a%20b+c", "UTF-8"));
	}
}
