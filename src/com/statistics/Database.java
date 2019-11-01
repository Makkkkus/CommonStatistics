package com.statistics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static String url;

	static Connection connection;

	public static void InitDatabase(String ip, int port, String servername, String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("JDBC driver unavailable!");
			return;
		}

		url = "jdbc:mysql:" + ip + ":" + port + "/" + servername;

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void DisableDatabase() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
