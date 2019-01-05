/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package warehouse;

import codes.dbconnect;
import codes.geolocation;
import com.teamdev.jxmaps.MapViewOptions;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Inspiron N4050
 */
public class retmap extends javax.swing.JFrame {
    
    double latitude,lantitude,distance;
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    /** Creates new form retmap */
    public retmap() {
        initComponents();
        
        con = dbconnect.connect();
        
        fillcombo();
    }

    
    private void fillcombo()
    {
        try{
            String sql = "select ret_id from retailer";
            ps =con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while(rs.next())
            {
                String comboitems = rs.getString("ret_id");
                retid.addItem(comboitems);
            }
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error getting truck no from DB");
        }
    }
    
    
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        retlocation = new javax.swing.JButton();
        retid = new javax.swing.JComboBox<>();
        storedb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("retmap"); // NOI18N

        retlocation.setText("Set Location");
        retlocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retlocationActionPerformed(evt);
            }
        });

        retid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        storedb.setText("Save");
        storedb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storedbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(retid, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(retlocation)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(storedb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retlocation)
                    .addComponent(retid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addComponent(storedb)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retlocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retlocationActionPerformed
        
        
        MapViewOptions options = new MapViewOptions();
        options.importPlaces();
        
        geolocation mapview = new geolocation(options);
        
        JFrame frame = new JFrame("JxMaps - Hello, World!");
        
        JButton setloc = new JButton("SET LOCATION");
        

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //frame.setBounds(0,0,200,200);
        frame.add(mapview, BorderLayout.CENTER);
        
        //adding a button to the frame
        frame.add(setloc, BorderLayout.PAGE_END);
        
        setloc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                latitude= mapview.getRetlat();
                lantitude = mapview.getRetlan();
                distance = mapview.getRetlength();
                
                System.out.println("");
                System.out.println("Retailer Latitude:"+latitude);
                System.out.println("Retailer Lantitude:"+lantitude);
                System.out.println("Retailer Distance:"+distance);
            }
            
        });
        
        
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
        
        
        
        
    }//GEN-LAST:event_retlocationActionPerformed

    private void storedbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storedbActionPerformed
        try{
            String sql="UPDATE retailer set latitude='"+latitude+"',langtitude='"+lantitude+"',distance='"+distance+"' where ret_id='"+retid.getSelectedItem().toString()+"'";
            ps = con.prepareStatement(sql);
            ps.execute();
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error getting truck no from DB");
        }
    }//GEN-LAST:event_storedbActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(retmap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(retmap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(retmap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(retmap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new retmap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> retid;
    private javax.swing.JButton retlocation;
    private javax.swing.JButton storedb;
    // End of variables declaration//GEN-END:variables

}