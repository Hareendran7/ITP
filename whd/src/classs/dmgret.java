/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author it16112810
 */
public class dmgret {
    
     public double damagesumQuantity( ResultSet rs,PreparedStatement pst, Connection conn, String  text){
        double sum=0;
        try{
            
         String sqll= "select dmgr_qty from dmgret where dmgro_id ='"+text+"' ";
         pst = conn.prepareStatement(sqll);
         rs = pst.executeQuery();
         rs.next();
         sum=rs.getDouble(1);
         
        }catch(Exception e){
          System.out.println(e);  
        }
       return sum;
    }
    
    
    
    public double damagesumAmount( ResultSet rs,PreparedStatement pst, Connection conn, String text){
        double sum=0;
        try{
            
          String sqas= "select dmgr_tot from dmgret where dmgro_id ='"+text+"' ";
                        pst = conn.prepareStatement(sqas);
                        rs = pst.executeQuery();
                        rs.next();
         sum=rs.getDouble(1);
        }catch(Exception e){
            
        }
        
        
        
        return sum;
    }
    
    
      public double sumQuantity( ResultSet rs,PreparedStatement pst, Connection conn, String  text){
        double sum=0;
        try{
            
         String sqllq= "select quantity from product where prod_id ='"+text+"' ";
         pst = conn.prepareStatement(sqllq);
         rs = pst.executeQuery();
         rs.next();
         sum=rs.getDouble(1);
         
        }catch(Exception e){
          System.out.println(e);  
        }
       return sum;
    }
    
}