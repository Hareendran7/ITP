/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import codes.*;
import java.sql.*;
import javafx.scene.layout.Priority;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author gange
 */
public class func1 extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public func1() {
        initComponents();
        
        con =dbconnect.connect();
        
        view_table();
        
        fillinchargecombo();
        
        filltrucknocombo();
        
        inchargeimage.setVisible(false);
        trucknoimage.setVisible(false);
    }
    
    private void view_table()
    {
        try{
            String sql = "select ord_id as 'Order ID',due_date as 'Due Date' from order_1 where status = 'Processed'  group by ord_id order by due_date";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            del_order.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error connecting to DB table");
        }
        
       
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        orderid = new javax.swing.JLabel();
        displayordid = new javax.swing.JLabel();
        incharge = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        trucknocombo = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        inchargecombo = new javax.swing.JComboBox<>();
        itemlist = new javax.swing.JLabel();
        duedatevalue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayitems = new javax.swing.JTextArea();
        inchargeimage = new javax.swing.JLabel();
        trucknoimage = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        del_order = new javax.swing.JTable();
        retailerlabel = new javax.swing.JLabel();
        retnameval1 = new javax.swing.JLabel();
        retlocation = new javax.swing.JLabel();
        retlocval1 = new javax.swing.JLabel();
        dispatch = new javax.swing.JLabel();
        dispatchval = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(859, 559));

        orderid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        orderid.setForeground(new java.awt.Color(255, 255, 255));
        orderid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderid.setText("Order ID :");
        orderid.setToolTipText("");
        orderid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        displayordid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        displayordid.setForeground(new java.awt.Color(255, 255, 255));
        displayordid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayordid.setText("#");
        displayordid.setToolTipText("");
        displayordid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        incharge.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        incharge.setForeground(new java.awt.Color(255, 255, 255));
        incharge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        incharge.setText("In-Charge :");
        incharge.setToolTipText("");
        incharge.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Due Date :");
        jLabel2.setToolTipText("");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Truck No :");
        jLabel3.setToolTipText("");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        trucknocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        trucknocombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trucknocomboActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(51, 51, 51));
        add.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/edit-validated-icon (1).png"))); // NOI18N
        add.setText("Submit");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        inchargecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        inchargecombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inchargecomboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inchargecomboMouseEntered(evt);
            }
        });
        inchargecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inchargecomboActionPerformed(evt);
            }
        });

        itemlist.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        itemlist.setForeground(new java.awt.Color(255, 255, 255));
        itemlist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        itemlist.setText("Item List :");
        itemlist.setToolTipText("");
        itemlist.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        duedatevalue.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        duedatevalue.setForeground(new java.awt.Color(255, 255, 255));
        duedatevalue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        duedatevalue.setText("#");
        duedatevalue.setToolTipText("");
        duedatevalue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        duedatevalue.setPreferredSize(new java.awt.Dimension(54, 20));

        displayitems.setEditable(false);
        displayitems.setColumns(20);
        displayitems.setRows(5);
        jScrollPane1.setViewportView(displayitems);

        inchargeimage.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        inchargeimage.setForeground(new java.awt.Color(255, 255, 255));
        inchargeimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inchargeimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        inchargeimage.setToolTipText("");
        inchargeimage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        trucknoimage.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        trucknoimage.setForeground(new java.awt.Color(255, 255, 255));
        trucknoimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trucknoimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        trucknoimage.setToolTipText("");
        trucknoimage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        del_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        del_order.setSurrendersFocusOnKeystroke(true);
        del_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                del_orderMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(del_order);

        retailerlabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        retailerlabel.setForeground(new java.awt.Color(255, 255, 255));
        retailerlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        retailerlabel.setText("Retailer name :");
        retailerlabel.setToolTipText("");
        retailerlabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        retnameval1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        retnameval1.setForeground(new java.awt.Color(255, 255, 255));
        retnameval1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        retnameval1.setText("###");
        retnameval1.setToolTipText("");
        retnameval1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        retlocation.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        retlocation.setForeground(new java.awt.Color(255, 255, 255));
        retlocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        retlocation.setText("Retailer Location :");
        retlocation.setToolTipText("");
        retlocation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        retlocval1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        retlocval1.setForeground(new java.awt.Color(255, 255, 255));
        retlocval1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        retlocval1.setText("###");
        retlocval1.setToolTipText("");
        retlocval1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        dispatch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        dispatch.setForeground(new java.awt.Color(255, 255, 255));
        dispatch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dispatch.setText("Dispatch boxes:");
        dispatch.setToolTipText("");
        dispatch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        dispatchval.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        dispatchval.setForeground(new java.awt.Color(255, 255, 255));
        dispatchval.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dispatchval.setText("###");
        dispatchval.setToolTipText("");
        dispatchval.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(orderid)
                                    .addComponent(retailerlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(retlocation)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(retnameval1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                        .addComponent(retlocval1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(duedatevalue, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(displayordid, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemlist, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(incharge))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inchargecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(inchargeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(trucknocombo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(trucknoimage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dispatch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dispatchval, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(add))
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(displayordid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(retailerlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(retnameval1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(retlocation, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(retlocval1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(duedatevalue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(itemlist, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inchargecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inchargeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dispatch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dispatchval, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trucknoimage, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(incharge, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trucknocombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

     private void fillinchargecombo()        //this method is used to transfer values from the database to te combo box
    {
         try{
            String sql = "select emp_id from employee where task = 'driver'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
     
            while(rs.next())
            {
                String comboitems = rs.getString("emp_id");
                inchargecombo.addItem(comboitems);
                
            }
            
            
        }
        catch(Exception e)
        {
            
        }
        
    }
   
     private void filltrucknocombo()        //this method is used to transfer values from the database to te combo box
     {
        try{
            String sql = "select truckno from truck where availability = 'available' ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            
     
            while(rs.next())
            {
                String truckno = rs.getString("truckno");
                trucknocombo.addItem(truckno);
            }
        }
        catch(Exception e)
        {
            
        }
        
        
    }
    
    
    
    private void inchargecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inchargecomboActionPerformed
       
        //trucknocombo.setSelectedIndex(0);
        String select = "Select";
        String inch_val = inchargecombo.getSelectedItem().toString();
        int inchcompare = inch_val.compareTo(select);
        //String inchvalue = inchargecombo.getSelectedItem().toString();
        
        if(inchcompare != 0)
        {
             
        try{
            String sql = "select truckno from delivery where incharge = '"+inch_val+"' and deliverystatus = 'undelivered'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
            String truckno = rs.getString("truckno");
            
            trucknocombo.removeAllItems();
            trucknocombo.addItem(truckno); 
            trucknocombo.disable();
            
            }
            else{
                try{
                String sql1="select truckno from truck where truckno not in (select truckno from delivery where deliverystatus='undelivered')";
                ps = con.prepareStatement(sql1);
                rs = ps.executeQuery();
                
                trucknocombo.enable();
                trucknocombo.removeAllItems();
                
                while(rs.next())
                {
                    
                    String truckno = rs.getString("truckno");
                    trucknocombo.addItem(truckno);
                }
                
                
                }
                catch(Exception e)
                {
                    
                }
            }   
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
            System.out.println(e);
        }
        }
        else if(inchcompare == 0)
        {
            trucknocombo.enable();
            trucknocombo.removeAllItems();
            filltrucknocombo();
            trucknocombo.setSelectedIndex(0);
        }
        
    }//GEN-LAST:event_inchargecomboActionPerformed

    private void inchargecomboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inchargecomboMouseClicked
        
        
    }//GEN-LAST:event_inchargecomboMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        inchargeimage.setVisible(false);
        trucknoimage.setVisible(false);
        String select = "Select";
        String inch_val = inchargecombo.getSelectedItem().toString();
        String truck_val = trucknocombo.getSelectedItem().toString();
        int rowno = del_order.getSelectedRow();
        truck t1 = new truck();
        //ImageIcon icon1 = new ImageIcon(icons8-High Priority-32);
        
        if(rowno != -1)
        {
        int inchcompare = inch_val.compareTo(select);
        int truckcompare = truck_val.compareTo(select);
        
        
       
        if(inchcompare==0)
        {
            inchargeimage.setVisible(true);
            //JOptionPane.showMessageDialog(null,textArea,"Enter valid data for the fields indicated by ", JOptionPane.PLAIN_MESSAGE,icons8-High Priority-32);
        }
        if(truckcompare==0)
        {
            trucknoimage.setVisible(true);
        }
        
        if((inchcompare !=0) && (truckcompare !=0))
        {
        newdelivery d1 = new newdelivery();
        
        String delstatus = "undelivered";
        
        d1.setdel_id(displayordid.getText());
        d1.setDeldue_date(duedatevalue.getText());
        d1.setIncharge(inchargecombo.getSelectedItem().toString());
        d1.setTruckno(trucknocombo.getSelectedItem().toString());
        d1.setStatus(delstatus);
        
        t1.setTruckno(trucknocombo.getSelectedItem().toString());
        t1.setTruckloadcap(dispatchval.getText());
        //System.out.println("checktruckcap output: "+t1.checktruckcap());
        
        if(t1.checktruckcap()==true)
        {
        d1.setNewdelivery();
        t1.updateloadcap();
        
        view_table();
       
        filltrucknocombo();
        
        retnameval1.setText("");
        retlocval1.setText("");
        displayordid.setText("");
        duedatevalue.setText("");
        inchargecombo.setSelectedIndex(0);
        trucknocombo.setSelectedIndex(0);
        
        inchargeimage.setVisible(false);
        trucknoimage.setVisible(false);
        displayitems.setText("");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Order cannot be loaded in the truck "+trucknocombo.getSelectedItem().toString());
        }
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Select an order to proceed further");
        }
    }//GEN-LAST:event_addActionPerformed

    private void del_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_del_orderMouseClicked
        del_order.setDefaultEditor(Object.class, null);//cannot edit cell values
        del_order.getTableHeader().setReorderingAllowed(false);//cannot change the column positions
        
        double totbox=0;
        dispatchval.setText("");
        inchargeimage.setVisible(false);
        trucknoimage.setVisible(false);
        
        int row_no = del_order.getSelectedRow();
        String order_id = del_order.getValueAt(row_no, 0).toString();
        
        displayordid.setText(order_id);
        duedatevalue.setText(del_order.getValueAt( row_no,1).toString());
        
        try{
            String sql = "select p.prod_name,p.cont_size,o.qty from product p, order_1 o where p.prod_id = o.prod_id and o.ord_id ='"+order_id+"' ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            
            displayitems.setText("");   //this line of command prevents the previously viewed records add with the next records
            while(rs.next())
            {
                String displaytxt1 = rs.getString("prod_name");//.substring(0,9);
                String displaytxt2 = rs.getString("qty");
                int prodqty = Integer.parseInt(displaytxt2);
                int prodsize = Integer.parseInt(rs.getString("cont_size"));
                //totbox=boxcal(prodsize,prodqty);
                totbox=totbox + boxcal(prodsize,prodqty);
                //System.out.println("totbox:"+totbox);
            
                if(displaytxt1.length()>=15)
                {
                    displayitems.append("   "+displaytxt1.substring(0,12) +"\t"+ "x"+"\t"+displaytxt2+"\n");
                }
                else
                {
                    displayitems.append("   "+displaytxt1+"\t"+ "x"+"\t"+displaytxt2+"\n");
                }
                
                
                
            
                
            
            }
            //String dispatchbox = Double.toString(Math.ceil(totbox));
            double dispatchdou = Math.ceil(totbox);
            int dispatchint = (int)dispatchdou;
            dispatchval.setText(Integer.toString(dispatchint));
            
            
            
            String sql1 = "select r.ret_name,r.ret_address2 from retailer r, order_1 o where o.ord_id = '"+order_id+"' and o.ret_id = r.ret_id  ";
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                retnameval1.setText(rs.getString("ret_name"));
                retlocval1.setText(rs.getString("ret_address2"));
            }
            
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_del_orderMouseClicked

    private double boxcal(int size, int qty)
    {
        int boxheight = 30;
        int boxwidth = 45;
        int boxlength = 60;
        double boxsize = boxheight*boxwidth*boxlength;
        
        double prodsize = size*qty;
        double noofbox =prodsize/boxsize;
        //System.out.println(noofbox);
        return noofbox;
        
        
        
    }
    
    
    private void inchargecomboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inchargecomboMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_inchargecomboMouseEntered

    private void trucknocomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trucknocomboActionPerformed
        
        
        
        
    }//GEN-LAST:event_trucknocomboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTable del_order;
    private javax.swing.JLabel dispatch;
    private javax.swing.JLabel dispatchval;
    private javax.swing.JTextArea displayitems;
    private javax.swing.JLabel displayordid;
    private javax.swing.JLabel duedatevalue;
    private javax.swing.JLabel incharge;
    private javax.swing.JComboBox<String> inchargecombo;
    private javax.swing.JLabel inchargeimage;
    private javax.swing.JLabel itemlist;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel orderid;
    private javax.swing.JLabel retailerlabel;
    private javax.swing.JLabel retlocation;
    private javax.swing.JLabel retlocval1;
    private javax.swing.JLabel retnameval1;
    private javax.swing.JComboBox<String> trucknocombo;
    private javax.swing.JLabel trucknoimage;
    // End of variables declaration//GEN-END:variables
}
