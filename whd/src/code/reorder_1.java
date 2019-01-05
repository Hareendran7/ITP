/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author HARIpc
 */
public class reorder_1 {
    
    Connection con = null;
    PreparedStatement pst = null;       //contains a sql statement which has been pre compiled
    ResultSet rs = null; 
    
    private String reorder_id;
    private String product_id;
    private String product_name;
    private String size_1;
    private String supplier_id;
    private String supplier_name;
    private int quantity;
    private Date reorder_date;
    private String status;
    
    public void setReorderID(String n)

   {
      reorder_id = n;
        
    }
    public void setProductID(String n)
    {
        product_id = n;
        
    }

    public  void setProductName(String n)
    {
        product_name= n;
        
    }
    
    public  void setSize(String n)
    {
        size_1= n;
        
    }
    
    public  void setSupplierID(String n)
    {
        supplier_id= n;
        
    }
 
    public  void setSupplierName(String n)
    {
        supplier_name= n;
        
    }
    
    public void setQuantity(int n)
    {
       quantity = n;
        
    }
    
    public void setReorderDate(Date n)
    {
      reorder_date = n;
        
    }
    
    public  void setStatus(String n)
    {
       status= n;
        
    }
    
    
    
    public  void storeDB()
    {
        con = DBconnect.connect();
        try
        {
         
     String query = "INSERT into reorder values ('"+reorder_id+"','"+product_id+"','"+product_name+"','"+size_1+"','"+supplier_id+"','"+supplier_name+"','"+quantity+"','"+new java.sql.Date(reorder_date.getTime())+"','"+status+"')";
        
      pst = con.prepareStatement(query);      //contains a precompiled sql statement
      pst.execute();      //used to execute a query
      JOptionPane.showMessageDialog(null,"Record Successfully Entered");
        }
        
        catch(Exception e)
        {
            System.out.println("Error :"+e);
        }
          
           
    }     
    
    
    public void checkReorder()
    {
        //product ids of the processing order
       // String a= prod_id;
        
       //select qunatity, rol from product where prod_id=a

    //if((ReorderLevel>Quantity)&&(Quantity<purchaseQuantity))
         String query = "INSERT into reorder values ('"+reorder_id+"','"+product_id+"','"+product_name+"','"+size_1+"','"+supplier_id+"','"+supplier_name+"','"+quantity+"','"+status+"')";
        
        
    
    
    }
    
    
}
