package com.rediff.h2test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;
import org.h2.tools.Server;

public class HelloH2 {

	public static void main(String[] args) throws Exception {
		startServer();
		testConnection();
	}

	private static void testConnection() throws Exception {
		// delete the database named 'test' in the user home directory
		DeleteDbFiles.execute("~", "test", true);

		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
		Statement stat = conn.createStatement();

		// this line would initialize the database
		// from the SQL script file 'init.sql'
		// stat.execute("runscript from 'init.sql'");

		stat.execute("create table abc(id int primary key, name varchar(255))");
		stat.execute("insert into abc values(1, 'Hello')");
		ResultSet rs;
		rs = stat.executeQuery("select * from abc");
		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
		stat.close();
		conn.close();
	}

	private static void startServer() throws SQLException {
		String[] args = new String[] {};
		Server server = Server.createTcpServer(args).start();
	}
}
