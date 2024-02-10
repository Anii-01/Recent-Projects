/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author anike
 */
public class ConnectionProvider {
    
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?allowPublicKeyRetrieval=true&useSSL=false","root","Aniphand@123");
            return con;
            //jdbc:mysql://localhost:3306/db?allowPublicKeyRetrieval=true&useSSL=false
        }
            catch(Exception e){
                    System.out.println(e);
                    return null;
                    }
        
    }
    
}
