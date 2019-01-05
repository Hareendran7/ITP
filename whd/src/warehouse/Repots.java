/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jega rinoshan
 */
public class Repots extends javax.swing.JPanel {
    
          Connection con = null;
    PreparedStatement pst = null;       //contains a sql statement which has been pre compiled
  ResultSet rs = null;

    /**
     * Creates new form Repots
     */
    public Repots() {
        initComponents();
        con=database_con. connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        purchase = new javax.swing.JButton();
        goods = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        retailerCOM = new javax.swing.JComboBox<>();
        retailerYEAR = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        YEARSET = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(null);

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Location wise sales");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(110, 300, 222, 57);

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-Newsleecher-48.png"))); // NOI18N
        jButton3.setText("Dominant Clients");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 51, 255), new java.awt.Color(51, 204, 255), null, null));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(260, 170, 193, 53);

        purchase.setBackground(new java.awt.Color(51, 51, 51));
        purchase.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        purchase.setForeground(new java.awt.Color(255, 255, 255));
        purchase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-Buy-64.png"))); // NOI18N
        purchase.setText("Retailer purchases");
        purchase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 255), new java.awt.Color(0, 255, 255), null, null));
        purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseActionPerformed(evt);
            }
        });
        add(purchase);
        purchase.setBounds(10, 170, 230, 50);

        goods.setBackground(new java.awt.Color(51, 51, 51));
        goods.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        goods.setForeground(new java.awt.Color(255, 255, 255));
        goods.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-Box-64.png"))); // NOI18N
        goods.setText("Stock Level");
        goods.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 204), new java.awt.Color(51, 204, 255), null, null));
        goods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goodsActionPerformed(evt);
            }
        });
        add(goods);
        goods.setBounds(490, 210, 235, 59);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Month Based Sales");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(110, 430, 220, 52);

        retailerCOM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Month", "January ", "February ", "March ", "April ", "May ", "June ", "July ", "August ", "September ", "October ", "November ", "December " }));
        add(retailerCOM);
        retailerCOM.setBounds(110, 80, 117, 38);

        retailerYEAR.setText("YEAR");
        retailerYEAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retailerYEARMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                retailerYEARMouseEntered(evt);
            }
        });
        retailerYEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retailerYEARActionPerformed(evt);
            }
        });
        add(retailerYEAR);
        retailerYEAR.setBounds(270, 80, 48, 32);

        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        add(jLabel1);
        jLabel1.setBounds(10, 30, 450, 210);

        YEARSET.setText("  SET-YEAR");
        YEARSET.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YEARSETMouseClicked(evt);
            }
        });
        YEARSET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YEARSETActionPerformed(evt);
            }
        });
        add(YEARSET);
        YEARSET.setBounds(180, 380, 100, 30);

        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jLabel2);
        jLabel2.setBounds(20, 290, 430, 210);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
  try{
        String sql="select SUM(order_1.qty),retailer.ret_address2 FROM Order_1 INNER JOIN retailer ON Order_1.ret_id=retailer.ret_id  where YEAR(order_1.ord_date)='"+YEARSET.getText()+"'group by retailer.ret_address2";
         pst = con.prepareStatement(sql);
                       rs= pst.executeQuery();
                       
           while(rs.next()){
            String count =rs.getString("SUM(order_1.qty)");
            int countt=Integer.parseInt(count);
            String location=rs.getString("retailer.ret_address2");
             dataset.setValue(countt, "Sales", location);
            
             
         
            } 
               JFreeChart chart = ChartFactory.createBarChart("SALES COUNT", "Location", "Sales", dataset,PlotOrientation.VERTICAL,false,true,false);
            CategoryPlot p=chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame =new ChartFrame("Bar chart for sales count",chart);
            frame.setVisible(true);
            frame.setSize(550,750);
          
        
        }
        catch(Exception e){
        System.out.print("errror");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseActionPerformed
        DefaultPieDataset piedataset=new DefaultPieDataset();
            
        try{
        String q="select SUM(qty),prod_name from order_1   where MONTHNAME(ord_date)='"+retailerCOM.getSelectedItem()+"' and YEAR(ord_date)='"+retailerYEAR.getText()+"' group by prod_name and size_1 ";
         pst = con.prepareStatement(q);
                       rs= pst.executeQuery();
                       
           while(rs.next()){
           
           String product=rs.getString("prod_name");
           String qty=rs.getString("SUM(qty)");
           int rate=Integer.parseInt(qty);
           piedataset.setValue(product, rate);
           }  
           
        JFreeChart chart = ChartFactory.createPieChart3D("Retailer Purchases", piedataset,true,true,true);
        PiePlot3D p=(PiePlot3D)chart.getPlot();
        ChartFrame frame =new ChartFrame("Pie Chart",chart);
            frame.setVisible(true);
            frame.setSize(550,750);
          
        
        
        
        
        
        }catch(Exception e){}
        
    }//GEN-LAST:event_purchaseActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        try{
            String sql="SELECT SUM(order_1.qty), retailer.ret_name FROM order_1 INNER JOIN retailer ON order_1.ret_id=retailer.ret_id where MONTHNAME(order_1.ord_date)='"+retailerCOM.getSelectedItem()+"' and YEAR(order_1.ord_date)='"+retailerYEAR.getText()+"' group by retailer.ret_name ORDER BY SUM(order_1.qty) DESC";
            pst = con.prepareStatement(sql);
                       rs= pst.executeQuery();
                       
            while(rs.next()){
            String line =rs.getString("SUM(order_1.qty)");
            int linee=Integer.parseInt(line);
            String name=rs.getString("retailer.ret_name");
             dataset.setValue(linee, "Sales", name);
            
             
         
            } 
                     JFreeChart chart = ChartFactory.createBarChart("Dominant Clients", "Reatailer", "Sales", dataset,PlotOrientation.VERTICAL,false,true,false);
            CategoryPlot p=chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame =new ChartFrame("Bar chart for Dominant Clients",chart);
            frame.setVisible(true);
            frame.setSize(750,650);
          
                       
        }
        
        
        
        catch(Exception e){
        System.out.println("erroe");}
        
        
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void goodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goodsActionPerformed
           DefaultPieDataset piedataset=new DefaultPieDataset();
            
        try{
        String q="select SUM(quantity),prod_name from stock group by prod_name and size_1";
         pst = con.prepareStatement(q);
                       rs= pst.executeQuery();
                       
           while(rs.next()){
           
           String product=rs.getString("prod_name");
           String qty=rs.getString("SUM(quantity)");
           int rate=Integer.parseInt(qty);
           piedataset.setValue(product, rate);
           }  
           
        JFreeChart chart = ChartFactory.createPieChart3D("STOCK LEVEL", piedataset,true,true,true);
        PiePlot3D p=(PiePlot3D)chart.getPlot();
        ChartFrame frame =new ChartFrame("Pie Chart",chart);
            frame.setVisible(true);
            frame.setSize(550,750);
          
        
        
        
        
        
        }catch(Exception e){}
        
    }//GEN-LAST:event_goodsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              DefaultCategoryDataset dataset = new DefaultCategoryDataset();
  try{
        String sql="select SUM(qty),MONTHNAME(ord_date) from order_1 where YEAR(ord_date)='"+YEARSET.getText()+"'group by MONTHNAME(ord_date) ORDER BY MONTH(ord_date) ASC ";
         pst = con.prepareStatement(sql);
                       rs= pst.executeQuery();
                       
           while(rs.next()){
            String count =rs.getString("SUM(qty)");
            int countt=Integer.parseInt(count);
            String location=rs.getString("MONTHNAME(ord_date)");
             dataset.setValue(countt, "Sales", location);
            
             
         
            } 
               JFreeChart chart = ChartFactory.createBarChart("MONTH SALES COUNT", "Month", "Sales", dataset,PlotOrientation.VERTICAL,false,true,false);
            CategoryPlot p=chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame =new ChartFrame("Bar chart for sales count",chart);
            frame.setVisible(true);
            frame.setSize(550,750);
          
        
        }
        catch(Exception e){
        System.out.print("errror");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void retailerYEARMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retailerYEARMouseEntered
    
    }//GEN-LAST:event_retailerYEARMouseEntered

    private void retailerYEARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retailerYEARMouseClicked
         retailerYEAR.setText("");
    }//GEN-LAST:event_retailerYEARMouseClicked

    private void retailerYEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retailerYEARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retailerYEARActionPerformed

    private void YEARSETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YEARSETActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YEARSETActionPerformed

    private void YEARSETMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YEARSETMouseClicked
        YEARSET.setText("");
    }//GEN-LAST:event_YEARSETMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField YEARSET;
    private javax.swing.JButton goods;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton purchase;
    private javax.swing.JComboBox<String> retailerCOM;
    private javax.swing.JTextField retailerYEAR;
    // End of variables declaration//GEN-END:variables
}
