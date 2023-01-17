package com.postGreSQL.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.postGreSQL.demo.Product;

public class CRUD {
	public static boolean Create_Operation(Product p)
	{
		Connection connection = null;
		boolean taskDone = false;
		try {
			ConnectDB CDB = new ConnectDB();
			connection = CDB.EstablishConnection("Employee", "postgres", "jerry123");
			String query = "insert into products(pname, pcheck, pmnf)values(?,?,?)";
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.setString(1, p.getProductName());
			prepared.setString(2, p.getProductCheck());
			prepared.setString(3, p.getMadeIn());
			prepared.executeUpdate();
			taskDone = true;
			prepared.close();
	
		}catch(Exception e) {
			System.out.println(e);
		}
		return taskDone;
	}
	public static void Read_Operation() {
		Connection connection = null;
		 
		try {
			ConnectDB CDB = new ConnectDB();
			connection = CDB.EstablishConnection("Employee", "postgres", "jerry123");
			String query = "SELECT * FROM products";
			PreparedStatement pst =  connection.prepareStatement(query);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				int pid = result.getInt(1);
				String pname = result.getString(2);
				String pcheck = result.getString(3);
				String pmnf = result.getString(4);
				
				System.out.println("[Product Id : "+pid+" ] [Product Name : "+pname+" ] [Product Quality : "+pcheck+" ] [Product Made In :"+pmnf+" ].");
			}
			 
		}catch(Exception e) {
			System.out.println(e);
		}
	 
	}
	public static boolean Delete_Operation(int pid) {
		Connection connection = null;
		boolean taskDone = false;
		try {
			ConnectDB CDB = new ConnectDB();
			connection = CDB.EstablishConnection("Employee", "postgres", "jerry123");
			String query = "DELETE FROM PRODUCTS WHERE pid = "+pid+";";
			String VerifyQuery = "SELECT * FROM products WHERE pid = "+pid+";";
			PreparedStatement VerifyCheck = connection.prepareStatement(VerifyQuery);
			PreparedStatement prepared = connection.prepareStatement(query);
		 
			ResultSet result = VerifyCheck.executeQuery();
			boolean ifNotExists = result.next();
			if(ifNotExists) {
			
			prepared.executeUpdate();
			System.out.println("Product Details Deleted Successfully...");
			taskDone = true;
			}
			else {
				System.out.println("There is no product with product Id "+pid );
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return taskDone;
	}
	public static boolean Update_Operation_Pname(int pid, String pname) {
		Connection connection = null;
		boolean taskDone = false;
		try {
			ConnectDB CDB = new ConnectDB();
			connection = CDB.EstablishConnection("Employee", "postgres", "jerry123");
			String VerifyQuery = "SELECT * FROM products where pid = "+pid+";";
			String query = "UPDATE products set pname = ? WHERE pid = "+pid+";";
			 
			PreparedStatement VerifyCheck = connection.prepareStatement(VerifyQuery);
			ResultSet Verify =  VerifyCheck.executeQuery();
			boolean ifExists = Verify.next();
			if(ifExists) {
				PreparedStatement prepared = connection.prepareStatement(query); 
				prepared.setString(1, pname);
				prepared.executeUpdate();
				System.out.println("Data Updated Successfully..");
				taskDone = true;
			}else {
				System.out.println("There is no product with product Id "+pid );
			}

		}catch(Exception e) {
			System.out.println(e);
		}
		return taskDone;
		
		
	}
	public static boolean Update_Operation_Pcheck(int pid, String pcheck) {
		Connection connection = null;
		boolean taskDone = false;
		try {
			ConnectDB CDB = new ConnectDB();
			connection = CDB.EstablishConnection("Employee", "postgres", "jerry123");
			String VerifyQuery = "SELECT * FROM products where pid = "+pid+";";
			String query = "UPDATE products set pcheck = ? WHERE pid = "+pid+";";
			 
			PreparedStatement VerifyCheck = connection.prepareStatement(VerifyQuery);
			ResultSet Verify =  VerifyCheck.executeQuery();
			boolean ifExists = Verify.next();
			if(ifExists) {
				PreparedStatement prepared = connection.prepareStatement(query);
				prepared.setString(1, pcheck);
				prepared.executeUpdate();
				System.out.println("Data Updated Successfully..");
				taskDone = true;
			}else {
				System.out.println("There is no product with product Id "+pid );
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return taskDone;
		
	}
	public static boolean Update_Operation_Pmnf(int pid, String pmnf) {
		Connection connection = null;
		boolean taskDone = false;
		try {
			ConnectDB CDB = new ConnectDB();
			connection = CDB.EstablishConnection("Employee", "postgres", "jerry123");
			String VerifyQuery = "SELECT * FROM products where pid = "+pid+";";
			String query = "UPDATE products set pmnf = ? WHERE pid = "+pid+";";
			PreparedStatement VerifyCheck = connection.prepareStatement(VerifyQuery);
			 
			ResultSet Verify = VerifyCheck.executeQuery();
			boolean ifExists = Verify.next();
			if(ifExists) {
				PreparedStatement prepared = connection.prepareStatement(query);
				prepared.setString(1, pmnf);
				prepared.executeUpdate();
				System.out.println("Data Updated Successfully..");
				taskDone = true;
			}else {
				System.out.println("There is no product with product Id "+pid );
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return taskDone;
		
	}
}
