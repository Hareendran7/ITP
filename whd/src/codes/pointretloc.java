/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

/**
 *
 * @author Inspiron N4050
 */

import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.swing.MapView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.EventListener;


public class pointretloc extends MapView{
    
    Connection con = null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    
    static String truckid;
    
    public pointretloc(MapViewOptions options) {
        super(options);
        
        
                    
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                if (status == MapStatus.MAP_STATUS_OK) {
                    
                    con=dbconnect.connect();
                    try
                    {
                        String sql="select distinct r.latitude,r.langtitude from retailer r,delivery d, order_1 o where d.truckno='"+truckid+"'and d.deliverystatus='undelivered' and o.ord_id=d.deliveryid and o.ret_id=r.ret_id";
                        ps=con.prepareStatement(sql);
                        rs=ps.executeQuery();
                        
                        final Map map = getMap();   //creating a map object
                        MapOptions options = new MapOptions(map);
                        map.setOptions(options);
                    //assigning the location latitude & langtitude to an object
                        map.setCenter(new LatLng(map, 6.875642, 79.868459));
                        LatLng location = new LatLng(6.875642, 79.868459);
                   
                    
                        Marker m1 = new Marker(map);    //Setting a marker to the warehouse location
                        m1.setPosition(location);
                        
                        InfoWindow i1= new InfoWindow(map);
                        i1.setContent("Warehouse");
                        i1.setPosition(location);
                        i1.open(map, m1);
                        
                        map.setZoom(11.0);  //zooming the map
                        
                        while(rs.next())
                        {
                            double lat= rs.getDouble("latitude");
                            double lan = rs.getDouble("langtitude");
                            LatLng retloc = new LatLng(lat, lan);
                
                    
                            final Marker m2=new Marker(map);
                            m2.setPosition(retloc);
        
                    
                        }
                        System.out.println("Truck no is:"+truckid);
                    }
                    catch(Exception e)
                    {
                        
                    }
                    
                    
                    
        
        
                    
                }
            }
        
        });
                }
    
    public void pointloc(String truckid)
    {
        
    }
    
    public void settruckid(String truckno)
    {
        truckid=truckno;
    }
        
    
}
