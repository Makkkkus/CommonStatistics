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
		create("", "", ip, port);
	}

	public static void create(String username, String password, String ip, int port) {
		client = MongoClients.create((username.equals("") || password.equals(""))
				? ("mongodb://" + ip + ":" + port)
				: ("mongodb://" + username + ":" + password + "@" + ip + ":" + port));

		db = client.getDatabase("commonstatistics");
		players = db.getCollection("players");
	}

	public static void storePlayer(UUID uuid, String name) {
		Document obj = new Document("uuid", uuid);
		obj.put("name", name);
		players.insertOne(obj);
	}

	public static Document readPlayer(UUID uuid) {
		Document r = new Document("uuid", uuid);
        return (Document) players.find(r);
    }

	public static void updatePlayer(UUID uuid, String name) {
		Document obj = new Document("uuid", uuid);
		obj.put("name", name);
		players.findOneAndReplace(readPlayer(uuid), obj);
	}
}
