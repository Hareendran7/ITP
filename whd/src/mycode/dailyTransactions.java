/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class dailyTransactions {
    
    public double RetailerDamage(PreparedStatement pst, Connection conn,ResultSet rs,String date){
        double sum=0;
        try{
            String sql="select sum(dmgr_tot) from  dmgret where dmgr_date='"+date+"'";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            //sum=rs.getFloat(1);
            sum=rs.getDouble(1);
        }catch(Exception e){
            System.out.println(e);
            
        }
        return sum;
    }
    
     public double SupplierPaymentStockExpense(PreparedStatement pst, Connection conn,ResultSet rs,String date){
        double sum=0;
         try{
            String sql="select sum(paid_amount) from  suppayment where paid_date='"+date+"'";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            //sum=rs.getFloat(1);
            sum=rs.getDouble(1);
        }catch(Exception e){
            System.out.println(e);
            
        }
        
        return sum;
    }
     
     
         public double delivery(PreparedStatement pst, Connection conn,ResultSet rs,String date){
        double sum=0;
         try{
            String sql="select sum(main_cost) from  maintenance where main_date='"+date+"'";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            //sum=rs.getFloat(1);
            sum=rs.getDouble(1);
        }catch(Exception e){
            System.out.println(e);
            
        }
        
        return sum;
    }


  public double retailerIncome(PreparedStatement pst, Connection conn,ResultSet rs,String date){
         double sum=0;
         
          try{
            String sql=" select sum(amou) from  set_payment where set_date='"+date+"'";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
           // sum=rs.getFloat(1);
            sum=rs.getDouble(1);
              
             
    }catch(Exception e){
            System.out.println(e);
        
    }
         
         return sum;
     }
    
    
}
