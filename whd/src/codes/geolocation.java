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
import com.teamdev.jxmaps.DirectionsLeg;
import com.teamdev.jxmaps.LocationElevationRequest;
import com.teamdev.jxmaps.DirectionsRequest;
import com.teamdev.jxmaps.DirectionsResult;
import com.teamdev.jxmaps.DirectionsRoute;
import com.teamdev.jxmaps.DirectionsRouteCallback;
import com.teamdev.jxmaps.DirectionsStatus;
import com.teamdev.jxmaps.Distance;
import com.teamdev.jxmaps.Geocoder;
import com.teamdev.jxmaps.GeocoderRequest;
import com.teamdev.jxmaps.GeocoderCallback;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.MapViewOptions;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.GeocoderStatus;
import com.teamdev.jxmaps.GeocoderResult;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapMouseEvent;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MouseEvent;
import com.teamdev.jxmaps.TravelMode;
import com.teamdev.jxmaps.swing.MapView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.plaf.basic.BasicButtonUI;


public class geolocation extends MapView {
    
    private double retlat,retlan,retlength;
    
    public geolocation(MapViewOptions options) {
        super(options);
        
        
                    
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                if (status == MapStatus.MAP_STATUS_OK) {
                    
        //setloc.setPreferredSize(new Dimension(150,40));
                    final Map map = getMap();   //creating a map object
                    MapOptions options = new MapOptions(map);
                    map.setOptions(options);
                    //assigning the location latitude & langtitude to an object
                    map.setCenter(new LatLng(map, 6.875642, 79.868459));
                    LatLng location = new LatLng(6.875642, 79.868459);
                   
                    
                    Marker m1 = new Marker(map);    //Setting a marker to the warehouse location
                    m1.setPosition(location);
                    map.setZoom(15.0);  //zooming the map
                    
                    JPanel content = new JPanel(new GridBagLayout());
                    content.setBackground(Color.white);
                    
                    
                    //setloc.addActionListener();
                    
                    map.addEventListener("click", new MapMouseEvent() {
                        @Override
                        public void onEvent(MouseEvent mouseEvent)
                        {
                            
                            final Marker m2=new Marker(map);
                            
                            m2.setPosition(mouseEvent.latLng());
                            
                            LatLng dest = new LatLng();
                            dest=m2.getPosition();
                            
                            double latvar,lngvar;
                            latvar = dest.getLat();
                            lngvar = dest.getLng();
                            //System.out.println("Latitude is: "+latvar);
                            //System.out.println("Langtitude is: "+lngvar);
                            //System.out.println("");
                           
                            
                            map.addEventListener("click", new MapMouseEvent() {
                            @Override        
                                
                                     public void onEvent(MouseEvent mouseEvent)
                                     {
                                         m2.remove();
                                     }
                                });
                            
                            //Creating a directions request
                            DirectionsRequest dirreq = new DirectionsRequest(map);
                    
                            dirreq.setOrigin(location); //Setting the location of the warehouse
                            dirreq.setDestination(dest);//Setting the location of the retailer
                            
                            dirreq.setTravelMode(TravelMode.DRIVING);
                            
                            getServices().getDirectionService().route(dirreq, new DirectionsRouteCallback(map){
                                @Override
                                public void onRoute(DirectionsResult result,DirectionsStatus status)
                                {
                                    if(status == DirectionsStatus.OK)
                                    {
                                        //Drawing the route between 2 points
                                        m1.remove();
                                        m2.remove();
                                        map.getDirectionsRenderer().setDirections(result);
                                        
                                        //Calculating the distance between two points
                                        DirectionsRoute[] routes = result.getRoutes();
                                        double totlength=0;
                                        if(routes.length>0)
                                        {
                                            
                                            for(DirectionsLeg leg : routes[0].getLegs())
                                            {
                                                totlength += (leg.getDistance().getValue())/1000;
                                                
                                            }
                                            
                                        }
                                        System.out.println("Length:"+totlength+" Km");
                                        System.out.println("Latitude is: "+latvar);
                                        System.out.println("Langtitude is: "+lngvar);
                                        
                                        setRetlat(latvar);
                                        setRetlan(lngvar);
                                        setRetlength(totlength);
                            
                                    
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null,"Unable to connect to the internet");
                                    }
                                    
                                } 
                            });
                        }
                    });
             
                            }
                        }
                    });
                }
    
    
public void setRetlat(double lat)
{
   retlat=lat; 
}

public void setRetlan(double lan)
{
    retlan=lan;
}

public void setRetlength(double length)
{
    retlength=length;
}

public double getRetlat()
{
   return retlat; 
}

public double getRetlan()
{
    return retlan;
}

public double getRetlength()
{
    return retlength;
}
    
}
        //});
    //}
//}

