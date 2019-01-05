/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Inspiron N4050
 */
public class service {
    
    private String servid;
    private String truckno;
    private String servtype;
    private String servdate;
    private double servcost;
    
    Connection con = null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    
    public void setServid(String id)
    {
        servid=id;
    }
    
    public void setTruckno(String truckid)
    {
        truckno=truckid;
    }
    
    public void setServtype(String type)
    {
        servtype=type;
    }
    
    public void setServdate(String date)
    {
        servdate=date;
    }
    public void setServcost(double cost)
    {
        servcost=cost;
    }
    
    public boolean checkfornum(String word)
    {
        for(int i=0;i<word.length();i++)
            {
            char ch = word.charAt(i);
            
            if(Character.isLetter(ch))
            {
                return false;
            }
            }
        return true;
    }
    
    public void insert()
    {
        con = dbconnect.connect();
        
        try
        {
            String sql = "insert into maintenance(main_id,truckno,main_type,main_date,main_cost) values('"+servid+"','"+truckno+"','"+servtype+"','"+servdate+"','"+servcost+"')";
            ps = con.prepareStatement(sql);
            ps.execute();
            
           
            
            JOptionPane.showMessageDialog(null,"Service record successfully added");
        }
        catch(Exception e)
        {
            System.out.println("Error in inserting values to maintenance table: "+e );
        }
    }
    
    public void update()
    {
        con = dbconnect.connect();
        
        try{
            String sql="update maintenance set truckno='"+truckno+"', main_type='"+servtype+"',main_date='"+servdate+"',main_cost='"+servcost+"' where main_id='"+servid+"'";
            ps = con.prepareStatement(sql);
            ps.execute();
        }
        catch(Exception e)
        {
            System.out.println("Error in updating values in maintenance table: "+e );
        }
    }
    
    
}
