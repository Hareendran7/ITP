/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author Inspiron N4050
 */
public class newdelivery extends delivery{
    
   
public void setdel_id(String newdelid)
{
    del_id = newdelid;
}

public void setIncharge(String delincharge)
{
    incharge = delincharge;
}

public void setTruckno(String deltruckno)
{
    truckno = deltruckno;
}

public void setDeldue_date(String delduedate)
{
    deldue_date = delduedate;
}

public void setStatus(String delstatus)
{
    status = delstatus;
}
    
    
public void setNewdelivery()
{
   
    con = dbconnect.connect();
    
    try{
        String sql="INSERT into delivery (deliveryID,incharge,truckno,deliveryduedate,deliverystatus) values ('"+del_id+"','"+incharge+"','"+truckno+"','"+deldue_date+"','"+status+"')";
        ps = con.prepareStatement(sql);
        ps.execute();
        
        String sql2="update order_1 set status = 'undelivered' where ord_id = '"+del_id+"'";
        ps = con.prepareStatement(sql2);
        ps.execute();
        
        JOptionPane.showMessageDialog(null,"Record added successfully");
        
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Error in sending data to delivery table");
        System.out.println(e);
        
    }
    
    //incharge,truckno,
    //'"+incharge+"','"+truckno+"',
    
    
}

    
    
    
}
