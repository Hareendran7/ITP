/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.sql.*;
import javax.swing.JOptionPane;


public class truck {
    
    Connection con = null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    
    protected static String truckno;
    protected static String purchasedate;
    protected static String trucktype;
    protected static String availability;
    protected static int truckcap;
    protected static int truckloadcap;
    
    
    public void setTruckno(String truck_no)
    {
        truckno = truck_no;
    }
    
    public void setPurchasedate(String date)
    {
        purchasedate = date;
    }
    
    public void setTrucktype(String type)
    {
        trucktype = type;
    }
    
    public void setTruckcap(int capacity)
    {
        truckcap = capacity;
    }
    
    public void setAvailability(String avail)
    {
        availability = avail;
    }
    
    public void setTruckloadcap(String loadcapacity)
    {
        truckloadcap=Integer.parseInt(loadcapacity);
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
            String sql = "insert into truck(truckno,purchasedate,trucktype,capacity,availability) values('"+truckno+"','"+purchasedate+"','"+trucktype+"','"+truckcap+"','"+availability+"')";
            ps = con.prepareStatement(sql);
            ps.execute();
            
            String sql2="update truck set load_capacity = '0' where truckno='"+truckno+"'";
            ps = con.prepareStatement(sql2);
            ps.execute();
            
            JOptionPane.showMessageDialog(null,"Vehicle record successfully added");
        }
        catch(Exception e)
        {
            System.out.println("Error in inserting values to truck table: "+e );
        }
    }
    
    public void updatetruck()
{
    con = dbconnect.connect();
    
    try{
        String sql="update truck set purchasedate = '"+purchasedate+"',trucktype = '"+trucktype+"',capacity = '"+truckcap+"', availability = '"+availability+"' where truckno = '"+truckno+"' ";
        ps = con.prepareStatement(sql);
        ps.execute();
    }
    catch(Exception e)
    {
        
        System.out.println("Error updating truck tabel: "+e);
    }   
}
    
    public void updateloadcap()
    {
        int oldload,newload;
        con = dbconnect.connect();
        try{
            String sql2="select load_capacity from truck where truckno = '"+truckno+"'";
            ps = con.prepareStatement(sql2);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                oldload = rs.getInt("load_capacity");
                newload = oldload+truckloadcap;
            
            
            String sql ="update truck set load_capacity='"+newload+"' where truckno = '"+truckno+"'";
            ps = con.prepareStatement(sql);
            ps.execute();
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error in updateloadcap: "+e);
        }
    }
    
    public boolean checktruckcap()
    {
        int currload,newload,totcap;
        con=dbconnect.connect();
        try{
            String sql="select capacity,load_capacity from truck where truckno = '"+truckno+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
            totcap=rs.getInt("capacity");
            currload= rs.getInt("load_capacity");
            newload = currload+truckloadcap;
            if(totcap<newload)
            {
                
                return false;
                
            }
            }
        }
        catch(Exception e)
        {
            System.out.println("check truck cap error:"+e);
        }
        return true;
        
    }    
    
    public void removeload()
    {
        int oldload,newload;
        con = dbconnect.connect();
        try{
            String sql2="select load_capacity from truck where truckno = '"+truckno+"'";
            ps = con.prepareStatement(sql2);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                oldload = rs.getInt("load_capacity");
                newload = oldload-truckloadcap;
            
                if(oldload==0)
                {
                    //Do not do anything
                }
                else
                {
                    String sql ="update truck set load_capacity='"+newload+"' where truckno = '"+truckno+"'";
                    ps = con.prepareStatement(sql);
                    ps.execute();
                }
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error in updateloadcap: "+e);
        }
        
        
    }
}
