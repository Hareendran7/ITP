/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
public class Attleave {
    
    Connection conn;
    PreparedStatement PST;
    
    private String empid;
    private String Type;
    private String Category;
    private String TimeIN;
    private String TimeOut;
    private String DateTo;
    private String DateFrom;
    private String WorkHours;
    private double AccOTHours;
    public int casual;
    public int sick;
    public int annual;
    public int nopay;
    public int Days;
    
   public Attleave(Connection conn,PreparedStatement PST) {
        this.conn = conn;
        this.PST = PST;
    }
   
   public Attleave(String empid,String Type,String Category,String TimeIN,String TimeOut,String DateTo,String DateFrom,String WorkHours,double AccOTHours){
       this.empid =empid ;
       this.Type = Type;
       this.Category = Category;
       this.AccOTHours = AccOTHours ;
       this.DateFrom = DateFrom;
       this.DateTo = DateTo;
       this.TimeIN = TimeIN;
       this.TimeOut =TimeOut;
       this.WorkHours = WorkHours;
   }
   
    public String getEmpid()
    {
        return empid;
    }
    
    public String getType()
    {
        return Type;
    }
    
    public String getCategory()
    {
        return Category;
    }
    
     public double getAccOTHours()
    {
        return AccOTHours;
    }
    
    public String getDateFrom()
    {
        return DateFrom;
    }
    
    public String getDateTo()
    {
        return DateTo;
    }
    
    public String getTimeIN()
    {
        return TimeIN;
    }
    
    public String getTimeOut()
    {
        return TimeOut;
    }
    
    public String getWorkHours()
    {
        return WorkHours;
    }
    
    public void addattend(String empid,String WorkHours,double AccOTHours){
        
            String sql1 = "Update attendance set WorkHours = '"+WorkHours+"', AccOTHours = '"+AccOTHours+"' where emp_id = ?";
              try{
                    PST = conn.prepareStatement(sql1);
                    PST.setString(1,empid );
                    PST.execute();
                   JOptionPane.showMessageDialog(null, "Attendance updated Successfully!");
                }
            
            catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e);
            }
        }
    
    public void addleave(String empid,String Type,String Category, String DateFrom ) {
        
        
        String sql1 = "INSERT INTO aleave (emp_id,Type,Category,Datefrom) "
                            + "VALUES ('"+empid+"','"+Type+"','"+Category+"','"+DateFrom+"')";

        try{               
                    PST = conn.prepareStatement(sql1);
                    PST.execute();
                    JOptionPane.showMessageDialog(null, "Leaves updated Successfully!");
           }
            
            catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e);
            }
        
    
    }
        
    }
    

