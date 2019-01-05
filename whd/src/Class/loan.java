/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class loan {
    Connection conn;
    PreparedStatement PST;
    ResultSet RS;
    
    private String loanid;
    private String empid;
    private String typeloan;
    private int installment;
    private double amount;
    private double interest;
    private double netsalary;
    public double finalsalary;
    
    
    public loan(Connection conn,PreparedStatement PST) {
        this.conn = conn;
        this.PST = PST;
    }
    
    public loan (String loanid,String empid,String typeloan,int installment,double amount,double interest,double netsalary,double finalsalary) {
        this.empid = empid;
        this.loanid = loanid;
        this.typeloan = typeloan ;
        this.installment= installment;
        this.amount = amount;
        this.interest = interest;
        this.netsalary =netsalary;
        this.finalsalary = finalsalary ;
        
    }

     
  
    
    
    public String getEmpid()
    {
        return empid;
    }
    
    public String loanid()
    {
        return loanid;
    }
    
    public String typeloan()
    {
        return typeloan;
    }
    
    public int installment()
    {
        return installment;
    }
    
    public double amount()
    {
        return amount;
    }
    
    public double interest()
    {
        return interest;
    }
    
    public double netsalary()
    {
        return netsalary;
    }
    
    public double finalsalary()
    {
        return finalsalary;
    }
    
       public void addloanHR(String empid,String loanid,String typeloan,double amount,int installment,double interest,double balance){
        try{ 
                    String sql1 = "INSERT INTO loan (empid,loanid,typeloan,amount,installment,interest,balance) "
                            + "VALUES ('"+empid+"','"+loanid+"','"+typeloan+"','"+amount+"','"+installment+"','"+interest+"','"+balance+"')";

                    PST = conn.prepareStatement(sql1);
                    PST.execute();
                    JOptionPane.showMessageDialog(null, "loan Details Saved Successfully!");
                }
            
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
        
       
     
       }
       
 public double calculatenetnetsalary(String empid,double netsalary,double interest,int installment,double finalsalary,double amount,double balance){
        if(balance != 0)
    {
      try{ 
                    String sql = "Select Netsalary from salary where emp_id = '"+empid+"'";
                    
                    PST = conn.prepareStatement(sql);
                    RS = PST.executeQuery();
                    
                    while(RS.next())
                    {
           
                    finalsalary = netsalary- (amount / installment) -((amount*interest)/installment);
                    
                    String sql1 = "UPDATE salary SET Netsalary ='"+finalsalary+"' where emp_id = '"+empid+"' ";
                            

                    PST = conn.prepareStatement(sql1);
                    PST.execute();
                    JOptionPane.showMessageDialog(null, "Net salary calculated Successfully!");
                    return finalsalary;
                    }
                }
            
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
        }
        return 0;
 
  
 }
}
       
   

