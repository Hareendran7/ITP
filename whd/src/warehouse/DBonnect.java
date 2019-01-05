/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;
import java.sql.*;
import com.mysql.jdbc.Connection;
/**
 *
 * @author vijeyaratnam
 */
public class DBonnect {
    
    public static Connection getConnection() 
    { 
        Connection con=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/whouse", "root", "root");
        }
        
        catch (Exception e)
        {
            System.out.println("error in connection:"+e);
        }
        return con;
    }
/*
    public static Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
  */          
        

    
}
