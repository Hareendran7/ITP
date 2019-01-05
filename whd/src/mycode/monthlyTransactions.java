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
public class monthlyTransactions {
    
    //income
     public double stockProfit(PreparedStatement pst, Connection conn,ResultSet rs,String month,String year){
         double sum=0;
           try{
        String sql=" select sum(profit) from  stoc_profit where year(date)='"+year+"' and month(date)='"+month+"' ";
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
     
     public double otherIncome(PreparedStatement pst, Connection conn,ResultSet rs,int month,int year){
         double sum=0;
         try{
        String sql=" select sum(amount) from income where year(date)='"+year+"' and month(date)='"+month+"' and income_type <> 'retailer Income'";
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
     
      public double balance(PreparedStatement pst, Connection conn,ResultSet rs,String month,String year){
         double sum=0;
          try{
        String sql=" select balance from profit_loss where year='"+year+"' and month='"+month+"'";
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
      
      
       public double retailerIncome(PreparedStatement pst, Connection conn,ResultSet rs,int month,int year){
         
         double sum=0;
          try{
        String sql=" select sum(amou) from set_payment where year( set_date)='"+year+"' and month( set_date)='"+month+"'";
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
       
       
       //expenses
       
        public double RetailerDamage(PreparedStatement pst, Connection conn,ResultSet rs,int month,int year){
         double sum=0;
           try{
        String sql=" select sum(dmgr_tot) from   dmgret where year(dmgr_date)='"+year+"' and month(dmgr_date)='"+month+"' ";
        pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            sum=rs.getDouble(1);
              
    }catch(Exception e){
            System.out.println(e);
        
    }
          return sum;
    }
    
         public double Salary(PreparedStatement pst, Connection conn,ResultSet rs,int month,int year){
         double sum=0;
           try{
        String sql=" select sum(Netsalary) from   salary  where year(Date)='"+year+"' and month(Date)='"+month+"' ";
        pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            sum=rs.getDouble(1);
               System.out.println(sum);
        
    }catch(Exception e){
            System.out.println(e);
        
    }
          return sum;
    }
         
          public double stockExpense(PreparedStatement pst, Connection conn,ResultSet rs,int month,int year){
        double sum=0;
               try{
        String sql=" select sum(paid_amount) from  suppayment where year(paid_date)='"+year+"' and month(paid_date)='"+month+"'";
        pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            sum=rs.getDouble(1);
        
    }catch(Exception e){
            System.out.println(e);
        
    }
         return sum;
     
    }
          
           public double delivery(PreparedStatement pst, Connection conn,ResultSet rs,int month,int year){
        double sum=0;
               try{
        String sql=" select sum(main_cost) from  maintenance where year(main_date)='"+year+"' and month(main_date)='"+month+"'";
        pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            sum=rs.getDouble(1);
        
    }catch(Exception e){
            System.out.println(e);
        
    }
         return sum;
     
    }
           
            public double otherExpense(PreparedStatement pst, Connection conn,ResultSet rs,int month,int year){
         double sum=0;
         try{
        String sql=" select sum(amount) from  expense where year(date)='"+year+"' and month(date)='"+month+"' and expense_type <> 'Retailer damage'and expense_type <> 'Stock Expense ' and expense_type <> 'Delivery' ";
        pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            sum=rs.getDouble(1);
        
    }catch(Exception e){
            System.out.println(e);
        
    }
         return sum;
     }
            
            
      
}
