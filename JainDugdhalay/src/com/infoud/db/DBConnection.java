package com.infoud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.infoud.constants.DBConstants;

public class DBConnection {

	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ="
					+ DBConstants.DB_CONNECTION_URL + ";";
			conn = DriverManager.getConnection(database, "", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
