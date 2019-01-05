/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {
    
    
        public static void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:A:/Gangesh/ITP Integrated&working/whd/db/" + fileName;
 
        try (Connection conn =DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (Exception e) {
            System.out.println("qqq   "+ e);
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewDatabase("wh.db");
    }
    
    
}
