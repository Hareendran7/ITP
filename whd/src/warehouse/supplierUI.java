/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gange
 */
public class supplierUI extends javax.swing.JFrame {

    /**
     * Creates new form functionUI
     */
    public supplierUI() {
        initComponents();
        
        panelSupplier p2 = new panelSupplier();
        jPanel3.removeAll();
        jPanel3.add(p2);
        jPanel3.revalidate();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        topinventory = new javax.swing.JButton();
        topduepayment = new javax.swing.JButton();
        topsalesorders = new javax.swing.JButton();
        topemployee = new javax.swing.JButton();
        topfinance = new javax.swing.JButton();
        topdamagehandle = new javax.swing.JButton();
        home = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        topdelivery = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1150, 700));

        topinventory.setBackground(new java.awt.Color(51, 51, 51));
        topinventory.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        topinventory.setForeground(new java.awt.Color(255, 255, 255));
        topinventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Cardboard Box-64.png"))); // NOI18N
        topinventory.setText("Inventory");
        topinventory.setBorder(null);
        topinventory.setBorderPainted(false);
        topinventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        topinventory.setFocusPainted(false);
        topinventory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topinventory.setName("topinventory"); // NOI18N
        topinventory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        topinventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topinventoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topinventoryMouseExited(evt);
            }
        });
        topinventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topinventoryActionPerformed(evt);
            }
        });

        topduepayment.setBackground(new java.awt.Color(51, 51, 51));
        topduepayment.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        topduepayment.setForeground(new java.awt.Color(255, 255, 255));
        topduepayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Payment History-64.png"))); // NOI18N
        topduepayment.setText("Due Payment");
        topduepayment.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        topduepayment.setBorderPainted(false);
        topduepayment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topduepayment.setName("delivery"); // NOI18N
        topduepayment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        topduepayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topduepaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topduepaymentMouseExited(evt);
            }
        });
        topduepayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topduepaymentActionPerformed(evt);
            }
        });

        topsalesorders.setBackground(new java.awt.Color(51, 51, 51));
        topsalesorders.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        topsalesorders.setForeground(new java.awt.Color(255, 255, 255));
        topsalesorders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Shopping Cart Loaded-64.png"))); // NOI18N
        topsalesorders.setText("Sales & Orders");
        topsalesorders.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        topsalesorders.setBorderPainted(false);
        topsalesorders.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topsalesorders.setName("delivery"); // NOI18N
        topsalesorders.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        topsalesorders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topsalesordersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topsalesordersMouseExited(evt);
            }
        });
        topsalesorders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topsalesordersActionPerformed(evt);
            }
        });

        topemployee.setBackground(new java.awt.Color(51, 51, 51));
        topemployee.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        topemployee.setForeground(new java.awt.Color(255, 255, 255));
        topemployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Permanent Job-64.png"))); // NOI18N
        topemployee.setText("Employee");
        topemployee.setBorder(null);
        topemployee.setBorderPainted(false);
        topemployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        topemployee.setFocusPainted(false);
        topemployee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topemployee.setName("inventory"); // NOI18N
        topemployee.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        topemployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topemployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topemployeeMouseExited(evt);
            }
        });
        topemployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topemployeeActionPerformed(evt);
            }
        });

        topfinance.setBackground(new java.awt.Color(51, 51, 51));
        topfinance.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        topfinance.setForeground(new java.awt.Color(255, 255, 255));
        topfinance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Sales Performance-64.png"))); // NOI18N
        topfinance.setText("Finance");
        topfinance.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        topfinance.setBorderPainted(false);
        topfinance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topfinance.setName("delivery"); // NOI18N
        topfinance.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        topfinance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topfinanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topfinanceMouseExited(evt);
            }
        });
        topfinance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topfinanceActionPerformed(evt);
            }
        });

        topdamagehandle.setBackground(new java.awt.Color(51, 51, 51));
        topdamagehandle.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        topdamagehandle.setForeground(new java.awt.Color(255, 255, 255));
        topdamagehandle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Factory-64.png"))); // NOI18N
        topdamagehandle.setText("Damage Handling");
        topdamagehandle.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        topdamagehandle.setBorderPainted(false);
        topdamagehandle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topdamagehandle.setName("delivery"); // NOI18N
        topdamagehandle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        topdamagehandle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topdamagehandleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topdamagehandleMouseExited(evt);
            }
        });
        topdamagehandle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topdamagehandleActionPerformed(evt);
            }
        });

        home.setBackground(new java.awt.Color(51, 51, 51));
        home.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Home-64.png"))); // NOI18N
        home.setText("Home");
        home.setBorder(null);
        home.setBorderPainted(false);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setFocusPainted(false);
        home.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        home.setName("topinventory"); // NOI18N
        home.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMouseExited(evt);
            }
        });
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Supplier Management");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Order Management");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Supplier Payment Management");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Reports");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        topdelivery.setBackground(new java.awt.Color(51, 51, 51));
        topdelivery.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        topdelivery.setForeground(new java.awt.Color(255, 255, 255));
        topdelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-Delivery-64.png"))); // NOI18N
        topdelivery.setText("Delivery");
        topdelivery.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        topdelivery.setBorderPainted(false);
        topdelivery.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topdelivery.setName("delivery"); // NOI18N
        topdelivery.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        topdelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topdeliveryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topdeliveryMouseExited(evt);
            }
        });
        topdelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topdeliveryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(topinventory, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(topdelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(topduepayment, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(topsalesorders, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(topemployee, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(topfinance, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(topdamagehandle, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topdamagehandle, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topfinance, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topemployee, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topsalesorders, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topduepayment, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topinventory, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topdelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void topinventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topinventoryMouseEntered
        topinventory.setBackground(new Color(51,51,51).brighter());
        topinventory.setSize(131,120);
    }//GEN-LAST:event_topinventoryMouseEntered

    private void topinventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topinventoryMouseExited

        topinventory.setBackground(new Color(51,51,51));
        topinventory.setSize(131,108);
    }//GEN-LAST:event_topinventoryMouseExited

    private void topinventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topinventoryActionPerformed
        // TODO add your handling code here:
       productUI inventory= new productUI();
        inventory.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_topinventoryActionPerformed

    private void topduepaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topduepaymentMouseEntered
        topduepayment.setBackground(new Color(51,51,51).brighter());
        topduepayment.setSize(131,120);

    }//GEN-LAST:event_topduepaymentMouseEntered

    private void topduepaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topduepaymentMouseExited
        topduepayment.setBackground(new Color(51,51,51));
        topduepayment.setSize(131,108);
    }//GEN-LAST:event_topduepaymentMouseExited

    private void topsalesordersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topsalesordersMouseEntered
        topsalesorders.setBackground(new Color(51,51,51).brighter());
        topsalesorders.setSize(131,120);
    }//GEN-LAST:event_topsalesordersMouseEntered

    private void topsalesordersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topsalesordersMouseExited
        topsalesorders.setBackground(new Color(51,51,51));
        topsalesorders.setSize(131,108);
    }//GEN-LAST:event_topsalesordersMouseExited

    private void topemployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topemployeeMouseEntered
        topemployee.setBackground(new Color(51,51,51).brighter());
        topemployee.setSize(131,120);
    }//GEN-LAST:event_topemployeeMouseEntered

    private void topemployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topemployeeMouseExited
        topemployee.setBackground(new Color(51,51,51));
        topemployee.setSize(131,108);
    }//GEN-LAST:event_topemployeeMouseExited

    private void topemployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topemployeeActionPerformed
        employee log = new employee();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_topemployeeActionPerformed

    private void topdeliveryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topdeliveryMouseEntered
        topdelivery.setBackground(new Color(51,51,51).brighter());
        topdelivery.setSize(131,120);
    }//GEN-LAST:event_topdeliveryMouseEntered

    private void topdeliveryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topdeliveryMouseExited
        topdelivery.setBackground(new Color(51,51,51));
        topdelivery.setSize(131,108);
    }//GEN-LAST:event_topdeliveryMouseExited

    private void topfinanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topfinanceMouseEntered
        topfinance.setBackground(new Color(51,51,51).brighter());
        topfinance.setSize(131,120);
    }//GEN-LAST:event_topfinanceMouseEntered

    private void topfinanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topfinanceMouseExited
        topfinance.setBackground(new Color(51,51,51));
        topfinance.setSize(131,108);
    }//GEN-LAST:event_topfinanceMouseExited

    private void topdamagehandleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topdamagehandleMouseEntered
        topdamagehandle.setBackground(new Color(51,51,51).brighter());
        topdamagehandle.setSize(131,120);
    }//GEN-LAST:event_topdamagehandleMouseEntered

    private void topdamagehandleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topdamagehandleMouseExited
        topdamagehandle.setBackground(new Color(51,51,51));
        topdamagehandle.setSize(131,108);
    }//GEN-LAST:event_topdamagehandleMouseExited

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
        home.setBackground(new Color(51,51,51).brighter());
        home.setSize(131,120);
    }//GEN-LAST:event_homeMouseEntered

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
        home.setBackground(new Color(51,51,51));
        home.setSize(131,108);
    }//GEN-LAST:event_homeMouseExited

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        homeUI gohome = new homeUI();
        gohome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        panelSupplier p2 = new panelSupplier();
        jPanel3.removeAll();
        jPanel3.add(p2);
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        panelOrder p3 = new panelOrder();
        jPanel3.removeAll();
        jPanel3.add(p3);
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        panelSupppayment p4 = new panelSupppayment();
        jPanel3.removeAll();
        jPanel3.add(p4);
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void topduepaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topduepaymentActionPerformed
        // TODO add your handling code here:
        DuePaymentUI log = new DuePaymentUI();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_topduepaymentActionPerformed

    private void topsalesordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topsalesordersActionPerformed
        order_salesUI log = new order_salesUI();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_topsalesordersActionPerformed

    private void topdeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topdeliveryActionPerformed
        functionUI deliveryfunc = new functionUI();
       deliveryfunc.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_topdeliveryActionPerformed

    private void topfinanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topfinanceActionPerformed
        financeUI log = new financeUI();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_topfinanceActionPerformed

    private void topdamagehandleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topdamagehandleActionPerformed
        damageUI log = null;
        try {
            log = new damageUI();
        } catch (SQLException ex) {
            Logger.getLogger(homeUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_topdamagehandleActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        panelReport p5 = new panelReport();
        jPanel3.removeAll();
        jPanel3.add(p5);
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(supplierUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplierUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplierUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplierUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplierUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton home;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton topdamagehandle;
    private javax.swing.JButton topdelivery;
    private javax.swing.JButton topduepayment;
    private javax.swing.JButton topemployee;
    private javax.swing.JButton topfinance;
    private javax.swing.JButton topinventory;
    private javax.swing.JButton topsalesorders;
    // End of variables declaration//GEN-END:variables
}
