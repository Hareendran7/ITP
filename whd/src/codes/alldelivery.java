/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.sql.*;


public class alldelivery extends delivery {
    
    protected static String delivery_date;
    
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

public void setDelivery_date(String deldate)
{
    delivery_date = deldate;
}

public void setStatus(String delstatus)
{
    status = delstatus;
}
    
public void updatedel()
{
    con = dbconnect.connect();
    
    try{
        String sql="update delivery set incharge = '"+incharge+"', truckno = '"+truckno+"', deliverydate = '"+delivery_date+"', deliverystatus = '"+status+"' where deliveryid = '"+del_id+"'";
        ps = con.prepareStatement(sql);
        ps.execute();
    }
    catch(Exception e)
    {
        
        System.out.println("Error updating"+e);
    }
    
    
    
}

public void updateundel()
{
    con = dbconnect.connect();
    
    try{
        String sql= "update delivery set incharge = '"+incharge+"', truckno = '"+truckno+"', deliverydate = null , deliverystatus = '"+status+"' where deliveryid = '"+del_id+"'";
        ps = con.prepareStatement(sql);
        ps.execute();
    }
    catch(Exception e)
    {
        System.out.println("Error updating: "+e);
    }
}

    
}
