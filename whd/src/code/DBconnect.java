
package code;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnect {
    
    
    public static Connection connect()
    {
        Connection conn=null;
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/whouse","root","root");
            
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return conn;
        
    }
}
