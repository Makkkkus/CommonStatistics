package com.statistics;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.UUID;

import org.bson.Document;

import com.mongodb.client.MongoClient;

public class Database {
	private static MongoCollection<Document> players;
	private static MongoDatabase db;
	private static MongoClient client;

	// Default port: 27017
	public static void create(String ip, int port) {
		//create(null, null, ip, port);
		client = MongoClients.create("mongodb://" + ip + ":" + port);

		db = client.getDatabase("commonstatistics");
		players = db.getCollection("players");
	}

	public static void create(String username, String password, String ip, int port) {
		client = MongoClients.create((username.equals(null) || password.equals(null))
				? ("mongodb://" + username + ":" + password + "@" + ip + ":" + port)
				: ("mongodb://" + ip + ":" + port));

		db = client.getDatabase("commonstatistics");
		players = db.getCollection("players");
	}

	public static void storePlayer(UUID uuid, String name) {
		Document obj = new Document("uuid", uuid);
		obj.put("name", name);
		players.insertOne(obj);
	}
}
