/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import codes.*;
import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.swing.*;
import interf.search;
import java.awt.BorderLayout;


import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class locations extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    String truckid;
    
    public locations() {
        initComponents();
        
        con = dbconnect.connect();
        
        viewlocation();
        
        viewmap();
        
    }
    
    
public void viewmap()
{
    
    //mappy.removeAll();
    MapViewOptions options = new MapViewOptions();
    options.importPlaces();
        
    pointretloc mapview = new pointretloc(options);
        
        
    mappy.add(mapview);
        //mappy.setVisible(true);
        mappy.revalidate();
}
    
    
    
    
    
    
    private void viewlocation(){
        try{
            String sql = "Select truckno as 'Truck No',deliveryduedate as 'Due date' from delivery where deliverystatus = 'undelivered' group by truckno";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            locatable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error connecting to Delivery table");
        }
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        locatable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewloca = new javax.swing.JTextArea();
        getloc = new javax.swing.JButton();
        mappy = new javax.swing.JPanel();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(859, 559));

        locatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        locatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locatableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(locatable);

        viewloca.setEditable(false);
        viewloca.setColumns(20);
        viewloca.setRows(5);
        jScrollPane2.setViewportView(viewloca);

        getloc.setText("Print Locations");
        getloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getlocActionPerformed(evt);
            }
        });

        mappy.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getloc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(mappy, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(getloc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mappy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void locatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locatableMouseClicked
       locatable.setDefaultEditor(Object.class, null);//cannot edit cell values
       locatable.getTableHeader().setReorderingAllowed(false);//cannot change the column positions
        
       //mappy.removeAll();
        
        int rowno = locatable.getSelectedRow();
        //String 
        truckid = locatable.getValueAt(rowno, 0).toString();
        
        
        
        MapViewOptions options = new MapViewOptions();
        options.importPlaces();
        
        pointretloc mapview2 = new pointretloc(options);
        
        mapview2.settruckid(truckid);
        mappy.removeAll();
        viewmap();
        //mappy.add(mapview2);    
        
        try{
            String sql = "select distinct r.ret_name,r.ret_address2 from retailer r,delivery d, order_1 o where d.truckno='"+truckid+"'and d.deliverystatus='undelivered' and o.ord_id=d.deliveryid and o.ret_id=r.ret_id order by r.distance";
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            
            viewloca.setText("");
            while(rs.next())
            {
                String retname = rs.getString("ret_name");
                String retaddress = rs.getString("ret_address2");
                
                if(retname.length()>=10)
                {
                    viewloca.append("   "+retname.substring(0,10) + "\t"+"-"+"\t"+retaddress+"\n");
                }
                else
                {
                    viewloca.append("   "+retname+"\t"+ "-"+"\t"+retaddress+"\n");
                }
                
                
            }
        }
        catch(Exception e)
        {
            
        }
        
        
    }//GEN-LAST:event_locatableMouseClicked

    private void getlocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getlocActionPerformed
        
        try {
//             String report="C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\final_finance\\src\\Reports\\cashflow.jrxml";
             JasperDesign jd= JRXmlLoader.load("C:\\Users\\gange\\Desktop\\whd\\src\\Reports\\deliveryloc.jrxml");
             String sql ="select distinct r.ret_name,r.ret_address2 from retailer r,delivery d, order_1 o where d.truckno='"+truckid+"'and d.deliverystatus='undelivered' and o.ord_id=d.deliveryid and o.ret_id=r.ret_id order by r.distance";
              JRDesignQuery newQuery=new JRDesignQuery();
              newQuery.setText(sql);
              jd.setQuery(newQuery);
             JasperReport jr=JasperCompileManager.compileReport(jd);
             JasperPrint jp=JasperFillManager.fillReport(jr,null,con);
             JasperViewer.viewReport(jp,false);
         } catch (JRException ex) {
             Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
        
        
    }//GEN-LAST:event_getlocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getloc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable locatable;
    private javax.swing.JPanel mappy;
    private javax.swing.JTextArea viewloca;
    // End of variables declaration//GEN-END:variables
}
