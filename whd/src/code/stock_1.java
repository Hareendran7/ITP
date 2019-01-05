/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.Date;

public class stock_1 {
    
    Connection con = null;
    PreparedStatement pst = null;       //contains a sql statement which has been pre compiled
    ResultSet rs = null;    //Sql statements which read data from a database query, return the queried data to the resultset.
    PreparedStatement pst2 = null;       //contains a sql statement which has been pre compiled
    ResultSet rs2 = null;   
    
    private String stock_id;
    private String product_id;
    private String size_1;
    private String product_name;
    private int quantity;
    private Date received_date;
    private Date expiary_date;
    private String description;
    private String storage_location;
    
   public String stock_id1="";
   
   public void setStockID(String n)

   {
      stock_id = n;
        
    }
    
 public  void setProductID(String n)
    {
       product_id= n;
        
    }
    
 public void setSize(String n)
    {
       size_1 = n;
        
    }
 
 public void setProductName(String n)
    {
       product_name = n;
        
    }
    
 public void setQuantity(int n)
    {
       quantity = n;
        
    }
public void setReceivedDate(Date n)
    {
      received_date = n;
        
    }
    
 public   void setExpiaryDate(Date n)
    {
      expiary_date = n;
        
    }
    
 public  void setDescription(String n)
    {
       description= n;
        
    }
 
 public  void setStorageLocation(String n)
    {
       storage_location= n;
        
    }
 
 public void product()
 {
     con = DBconnect.connect();
     int a=0;
     int b;
     try
        {
         
        String query = "select quantity from product where prod_id='"+product_id+"' ";
        
        pst = con.prepareStatement(query);      //contains a precompiled sql statement
        rs=pst.executeQuery();      //used to execute a query
      
        while(rs.next())
        {  
           a=rs.getInt("quantity");
        }
           b=quantity+a;
     
        String query2="update product set quantity='"+b+"' where prod_id='"+product_id+"' ";
        
             pst2=con.prepareStatement(query2);
            pst2.execute();  
            JOptionPane.showMessageDialog(null,"Updated");
        
       // JOptionPane.showMessageDialog(null,"Record Successfully Entered");
        
        }
    catch(Exception e)
        {
            System.out.println("Error :"+e);
        }
          
           
    }     
 
 
 
 
 
 
 
 
 
 
 public  void storeDB()
    {
    con = DBconnect.connect();
    
    try
        {
         
        String query = "INSERT into stock values ('"+stock_id+"','"+product_id+"','"+size_1+"','"+product_name+"','"+quantity+"','"+new java.sql.Date(received_date.getTime())+"','"+new java.sql.Date(expiary_date.getTime())+"','"+description+"','"+storage_location+"')";
        
        pst = con.prepareStatement(query);      //contains a precompiled sql statement
        pst.execute();      //used to execute a query
      
        //String query2="select 
        
        
        JOptionPane.showMessageDialog(null,"Record Successfully Entered");
        }
        
    catch(Exception e)
        {
            System.out.println("Error :"+e);
        }
          
           
    }     
}
