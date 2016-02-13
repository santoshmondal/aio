package com.affixus.util;

import com.affixus.pojo.Auth;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	

	public static Object jsonToObject(String json, Class<?> clazz) {

		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String objectToJson(Object object) {
		try {

			return mapper.writeValueAsString(object);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	

	public static void main(String[] args) {
		String json = "{\"userid\":\"abcdef\",\"password\":\"12345\"}";
		
		Auth auth = (Auth)JsonUtil.jsonToObject(json, Auth.class);
		
		
		System.out.println(auth);
	}
}
