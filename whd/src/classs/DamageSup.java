
package classs;

import Class.DBconnecter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author it16112810
 */
public class DamageSup {
    
   
            public static Connection connect()
    {
       Connection conn = null;
       
       try {
           Class.forName("com.mysql.jdbc.Driver");
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/whouse","root","");
       
       }
       catch(Exception e){
           System.out.println(e);
           
    }
       return conn;
    }
       
        Connection conn = null;
     
         
 
      
   public ArrayList<stockD>getData(String stoc_id){
      
    ArrayList<stockD> list = new ArrayList<stockD>();
    Connection conn = connect();
        PreparedStatement pst ;
        ResultSet rs;
       try{
           
             String sql="SELECT stoc_id,prod_id,size_1,prod_name,quantity,rece_date,expi_date,desc_1,stor_location FROM stock WHERE stoc_id ='"+stoc_id+"' ";
             pst=conn.prepareStatement(sql);
             rs= pst.executeQuery();
             stockD p;
  
            while(rs.next()){
                
                p = new stockD(rs.getString("stoc_id"),rs.getString("prod_id"),rs.getString("size_1"),rs.getString("prod_name"),rs.getString("quantity"),rs.getString("rece_date"),rs.getString("expi_date"),rs.getString("desc_1"),rs.getString("stor_location"));
     
                list.add(p);

            }

         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);

         }
         return list;
       
    
    }
    
    
    
  
    
    
    
}
