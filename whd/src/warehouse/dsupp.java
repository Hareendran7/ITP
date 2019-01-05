/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;


import Class.DBconnecter;
import classs.DamageSup;
import classs.stockD;
import classs.table_1;
import classs.validate;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.sql.Connection;
import static java.sql.JDBCType.DATE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author it16112810
 */
public class dsupp extends javax.swing.JPanel {

        PreparedStatement pst = null;
        ResultSet rs=null;
        DateFormat df = DateFormat.getDateInstance();
        Connection conn = null;
        
    public dsupp() throws SQLException {
        initComponents();
        conn =  DBconnecter.connect();
        fillcombo4();
        showtable();
    }
    

    
    private void fillcombo1(){
        
     
  
        try {
            String codee = jComboBox4.getSelectedItem().toString();
            
            String sql = "SELECT p.supp_id FROM stock s ,product p  where p.prod_id = s.prod_id and stoc_id= '"+codee +"'  ";
     
            pst = conn.prepareStatement(sql);
            
            rs = pst.executeQuery();
            
           while(rs.next())
            {

                
                String UNN_PR=rs.getString("supp_id");
                jLabel9.setText(UNN_PR);
                String UNNN_PR=rs.getString("supp_id");
                jLabel27.setText(UNNN_PR);
        
  
           }  
             
           
        } catch (Exception e) {
            System.out.println(e);
        }
 
    }
    
    
 private void fillcombo2() throws SQLException{
  
    
    // String code = jComboBox1.getSelectedItem().toString();
     
    //   String sql = "SELECT prod_id FROM product where supp_id= '"+code+"' ";
    //   String sql = "SELECT prod_id FROM stock where stoc_id= '"+code+"' ";
//    
// String sql = "SELECT * FROM product";
// try {
//     pst = conn.prepareStatement(sql);
//     rs = pst.executeQuery();
//     
//     while(rs.next())
//     {
//          String Pr_ID = rs.getString("prod_id");
//          jComboBox2.addItem(Pr_ID);
//          String Prr_ID = rs.getString("prod_id");
//          jComboBox7.addItem(Prr_ID);
//         
//     }
//     
//      } catch (Exception e) {
//            System.out.println(e);
//        }
    }
    
private void fillcombo3(){
    
    
       
       

      //  String sql = "SELECT buy_price FROM product ";
        try {
            
         String codeee = jComboBox2.getSelectedItem().toString();
         String sql = "SELECT buy_price FROM product where prod_id ='"+codeee+"' ";
         
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
//                String UN_Pr = rs.getString("buy_price");
//                jComboBox3.addItem(UN_Pr);
                
                String UN_PR=rs.getString("buy_price");
                jLabel10.setText(UN_PR);
                String UNP_PR=rs.getString("buy_price");
                jLabel19.setText(UNP_PR);
                
//                String UNN_Pr = rs.getString("buy_price");
//                jComboBox5.addItem(UNN_Pr);
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

private void fillcombo4(){
    
    DamageSup dm=new DamageSup();
    Connection conn =DamageSup.connect();
    
     String sql = "SELECT stoc_id  FROM stock";
        try {
            
           
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                String ST_Pr = rs.getString("stoc_id");
                jComboBox4.addItem(ST_Pr);
                String STT_Pr = rs.getString("stoc_id");
                jComboBox8.addItem(STT_Pr);
                String Pr_ID = rs.getString("prod_id");
                jComboBox2.addItem(Pr_ID);
                String Prr_ID = rs.getString("prod_id");
                jComboBox7.addItem(Prr_ID);
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
  
   
      


    }

      
      
      public ArrayList<table_1>tablelist(){
         ArrayList<table_1> tablelist= new ArrayList<>();
         try{
             String sql="SELECT dmgs_id,dmgst_id,dmgs_date,dmgs_des,dmgspr_id,dmgs_qty,dmgs_unit,dmgs_tot FROM dmgsup ";
             pst=conn.prepareStatement(sql);
             rs= pst.executeQuery();


            while(rs.next()){
                table_1 tb=new table_1(rs.getString("dmgs_id"),rs.getString("dmgst_id"),rs.getString("dmgs_date"),rs.getString("dmgs_des"),rs.getString("dmgspr_id"),rs.getString("dmgs_qty"),rs.getString("dmgs_unit"),rs.getString("dmgs_tot"));
                tablelist.add(tb);

            }

         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);

         }
         return tablelist;
     }
      
  
    
         public void tableload()
         {
         
              String PID = jTextField4.getText();
         
             try{
             
            //  String sql="SELECT prod_id,stoc_name,qty,rece_date FROM stock where stoc_id ='"+PID+"' ";
            // String sql="SELECT s.prod_id,p.supp_id,s.stoc_name,s.qty,p.unit_price,s.rece_date FROM stock s ,product p  where s.prod_id = p.prod_id ";
            
            // String sq= "SELECT s.prod_id,p.supp_id,s.stoc_name,s.quantity,p.buy_price,s.rece_date FROM stock s ,product p  where s.stoc_id ='"+PID+"' and s.prod_id = p.prod_id ";
            
           String sq =  "SELECT s.prod_id AS PRODUCT ,p.supp_id AS SUPPLIER ,s.quantity AS QTY,p.buy_price AS BUYPRICE,s.rece_date AS RECEIVEDATE  FROM stock s ,product p  where s.stoc_id = '"+PID+"' and s.prod_id = p.prod_id" ;
           
          //   String sq= "SELECT s.prod_id,p.supp_id,s.stoc_id,s.quantity,p.buy_price,s.rece_date FROM stock s ,product p  where s.stoc_id ='"+PID+"' ";
             pst=conn.prepareStatement(sq);
             rs= pst.executeQuery();
             

             jTable2.setModel(DbUtils.resultSetToTableModel(rs));
             
             }
             catch(Exception e){
             
             
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

        jPanel3 = new javax.swing.JPanel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSlider1 = new javax.swing.JSlider();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        IMessage = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("UNIT PRICE");

        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUPPLIER ID");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRODUCT ID");

        jComboBox2.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox2MouseEntered(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("TOTAL");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DESCRIPTION");

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));

        IMessage.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        IMessage.setForeground(new java.awt.Color(255, 0, 0));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PURCHASE ID");

        jComboBox4.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox4MouseEntered(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DATE");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("QTY");

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(27, 27, 27)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(36, 36, 36)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(27, 27, 27)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))))
                .addGap(101, 101, 101)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(10, 10, 10)))
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-validated-icon (1).png"))); // NOI18N
        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-undo-icon.png"))); // NOI18N
        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("SEARCH");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("STOCK ID");

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P_ID", "QTY", "UNIT_PRICE", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SUPPLIER", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLayeredPane2.setBackground(new java.awt.Color(51, 51, 51));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DATE");

        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("PRODUCT ID");

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("UNIT PRICE");

        jComboBox7.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox7.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT PRODUCT ID" }));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("SUPPLIER ID");

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("STOCK ID");

        jComboBox8.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox8.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT STOCK ID" }));

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("AMOUNT");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DESCRIPTION");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("QTY");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));

        jLabel27.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));

        jLayeredPane2.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jComboBox7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jComboBox8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jDateChooser2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17))
                        .addGap(24, 24, 24)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(24, 24, 24)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(38, 38, 38)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9)
                            .addComponent(jTextField3)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 15, Short.MAX_VALUE))
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(141, 141, 141))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(27, 27, 27)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SUPPLIER ID", "STOCK ID", "PRODUCT ID", "DESCRIPTION", "QTY", "UNIT_PRICE", "DATE", "AMOUNT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-delete-icon.png"))); // NOI18N
        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("SUBMIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-undo-icon.png"))); // NOI18N
        jButton6.setText("RESET");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(20, 20, 20))
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("VIEW", jPanel2);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jTable3.setBackground(new java.awt.Color(51, 51, 51));
        jTable3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SUPPLIER ID", "STOCK ID", "DATE", "DESCRIPTION", "PRODUCT ID", "QTY", "UNIT PRICE", "AMOUNT"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-undo-icon.png"))); // NOI18N
        jButton7.setText("RESET");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("PRINT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("SUPPLIER NAME");

        jTextField6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(52, 52, 52)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("PRINT", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
            try {
                // TODO add your handling code here:
                //ROW WISE
    
                DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                int r = jTable1.getSelectedRow();
  
                 String D_ID = jTable1.getValueAt(r, 0).toString();
                 String S_ID = jTable1.getValueAt(r, 1).toString();
                 Date date =new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(r, 2).toString());
                 String des  = jTable1.getValueAt(r, 3).toString();
                 String P_ID = jTable1.getValueAt(r, 4).toString();
                 String QTY  = jTable1.getValueAt(r, 5).toString();
                 String UNIT_PRICE = jTable1.getValueAt(r,6).toString();
                 String AMOUNT = jTable1.getValueAt(r, 7).toString();
                 
                
                    
                    jLabel27.setText(D_ID);
                  //  jComboBox6.setSelectedItem(D_ID);
                    jComboBox8.setSelectedItem(S_ID);
                    jDateChooser2.setDate(date);
                    jTextField8.setText(des);
                    jComboBox7.setSelectedItem(P_ID);
                    jTextField9.setText(QTY);
                  //  jComboBox5.setSelectedItem(UNIT_PRICE);
                    jLabel19.setText(UNIT_PRICE);
                    jTextField3.setText(AMOUNT);
                    jTextField6.setText(D_ID);
                    
                      double QTYQ = Double.parseDouble(QTY);

                if(QTYQ>=1000)
                {
                    jTextField9.setBackground(Color.RED);
                    jTextField9.setForeground(Color.BLACK);

                }

                else{

                    jTextField9.setBackground(Color.BLUE);
                    jTextField9.setForeground(Color.BLACK);

                }

            } catch (ParseException ex) {
                System.out.println(ex);
            }

      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased

    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        //INSERT
     
      validate valid=new validate();
      valid.isBlank(jTextField5.getText(),jLabel22);
      valid.isBlank(jTextField1.getText(),jLabel20);
      valid.isBlank(jTextField2.getText(),jLabel21);
  
        try{

        SimpleDateFormat dFormat = new SimpleDateFormat("YYYY-MM-dd");
        
      //  String DS_ID=jComboBox1.getSelectedItem().toString();
        String DS_ID=jLabel9.getText();
        String ST_ID=jComboBox4.getSelectedItem().toString();
        String S_DATE= dFormat.format(jDateChooser1.getDate());
        String S_DES=jTextField5.getText();
        String PPR_ID=jComboBox2.getSelectedItem().toString();
     //   String PPR_ID=jLabel10.getText();
        String S_QTY=jTextField1.getText();
      //  String S_UNITPRICE=jComboBox3.getSelectedItem().toString();
          String S_UNITPRICE=jLabel10.getText();
        String S_AMOUNT=jTextField2.getText();
        


            IMessage.setText("");

            DefaultTableModel model =(DefaultTableModel)jTable1.getModel();

            if(!jTextField1.getText().trim().equals("")){
                
             
           //   model.addRow(new Object[]{jComboBox1.getSelectedItem(),jComboBox4.getSelectedItem(),S_DATE,jTextField5.getText(),jComboBox2.getSelectedItem(),jTextField1.getText(),jComboBox3.getSelectedItem(),jTextField2.getText()});
               model.addRow(new Object[]{jLabel9.getText(),jComboBox4.getSelectedItem(),S_DATE,jTextField5.getText(),PPR_ID,jComboBox2.getSelectedItem(),jTextField1.getText(),jLabel10.getText(),jTextField2.getText()});
                String sql="INSERT INTO dmgsup(dmgs_id,dmgst_id,dmgs_date,dmgs_des,dmgspr_id,dmgs_qty,dmgs_unit,dmgs_tot) VALUES('"+DS_ID+"','"+ST_ID+"','"+S_DATE+"','"+S_DES+"','"+PPR_ID+"','"+S_QTY+"','"+S_UNITPRICE+"','"+S_AMOUNT+"')";
            
                String sqll=" UPDATE stock SET quantity = quantity - '"+S_QTY+"' WHERE stoc_id ='"+ST_ID+"' and prod_id ='"+PPR_ID+"' ";
             
                
                String word = " DEDUCT DAMAGE " ;
                
                String sqlll=" UPDATE suppayment SET amount = amount - '"+S_AMOUNT+"',ref_dese ='"+word+"' WHERE stoc_id ='"+ST_ID+"'";
                
                pst=conn.prepareStatement(sql);
                pst.execute();
                pst=conn.prepareStatement(sqll);
                pst.execute();
                pst=conn.prepareStatement(sqlll);
                pst.execute();

                JOptionPane.showMessageDialog(null, " RECORD INSERTED ");

            }
            
            else{

                IMessage.setText(" * QTY SHOULD BE THERE OTHER WISE CANT GET THE AMOUNT ");
            }

        }catch(Exception e){

            System.out.println(e);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:


        jTextField5.setText("  ");
       // jComboBox1.setSelectedItem("SELECT SUPPLIER ID");
        jComboBox2.setSelectedItem("SELECT PRODUCT ID");
        jLabel9.setText("  ");
        jComboBox4.setSelectedItem("SELECT STOCK ID");
        jDateChooser1.setDate(null);
        jTextField1.setText("  ");
     //   jComboBox5.setSelectedItem("UNIT PRICE");
         jLabel10.setText("  ");
        jTextField2.setText("  ");
        



        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
         //RESET
         
        jTextField8.setText("  ");
        //jComboBox6.setSelectedItem("SELECT SUPPLIER ID");
        jLabel27.setText("  ");
        jComboBox7.setSelectedItem("SELECT PRODUCT ID");
        jComboBox8.setSelectedItem("SELECT STOCK ID");
        jDateChooser2.setDate(null);
        jTextField9.setText("  ");
       // jComboBox5.setSelectedItem("UNIT PRICE");
        jLabel19.setText("  ");
        jLabel19.setText("  ");
        jTextField3.setText("  ");
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
         int x= JOptionPane.showConfirmDialog(null,"Do you want to delete it?");
        if(x==0){


            String D_ID=jComboBox8.getSelectedItem().toString();
            String DP_ID=jComboBox7.getSelectedItem().toString();
            String S_QTY=jTextField9.getText();
            String S_AMOUNT=jTextField3.getText();
            
            
            String sql = "DELETE from dmgsup  WHERE dmgst_id='"+D_ID+"' and dmgspr_id='"+DP_ID+"' " ;
            String sqll=" UPDATE stock SET quantity = quantity + '"+S_QTY+"' WHERE stoc_id ='"+D_ID+"' and prod_id ='"+DP_ID+"' ";
            String word = "DELETE DAMAGE " ;
            String sqlll=" UPDATE suppayment SET amount  = amount  + '"+S_AMOUNT+"',ref_dese = '"+word+"' WHERE stoc_id ='"+D_ID+"' and prod_id ='"+DP_ID+"' ";
            
            try{
                pst=conn.prepareStatement(sql);
                pst.execute();
                pst=conn.prepareStatement(sqll);
                pst.execute();
                pst=conn.prepareStatement(sqlll);
                pst.execute();
                Statement ST;
                ST = conn.createStatement();

                    DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    JOptionPane.showMessageDialog(null, "Deleted");
                    showtable();
                              
            }catch(Exception e){
                System.out.println(e);

            }
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //ADD SELECTED ROWS to another table

        TableModel modell = jTable1.getModel();
        int[]indexs = jTable1.getSelectedRows();
        

        Object[] row = new Object[8];

        DefaultTableModel mode12 = ( DefaultTableModel)jTable3.getModel();
        
        
        
        for(int i =0 ; i < indexs.length ; i++)
        {

            row[0] = modell.getValueAt(indexs[i],0);
            row[1] = modell.getValueAt(indexs[i],1);
            row[2] = modell.getValueAt(indexs[i],2);
            row[3] = modell.getValueAt(indexs[i],3);
            row[4] = modell.getValueAt(indexs[i],4);
            row[5] = modell.getValueAt(indexs[i],5);
            row[6] = modell.getValueAt(indexs[i],6);
            row[7] = modell.getValueAt(indexs[i],7);
            
            
            
            
            

            mode12.addRow(row);
        }
        JOptionPane.showMessageDialog(null, "ADDED TO DAMAGED GOODS");                 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        
           DefaultTableModel mode =(DefaultTableModel)jTable3.getModel();
            while (mode.getRowCount()>0){
            for(int i=0;i<mode.getRowCount();i++)
            {
                mode.removeRow(i);
            }

        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //update 
        
        
       validate valid=new validate(); 
       valid.isBlank(jTextField8.getText(),jLabel23);
       valid.isBlank(jTextField9.getText(),jLabel24);
       valid.isBlank(jTextField3.getText(),jLabel25);
        
        int x =JOptionPane.showConfirmDialog(null, "Do you want to update?");
        
        if(x==0){
            
            String desc=jTextField8.getText();
           // String supID=jComboBox6.getSelectedItem().toString();
            String supID=jLabel27.getText();
            String proID=jComboBox7.getSelectedItem().toString();
            String sto_ID=jComboBox8.getSelectedItem().toString();
            
            SimpleDateFormat dateformat=new  SimpleDateFormat ("yyyy-MM-dd");
            String exdate=dateformat.format(jDateChooser2.getDate());
            
            String qty=jTextField9.getText();
           // String uniPr=jComboBox5.getSelectedItem().toString();
            String uniPr=jLabel19.getText();
            String amnt=jTextField3.getText();
                
            
            try{
                String record = "SELECT * FROM dmgsup WHERE dmgs_id='"+supID+"' AND dmgst_id='"+sto_ID+"' AND dmgs_date='"+exdate +"' AND dmgs_des='"+desc +"' AND dmgspr_id ='"+proID+"' AND dmgs_qty='"+qty +"' AND dmgs_unit='"+uniPr+"' AND dmgs_tot='"+amnt+"' ";
                
                pst = conn.prepareStatement(record);
                ResultSet rs = pst.executeQuery();
                
                    if(rs.next()){
                        JOptionPane.showConfirmDialog(null, "Record already exists");
                    }
                    else{
                        String sql="UPDATE dmgsup SET dmgs_id='"+supID+"',dmgst_id='"+sto_ID+"',dmgs_date='"+exdate +"',dmgs_des='"+desc +"',dmgspr_id ='"+proID+"',dmgs_qty='"+qty +"',dmgs_unit='"+uniPr+"',dmgs_tot='"+amnt+"' where dmgst_id ='"+sto_ID+"' and dmgspr_id = '"+proID+"' ";
                        
//                        if (qty < = record.qty)
//                        {
//                        String sqll=" UPDATE stock SET qty = qty  '"+qty+"' WHERE stoc_id ='"+sto_ID+"' and prod_id ='"+proID+"' ";
//                        String sqlll=" UPDATE suppayment SET amount = amount '"+amnt+"' WHERE stoc_id ='"+sto_ID+"' and prod_id ='"+proID+"' ";
//                        pst=conn.prepareStatement(sqll);
//                        pst.execute();
//                        pst=conn.prepareStatement(sqlll);
//                        pst.execute();
//                        
//                        }
//                        else
//                            
//                        {
//                        String sqll=" UPDATE stock SET qty = qty - '"+qty+"' WHERE stoc_id ='"+sto_ID+"' and prod_id ='"+proID+"' ";
//                        String sqlll=" UPDATE suppayment SET amount = amount- '"+amnt+"' WHERE stoc_id ='"+sto_ID+"' and prod_id ='"+proID+"' ";
//                        pst=conn.prepareStatement(sqll);
//                        pst.execute();
//                        pst=conn.prepareStatement(sqlll);
//                        pst.execute();
//                        
//                        }
                        
                        pst=conn.prepareStatement(sql);
                        pst.execute();
                        
                        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                        if(jTable1.getSelectedRow()==-1){
                            if(jTable1.getSelectedRowCount()==0){
                                JOptionPane.showConfirmDialog(null, "Table is empty");
                            }else{
                                JOptionPane.showConfirmDialog(null, "You must select a row");
                            }
                        }else{
                            
                            
                             //   model.setValueAt(supID,jTable1.getSelectedRow(),0);
                                model.setValueAt(supID,jTable1.getSelectedRow(),0);
                                model.setValueAt(sto_ID,jTable1.getSelectedRow(),1);
                                model.setValueAt(exdate,jTable1.getSelectedRow(),2);
                                model.setValueAt(jTextField8.getText(),jTable1.getSelectedRow(),3);
                                model.setValueAt(jComboBox7.getSelectedItem().toString(),jTable1.getSelectedRow(),4);
                                model.setValueAt(jTextField9.getText(),jTable1.getSelectedRow(),5);
                              //  model.setValueAt(jComboBox5.getSelectedItem().toString(),jTable1.getSelectedRow(),6);
                                model.setValueAt(jLabel19.getText(),jTable1.getSelectedRow(),6);
                                model.setValueAt(jTextField3.getText(),jTable1.getSelectedRow(),7);
            
                                JOptionPane.showMessageDialog(null, "Record updated successfully!");
                            
                        }
                   
                    }
                    
                                        
                                jTextField8.setText(null);
                               // jComboBox6.setSelectedItem("SELECT SUPPLIER ID");
                               jLabel27.setText(null);
                                jComboBox7.setSelectedItem("SELECT PRODUCT ID");
                                jComboBox8.setSelectedItem("SELECT STOCK ID");
                                jDateChooser2.setDate(null);
                                jTextField9.setText(null);
                             //   jComboBox5.setSelectedItem("UNIT PRICE");
                                 jLabel19.setText(null);
                                jTextField3.setText(null);
                
                
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Record Not Updated!");
                
            }
  
        }
 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
          //print
 
        MessageFormat header = new MessageFormat("DAMAGE SUPPLIER GOOD DETAILS");
        MessageFormat footer = new MessageFormat("page{0,number,integer} ");

            try {
                jTable3.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            } catch (PrinterException ex) {
                Logger.getLogger(dsupp.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
     
        tableload();
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
        
        
        double AMOUNT,QTY,UNIT_PRICE;
        QTY = Double.parseDouble(jTextField1.getText());
        UNIT_PRICE = Double.parseDouble(jLabel10.getText());
      //UNIT_PRICE = Double.parseDouble((String) jComboBox3.getSelectedItem());
        AMOUNT = QTY * UNIT_PRICE;
        jTextField1.setText(Double.toString(QTY));
        jLabel10.setText(Double.toString(UNIT_PRICE));
//      jComboBox3.setSelectedItem(UNIT_PRICE);
        jTextField2.setText(Double.toString(AMOUNT));
        
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        // TODO add your handling code here:
        
        double AMOUNT,QTY,UNIT_PRICE;
        QTY = Double.parseDouble(jTextField9.getText());
        //UNIT_PRICE = Double.parseDouble((String) jComboBox5.getSelectedItem());
         UNIT_PRICE = Double.parseDouble(jLabel19.getText());
        AMOUNT = QTY * UNIT_PRICE;
        jTextField9.setText(Double.toString(QTY));
      //  jComboBox5.setSelectedItem(UNIT_PRICE);
        jLabel19.setText(Double.toString(UNIT_PRICE));
        jTextField3.setText(Double.toString(AMOUNT));
        
        
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
            
            // TODO add your handling code here:
            
            fillcombo3();
            
    }//GEN-LAST:event_jComboBox2MouseEntered

    private void jComboBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseEntered
        // TODO add your handling code here:
        
        fillcombo1();
        
    }//GEN-LAST:event_jComboBox4MouseEntered

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        
//        DBconnecter db =new DBconnecter();
//        DamageSup dm =new DamageSup();
//        ArrayList<stockD>list = dm.getData((String) jComboBox4.getSelectedItem().toString());
//        for(int i =0;i<list.size();i++){
//        
//            try {
//                jComboBox4.addItem(rs.getString(1));
//            } catch (SQLException ex) {
//                Logger.getLogger(dsupp.class.getName()).log(Level.SEVERE, null, ex);
//            }
        
   //     }
        
        
        
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        // TODO add your handling code here:
        
        String s=jComboBox4.getSelectedItem().toString();
        
        String sql="select prod_id from stock where stoc_id='"+ s +"' ";
            try {
                
               PreparedStatement pst = conn.prepareStatement(sql);
               ResultSet rs = pst.executeQuery();
               
                while(rs.next()){
                
                jComboBox2.setSelectedItem(rs.getString("prod_id"));
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(dsupp.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        
        
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
       
//      String s = jLabel27.getText();
//      String sql= " select supp__name from supplier where supp_id = '"+s +"' ";
        
    }//GEN-LAST:event_jTextField6MouseClicked

    public void showtable(){
            ArrayList<table_1> list=tablelist();
            DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
            model.setColumnIdentifiers(new Object[]{"dmgs_id","dmgst_id","dmgs_date","dmgs_des","dmgspr_id","dmgs_qty","dmgs_unit","dmgs_tot"});
            Object[] row=new Object[8];
            
            for(int i=0;i<list.size();i++){
                
                row[0]=list.get(i).getDS_ID();
                row[1]=list.get(i).getST_ID();
                row[2]=list.get(i).getS_DATE();
                row[3]=list.get(i).getS_DES();
                row[4]=list.get(i).getSPR_ID();
                row[5]=list.get(i).getS_QTY();
                row[6]=list.get(i).getS_UNITPRICE();
                row[7]=list.get(i).getS_AMOUNT();
                
                model.addRow(row);
                
            }
            jTable1.setModel(model);
            
         
        }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMessage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
