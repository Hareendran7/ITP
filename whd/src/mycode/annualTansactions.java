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
public class annualTansactions {
    
    public double salary(PreparedStatement pst, Connection conn,ResultSet rs,int year){
        double sum=0;
        
        try{
         String sql=" select sum(Netsalary) from   salary  where year(Date)='"+year+"' ";
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            sum=rs.getDouble(1);
         
        sum=rs.getDouble(1);
            }catch(Exception e){
                
            }
        
        
        return sum;
        
    }
    
    
    public double stockExpense(PreparedStatement pst, Connection conn,ResultSet rs,int year){
        double sum=0;
               try{
        String sql=" select sum(paid_amount) from  suppayment where year(paid_date)='"+year+"'";
        pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            sum=rs.getDouble(1);
        
    }catch(Exception e){
            System.out.println(e);
        
    }
         return sum;
    }
    
     public double delivery(PreparedStatement pst, Connection conn,ResultSet rs,int year){
        double sum=0;
               try{
        String sql=" select sum(main_cost) from  maintenance where year(main_date)='"+year+"'";
        pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            sum=rs.getDouble(1);
        
    }catch(Exception e){
            System.out.println(e);
        
    }
         return sum;
     
    }
     
     public double RetailerDamage(PreparedStatement pst, Connection conn,ResultSet rs,int year){
         double sum=0;
           try{
        String sql=" select sum(dmgr_tot) from   dmgret where year(dmgr_date)='"+year+"'";
        pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            sum=rs.getDouble(1);
              
    }catch(Exception e){
            System.out.println(e);
        
    }
    
           return sum;
           
           
     }
           
           //income
           
        public double retailerIncome(PreparedStatement pst, Connection conn,ResultSet rs,int year){
         
         double sum=0;
          try{
        String sql=" select sum(amou) from set_payment where year( set_date)='"+year+"'";
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
     public double Janbalance(PreparedStatement pst, Connection conn,ResultSet rs,String month,int year){
         double sum=0;
          try{
        String sql=" select balance from month_trans where month ='"+month+"' and year='"+year+"'";
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
     
      public double OtheMonthbalance(PreparedStatement pst, Connection conn,ResultSet rs,int year,int month){
         double sum=0;
          try{
        String sql=" select balance from month_trans where month ='"+month+"' and year='"+year+"'";
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
      
     public double otherIncome(PreparedStatement pst, Connection conn,ResultSet rs,int year){
         double sum=0;
         try{
        String sql=" select sum(amount) from income where year(date)='"+year+"'  and income_type <> 'retailer Income'";
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
     
     
     public double electricity(PreparedStatement pst, Connection conn,ResultSet rs,int year){
         double sum=0;
         try{
             String q="select sum(elect) from month_trans where year='"+year+"'";
             pst = conn.prepareStatement(q);
             rs=pst.executeQuery();
             rs.next();
             sum=rs.getDouble(1);
             
         }catch(Exception e){
             
         }
         
         return sum;
         
         
     }
     
     public double water(PreparedStatement pst, Connection conn,ResultSet rs,int year){
         double sum=0;
         try{
             String q="select sum(water) from month_trans where year='"+year+"'";
             pst = conn.prepareStatement(q);
             rs=pst.executeQuery();
             rs.next();
             sum=rs.getDouble(1);
             
         }catch(Exception e){
             
         }
         
         return sum;
         
         
     }
     
      public double telephone(PreparedStatement pst, Connection conn,ResultSet rs,int year){
         double sum=0;
         try{
             String q="select sum(tele) from month_trans where year='"+year+"'";
             pst = conn.prepareStatement(q);
             rs=pst.executeQuery();
             rs.next();
             sum=rs.getDouble(1);
             
         }catch(Exception e){
             
         }
         
         return sum;
         
         
     }
      
       public double rent(PreparedStatement pst, Connection conn,ResultSet rs,int year){
         double sum=0;
         try{
             String q="select sum(rent) from month_trans where year='"+year+"'";
             pst = conn.prepareStatement(q);
             rs=pst.executeQuery();
             rs.next();
             sum=rs.getDouble(1);
             
         }catch(Exception e){
             
         }
         
         return sum;
         
         
     }
       
        public double otherExpense(PreparedStatement pst, Connection conn,ResultSet rs,int year){
         double sum=0;
         try{
        String sql=" select sum(amount) from  expense where year(date)='"+year+"'  and expense_type <> 'Retailer damage'and expense_type <> 'Stock Expense ' and expense_type <> 'Delivery' ";
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
