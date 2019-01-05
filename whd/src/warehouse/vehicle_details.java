/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import codes.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;


public class vehicle_details extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    static int idcount;
    static int lastidcount;
    
    public vehicle_details() {
        initComponents();
        
        con = dbconnect.connect();
        
        trucktable();
        servicetable();
        //fillinchargecombo2();
        
        trucupdate.setEnabled(false);
        trucdelete.setEnabled(false);
        trucsubmit.setEnabled(true);
        trucnew.setVisible(false);
        
        trucknovalid.setVisible(false);
        purdatevalid.setVisible(false);
        makevalid.setVisible(false);
        capacvalid.setVisible(false);
        
        servupdate.setEnabled(false);
        servdelete.setEnabled(false);
        servsubmit.setEnabled(true);
        servnew.setVisible(false);
        
        servidvalid.setVisible(false);
        servtruckvalid.setVisible(false);
        servdatevalid.setVisible(false);
        servtypevalid.setVisible(false);
        servcostvalid.setVisible(false);
    }
    
    
    private void filltrucknocombo2(){
        
        try{
            String sql = "select truckno from truck";
            ps =con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while(rs.next())
            {
                String comboitems = rs.getString("truckno");
                servtruckval.addItem(comboitems);
            }
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error getting truck no from DB");
        }
        
        
    }
    
    
    

    private void trucktable()
    {
        trucktable.getTableHeader().setResizingAllowed(false);//cannot change the size of the columns
        try
        {
            String sql = "select truckno as 'Truck No',purchasedate as 'Purchase Date',trucktype as 'Make',availability as 'Availability',capacity as 'Capacity' from truck";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            trucktable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            
        }    
    }
    
    private void servicetable()
    {
        servtable.getTableHeader().setResizingAllowed(false);//cannot change the size of the columns
        try
        {
            String sql="select main_id as 'Service ID', truckno as 'Truck No', main_type as 'Service Type', main_date as 'Service Date', main_cost as 'Service Charge' from maintenance";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            servtable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            
        }
        
        
    }
    
    private void fillinchargecombo2(){
    
    try{
        String sql = "select truckno from truck ";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
        
        while(rs.next())
        {
            String comboitems = rs.getString("truckno");
            servtruckval.addItem(comboitems);
        }
    }
    catch(Exception e)
    {
        
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        truckno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trucktable = new javax.swing.JTable();
        truckno1 = new javax.swing.JLabel();
        truckno2 = new javax.swing.JLabel();
        truckno3 = new javax.swing.JLabel();
        truckno4 = new javax.swing.JLabel();
        trucknotxt = new javax.swing.JTextField();
        purdate = new com.toedter.calendar.JDateChooser();
        maketxt = new javax.swing.JTextField();
        capacitytxt = new javax.swing.JTextField();
        availtxt = new javax.swing.JComboBox<>();
        trucknovalid = new javax.swing.JLabel();
        purdatevalid = new javax.swing.JLabel();
        makevalid = new javax.swing.JLabel();
        capacvalid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        trucnew = new javax.swing.JButton();
        trucsubmit = new javax.swing.JButton();
        trucupdate = new javax.swing.JButton();
        trucdelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        servtable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        servnew = new javax.swing.JButton();
        servsubmit = new javax.swing.JButton();
        servupdate = new javax.swing.JButton();
        servdelete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        servid = new javax.swing.JLabel();
        servidval = new javax.swing.JTextField();
        servidvalid = new javax.swing.JLabel();
        servtruck = new javax.swing.JLabel();
        servdate = new javax.swing.JLabel();
        servtype = new javax.swing.JLabel();
        servcost = new javax.swing.JLabel();
        servcostval = new javax.swing.JTextField();
        servtypeval = new javax.swing.JComboBox<>();
        servdateval = new com.toedter.calendar.JDateChooser();
        servtruckval = new javax.swing.JComboBox<>();
        servtruckvalid = new javax.swing.JLabel();
        servdatevalid = new javax.swing.JLabel();
        servtypevalid = new javax.swing.JLabel();
        servcostvalid = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(859, 559));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        truckno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        truckno.setForeground(new java.awt.Color(255, 255, 255));
        truckno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        truckno.setText("Truck no:");
        truckno.setToolTipText("");
        truckno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        trucktable.setModel(new javax.swing.table.DefaultTableModel(
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
        trucktable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trucktableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(trucktable);

        truckno1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        truckno1.setForeground(new java.awt.Color(255, 255, 255));
        truckno1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        truckno1.setText("Purchase date:");
        truckno1.setToolTipText("");
        truckno1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        truckno2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        truckno2.setForeground(new java.awt.Color(255, 255, 255));
        truckno2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        truckno2.setText("Make:");
        truckno2.setToolTipText("");
        truckno2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        truckno3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        truckno3.setForeground(new java.awt.Color(255, 255, 255));
        truckno3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        truckno3.setText("Load Capacity:");
        truckno3.setToolTipText("");
        truckno3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        truckno4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        truckno4.setForeground(new java.awt.Color(255, 255, 255));
        truckno4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        truckno4.setText("Availability:");
        truckno4.setToolTipText("");
        truckno4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        purdate.setDateFormatString("yyyy-M-d ");

        availtxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "available", "unavailable" }));

        trucknovalid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        trucknovalid.setForeground(new java.awt.Color(255, 255, 255));
        trucknovalid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trucknovalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        trucknovalid.setToolTipText("");
        trucknovalid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        purdatevalid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        purdatevalid.setForeground(new java.awt.Color(255, 255, 255));
        purdatevalid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purdatevalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        purdatevalid.setToolTipText("");
        purdatevalid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        makevalid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        makevalid.setForeground(new java.awt.Color(255, 255, 255));
        makevalid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        makevalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        makevalid.setToolTipText("");
        makevalid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        capacvalid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        capacvalid.setForeground(new java.awt.Color(255, 255, 255));
        capacvalid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        capacvalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        capacvalid.setToolTipText("");
        capacvalid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        trucnew.setText("New");
        trucnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trucnewActionPerformed(evt);
            }
        });

        trucsubmit.setText("Submit");
        trucsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trucsubmitActionPerformed(evt);
            }
        });

        trucupdate.setText("Update");
        trucupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trucupdateActionPerformed(evt);
            }
        });

        trucdelete.setText("Delete");
        trucdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trucdeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trucnew, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trucsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trucupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trucdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trucnew, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(trucsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(trucupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(trucdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 2, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("*No of delivery boxes a truck can accomodate");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(truckno3)
                            .addComponent(truckno2)
                            .addComponent(truckno1)
                            .addComponent(truckno))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(trucknotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(trucknovalid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(purdate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(purdatevalid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(capacitytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(capacvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(maketxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)
                                    .addComponent(makevalid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(truckno4)
                        .addGap(18, 18, 18)
                        .addComponent(availtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(trucknotxt)
                                .addComponent(truckno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(trucknovalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(truckno1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(purdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(purdatevalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(truckno2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(maketxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(makevalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(truckno3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(capacitytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(capacvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(truckno4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(availtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("New Truck", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        servtable.setModel(new javax.swing.table.DefaultTableModel(
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
        servtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servtableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(servtable);

        jPanel4.setOpaque(false);

        servnew.setText("New");
        servnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servnewActionPerformed(evt);
            }
        });

        servsubmit.setText("Submit");
        servsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servsubmitActionPerformed(evt);
            }
        });

        servupdate.setText("Update");
        servupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servupdateActionPerformed(evt);
            }
        });

        servdelete.setText("Delete");
        servdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servdeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(servnew, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(servnew, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(servsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(servupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(servdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setOpaque(false);

        servid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servid.setForeground(new java.awt.Color(255, 255, 255));
        servid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servid.setText("Service ID:");
        servid.setToolTipText("");
        servid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servidvalid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servidvalid.setForeground(new java.awt.Color(255, 255, 255));
        servidvalid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servidvalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        servidvalid.setToolTipText("");
        servidvalid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servtruck.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servtruck.setForeground(new java.awt.Color(255, 255, 255));
        servtruck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servtruck.setText("Truck no:");
        servtruck.setToolTipText("");
        servtruck.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servdate.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servdate.setForeground(new java.awt.Color(255, 255, 255));
        servdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servdate.setText("Service Date:");
        servdate.setToolTipText("");
        servdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servtype.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servtype.setForeground(new java.awt.Color(255, 255, 255));
        servtype.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servtype.setText("Service Type:");
        servtype.setToolTipText("");
        servtype.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servcost.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servcost.setForeground(new java.awt.Color(255, 255, 255));
        servcost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servcost.setText("Service Cost:");
        servcost.setToolTipText("");
        servcost.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servtypeval.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Re-Fuel", "Engine Maintenance" }));
        servtypeval.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servtypevalMouseClicked(evt);
            }
        });
        servtypeval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servtypevalActionPerformed(evt);
            }
        });

        servdateval.setDateFormatString("yyyy-M-d ");

        servtruckval.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        servtruckval.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servtruckvalMouseClicked(evt);
            }
        });
        servtruckval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servtruckvalActionPerformed(evt);
            }
        });

        servtruckvalid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servtruckvalid.setForeground(new java.awt.Color(255, 255, 255));
        servtruckvalid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servtruckvalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        servtruckvalid.setToolTipText("");
        servtruckvalid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servdatevalid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servdatevalid.setForeground(new java.awt.Color(255, 255, 255));
        servdatevalid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servdatevalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        servdatevalid.setToolTipText("");
        servdatevalid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servtypevalid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servtypevalid.setForeground(new java.awt.Color(255, 255, 255));
        servtypevalid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servtypevalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        servtypevalid.setToolTipText("");
        servtypevalid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        servcostvalid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        servcostvalid.setForeground(new java.awt.Color(255, 255, 255));
        servcostvalid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servcostvalid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse/icons8-High Priority-32.png"))); // NOI18N
        servcostvalid.setToolTipText("");
        servcostvalid.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(servid)
                    .addComponent(servtype)
                    .addComponent(servdate)
                    .addComponent(servtruck)
                    .addComponent(servcost))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(servtypeval, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servdateval, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servtruckval, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servcostval, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(servidval, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(servcostvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(servtypevalid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(servtruckvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(servdatevalid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(servidvalid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(servidval, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(servtruckval, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(servdateval, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(servtypeval, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(servcostval, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servidvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servtruckvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servtruck, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(servdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(servdatevalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(servtype, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(servtypevalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servcostvalid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servcost, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Maintenance", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void trucktableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trucktableMouseClicked
       trucktable.setDefaultEditor(Object.class, null);//cannot edit cell values
       trucktable.getTableHeader().setReorderingAllowed(false);//cannot change the column positions
       trucktable.getTableHeader().setResizingAllowed(false);//cannot change the size of the columns
       
        
        trucupdate.setEnabled(true);
        trucdelete.setEnabled(true);
        trucsubmit.setEnabled(false);
        trucnew.setVisible(true);
        
        trucknovalid.setVisible(false);
        purdatevalid.setVisible(false);
        makevalid.setVisible(false);
        capacvalid.setVisible(false);
        
        availtxt.setSelectedIndex(0);
        
        int rowno = trucktable.getSelectedRow();
        String truckno = trucktable.getValueAt(rowno, 0).toString();
        
        trucknotxt.setText(truckno);
        
        try
        {
            String sql = "select purchasedate,trucktype,availability,capacity from truck where truckno = '"+truckno+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                purdate.setDate(rs.getDate("purchasedate"));
                maketxt.setText(rs.getString("trucktype"));
                capacitytxt.setText(rs.getString("capacity"));
                availtxt.setSelectedItem(rs.getString("availability"));
            }
        }
        catch(Exception e)
        {
            
        }
        
    }//GEN-LAST:event_trucktableMouseClicked

    private void trucnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trucnewActionPerformed
        
        trucupdate.setEnabled(false);
        trucdelete.setEnabled(false);
        trucsubmit.setEnabled(true);
        trucnew.setVisible(false);
        
        trucknotxt.setText("");
        purdate.setDate(null);
        maketxt.setText("");
        capacitytxt.setText("");
        availtxt.setSelectedIndex(0);
        trucktable();
        
    }//GEN-LAST:event_trucnewActionPerformed

    private void trucsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trucsubmitActionPerformed
        
        trucknovalid.setVisible(false);
        purdatevalid.setVisible(false);
        makevalid.setVisible(false);
        capacvalid.setVisible(false);
        
        truck t1 = new truck();
        int errcount =0;
        
        if((trucknotxt.getText().isEmpty()) || (truckno.getText().length()<6))
        {
            trucknovalid.setVisible(true);
            errcount++;
        }
        if(purdate.getDate() == null)
        {
            purdatevalid.setVisible(true);
            errcount++;
        }
        if((maketxt.getText().isEmpty()))
        {
            makevalid.setVisible(true);
            errcount++;
        }
        if((capacitytxt.getText().isEmpty()) || t1.checkfornum(capacitytxt.getText())==false)
        {
            capacvalid.setVisible(true);    
            errcount++;
        }
        
        if(errcount == 0)
        {
            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd"); 
            String purchasedate = Date_Format.format(purdate.getDate());
        
            t1.setTruckno(trucknotxt.getText());
            t1.setPurchasedate(purchasedate);
            t1.setTrucktype(maketxt.getText());
            t1.setTruckcap(Integer.parseInt(capacitytxt.getText()));
            t1.setAvailability(availtxt.getSelectedItem().toString());
        
            t1.insert();
            trucktable();
            
            trucknotxt.setText("");
            purdate.setDate(null);
            maketxt.setText("");
            capacitytxt.setText("");
        }
        
    }//GEN-LAST:event_trucsubmitActionPerformed

    private void trucupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trucupdateActionPerformed
       
        trucknovalid.setVisible(false);
        purdatevalid.setVisible(false);
        makevalid.setVisible(false);
        capacvalid.setVisible(false);
        
        int rowno = trucktable.getSelectedRow();
        
        if(rowno != -1)
        {
        truck t2 = new truck();
       
        int errcount =0;
        
            if(trucknotxt.getText().isEmpty())
            {
                trucknovalid.setVisible(true);
                errcount++;
            }
            if(purdate.getDate() == null)
            {
                purdatevalid.setVisible(true);
                errcount++;
            }
            if((maketxt.getText().isEmpty()))
            {
                makevalid.setVisible(true);
                errcount++;
            }
            if((capacitytxt.getText().isEmpty()) || t2.checkfornum(capacitytxt.getText())==false)
            {
                capacvalid.setVisible(true);    
                errcount++;
            }
            if(errcount == 0)
            {
                SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd"); 
                String purchasedate = Date_Format.format(purdate.getDate());
       
                t2.setTruckno(trucknotxt.getText());
                t2.setPurchasedate(purchasedate);
                t2.setTrucktype(maketxt.getText());
                t2.setTruckcap(Integer.parseInt(capacitytxt.getText()));
                t2.setAvailability(availtxt.getSelectedItem().toString());
       
                t2.updatetruck();
                trucktable();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a record to proceed further");
        }
    }//GEN-LAST:event_trucupdateActionPerformed

    private void trucdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trucdeleteActionPerformed
        int rowno = trucktable.getSelectedRow();
        String truckid = trucktable.getValueAt(rowno, 0).toString();
        
        if(rowno != -1)
        {
            con = dbconnect.connect();
            try{
                String sql ="Delete from truck where truckno = '"+truckid+"'";
                ps = con.prepareStatement(sql);
                ps.execute();
                
                trucktable();
            }
            catch(Exception e)
            {
                System.out.println("Error while deleting: "+e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Please select a record to delete");
        }
    }//GEN-LAST:event_trucdeleteActionPerformed

    private void servtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servtableMouseClicked
       servtable.setDefaultEditor(Object.class, null);//cannot edit cell values
       servtable.getTableHeader().setReorderingAllowed(false);//cannot change the column positions
        
        servupdate.setEnabled(true);
        servdelete.setEnabled(true);
        servsubmit.setEnabled(false);
        servnew.setVisible(true);
        
        servidvalid.setVisible(false);
        servtruckvalid.setVisible(false);
        servdatevalid.setVisible(false);
        servtypevalid.setVisible(false);
        servcostvalid.setVisible(false);
        
       /* servtruckval.setSelectedIndex(0);
        servdateval.setDate(null);
        servtypeval.setSelectedIndex(0);
        servcostval.setText("");    */
        
        int rowno = servtable.getSelectedRow();
        String servno = servtable.getValueAt(rowno, 0).toString();
        
        servidval.setText(servno);
        servidval.setEnabled(false);
        
        try
        {
            String sql = "select truckno,main_type,main_date,main_cost from maintenance where main_id='"+servno+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                servtruckval.setSelectedItem(rs.getString("truckno"));
                servdateval.setDate(rs.getDate("main_date"));
                servtypeval.setSelectedItem(rs.getString("main_type"));
                servcostval.setText(rs.getString("main_cost"));
            }
        }
        catch(Exception e)
        {
            
        }
        
        
        
    }//GEN-LAST:event_servtableMouseClicked

    private void servtruckvalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servtruckvalMouseClicked

    }//GEN-LAST:event_servtruckvalMouseClicked

    private void servtruckvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servtruckvalActionPerformed

    }//GEN-LAST:event_servtruckvalActionPerformed

    private void servtypevalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servtypevalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_servtypevalMouseClicked

    private void servtypevalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servtypevalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servtypevalActionPerformed

    private void servnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servnewActionPerformed
        servupdate.setEnabled(false);
        servdelete.setEnabled(false);
        servsubmit.setEnabled(true);
        servnew.setVisible(false);
        
        servidval.setText("");
        servtruckval.setSelectedIndex(0);
        servdateval.setDate(null);
        servtypeval.setSelectedIndex(0);
        servcostval.setText("");
        
        servupdate.setEnabled(false);
        servdelete.setEnabled(false);
        servsubmit.setEnabled(true);
        servnew.setVisible(false);
        
        servidval.setEnabled(true);
        
        
    }//GEN-LAST:event_servnewActionPerformed

    private void servsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servsubmitActionPerformed
        
        idcount = lastidcount+1;
        System.out.println("idcount = "+idcount);
        lastidcount = idcount;
        idcount = lastidcount;
        
        
        servidvalid.setVisible(false);
        servtruckvalid.setVisible(false);
        servdatevalid.setVisible(false);
        servtypevalid.setVisible(false);
        servcostvalid.setVisible(false);
        
        service  s1 = new service();
        int errcount =0;
        
        if(servidval.getText().isEmpty())
        {
            servidvalid.setVisible(true);
            errcount++;
        }
        
        if((servtruckval.getSelectedItem().toString().compareTo("Select") == 0))
        {
            servtruckvalid.setVisible(true);
            errcount++;
        }
        
        if(servdateval.getDate() == null)
        {
            servdatevalid.setVisible(true);
            errcount++;
        }
        if((servtypeval.getSelectedItem().toString().compareTo("Select") == 0))
        {
            servtypevalid.setVisible(true);
            errcount++;
        }
        if((servcostval.getText().isEmpty()) || s1.checkfornum(servcostval.getText())==false)
        {
            servcostvalid.setVisible(true);    
            errcount++;
        }
        
        if(errcount == 0)
        {
            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd"); 
            String servicedate = Date_Format.format(servdateval.getDate());
        
            s1.setServid(servidval.getText());
            s1.setTruckno(servtruckval.getSelectedItem().toString());
            s1.setServtype(servtypeval.getSelectedItem().toString());
            s1.setServdate(servicedate);
            s1.setServcost(Double.parseDouble(servcostval.getText()));
            s1.insert();
            servicetable();
            
            servidval.setText("");
            servtruckval.setSelectedIndex(0);
            servdateval.setDate(null);
            servtypeval.setSelectedIndex(0);
            servcostval.setText("");
            
            
        }
    }//GEN-LAST:event_servsubmitActionPerformed

    private void servupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servupdateActionPerformed
        
        servidvalid.setVisible(false);
        servtruckvalid.setVisible(false);
        servdatevalid.setVisible(false);
        servtypevalid.setVisible(false);
        servcostvalid.setVisible(false);
        
        service  s1 = new service();
        int errcount =0;
        
        if(servidval.getText().isEmpty())
        {
            servidvalid.setVisible(true);
            errcount++;
        }
        
        if((servtruckval.getSelectedItem().toString().compareTo("Select") == 0))
        {
            servtruckvalid.setVisible(true);
            errcount++;
        }
        
        if(servdateval.getDate() == null)
        {
            servdatevalid.setVisible(true);
            errcount++;
        }
        if((servtypeval.getSelectedItem().toString().compareTo("Select") == 0))
        {
            servtypevalid.setVisible(true);
            errcount++;
        }
        if((servcostval.getText().isEmpty()) || s1.checkfornum(servcostval.getText())==false)
        {
            servcostvalid.setVisible(true);    
            errcount++;
        }
        
        if(errcount == 0)
        {
            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd"); 
            String servicedate = Date_Format.format(servdateval.getDate());
        
            s1.setServid(servidval.getText());
            s1.setTruckno(servtruckval.getSelectedItem().toString());
            s1.setServtype(servtypeval.getSelectedItem().toString());
            s1.setServdate(servicedate);
            s1.setServcost(Double.parseDouble(servcostval.getText()));
            s1.update();
            servicetable();
            
            servidval.setText("");
            servtruckval.setSelectedIndex(0);
            servdateval.setDate(null);
            servtypeval.setSelectedIndex(0);
            servcostval.setText("");
            
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_servupdateActionPerformed

    private void servdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servdeleteActionPerformed
        
        try{
            String sql = "delete from maintenance where main_id='"+servidval.getText()+"'";
            ps=con.prepareStatement(sql);
            ps.execute();
        }
        catch(Exception e)
        {
            
        }
        servicetable();
    }//GEN-LAST:event_servdeleteActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
       
        servtruckval.removeAllItems();
        servicetable();
        fillinchargecombo2();
        
        
        
        
    }//GEN-LAST:event_jTabbedPane1MouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> availtxt;
    private javax.swing.JTextField capacitytxt;
    private javax.swing.JLabel capacvalid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField maketxt;
    private javax.swing.JLabel makevalid;
    private com.toedter.calendar.JDateChooser purdate;
    private javax.swing.JLabel purdatevalid;
    private javax.swing.JLabel servcost;
    private javax.swing.JTextField servcostval;
    private javax.swing.JLabel servcostvalid;
    private javax.swing.JLabel servdate;
    private com.toedter.calendar.JDateChooser servdateval;
    private javax.swing.JLabel servdatevalid;
    private javax.swing.JButton servdelete;
    private javax.swing.JLabel servid;
    private javax.swing.JTextField servidval;
    private javax.swing.JLabel servidvalid;
    private javax.swing.JButton servnew;
    private javax.swing.JButton servsubmit;
    private javax.swing.JTable servtable;
    private javax.swing.JLabel servtruck;
    private javax.swing.JComboBox<String> servtruckval;
    private javax.swing.JLabel servtruckvalid;
    private javax.swing.JLabel servtype;
    private javax.swing.JComboBox<String> servtypeval;
    private javax.swing.JLabel servtypevalid;
    private javax.swing.JButton servupdate;
    private javax.swing.JButton trucdelete;
    private javax.swing.JLabel truckno;
    private javax.swing.JLabel truckno1;
    private javax.swing.JLabel truckno2;
    private javax.swing.JLabel truckno3;
    private javax.swing.JLabel truckno4;
    private javax.swing.JTextField trucknotxt;
    private javax.swing.JLabel trucknovalid;
    private javax.swing.JTable trucktable;
    private javax.swing.JButton trucnew;
    private javax.swing.JButton trucsubmit;
    private javax.swing.JButton trucupdate;
    // End of variables declaration//GEN-END:variables
}
