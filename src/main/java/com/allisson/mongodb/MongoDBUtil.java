package com.allisson.mongodb;

import java.util.HashMap;
import java.util.Map;

import com.allisson.model.Bean;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {

	private static final String DATABASE = "per";
	private static final String SERVER_IP = "localhost";
	
	private static final Map<MongoDatabase, MongoClient> connections = new HashMap<MongoDatabase, MongoClient>();
	
	
	public static <T extends Bean> MongoDatabase getDatabase() {
		MongoClient client = new MongoClient(SERVER_IP);
		MongoDatabase db = client.getDatabase(DATABASE);
		connections.put(db, client);
		return db;
	}
	
	public static void closeConnection(MongoDatabase db) {
		MongoClient client = connections.remove(db);
		if(client != null) client.close();
	}
	
}
