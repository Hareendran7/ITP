
package warehouse;


import Class.DBconnecter;
import classs.dmgret;
import classs.table;
import classs.validate;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
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
import javax.swing.text.Document;
import net.proteanit.sql.DbUtils;
//import net.proteanit.sql.DbUtils;

/**
 *
 * @author it16112810
 */
public class dret extends javax.swing.JPanel {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        DateFormat df = DateFormat.getDateInstance();
  
    public dret() throws SQLException {
        initComponents();
          conn =  DBconnecter.connect();
          fillcombo1();
       //   fillcombo2();
       //   fillcombo3();
          fillcombo6();
          showtable();
    }
    
    
    
    
     private void fillcombo1(){
    
//        try {
//            String sql = "SELECT DISTINCT ord_id, prod_id FROM order_1";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            
//            while(rs.next())
//            {
////                String Su_ID = rs.getString("ord_id");
////                jComboBox4.addItem(Su_ID);
//                String Suu_ID = rs.getString("ord_id");
//                jComboBox8.addItem(Suu_ID);
////                String UN_Pr = rs.getString("prod_id");
////                jComboBox2.addItem(UN_Pr);
//                String UNN_Pr = rs.getString("prod_id");
//                jComboBox6.addItem(UNN_Pr);
//                
//                
//                
//            }
//            
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
    
    
// private void fillcombo2() throws SQLException{
//    
//     String codee = jComboBox4.getSelectedItem().toString();
//     
//     String sql = "SELECT ret_id FROM order_1 where ord_id='"+codee+"'";
//     pst = conn.prepareStatement(sql);
//     rs = pst.executeQuery();
//     
//     while(rs.next())
//     {
//
//          String UNN_PR=rs.getString("ret_id");
//          jLabel37.setText(UNN_PR);
//          String UNNN_PR=rs.getString("ret_id");
//          jLabel38.setText(UNNN_PR);
//                  
//     }
//    }
    
private void fillcombo3(){
    
//        try {
//            String sql = "SELECT prod_id FROM product";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            
//            while(rs.next())
//            {
//                String UN_Pr = rs.getString("prod_id");
//                jComboBox2.addItem(UN_Pr);
//                String UNN_Pr = rs.getString("prod_id");
//                jComboBox6.addItem(UNN_Pr);
//            }
//            
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

private void fillcombo4(){
    
//        try {
//            
//             String codee = jComboBox2.getSelectedItem().toString();
//             String sql = "SELECT sell_price FROM product where prod_id ='"+codee+"'";
//          //  String sql = "SELECT * FROM product";
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            
//            while(rs.next())
//            {
////                String ST_Pr = rs.getString("sell_price");
////                jComboBox3.addItem(ST_Pr);
////                String STT_Pr = rs.getString("sell_price");
////                jComboBox7.addItem(STT_Pr);
////                  
//                   String UNN_PR=rs.getString("sell_price");
//                   jLabel35.setText(UNN_PR);
//                   String UNNN_PR=rs.getString("sell_price");
//                   jLabel39.setText(UNNN_PR);
//            }
//            
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
   }


    
private void fillcombo6(){
    
               try {
                   
         String sql = "SELECT DISTINCT ord_id FROM order_1 ";
         // String sql = "SELECT ord_id FROM order_1 ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {

                String ST_Pr = rs.getString("ord_id");
                jComboBox1.addItem(ST_Pr);
   
            }
   
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void fillcombo8(){
    
                try {
              
              String codee = jLabel38.getText();
              String sql = "SELECT ret_name FROM retailer where ret_id = '"+codee+"' "; 
         
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {

                String QQ = rs.getString("ret_name");
                jTextField9.setText(QQ);
   
            }      


          } catch (Exception e) {
            System.out.println(e);
        }
    }
      
    
      public ArrayList<table>tablelist(){
         ArrayList<table> tablelist= new ArrayList<>();
         try{
             String sql="SELECT dmgr_id,dmgro_id,dmgr_date,dmgr_des,dmgrpr_id,dmgr_qty,dmgr_unit,dmgr_tot FROM dmgret ";
             pst=conn.prepareStatement(sql);
             rs= pst.executeQuery();


            while(rs.next()){
                table tb=new table(rs.getString("dmgr_id"),rs.getString("dmgro_id"),rs.getString("dmgr_date"),rs.getString("dmgr_des"),rs.getString("dmgrpr_id"),rs.getString("dmgr_qty"),rs.getString("dmgr_unit"),rs.getString("dmgr_tot"));
                tablelist.add(tb);

            }

         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);

         }
         return tablelist;
     }
      
       public void tableload()
         {
         
    
              String PID = jComboBox1.getSelectedItem().toString();
             try{
            String sq= "SELECT s.prod_id AS PRODUCTID,s.ret_id AS RETAILERID,s.qty AS QTY,p.sell_price AS SELLPRICE,s.ord_date AS OREDERDATE,s.total AS TOTAL FROM order_1 s,product p where s.ord_id ='"+PID+"' and s.prod_id = p.prod_id and status = 'delivered' ";

             pst=conn.prepareStatement(sq);
             rs= pst.executeQuery();
             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         
             jLabel40.setText(PID);  
             
             
             
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
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        IMessage = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jTextField12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        iMessage1 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        jLabel41.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));

        jLabel43.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));

        jLabel46.setText("jLabel46");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(856, 550));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Search");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PR_ID", "QTY", "UNIT_PR"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order ID");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jComboBox1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        IMessage.setBackground(new java.awt.Color(0, 0, 0));
        IMessage.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        IMessage.setForeground(new java.awt.Color(255, 255, 255));

        jButton12.setBackground(new java.awt.Color(51, 51, 51));
        jButton12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-file-icon.png"))); // NOI18N
        jButton12.setText("Insert");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(51, 51, 51));
        jButton13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-undo-icon.png"))); // NOI18N
        jButton13.setText("Reset");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product ID");

        jLabel32.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));

        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Unit Price");

        jLabel33.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Order ID");

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Total");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer ID");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Description");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date");

        jLabel35.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));

        jLabel37.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));

        jLabel40.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));

        jLabel42.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));

        jLabel45.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));

        jLabel49.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(62, 62, 62)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel24)
                    .addComponent(jLabel4))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(230, 230, 230)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(436, 436, 436)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel36))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(199, 199, 199)))
        );

        jLabel44.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(323, 323, 323)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(449, 449, 449)
                                .addComponent(jButton12)
                                .addGap(24, 24, 24)
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8))
                            .addComponent(IMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(739, 739, 739)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(740, 740, 740)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12)
                            .addComponent(jButton13))
                        .addContainerGap(42, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(251, 251, 251)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(252, 252, 252)))
        );

        jTabbedPane1.addTab("Retailer", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Unit Price");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Date");

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Quantity");

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Description");

        jTextField14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField14MouseEntered(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Customer ID");

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Product ID");

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Order ID");

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Amount");

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));

        jLabel29.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));

        jLabel31.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));

        jLabel34.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 0));

        jLabel38.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));

        jLabel47.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));

        jLabel48.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));

        jLayeredPane2.setLayer(jTextField12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(iMessage1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jDateChooser2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel28, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel29, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel31, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel34, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel38, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel39, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel47, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel48, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(48, 48, 48)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel31)
                                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                                    .addGap(88, 88, 88)))
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel18)
                            .addComponent(jLabel14)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField12)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(89, 89, 89))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(iMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DAMAGE_NO", "INVOICE NO", "C_ID", "PR_ID", "QTY", "UNIT_PR", "DATE_", "TOTAL"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-delete-icon.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-undo-icon.png"))); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Submit");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(24, 24, 24)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jTabbedPane1.addTab("Edit", jPanel2);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Total Amount");

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Total Qty");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Reatiler Name");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REFUND INVOICE");

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Total Products");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable4.setBackground(new java.awt.Color(51, 51, 51));
        jTable4.setForeground(new java.awt.Color(255, 255, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RETAILER ID", "ORDER NO", "DATE", "DESCRIPTION", "PRODUCT ID", "QTY", "UNIT PRICE", "TOTAL"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-edit-undo-icon.png"))); // NOI18N
        jButton8.setText("Reset");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Print");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(51, 51, 51));
        jButton20.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Calculate");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton20)
                        .addGap(24, 24, 24)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton8)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Refund", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        
//          DefaultTableModel model=(DefaultTableModel)jTable4.getModel();
//            int r = jTable4.getSelectedRow();
//            String D_ID = jTable4.getValueAt(r, 0).toString();
//            jTextField9.setText(D_ID);
        
        
        
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:

       fillcombo8();
         
        int sum =0;
        for(int i=0;i<jTable4.getRowCount();i++)
        {

            sum=sum + Integer.parseInt(jTable4.getValueAt(i,7).toString());
        }

        jTextField8.setText(Integer.toString(sum));

        int count =0;
        for(int i=0;i<jTable4.getRowCount();i++)
        {

            count =count+1;

        }

        jTextField10.setText(Integer.toString(count));

        int summ =0;
        for(int i=0;i<jTable4.getRowCount();i++)
        {

            summ=summ + Integer.parseInt(jTable4.getValueAt(i,5).toString());
        }

        jTextField11.setText(Integer.toString(summ));

        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        //ADD SELECTED ROWS to another table

        TableModel modell = jTable2.getModel();
        int[]indexs = jTable2.getSelectedRows();

        Object[] row = new Object[8];

        DefaultTableModel mode12 = ( DefaultTableModel)jTable4.getModel();

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
        JOptionPane.showMessageDialog(null, "ADDED TO RETURN GOODS");

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        //RESET

        jTextField15.setText("  ");
        jLabel38.setText("  ");
        jDateChooser2.setDate(null);
        jTextField12.setText("  ");
        jLabel39.setText("  ");
        jLabel48.setText("  ");
        jLabel47.setText("  ");
        jTextField14.setText("  ");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int x= JOptionPane.showConfirmDialog(null,"Do you want to delete it?");
        if(x==0){

            String D_ID= jLabel48.getText();
            String DP_ID=jLabel47.getText();
            String S_QTY=jTextField12.getText();
            String S_AMOUNT=jTextField14.getText();

            String sql = "DELETE from dmgret WHERE dmgro_id ='"+D_ID+"' and dmgrpr_id = '"+DP_ID+"' " ;
            String sqlll=" UPDATE order_details SET upd_total = upd_total + '"+S_AMOUNT+"' WHERE ord_id='"+D_ID+"'  ";
            
        
            try{
                pst=conn.prepareStatement(sql);
                pst.execute();

                  pst=conn.prepareStatement(sqlll);
                   pst.execute();
                   
                   
                    String sqpppl=" UPDATE order_details SET status=' null ' WHERE ord_id  ='"+D_ID+"' ";
                   
                pst=conn.prepareStatement(sqpppl);
                pst.execute();

                Statement ST;
                ST = conn.createStatement();

                    DefaultTableModel model =(DefaultTableModel) jTable2.getModel();
                    model.setRowCount(0);
                    JOptionPane.showMessageDialog(null, "Deleted");
                    showtable();

            }catch(Exception e){
                System.out.println(e);

            }
        }
                                jTextField15.setText(null);
                                jTextField14.setText(null);
                                jLabel38.setText(null);
                                jLabel47.setText(null);
                                jLabel48.setText(null);
                                jDateChooser2.setDate(null);
                                jTextField12.setText(null);
                                jLabel39.setText(null);
                                jTextField14.setText(null);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        //ROW WISE

        
    try {
        
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        int r = jTable2.getSelectedRow();

        String RD_ID = jTable2.getValueAt(r, 0).toString();
        String RS_ID = jTable2.getValueAt(r, 1).toString();
        Date Rdate =new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(r, 2).toString());
        String Rdes  = jTable2.getValueAt(r, 3).toString();
        String RP_ID = jTable2.getValueAt(r, 4).toString();
        String RQTY  = jTable2.getValueAt(r, 5).toString();
        String RUNIT_PRICE = jTable2.getValueAt(r,6).toString();
        String RAMOUNT = jTable2.getValueAt(r, 7).toString();
        

        jLabel38.setText(RD_ID);
        jLabel48.setText(RS_ID);
        jDateChooser2.setDate(Rdate);
        jTextField15.setText(Rdes);
        jLabel47.setText(RP_ID);
        jTextField12.setText(RQTY);
        jLabel39.setText(RUNIT_PRICE);
        jTextField14.setText(RAMOUNT);

        double QTYQ = Double.parseDouble(RQTY);

        if(QTYQ>=1000)
        {
            jTextField12.setBackground(Color.RED);
            jTextField12.setForeground(Color.BLACK);

        }

        else{

            jTextField12.setBackground(Color.BLUE);
            jTextField12.setForeground(Color.BLACK);

        }
    }
   catch (ParseException ex) {
                System.out.println(ex);
            }
       
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
           DefaultTableModel mode =(DefaultTableModel)jTable4.getModel();
            while (mode.getRowCount()>0){
            for(int i=0;i<mode.getRowCount();i++)
            {
                mode.removeRow(i);
            }

        }
            
            
        jTextField9.setText("  ");
        jTextField10.setText("  ");
        jTextField8.setText("  ");
        jTextField11.setText("  ");
        
            
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       
         

        
//StringBuilder builder = new StringBuilder();
//builder.append("Product: ");
//builder.append(jTextField9.getText());
//builder.append(System.getProperty("line.separator"));
//builder.append("Job: ");
//builder.append(jTextField8.getText());
//builder.append(System.getProperty("line.separator"));
////builder.append("Task: ");
////builder.append(task.getTaskID();
//

//MessageFormat header = new MessageFormat(builder.toString());
//
//           


        MessageFormat header = new MessageFormat(" Retailer Name  :  "+jTextField9.getText()+" ");
//        MessageFormat footer = new MessageFormat("page{0,number,integer} ");
       MessageFormat footer = new MessageFormat(" Total Amount   :  "+jTextField8.getText()+" ");

            try {
                jTable4.print(JTable.PrintMode.FIT_WIDTH, header, footer);

            } catch (PrinterException ex) {
                Logger.getLogger(dret.class.getName()).log(Level.SEVERE, null, ex);
            }



//
//PrinterJob job = PrinterJob.getPrinterJob();
//
//MessageFormat[] header = new MessageFormat[6];
// 
//header[0] = new MessageFormat("");
//header[1] = new MessageFormat(jTextField9.getText());
//header[2] = new MessageFormat(jTextField8.getText());
//header[3] = new MessageFormat("Scrud 60 - Grade Returns - Random Sample");
//header[4] = new MessageFormat("");
//
//MessageFormat[] footer = new MessageFormat[4];
// 
//footer[0] = new MessageFormat("Assistant Examiner Signature:______________  Date:___ /___ /_____ ");
//footer[1] = new MessageFormat("");
//footer[2] = new MessageFormat("");
//footer[3] = new MessageFormat("Advising  Examiner Signature:______________  Date:___ /___ /_____ ");
//
//job.setPrintable(new PrintTableMultiLine(jTable4, JTable.PrintMode.FIT_WIDTH, header, footer ));

//job.setPrintable(jTable4, JTable.PrintMode.FIT_WIDTH, header, footer );
//jTable4.print(JTable.PrintMode.FIT_WIDTH, header, footer);

       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        //update
        
      validate valid=new validate();
      valid.isBlank(jTextField15.getText(),jLabel34);
      boolean bool= valid.doublecheck(jTextField12.getText());
      if(bool==true){
         jLabel28.setText("Please Enter QTY");
        }
      else{
         jLabel28.setText("");
        }
      valid.isBlank(jTextField14.getText(),jLabel29);
        
      int x =JOptionPane.showConfirmDialog(null, "Do you want to update?");
        
      if(x==0){
            
            String desc=jTextField15.getText();
            String supID=jLabel38.getText();
            SimpleDateFormat dateformat=new  SimpleDateFormat ("yyyy-MM-dd");
            String exdate=dateformat.format(jDateChooser2.getDate());
            String qty=jTextField12.getText();
            String uniPr=jLabel39.getText();
            String amnt=jTextField14.getText();
            String sto_ID=jLabel48.getText();
            String proID=jLabel47.getText();
            
 
            try{
            
                 String record = "SELECT * FROM dmgret WHERE dmgr_id='"+supID+"' AND dmgro_id='"+sto_ID+"' AND dmgr_date='"+exdate +"' AND dmgr_des='"+desc +"' AND dmgrpr_id ='"+proID+"' AND dmgr_qty='"+qty +"' AND dmgr_unit='"+uniPr+"' AND dmgr_tot='"+amnt+"' ";
                pst = conn.prepareStatement(record);
                ResultSet rs = pst.executeQuery();
                
                    if(rs.next()){
                        JOptionPane.showConfirmDialog(null, "Record already exists");
                    }
                    else{
                        String sql="UPDATE dmgret SET dmgr_id='"+supID+"',dmgro_id='"+sto_ID+"',dmgr_date='"+exdate +"',dmgr_des='"+desc +"',dmgrpr_id ='"+proID+"',dmgr_qty='"+qty +"',dmgr_unit='"+uniPr+"',dmgr_tot='"+amnt+"' where dmgro_id ='"+sto_ID+"' and dmgrpr_id = '"+proID+"' ";
                        
                        
                        double QTY , Amount ,qqty, amtt ,supstc,supamt;
                        QTY = Double.parseDouble(jTextField12.getText()); 
                        qqty = Double.parseDouble(jTextField14.getText());                        
                        dmgret a= new dmgret();
                        Amount=a.damagesumQuantity(rs, pst, conn,sto_ID);                      
                        dmgret b=new dmgret();
                        amtt=b.damagesumAmount(rs, pst, conn, sto_ID);
                        
                        if (QTY>Amount){
                            
                            supstc=QTY-Amount;
                            supamt=qqty-amtt;
                                         
                       
                        String sqllll=" UPDATE order_details SET upd_total = upd_total  - '"+supamt+"'  WHERE ord_id  ='"+sto_ID+"' ";
                        
                        pst=conn.prepareStatement(sqllll);
                        pst.execute();
                        }
                      
                        else
                            
                        {
                            
                            supstc=Amount-QTY;
                            supamt=amtt-qqty;
                            
 
                        String sqpp=" UPDATE order_details SET upd_total  = upd_total  + '"+supamt+"' WHERE ord_id  ='"+sto_ID+"' ";
                        
                        pst=conn.prepareStatement(sqpp);
                        pst.execute();
                        
                        }
         
                        pst=conn.prepareStatement(sql);
                        pst.execute();
                        
                        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
                        
                        if(jTable2.getSelectedRow()==-1){
                            if(jTable2.getSelectedRowCount()==0){
                                JOptionPane.showConfirmDialog(null, "Table is empty");
                            }else{
                                JOptionPane.showConfirmDialog(null, "You must select a row");
                            }
                        }else{
                                model.setValueAt(jLabel38.getText(),jTable2.getSelectedRow(),0);
                                model.setValueAt(sto_ID,jTable2.getSelectedRow(),1);
                                model.setValueAt(exdate,jTable2.getSelectedRow(),2);
                                model.setValueAt(jTextField15.getText(),jTable2.getSelectedRow(),3);
                                model.setValueAt(proID,jTable2.getSelectedRow(),4);
                                model.setValueAt(jTextField12.getText(),jTable2.getSelectedRow(),5);
                                model.setValueAt(jLabel39.getText(),jTable2.getSelectedRow(),6);
                                model.setValueAt(jTextField14.getText(),jTable2.getSelectedRow(),7);
            
                        String sqppp=" UPDATE order_details SET status='Deducted' WHERE ord_id  ='"+sto_ID+"' ";
                        pst=conn.prepareStatement(sqppp);
                        pst.execute();
                                
                                
                                JOptionPane.showMessageDialog(null, "Record updated successfully!");
                            
                        }
                        
                   
                    }
                    
                                jTextField15.setText(null);      
                                jTextField14.setText(null);
                                jLabel38.setText(null);
                                jLabel47.setText(null);
                                jLabel48.setText(null);
                                jDateChooser2.setDate(null);
                                jTextField12.setText(null);
                                jLabel39.setText(null);
                                jTextField14.setText(null);
                
                
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Record Not Updated!");
      } 
        }
      else{
       JOptionPane.showMessageDialog(null, "Select a Row !");}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField14MouseClicked
        // TODO add your handling code here:
  
        double AMOUNT,QTY,UNIT_PRICE;
        QTY = Double.parseDouble(jTextField12.getText());
        UNIT_PRICE  = Double.parseDouble(jLabel39.getText());
        AMOUNT = QTY * UNIT_PRICE;
        jTextField12.setText(Double.toString(QTY));
        jLabel39.setText(Double.toString(UNIT_PRICE));
        jTextField14.setText(Double.toString(AMOUNT)); 
    }//GEN-LAST:event_jTextField14MouseClicked

    private void jTextField14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14MouseEntered

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:

        jTextField5.setText("  ");
        jLabel37.setText("  ");
        jLabel40.setText("  ");
        jLabel45.setText("  ");
        jDateChooser1.setDate(null);
        jTextField2.setText("  ");
        jLabel35.setText("  ");
        jTextField3.setText("  ");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:

        //INSERT
      SimpleDateFormat dFormat = new SimpleDateFormat("YYYY-MM-dd");
         
         validate valid=new validate();
         valid.isBlank(jTextField5.getText(),jLabel12);
         boolean bool= valid.doublecheck(jTextField2.getText());
         if(bool==true){
         jLabel30.setText("Please Enter QTY");
          }
         else{
         jLabel30.setText("");
          }
       
        valid.isBlank(jTextField3.getText(),jLabel32);

        try{

           // SimpleDateFormat dFormat = new SimpleDateFormat("YYYY-MM-dd");

            String DR_ID = jLabel37.getText();
            String RO_ID = jLabel40.getText();
            String RPR_ID = jLabel45.getText();
            String R_DATE= dFormat.format(jDateChooser1.getDate());
            String R_DES=jTextField5.getText();
            String R_QTY=jTextField2.getText();
            String R_UNITPRICE=jLabel35.getText();
            String R_AMOUNT=jTextField3.getText();
  
            jLabel33.setText("");

            DefaultTableModel model =(DefaultTableModel)jTable2.getModel();       
       
            if(!jTextField2.getText().trim().equals("")){
                

        boolean booll;
        validate aa=new validate();
        booll=aa.currentDate(R_DATE);    
        if(booll==false){
        jLabel49.setText("Please Enter Current Date");
        }
        else{
        jLabel49.setText("");
        
       // }
                
                model.addRow(new Object[]{jLabel37.getText(),jLabel40.getText(),R_DATE,jTextField5.getText(),jLabel45.getText(),jTextField2.getText(),jLabel35.getText(),jTextField3.getText()});
                String sql="INSERT INTO dmgret(dmgr_id,dmgro_id,dmgr_date,dmgr_des,dmgrpr_id,dmgr_qty,dmgr_unit,dmgr_tot) VALUES('"+DR_ID+"','"+RO_ID+"','"+R_DATE+"','"+R_DES+"','"+RPR_ID+"','"+R_QTY+"','"+R_UNITPRICE+"','"+R_AMOUNT+"')";
                String sqll=" UPDATE order_details SET upd_total = upd_total - '"+R_AMOUNT+"' WHERE ord_id ='"+RO_ID+"' ";
                String sqpppl=" UPDATE order_details SET status='Deducted' WHERE ord_id  ='"+RO_ID+"' ";
                 
                pst=conn.prepareStatement(sqpppl);
                pst.execute();
                                
              
                pst=conn.prepareStatement(sql);
                pst.execute();
                pst=conn.prepareStatement(sqll);
                pst.execute();

                JOptionPane.showMessageDialog(null, " RECORD INSERTED ");
                
        }
          }
            else{

                jLabel33.setText(" * QTY SHOULD BE THERE OTHER WISE CANT GET THE AMOUNT");
            }

        }catch(Exception e){

            System.out.println(e);
            
        }
        
        
        jTextField5.setText("  ");
        jLabel37.setText("  ");
        jLabel40.setText("  ");
        jLabel45.setText("  ");
        jDateChooser1.setDate(null);
        jTextField2.setText("  ");
        jLabel35.setText("  ");
        jTextField3.setText("  ");
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        // TODO add your handling code here:

         try {
        
        double AMOUNT,QTY,UNIT_PRICE;
        QTY = Double.parseDouble(jTextField2.getText());
        UNIT_PRICE = Double.parseDouble(jLabel35.getText());
        AMOUNT = QTY * UNIT_PRICE;
        jTextField2.setText(Double.toString(QTY));
     //   jLabel35.setText(Double.toString(QTY));
        jTextField3.setText(Double.toString(AMOUNT));
        
         }
         
         catch(Exception e){
         
          JOptionPane.showMessageDialog(null, " Enter QTY First ! ");
         
         }
         
        
        
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        tableload();
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
        
        
        
                 
//    ////          String PID = jTextField1.getText();
//              String PID = jComboBox1.getSelectedItem().toString(); 
//              
//         
//             try{
//             
//         
//           // String sq= "SELECT s.prod_id,s.ret_id,s.qty,p.sell_price,s.ord_date,s.total FROM order_1 s,product p where s.ord_id ='"+PID+"' and s.prod_id = p.prod_id ";
//            String sq= "SELECT s.prod_id AS PRODUCTID,s.ret_id AS RETAILERID,s.qty AS QTY,p.sell_price AS SELLPRICE,s.ord_date AS OREDERDATE,s.total AS TOTAL FROM order_1 s,product p where s.ord_id ='"+PID+"' and s.prod_id = p.prod_id";
//           //  String sq= "SELECT s.prod_id,s.ret_id,s.qty,p.sell_uprice,s.ord_date,s.total FROM order_1 s,product p where s.ord_id ='"+PID+"'";
//             pst=conn.prepareStatement(sq);
//             rs= pst.executeQuery();
//             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//             
//             }
//             catch(Exception e){
//             
//             
//             }
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        
        
////         //          String PID = jTextField1.getText();
////              String PID = jComboBox1.getSelectedItem().toString(); 
////              
////         
////             try{
////             
////         
////            String sq= "SELECT s.prod_id,s.ret_id,s.qty,p.sell_price,s.ord_date,s.total FROM order_1 s,product p where s.ord_id ='"+PID+"' and s.prod_id = p.prod_id ";
////            String sq= "SELECT s.prod_id AS PRODUCTID,s.ret_id AS RETAILERID,s.qty AS QTY,p.sell_price AS SELLPRICE,s.ord_date AS OREDERDATE,s.total AS TOTAL FROM order_1 s,product p where s.ord_id ='"+PID+"' and s.prod_id = p.prod_id";
////             String sq= "SELECT s.prod_id,s.ret_id,s.qty,p.sell_uprice,s.ord_date,s.total FROM order_1 s,product p where s.ord_id ='"+PID+"'";
////             pst=conn.prepareStatement(sq);
////             rs= pst.executeQuery();
////             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
////             
////             }
////             catch(Exception e){
////             
////             
////             }
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        //ROW WISE 
        
            try {
        
          DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            
            int r = jTable1.getSelectedRow();

            String D_ID = jTable1.getValueAt(r, 0).toString();
            String S_ID = jTable1.getValueAt(r, 1).toString();
            String UNIT_PRICE = jTable1.getValueAt(r,3).toString();
            Date date =new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(r, 4).toString());
           
            jLabel37.setText(S_ID);
            jLabel45.setText(D_ID);
            jLabel35.setText(UNIT_PRICE);
            jDateChooser1.setDate(date);
            String PID = jComboBox1.getSelectedItem().toString();
            jLabel40.setText(PID); 
            

               } catch (ParseException ex) {
            System.out.println(ex);
        }
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    
    
     public void showtable(){
            ArrayList<table> list=tablelist();
            DefaultTableModel model =(DefaultTableModel) jTable2.getModel();
            model.setColumnIdentifiers(new Object[]{"dmgr_id","dmgro_id","dmgr_date","dmgr_des","dmgrpr_id","dmgr_qty","dmgr_unit","dmgr_tot"});
            Object[] row=new Object[8];
            
            for(int i=0;i<list.size();i++){
                
                row[0]=list.get(i).getDR_ID();
                row[1]=list.get(i).getRO_ID();
                row[2]=list.get(i).getR_DATE();
                row[3]=list.get(i).getR_DES();
                row[4]=list.get(i).getRPR_ID();
                row[5]=list.get(i).getR_QTY();
                row[6]=list.get(i).getR_UNITPRICE();
                row[7]=list.get(i).getR_AMOUNT();
                
                model.addRow(row);
                
            }
            jTable2.setModel(model);
            
         
        }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMessage;
    private javax.swing.JLabel iMessage1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
