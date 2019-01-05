/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import com.mysql.jdbc.Connection;
import javax.swing.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class DBconnecter {
 Connection conn = null;
     
    public static Connection connect (){ 
    
      try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/whouse","root","root");
           return conn;
        } 
catch(Exception e) {
       System.out.println("Error in DBconnector"+e);
       return null;
    }
}   
}