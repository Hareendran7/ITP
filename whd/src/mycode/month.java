/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class month {
    
    
    public String month(int mo){
        String Str1=null;
           if(mo==1 || mo==13){
            Str1="January";
          
        }else if(mo==2 ){
            Str1="February";
            
        }else if(mo==3  ){
            Str1="March";
         
        }else if(mo==4 ){
            Str1="April";
          
        }else if(mo==5 ){
            Str1="May";
          
        }else if(mo==6 ){
            Str1="June";
          
        }else if(mo==7 ){
            Str1="July";
           
        }else if(mo==8 ){
            Str1="August";
           
        }else if(mo==9 ){
            Str1="September";
         
        }else if(mo==10 ){
            Str1="October";
         
        }else if(mo==11 ){
            Str1="November";
           
        }else if(mo==12 || mo==0 ){
            Str1="December";
           

        }
        
        
        
        return Str1;
    }
    
    
      public   DefaultTableModel getAnnualTable(ResultSet rs, PreparedStatement pst,Connection conn,String str){
     
 
      DefaultTableModel model = new DefaultTableModel();
      model.addColumn("Month");
      model.addColumn("Total Income");
      model.addColumn("Total Expense");
      model.addColumn("Balance");
      
      
        try {
             String sql="SELECT month,tot_income,tot_expense,balance FROM profit_loss where year='"+str+"'";
             pst=conn.prepareStatement(sql);
             rs= pst.executeQuery();
                
                while(rs.next()){
                    model.addRow(new Object[]{rs.getString("month"),rs.getDouble("tot_income"),rs.getDouble("tot_expense"),rs.getDouble("balance")});
                    
            }
        } catch (SQLException ex) {
             
            }
        return model;
      
   }
   
}
