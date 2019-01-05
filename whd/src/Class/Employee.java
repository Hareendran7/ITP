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
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
/**
 *
 * @author Dell
 */
public class Employee {
    
    Connection conn;
    PreparedStatement PST;
    
    private String empid;
    private String Cal_Name;
    private String Surname;
    private String Fullname;
    private String NIC;
    private Date DOB;
    private String Gender;
    private String Nation;
    private String Status;
    private String Address;
    private String tel_phone;
    private String mobile;
    private String Email;
    private String Electroate;
    private String Employee_Type;
    private String Task;
    private Date Appdate;
    private double Basic_Salary;
    private double food;
    byte[] person_image;
    
    public Employee(Connection conn,PreparedStatement PST) {
        this.conn = conn;
        this.PST = PST;
    }
    
    public Employee (String empid,String Cal_Name,String Surname,String Fullname,String NIC,Date DOB, String Gender,String Nation,String Status,String Address,
    String tel_phone,String mobile,String Email,String Electroate,String Employee_type,String Task,Date Appdate,double Basic_Salary,double food) {
        this.empid = empid;
        this.Cal_Name =Cal_Name;
        this.Surname =Surname;
        this.Fullname=Fullname;
        this.NIC =NIC ;
        this.DOB = DOB;
        this.Gender = Gender;
        this.Nation =Nation;
        this.Status =Status;
        this.Address=Address;
        this.tel_phone=tel_phone;
        this.mobile =mobile;
        this.Email=Email;
        this.Electroate=Electroate;
        this.Employee_Type=Employee_type;
        this.Task=Task;
        this.Appdate=Appdate;
        this.Basic_Salary = Basic_Salary;
        this.food = food;
        this.person_image = person_image;
    }
    
    
    public String getEmpid()
    {
        return empid;
    }
    
    public String getCal_Name()
    {
        return Cal_Name;
    }
    
    public String getSurname()
    {
        return Surname;
    }
    
    public String getFullname()
    {
        return Fullname;
    }
    
    public String getNIC()
    {
        return NIC;
    }
    
    
    public Date getDOB()
    {
        return DOB;
    }
    
    public String getGender()
    {
        return Gender;
    }
    
    public String getNation()
    {
        return Nation;
    }
    
    public String getStatus()
    {
        return Status;
    }
    
    public String getAddress()
    {
        return Address;
    }
    
    
    public String gettel_phone()
    {
        return tel_phone;
    }
    
    public String getmobile()
    {
        return mobile;
    }
    
     public String getEmail()
    {
        return Email;
    }
    
    
    public String getElectroate()
    {
        return Electroate;
    }
    
    public String getEmployee_Type()
    {
        return Employee_Type;
    }
    
    public String getTask()
    {
        return Task;
    }
    
    public Date getAppdate()
    {
        return Appdate;
    }
    
    public double getBasicSalary()
    {
        return Basic_Salary;
    }
    
    public double getfood()
    {
        return food;
    }
    
    public byte[] getimage()
    {
        return person_image;
    }
   public void addemployee(String empid,String Cal_Name,String Surname,String Fullname,String NIC,Date DOB, String Gender,String Nation,String Status,String Address,String tel_phone,String mobile,String Email,String Electroate,String Employee_Type,String Task,Date Appdate,double Basic_Salary,double food){
        try{
//            
       
            String sql = "SELECT * FROM employee WHERE emp_id = '"+empid+"'" ;
            try{
                PST = conn.prepareStatement(sql);
                ResultSet RS = PST.executeQuery();
                if(RS.next()){
                    JOptionPane.showMessageDialog(null, "Employee details is already in the system");
                    return;
                }
                else{
                    
                    String sql1 = "INSERT INTO employee (emp_id,Cal_name,last_name,dob,app_date,Email,NIC,Gender,Nation,Status,Address,tel_phone,mobile,Electroate,Employee_Type,Task,Firstname,Basic_Salary,food) "
                            + "VALUES ('"+empid+"','"+Cal_Name+"','"+Surname+"','"+new java.sql.Date(DOB.getTime())+"','"+new java.sql.Date(Appdate.getTime())+"','"+Email+"','"+NIC+"','"+Gender+"','"+Nation+"','"+Status+"','"+Address+"','"+tel_phone+"','"+mobile+"','"+Electroate+"','"+Employee_Type+"','"+Task+"','"+Fullname+"','"+Basic_Salary+"','"+food+"')";

                    PST = conn.prepareStatement(sql1);
                    PST.execute();
                    JOptionPane.showMessageDialog(null, "Record Added Successfully!");
                }
            }
           
             catch(java.lang.NullPointerException e)
            {
                JOptionPane.showMessageDialog(null,"Select the date of birth");
            }
            catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e)
            {
                JOptionPane.showMessageDialog(null,"Already employee "+empid+" is inserted");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return;
        }
        
    }
   public void update(String empid,String Cal_Name,String Surname,String Fullname,String NIC,String Status,String Address,String tel_phone,String mobile,String Email,String Electroate,String Employee_Type,String Task,double Basic_Salary,double food)
   {
            
        String sql = "Update employee set NIC = '"+NIC+"', Email = '"+Email+"',Cal_name= '"+Cal_Name+"',last_name= '"+Surname+"',Status = '"+Status+"',tel_phone ='"+tel_phone+"',mobile = '"+mobile+"',Electroate = '"+Electroate+"',Employee_Type = '"+Employee_Type+"',Address = '"+Address+"',Task = '"+Task+"',Firstname = '"+Fullname+"',Basic_Salary = '"+Basic_Salary+"',food = '"+food+"' where emp_id = '"+empid+"'";
          try{ 
          PST = conn.prepareStatement(sql);
          
          PST.execute();
            JOptionPane.showMessageDialog(null, "Record updated successfully!");  
          }
          
          catch(SQLException e){
           JOptionPane.showMessageDialog(null, e); 
        }  
}
   
 public void delete(String empid){
        try{
            String delete = "DELETE FROM employee WHERE emp_id = '"+empid+"'";
            PST = conn.prepareStatement(delete);
            PST.execute();
            JOptionPane.showMessageDialog(null, "Record Deleted!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Record Not Deleted!"); 
        }
    }   
}
