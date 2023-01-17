package com.postGreSQL.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectDB {
	static Connection connection=null;
	public Connection EstablishConnection(String dbName, String dbUserName, String dbPassword) {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost/"+dbName,dbUserName,dbPassword);
			if(connection!=null) {
				System.out.println("[CONNECTED TO POSTGRESQL]");
			}else {
				System.out.println("Connection not established.. due to an error.");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	/*public   void CreateTable(Connection conn, String Table_Name) {
		PreparedStatement pst = null;
		try {
			String query = "create table "+Table_Name+"(pid SERIAL, pname varchar(255), pcheck varchar(255), pmnf varchar(255), primary key(pid));";
			pst = conn.prepareStatement(query);
			pst.executeLargeUpdate();
			System.out.println("Table '"+Table_Name+"'  Created Successfully...");
		}catch(Exception e) {
			System.out.println(e);
		}
	}*/
}
