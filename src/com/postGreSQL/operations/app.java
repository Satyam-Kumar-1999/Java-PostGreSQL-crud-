package com.postGreSQL.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import com.postGreSQL.connection.CRUD;
import com.postGreSQL.demo.Product;
import com.postGreSQL.connection.ConnectDB;

public class app {

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		ConnectDB CDB = new ConnectDB();
		Connection connection  = CDB.EstablishConnection("Employee", "postgres", "jerry123");
		//CDB.CreateTable(connection, "Products");
		System.out.println("JAVA CONNECTIVITY WITH POSTGreSQL..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("-------------------------------------");

			System.out.println("1 . Insert Data To Database");
			System.out.println("2 . Display Data From Database");
			System.out.println("3 . Delete Data From Dataabse");
			System.out.println("4 . Update Data In Database");
			System.out.println("5 . Exit Application");
			try {
			int choice = Integer.parseInt(br.readLine());
			switch(choice) {                            
			case 1:
			 
				System.out.println("Enter The Product Name");
				String productName = br.readLine();	
		 
				System.out.println("Enter The Product Quality");
				String ProductQuality = br.readLine();
				System.out.println("Enter The Manufacture Place");
				String MnfPlace = br.readLine();
				if(productName == "" || ProductQuality =="" || MnfPlace =="") {
					System.out.println("------------------------------------------");
					System.out.println("Sorry, Product Details Should Not Be Empty.");
				}else {
				Product p = new Product(productName, ProductQuality, MnfPlace);
				boolean taskDone =CRUD.Create_Operation(p);
				if(taskDone) {
					System.out.println("Data Inserted Successfully..");
				}else {
					System.out.println("Data Not Insrted. Due to an error.");
				}
				}
				
			break;
			case 2:
				  CRUD.Read_Operation();
			break;
			case 3:
				System.out.print("Enter The Product Id : ");
				int pid = Integer.parseInt(br.readLine());
				CRUD.Delete_Operation(pid);
			break;
			case 4:
				System.out.println("-------------------------------------");
				System.out.println("1) Update Product Name.");
				System.out.println("2) Update Product Quality Check.");
				System.out.println("3) Update Product Manufacturing Place.");
				int updateChoice = Integer.parseInt(br.readLine());
			switch(updateChoice) {
			case 1:
				System.out.print("Enter The Product Id : ");
				int pid1 = Integer.parseInt(br.readLine());
				System.out.println("Enter the new name for thiS Product Id : ");
				String pname = br.readLine();
				CRUD.Update_Operation_Pname(pid1, pname);
				break;
			case 2:
				System.out.print("Enter The Product Id : ");
				int pid2 = Integer.parseInt(br.readLine());
				System.out.println("Enter the new quality status for this Product Id : ");
				String pcheck = br.readLine();
				CRUD.Update_Operation_Pcheck(pid2, pcheck);
				break;
			case 3:
				System.out.print("Enter The Product Id : ");
				int pid3 = Integer.parseInt(br.readLine());
				System.out.println("Enter the new manufacturing place for this Product Id :");
				String pmnf = br.readLine();
				CRUD.Update_Operation_Pmnf(pid3,pmnf);
				break;
			default: System.out.println("[Choose Option From 1 to 3.]");
			}
			break;
			case 5:                                  
			System.out.println("Made with Love with Jerry.");
			System.exit(0);
			default:System.out.println("Select choice from 1 to 5.");
			}
			}catch(NumberFormatException nfe) {
				System.out.println("Empty Input Not Allowed.");
			}
		}
		}
	}

