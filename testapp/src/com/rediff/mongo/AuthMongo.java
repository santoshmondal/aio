package com.rediff.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class AuthMongo {
	private static DB db = null;
	
	public AuthMongo() {
		try {
			MongoClientOptions.Builder builder = new MongoClientOptions.Builder();

			
			builder.connectionsPerHost(10);
			builder.connectTimeout(20000);
			builder.maxWaitTime(20000);
			builder.socketTimeout(20000);

			builder.threadsAllowedToBlockForConnectionMultiplier(300);
			builder.socketKeepAlive(true);
			builder.writeConcern(WriteConcern.SAFE);
			builder.readPreference(ReadPreference.secondaryPreferred());

			MongoClientOptions build = builder.build();
			MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017), build);

			db = mongoClient.getDB("backyard");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("AUTH MONGO!!");
		System.out.println();
	}

}
