/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;
import java.sql.*;
import javax.swing.JOptionPane;

import warehouse.database_con;
import net.proteanit.sql.DbUtils;
/**
/**
 *
 * @author jega rinoshan
 */
public class methodw {
    
     Connection con = null;
    PreparedStatement pst = null;       //contains a sql statement which has been pre compiled
   ResultSet rs = null;    //Sql statements which read data from a database query, return the queried data to the resultset.
    
      
     static String orderid;
     static String order_date;
     static String productName;
     static String retailerid;
     static String suplierid;
     static String quty;
    static String deliveryid;
    static String totalAmount;
    static String productID;
    static String size;
    
   
 
    void setSize (String j){
    size=j;
}
    void setproID(String q){
        productID=q;
    }
    
    void setTot(String i){
        totalAmount=i;
    }
      
    
      void  SetOrderid (String a){
           orderid=a  ;
      }
      
           void  setDate (String b){
          order_date=b ;
      } 
      
        void SetProductname(String c){
         productName=c ;
      }
            void SetRetid (String d){
        retailerid=d ;
      }
            
          void SetSup( String e){
           suplierid=e;
      }
        void SetQty(String f){
          
             quty=f;

             
      } 

          void SetDel_id (String g){
             deliveryid=g;
      }
            
         
          void Connet()
            {
                con =database_con.connect();
                
                
                try{
                    
                    String q ="insert into order_1(ord_id,ord_date,ret_id,supp_id,due_date,total,prod_name,qty,prod_id,size_1) values('"+orderid+"','"+order_date+"','"+retailerid+"','"+suplierid+"','"+deliveryid+"','"+totalAmount+"','"+productName+"','"+quty+"','"+productID+"','"+size+"')";
                    
                        pst = con.prepareStatement(q);
                        pst.execute();
                        JOptionPane.showMessageDialog(null,"Record Successfully Added");
                }
                catch(Exception e)
                {
                System.out.println("error"+e);
                }
            }
             
            void deleterrecord(String ord_id)
            {
            
                 con =database_con.connect();
                 
                 try{
                 
                     String sql= "DELETE FROM order_1 where ord_id = '"+ord_id+"' "  ;
                         pst = con.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null,"Record Successfully Deleted");
                       
                        
                        
                        
                        
                     
                
                 
                 }
                   catch(Exception e)
                {
                System.out.println("error"+e);
                 JOptionPane.showMessageDialog(null,"Order is in process");
                }
                 
                
            }
          /*      void deletersuprecord(String ord_id)
            {
            
                 con =database_con.connect();
                 
                 try{
                 
                     String sql= "DELETE FROM order_details where ord_id = '"+ord_id+"' "  ;
                         pst = con.prepareStatement(sql);
                        pst.execute();
               
                 
                 }
                   catch(Exception e)
                {
                System.out.println("error"+e);
                }
                 
                
            } */
            
                 void updaterecord(String ord_id)
            {
            
                 con =database_con.connect();
                 
                 try{
                 
                     String sql= "UPDATE order_1 SET ord_date= '"+order_date+"',ret_id= '"+retailerid+"',due_date='"+deliveryid+"' where ord_id = '"+ord_id+"' "  ;
                         pst = con.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null,"Record Successfully Updated");
                        
           
                 
                 }
                   catch(Exception e)
                {
                System.out.println("error"+e);
                }
                 
                
            }

    
    
            
             
            
    
}
