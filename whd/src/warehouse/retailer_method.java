/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;
import java.sql.*;
import javax.swing.JOptionPane;

import warehouse.database_con;

 
public class retailer_method {
    
     Connection con = null;
    PreparedStatement pst = null;       //contains a sql statement which has been pre compiled
   ResultSet rs = null;        //Sql statements which read data from a database query, return the queried data to the resultset.
    
   static double lat;
   static double lan;
   static double dis;
   static String retailerID;
   static String retailerAdd;
   static String retailerName;
   static String retailerCon;
   static String  retailerAdd2;
   static String email;
   
   void setdistance(double s){
   dis=s;
   }
   void setlang(double r){
   lan=r;
   
   }
   void setlati(double q){
   lat=q;
   
   }
   void setEmail(String p){
   email=p;
   
   }
   void setADD2(String e){
   retailerAdd2=e;
   
   }
   void setID (String a){
       retailerID=a;
   }
   void setADD(String b){
       retailerAdd=b;
   }
   void setName(String c){
       retailerName=c;
       
   }
   void setContact(String d){
       retailerCon=d;
   }
   
   
  boolean check_lenphone(String n)        
    {
        if((n.length()==10))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
   public void Connet(){
   
       con=database_con.connect();
       
       try{
           String q="insert into retailer(ret_id,ret_name,ret_contact,ret_address,ret_address2,email,latitude,langtitude,distance) values('"+retailerID+"','"+retailerName+"','"+retailerCon+"','"+retailerAdd+"','"+retailerAdd2+"','"+email+"','"+lat+"','"+lan+"','"+dis+"')";
               
           pst = con.prepareStatement(q);
           pst.execute();
           JOptionPane.showMessageDialog(null,"Record Successfully Added");
       }
       catch(Exception e){
       System.out.println("error"+e);
       }
   
   }
   
       void deleterrecord(String retailerID)
            {
            
                   con=database_con. connect();
                 
                 try{
                 
                     String sql= "DELETE FROM retailer where ret_id = '"+retailerID+"' "  ;
                         pst = con.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null,"Record Successfully Deleted");
                        
                        
                        
                        
                     
                
                 
                 }
                   catch(Exception e)
                {
                System.out.println("error"+e);
                 JOptionPane.showMessageDialog(null,"Order under process");
                }
                 
                
            }
       
                 void updaterecord(String retailerID)
            {
            
                con=database_con. connect();
                 
                 try{
                 
                     String sql= "UPDATE retailer SET ret_id='"+retailerID+"',ret_name='"+retailerName+"',ret_address='"+retailerAdd+"',ret_contact='"+retailerCon+"',ret_address2='"+retailerAdd2+"',email='"+email+"' where ret_id = '"+retailerID+"' "  ;
                         pst = con.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null,"Record Successfully Updated");
                        
           
                 
                 }
                   catch(Exception e)
                {
                System.out.println("error"+e);
                }
                 
                
            }
                 
                    boolean check_emailid(String z)
    {
        int countat = 0;
        
        for(int i=0;i<z.length();i++)
        {
            if(z.charAt(i)=='@')
            {
                countat++;
            }
        }
       
        if((countat>0)&&((z.lastIndexOf("@")) < (z.lastIndexOf(".com"))) && (z.endsWith(".com")))
        {
            //System.out.println("index of .com is : "+ e.lastIndexOf(".com"));
            return true;
        }
        return false;
    }
    
            
}
