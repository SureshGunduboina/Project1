package com.suresh.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
       public static void main(String[] args) {
    	   try (Scanner sc = new Scanner(System.in);){
    	   
    	   System.out.println("Please Enter Username");
    	   String username = sc.nextLine();
    	   System.out.println("Please Enter Password");
    	   String password = sc.nextLine();
   		
			 Class.forName("org.postgresql.Driver");
	         Connection  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_db","postgres", "root");
	           PreparedStatement pst = con.prepareStatement("select * from users where uname = ? and upwd = ?");
	            pst.setString(1, username);
	            pst.setString(2, password);
	            
	            ResultSet rs = pst.executeQuery();
	            if(rs.next()) {
	            	System.out.println("Valid login Credentials");
	            	System.out.println("Welcome  "+ username);
	            }else {
	            	System.out.println("Invalid Login Credentials");
	            }
	           
		}catch(Exception e) {
			System.out.println("Something went wrong !! Please try again "+e);
		}
	}

}
    	   
      
