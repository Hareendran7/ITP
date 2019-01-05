package code;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import static java.sql.JDBCType.BLOB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.sql.Types.BLOB;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class product_1 {
    
    Connection con = null;
    PreparedStatement pst = null;       //contains a sql statement which has been pre compiled
    ResultSet rs = null;    //Sql statements which read data from a database query, return the queried data to the resultset.
    PreparedStatement pst7 = null;       //contains a sql statement which has been pre compiled
    ResultSet rs7 = null; 
    
    
    private String product_id;
    private String product_name;
    private String supplier_id;
    private String supplier_name;
    private String size_1;
    private String category;
    private double buy_price;
    private double sell_price;
    private double mrp;
    private int quantity;
    private int reorder_level;
    private int container_size;
    private String description;
     //private BLOB image;
  
    public String prod_id1="";
    
public void setProductID(String n)

   {
      product_id = n;
        
    }
public void setProductName(String n)
    {
        product_name = n;
        
    }

 public  void setSupplierID(String n)
    {
        supplier_id= n;
        
    }
 
 public  void setSupplierName(String n)
    {
        supplier_name= n;
        
    }
 public void setSize(String n)
    {
       size_1 = n;
        
    }

 public void setCategory(String n)
    {
       category = n;
        
    }
 
 public void setBuyPrice(double n)
    {
       buy_price = n;
        
    }
 public void setSellPrice(double n)
    {
      sell_price = n;
        
    }
 
  public void setMrp(double n)
    {
      mrp = n;
        
    }
  
  public void setQuantity(int n)
    {
       quantity = n;
        
    }
public void setReorderLevel(int n)
    {
        reorder_level= n;
        
    }
public void setContainerSize(int n)
    {
        container_size= n;
        
    }
 public  void setDescription(String n)
    {
       description= n;
        
    }
 
 
    
   public String genProductID()
           {
        try{
            String qry="SELECT product_id FROM product ORDER BY prod_id DESC LIMIT 1";
            pst=con.prepareStatement(qry);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String r1=rs.getString(prod_id1);
                int ln=r1.length();
                String stxt=r1.substring(0,3);
                String snum=r1.substring(3,ln);
                int n=Integer.parseInt(snum);
                n++;
                snum=Integer.toString(n);
                
     return  (stxt+snum);
                
            }
            else
            {
     return "pro123";
            }
            }
        
        catch(Exception e){
    
        JOptionPane.showMessageDialog(null,e);
    }
        return "pro123";
    }
   
   public void checkProductAvailability()
   {
       try{
    con = DBconnect.connect();
      
    String query2="select * from produt where prod_name='"+product_name+"', size='"+size_1+"' ";
    pst7 = con.prepareStatement(query2);
    rs7 = pst7.executeQuery();
            
    if(rs.getRow()==0)
      JOptionPane.showMessageDialog(null,"Product Already Avilable");
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
            
          
    String query2=" select * from product where prod_name='"+product_name+"' and size_1='"+size_1+"' ";
    pst7 = con.prepareStatement(query2);
    rs7 = pst7.executeQuery();
            
    if(rs7.next())
        {
      JOptionPane.showMessageDialog(null,"Product Already Avilable");
        }  
      
        else {  
     String query = "INSERT into product values ('"+product_id+"','"+size_1+"','"+product_name+"','"+supplier_id+"','"+supplier_name+"','"+buy_price+"','"+sell_price+"','"+mrp+"','"+quantity+"','"+category+"','"+reorder_level+"','"+container_size+"','"+description+"')";
        
      pst = con.prepareStatement(query);      //contains a precompiled sql statement
      pst.execute();      //used to execute a query
      JOptionPane.showMessageDialog(null,"Record Successfully Entered");
        }
        }
     
        catch(Exception e)
        {
            System.out.println("Error :"+e);
        }
          
          
        
    }
  void add_product()
    {
    try{
          
     
    //String qry="INSERT INTO untitled (product_id,supplier_id,supplier_name,product_name,unit_price,description) values ('"+product_id+"','"+Supplier_ID+"',
   // pst=con.prepareStatement(qry);
      pst.execute();
      JOptionPane.showMessageDialog(null,"Data stored");
    }                                        
     catch(Exception e)
        {
            System.out.println("Error :"+e);
        }
    }

    
 
    }
        
    
    
    
    