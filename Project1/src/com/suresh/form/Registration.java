package com.suresh.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Registration {
           public static void main(String[] args) {
        	   
			 Connection con;
			try (Scanner sc = new Scanner(System.in)){
				 System.out.println("Enter your name");
				 String uname =sc.nextLine();
				 System.out.println("Enter your mailId");
					String uemail =sc.nextLine();
					 System.out.println("Enter your Password");
					String upwd =sc.nextLine();
					 System.out.println("Enter your mobilenumber");
					String umobile =sc.nextLine();
		            Class.forName("org.postgresql.Driver");
		           con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_db?useSSL=false","postgres", "root");
		           PreparedStatement pst = con.prepareStatement("insert into users(uname, upwd, uemail, umobile) values(?, ?, ?, ?)");
		            pst.setString(1, uname);
		            pst.setString(2, upwd);
		            pst.setString(3, uemail);
		            pst.setString(4, umobile);
		           
		            int rowCount = pst.executeUpdate();
		            if(rowCount > 0) {
		            	System.out.println("Registration Successfull");
		            }else {
		            	System.out.println("Registration failed");
		            }
				}catch(Exception e) {
					e.printStackTrace();
				}
			
		}


}
