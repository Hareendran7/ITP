/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import com.sun.glass.events.KeyEvent;
import com.teamdev.jxmaps.MapViewOptions;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author jega rinoshan
 */

public class retailer extends javax.swing.JPanel {
          Connection con = null;
    PreparedStatement pst = null;       //contains a sql statement which has been pre compiled
  ResultSet rs = null;        //Sql statements which read data from a database query, return the queried data to the resultset.
    
  double latitude,lantitude,distance;

    /**
     * Creates new form retailer
     */
  String rettID;
    public retailer() {
        initComponents();
         con=database_con. connect();
         view_table();
         genretid();
         retID.setText(rettID);
    }
       private void view_table(){
    
        try{
            String sql="select ret_id as'Retailer ID' , ret_name as'Retailer Name',ret_contact as'Contact' ,ret_address as'Retailer Address', ret_address2 as'Location', email as 'Email' from retailer";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery(sql);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));// display the queried the result from db to table
        }
        catch(Exception e){
            System.out.println("error");
        
        }
    }
          public void genretid()
         {
             try{
             String sql="select ret_id from retailer ORDER BY ret_id DESC LIMIT 1";
                 pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
            
            
                if(rs.next()){
                String b1=rs.getString("ret_id");
                int ln=b1.length();
                String stxt=b1.substring(0,3);
                String snum=b1.substring(3, ln);
                int o=Integer.parseInt(snum);
                o++;
                snum=Integer.toString(o);
                
                rettID=stxt +snum;
                
                
                
                }
                else{
                    rettID="ret123";
                }
                
             }
             catch(Exception e){}
         
         
         
         }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        retname = new javax.swing.JTextField();
        retcon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        retAdd = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        retADD2 = new javax.swing.JTextField();
        add2 = new javax.swing.JLabel();
        retRS = new javax.swing.JLabel();
        nameRS = new javax.swing.JLabel();
        conRS = new javax.swing.JLabel();
        add1 = new javax.swing.JLabel();
        nu = new javax.swing.JLabel();
        retID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        e_mail = new javax.swing.JTextField();
        emai_l = new javax.swing.JLabel();
        setloc = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(640, 549));
        setLayout(null);

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email:");
        add(jLabel5);
        jLabel5.setBounds(170, 180, 45, 30);

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Region:");
        add(jLabel4);
        jLabel4.setBounds(160, 370, 60, 30);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Retailer Name:");
        add(jLabel3);
        jLabel3.setBounds(110, 60, 110, 30);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Retailer ID:");
        add(jLabel2);
        jLabel2.setBounds(140, 20, 84, 34);

        retname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                retnameMouseEntered(evt);
            }
        });
        retname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retnameActionPerformed(evt);
            }
        });
        add(retname);
        retname.setBounds(240, 60, 170, 30);

        retcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                retconMouseEntered(evt);
            }
        });
        retcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retconActionPerformed(evt);
            }
        });
        retcon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                retconKeyTyped(evt);
            }
        });
        add(retcon);
        retcon.setBounds(240, 120, 170, 30);

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Retailer ID", "Retailer Name", "Retailer Address", "Retailer Contact", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 430, 742, 128);

        retAdd.setColumns(20);
        retAdd.setRows(5);
        retAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                retAddMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(retAdd);

        add(jScrollPane2);
        jScrollPane2.setBounds(240, 230, 170, 110);

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Retailer Address:");
        add(jLabel6);
        jLabel6.setBounds(90, 240, 123, 30);

        retADD2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                retADD2MouseEntered(evt);
            }
        });
        add(retADD2);
        retADD2.setBounds(240, 370, 170, 30);

        add2.setForeground(new java.awt.Color(255, 255, 255));
        add(add2);
        add2.setBounds(240, 400, 160, 20);

        retRS.setForeground(new java.awt.Color(255, 255, 255));
        add(retRS);
        retRS.setBounds(380, 410, 160, 20);

        nameRS.setForeground(new java.awt.Color(255, 255, 255));
        add(nameRS);
        nameRS.setBounds(240, 90, 160, 20);

        conRS.setForeground(new java.awt.Color(255, 255, 255));
        add(conRS);
        conRS.setBounds(240, 150, 170, 20);

        add1.setForeground(new java.awt.Color(255, 255, 255));
        add(add1);
        add1.setBounds(240, 340, 160, 20);

        nu.setForeground(new java.awt.Color(255, 255, 255));
        add(nu);
        nu.setBounds(610, 410, 160, 20);

        retID.setBackground(new java.awt.Color(51, 51, 51));
        retID.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        retID.setForeground(new java.awt.Color(255, 255, 255));
        retID.setText("ID");
        add(retID);
        retID.setBounds(240, 20, 140, 30);

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Retailer Contact No:");
        add(jLabel7);
        jLabel7.setBounds(70, 120, 150, 30);

        e_mail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                e_mailMouseEntered(evt);
            }
        });
        e_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_mailActionPerformed(evt);
            }
        });
        add(e_mail);
        e_mail.setBounds(240, 180, 170, 30);

        emai_l.setBackground(new java.awt.Color(51, 51, 51));
        emai_l.setForeground(new java.awt.Color(255, 255, 255));
        add(emai_l);
        emai_l.setBounds(240, 210, 170, 20);

        setloc.setBackground(new java.awt.Color(51, 51, 51));
        setloc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        setloc.setForeground(new java.awt.Color(255, 255, 255));
        setloc.setText("Set Location");
        setloc.setPreferredSize(new java.awt.Dimension(119, 41));
        setloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setlocActionPerformed(evt);
            }
        });
        add(setloc);
        setloc.setBounds(420, 370, 150, 30);

        jPanel1.setOpaque(false);

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit-validated-icon (1).png"))); // NOI18N
        jButton5.setText("Submit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-edit-undo-icon.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-edit-delete-icon.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1);
        jPanel1.setBounds(460, 80, 190, 230);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
               retailer_method r1= new retailer_method();
                     
                     int rowno = jTable1.getSelectedRow();
                     if (rowno == -1)
                {
                    JOptionPane.showMessageDialog(null, "Please select a row to Delete");
                }
                     else{
                     String row_id= jTable1.getValueAt(rowno,0).toString();
                     
                     r1.deleterrecord(row_id);
                        genretid();
       retID.setText(rettID);
                       retcon.setText("");
                       retAdd.setText("");
                       retname.setText("");
                       retADD2.setText("");
                     view_table();
                     }
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        jButton5.setEnabled(true);
        genretid();
       retID.setText(rettID);
       retcon.setText("");
       retAdd.setText("");
       retname.setText("");
       retADD2.setText("");
          add2.setText("");
        add1.setText("");
        conRS.setText("");
        retRS.setText("");
        nameRS.setText("");
         emai_l.setText("");
         e_mail.setText("");
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void retconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retconActionPerformed

    private void retnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retnameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          retailer_method r1= new retailer_method();
                     
                     int row_no = jTable1.getSelectedRow();
                     if (row_no == -1)
                {
                    JOptionPane.showMessageDialog(null, "Please select a row to Update");
                }
                     else{
                     String row_id= jTable1.getValueAt(row_no,0).toString();
                     
                     String upretid=retID.getText();
                     String upcon=retcon.getText();
                     String upadd=retAdd.getText();
                     String upname=retname.getText();
                     String upadd2=retADD2.getText();
                     
                     r1.setADD(upadd);
                     r1.setContact(upcon);
                     r1.setID(upretid);
                     r1.setName(upname);
                     r1.setADD2(upadd2);
                     
                     r1.updaterecord(row_id);
                     
                         genretid();
       retID.setText(rettID);
                       retcon.setText("");
                       retAdd.setText("");
                       retname.setText("");
                       retADD2.setText("");
                       
                       view_table();
                       
                      
                     
                     
                     }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       retailer_method r1=new retailer_method();
       boolean checkemailid;
       checkemailid = r1.check_emailid(e_mail.getText());
        boolean check_len;
        check_len = r1.check_lenphone(retcon.getText());
        
        if(checkemailid == false){
        
        emai_l.setText("*Enter a valid email ID");
        
        }
           if (check_len == false)
        {
            conRS.setText( "Please enter 10 digits for contact number");
        }
        
        
    
                         if(retname.getText().isEmpty())
         {
              nameRS.setText("*Required field");
         }
                if(retID.getText().isEmpty())
         {
              retRS.setText("*Required field");
         }
                
                    if(retcon.getText().isEmpty())
         {
              conRS.setText("*Required field");
         }
                             if(retAdd.getText().isEmpty())
         {
              add1.setText("*Required field");
         }
          
                   if(retADD2.getText().isEmpty())
         {
              add2.setText("*Required field");
         }
          if(retADD2.getText().isEmpty() ||retAdd.getText().isEmpty()  ||retcon.getText().isEmpty() ||retID.getText().isEmpty() ||retname.getText().isEmpty() || check_len == false || checkemailid == false ){
          
          nu.setText("*Required field");
          
          }
              
          else{ 
       r1.setlati(latitude);
       r1.setlang(lantitude);
       r1.setdistance(distance);
       r1.setEmail(e_mail.getText());
       r1.setADD2(retADD2.getText());
       r1.setID(retID.getText());
       r1.setContact(retcon.getText());
       r1.setADD(retAdd.getText());
       r1.setName(retname.getText());
   
       
       r1.Connet();
       
       //retID.setText("");
       e_mail.setText("");
       retcon.setText("");
       retAdd.setText("");
       retname.setText("");
       retADD2.setText("");
       emai_l.setText("");
         genretid();
         retID.setText(rettID);
         
       
    
              
          }
       
       
       view_table();
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        jButton5.setEnabled(false);
        int row=jTable1.getSelectedRow();
          String row_id=jTable1.getValueAt(row, 0).toString();
          
          try{
              String sql ="select * from retailer where ret_id= '"+row_id+"' "  ;
              pst=con.prepareStatement(sql);
              rs=pst.executeQuery();
              
              if(rs.next())
              {
                       String upretid=rs.getString("ret_id");
                     String upcon=rs.getString("ret_contact");
                     String upadd=rs.getString("ret_address");
                     String upname=rs.getString("ret_name");
                    String upADD2=rs.getString("ret_address2");
                        
                         retID.setText(upretid);
                        retcon.setText(upcon);
                         retAdd.setText(upadd);
                         retname.setText(upname); 
                         retADD2.setText(upADD2);
                         e_mail.setText(rs.getString("Email"));
        
                     
              }
          }
          catch(Exception e){}
          
    }//GEN-LAST:event_jTable1MouseClicked

    private void retconKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_retconKeyTyped
           char c =evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE)||c==KeyEvent.VK_DELETE)){ // we can not enter any character
        
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"You can't enter character");
      } 
    }//GEN-LAST:event_retconKeyTyped

    private void retnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retnameMouseEntered
           add2.setText("");
        add1.setText("");
        conRS.setText("");
        retRS.setText("");
        nameRS.setText("");
        nu.setText("");
         emai_l.setText("");
    }//GEN-LAST:event_retnameMouseEntered

    private void retconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retconMouseEntered
          add2.setText("");
        add1.setText("");
        conRS.setText("");
        retRS.setText("");
        nameRS.setText("");
         nu.setText("");
          emai_l.setText("");
    }//GEN-LAST:event_retconMouseEntered

    private void retAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retAddMouseEntered
          add2.setText("");
        add1.setText("");
        conRS.setText("");
        retRS.setText("");
        nameRS.setText("");
         nu.setText("");
          emai_l.setText("");
    }//GEN-LAST:event_retAddMouseEntered

    private void retADD2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retADD2MouseEntered
         add2.setText("");
        add1.setText("");
        conRS.setText(""); 
        retRS.setText("");
        nameRS.setText("");
         nu.setText("");
    }//GEN-LAST:event_retADD2MouseEntered

    private void e_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_mailActionPerformed

    private void e_mailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e_mailMouseEntered
           add2.setText("");
        add1.setText("");
        conRS.setText("");
        retRS.setText("");
        nameRS.setText("");
        nu.setText("");
         emai_l.setText("");
    }//GEN-LAST:event_e_mailMouseEntered

    
    private boolean checkcon()
    {
        try{
            URL url = new URL("https://www.google.com");
            URLConnection chkcon = url.openConnection();
            chkcon.connect();
            //return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please check your internet connection " );
            return false;
        }
        return true;
    }
    
    
    private void setlocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setlocActionPerformed
        
        if(checkcon()==true)
        {
        MapViewOptions options = new MapViewOptions();
        options.importPlaces();
        
        geolocation mapview = new geolocation(options);
        
        JFrame frame = new JFrame("Retailer Location");
        
        JButton setloc = new JButton("SET LOCATION");
        

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //frame.setBounds(0,0,200,200);
        frame.add(mapview, BorderLayout.CENTER);
        
        //adding a button to the frame
        frame.add(setloc, BorderLayout.PAGE_END);
        
        latitude= 0;
        lantitude = 0;
        distance = 0;
        
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
                
                if(latitude==0 || lantitude ==0 || distance==0)
                {
                    JOptionPane.showMessageDialog(null, "Please select a valid retailer location");
                }
                else
                {
                    frame.dispose();
                }
                
            }
            
        });
        
        
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        }
        
    }//GEN-LAST:event_setlocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add1;
    private javax.swing.JLabel add2;
    private javax.swing.JLabel conRS;
    private javax.swing.JTextField e_mail;
    private javax.swing.JLabel emai_l;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nameRS;
    private javax.swing.JLabel nu;
    private javax.swing.JTextField retADD2;
    private javax.swing.JTextArea retAdd;
    private javax.swing.JLabel retID;
    private javax.swing.JLabel retRS;
    private javax.swing.JTextField retcon;
    private javax.swing.JTextField retname;
    private javax.swing.JButton setloc;
    // End of variables declaration//GEN-END:variables
}
