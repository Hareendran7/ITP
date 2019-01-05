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


public class Salary1 {
   
    Connection conn;
    PreparedStatement PST;
    
    private String empid;
    private String payrollno;
    private String EPFNo;
    private String ETFNo;
    private String TaxType;
    private int EPFp;
    private int ETFp;
    private double Basic_Salary;
    private double Food;
    private double Performance;
    private double Gross_Salary;
    private double OT;
    private double No_of_Days;
    private double Leaves;
    private double EPF_Amount;
    private double ETF_Amount;
    private double Netsalary;
    private double Attendance;
    public double loan;
    public String Date;
    
    public Salary1(Connection conn,PreparedStatement PST) {
        this.conn = conn;
        this.PST = PST;
    }
    
    public Salary1 (String empid,String payrollno,String EPFNo,String ETFNo,String TaxType,int EPFp, int ETFp,double Basic_Salary,double Food,double Performance,
    double Gross_Salary,double OT,double No_of_Days,double Leaves,double EPF_Amount,double ETF_Amount,double Netsalary,double Attendance) {
        this.empid = empid;
        this.payrollno = payrollno;
        this.EPFNo = EPFNo;
        this.ETFNo = ETFNo;
        this.TaxType = TaxType;
        this.EPFp = EPFp;
        this.ETFp = ETFp;
        this.Basic_Salary = Basic_Salary ;
        this.Food = Food;
        this.Performance = Performance ; 
        this.Gross_Salary = Gross_Salary;
        this.OT = OT;
        this.No_of_Days = No_of_Days;
        this.Leaves = Leaves;
        this.EPF_Amount = EPF_Amount;
        this.ETF_Amount = ETF_Amount;
        this.Netsalary = Netsalary;
        this.Attendance = Attendance;
    }
    
    
    public String getEmpid()
    {
        return empid;
    }
    
    public String getpayrollno()
    {
        return payrollno;
    }
    
    public String getEPFNo()
    {
        return EPFNo;
    }
    
    public String getETFNo()
    {
        return ETFNo;
    }
    
    public String getTaxType()
    {
        return TaxType;
    }
    
    
    public int getEPFp()
    {
        return EPFp;
    }
    
    public int getETFp()
    {
        return ETFp;
    }
    
    public double getBasic_Salary()
    {
        return Basic_Salary;
    }
    
    public double getFood()
    {
        return Food;
    }
    
    public double getPerformance()
    {
        return Performance;
    }
    
    public double getGross_Salary()
    {
        return Gross_Salary;
    }
    
    public double getOT()
    {
        return OT;
    }
    
    public double getNo_of_Days()
    {
        return No_of_Days;
    }
    
    public double getLeaves()
    {
        return Leaves;
    }
    
    public double getEPF_Amount()
    {
        return EPF_Amount;
    }
    
    public double getETF_Amount()
    {
        return ETF_Amount;
    }
    
    public double getNetsalary()
    {
        return Netsalary;
    }
    
    public double getAttendance()
    {
        return Attendance;
    }
    
   public void addsalaryHR(String empid,String payrollno,String EPFNo,String ETFNo,String TaxType,double Basic_Salary,double Food){
        try{
//            
       
            String sql = "SELECT * FROM Salary WHERE emp_id = '"+empid+"'" ;
            try{
                PST = conn.prepareStatement(sql);
                ResultSet RS = PST.executeQuery();
                if(RS.next()){
                    JOptionPane.showMessageDialog(null, "Employee details is already in the system");
                    return;
                }
                else{
                    
                    String sql1 = "INSERT INTO salary (emp_id,payrollno,EPFNo,ETFNo,Tax_type,Basic_Salary,Food) "
                            + "VALUES ('"+empid+"','"+payrollno+"','"+EPFNo+"','"+ETFNo+"','"+TaxType+"','"+Basic_Salary+"','"+Food+"')";

                    PST = conn.prepareStatement(sql1);
                    PST.execute();
                    JOptionPane.showMessageDialog(null, "Salary Details Saved Successfully!");
                }
            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return;
        }
    } 
   
   public void UpdateSalary(String empid,double Performance,double OT,double Attendance){
   
   
            try{
                    String sql1 = "UPDATE Salary SET Performance ='"+Performance+"',OT = '"+OT+"',Attendance ='"+Attendance+"' where emp_id = '"+empid+"' ";
                            

                    PST = conn.prepareStatement(sql1);
                    PST.execute();
                    JOptionPane.showMessageDialog(null, "Salary Details Updated Successfully!");
                }
            
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
   
  
   } 
    
    
    public double calculatenetgrosssalary(String empid,double Basic_Salary,double Food,double Performance,double OT,double Attendance){
        
      try{
//            
       
            String sql = "SELECT * FROM Salary WHERE Gross_Salary = '"+Gross_Salary+"'" ;
            try{
                PST = conn.prepareStatement(sql);
                ResultSet RS = PST.executeQuery();
                if(RS.next()){
                    JOptionPane.showMessageDialog(null, "Employee details is already in the system");
                    return 0;
                }
                else{
                    
                    Gross_Salary = Basic_Salary+Food+Performance+OT*100+Attendance;
                    
                    String sql1 = "UPDATE Salary SET Gross_Salary ='"+Gross_Salary+"'where emp_id = '"+empid+"' ";
                            

                    PST = conn.prepareStatement(sql1);
                    PST.execute();
                    JOptionPane.showMessageDialog(null, "Gross Salary Calculated Successfully!");
                    return Gross_Salary;
                }
            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }  
        
    return 0;
    }
    
    public void Updatededuction(String empid,double Leaves,double EPF_Amount,double ETF_Amount,double NetSalary){
   
   
            try{
                    String sql1 = "UPDATE Salary SET Leaves = '"+Leaves+"',EPFAmount ='"+EPF_Amount+"',ETF_Amount ='"+ETF_Amount+"',Netsalary ='"+NetSalary+"' where emp_id = '"+empid+"' ";
                            

                    PST = conn.prepareStatement(sql1);
                    PST.execute();
                    JOptionPane.showMessageDialog(null, "Updated deduction Successfully!");
                }
            
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
   
  
   }
  public double calculatenetnetsalary(String empid,double Gross_Salary,double Leaves,double EPF_Amount,double ETF_Amount,String Date){
        
      try{
//            
       
            String sql = "SELECT * FROM salary WHERE Netsalary = '"+Netsalary+"'" ;
            try{
                PST = conn.prepareStatement(sql);
                ResultSet RS = PST.executeQuery();
                if(RS.next()){
                    JOptionPane.showMessageDialog(null, "Employee details is already in the system");
                    return 0;
                }
                else{
                    
                    Netsalary = Gross_Salary-Leaves *120 -EPF_Amount -ETF_Amount;
                    
                    String sql1 = "UPDATE salary SET Netsalary ='"+Netsalary+"' and Date = '"+Date+"' where emp_id = '"+empid+"' ";
                            

                    PST = conn.prepareStatement(sql1);
                    PST.execute();
                    JOptionPane.showMessageDialog(null, "Net salary calculated Successfully!");
                    return Netsalary;
                }
            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }  
        
    return 0;
    }
}
