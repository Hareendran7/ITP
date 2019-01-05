/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;



import code.DBconnect;
import code.SendMail;
import code.reorder_1;
import code.validate_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Properties;
import javax.swing.JOptionPane;

public class reorder extends javax.swing.JPanel {

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs = null;
        
    public String reorder_id;
    /**
     * Creates new form reorder
     */
    public reorder() {
        initComponents();
        
        con = DBconnect.connect();
        
        tableload();
        
        fillProductCombo();
        
        fillEmailSupplierCombo();
        
        product_name.disable();
        pro_size.disable();
        status.disable();
        quantity.disable();
        
    }

    public void tableload(){
        
        try{
        String sql = "SELECT reor_id as 'Reorder ID',prod_id as 'Product ID',prod_name as 'Product Name',size_1 as 'Size',supp_id as 'Supplier ID',comp_name as 'Supplier',quantity as 'Quantity',reor_date as Date,status as 'Status'  FROM reorder";
        pst = con.prepareStatement(sql);
        rs =pst.executeQuery(sql);
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
    }
    }
    
    public void genReorderID()
           {
        try{
            String qry="SELECT reor_id FROM reorder ORDER BY reor_id DESC LIMIT 1";
            pst=con.prepareStatement(qry);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String r1=rs.getString("reor_id");
                int ln=r1.length();
                String stxt=r1.substring(0,3);
                String snum=r1.substring(3,ln);
                int n=Integer.parseInt(snum);
                n++;
                snum=Integer.toString(n);
                
             reorder_id=stxt+snum;
                
            }
            else
            {
             reorder_id= "reo123";
            }
            }
        
        catch(Exception e){
    
        JOptionPane.showMessageDialog(null,e);
    }
        
    }
      
    
   public void fillProductCombo()
    {
        try
        {
            String sql="select distinct prod_name from product";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                String comboitems=rs.getString("prod_name");
                product_name.addItem(comboitems);
            }
        }
        catch(Exception e)
        {
            
        }
        
       
    }   
   
   public void fillProductIDCombo()
     {
         
        String name=product_name.getSelectedItem().toString();
        String size1=pro_size.getSelectedItem().toString();
         try
         {
             String sql="select prod_id from product where prod_name='"+name+"' and size_1='"+size1+"' ";
            
             pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next())
            {
                String add1=rs.getString("prod_id");
                product_id_label.setText(add1);

            }
         }
         
         catch(Exception e)
        {
            
        }
     }
   
    public void fillSupplierCombo()
    {
        try
        {
            String prod_name=product_name.getSelectedItem().toString();
            String sql="select distinct comp_name from product where prod_name='"+prod_name+"' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                String comboitems=rs.getString("comp_name");
                supplier_name.setText(comboitems);
            }
        }
        catch(Exception e)
        {
            
        }
        
       
    }
    
    public void fillSupplierIDCombo()
     {
         String name=supplier_name.getText();
         try
         {
             String sql="select supp_id from supplier where comp_name='"+name+"' ";
             pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next())
            {
                String add1=rs.getString("supp_id");
                supplier_id_label.setText(add1);

            }
         }
         
         catch(Exception e)
        {
            
        }
     }
    
    public void fillSizeCombo()
    {
        
        
        try
        {
            pro_size.removeAllItems();
            String name=product_name.getSelectedItem().toString();
            String sql="select distinct size_1 from product where prod_name='"+name+"' ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                String comboitems=rs.getString("size_1");
                pro_size.addItem(comboitems);
            }
        }
        catch(Exception e)
        {
            
        }
        
       
    }
       
    public void fillEmailSupplierCombo()
    {
        try
        {
           
            String sql="select distinct comp_name from supplier ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                String comboitems=rs.getString("comp_name");
                mail_supplier.addItem(comboitems);
            }
        }
        catch(Exception e)
        {
            
        }
        
       
    }
 
     public void fillEmailAddress()
     {
         String name=mail_supplier.getSelectedItem().toString();
         
         try
         {
             String sql="select supp_mail from supplier where comp_name='"+name+"' ";
             pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next())
            {
                String add1=rs.getString("supp_mail");
                receiver_mail.setText(add1);

            }
         }
         
         catch(Exception e)
        {
            
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        product_name = new javax.swing.JComboBox<>();
        pro_size = new javax.swing.JComboBox<>();
        product_id_label = new javax.swing.JLabel();
        supplier_id_label = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        reorder_ID_label = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        supplier_name = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        mail_supplier = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        receiver_mail = new javax.swing.JLabel();
        subject = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        reorder_date = new com.toedter.calendar.JDateChooser();
        quantity_label = new javax.swing.JLabel();
        product_name_label = new javax.swing.JLabel();
        size_label = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit-validated-icon (1).png"))); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product ID");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Name");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Size");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Supplier ID");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Supplier Name");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Processed");

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Actions-edit-undo-icon.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Reorder");

        quantity.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        status.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unprocessed", "Processed" }));

        product_name.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        product_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        product_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                product_nameItemStateChanged(evt);
            }
        });
        product_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_nameMouseEntered(evt);
            }
        });
        product_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_nameActionPerformed(evt);
            }
        });

        pro_size.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        pro_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        pro_size.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pro_sizeMouseEntered(evt);
            }
        });

        product_id_label.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        product_id_label.setForeground(new java.awt.Color(255, 255, 255));

        supplier_id_label.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        supplier_id_label.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reorder ID");

        reorder_ID_label.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        reorder_ID_label.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new-file-icon.png"))); // NOI18N
        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        supplier_name.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        supplier_name.setForeground(new java.awt.Color(255, 255, 255));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Email-icon.png"))); // NOI18N
        jButton4.setText("Send Email");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Supplier");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Email Address");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Description");

        mail_supplier.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        mail_supplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        mail_supplier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mail_supplierItemStateChanged(evt);
            }
        });
        mail_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mail_supplierMouseEntered(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Subject");

        receiver_mail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        receiver_mail.setForeground(new java.awt.Color(255, 255, 255));

        subject.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        desc.setColumns(20);
        desc.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        desc.setRows(5);
        jScrollPane2.setViewportView(desc);

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setToolTipText("");
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator1.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Date");

        reorder_date.setDateFormatString("yyyy-M-d");

        quantity_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        quantity_label.setForeground(new java.awt.Color(255, 0, 0));

        product_name_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        product_name_label.setForeground(new java.awt.Color(255, 0, 0));

        size_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        size_label.setForeground(new java.awt.Color(255, 0, 0));

        date_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        date_label.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(reorder_ID_label, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(product_id_label, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(supplier_id_label, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(supplier_name, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(product_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(pro_size, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(size_label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(quantity_label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(reorder_date, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(date_label, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(mail_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(receiver_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(reorder_ID_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(product_id_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplier_id_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplier_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(product_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pro_size, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(size_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reorder_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(mail_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(receiver_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        boolean quantity2;
        int count=0;
        
        validate_1 v4=new validate_1();
        quantity2=v4.numcheck(quantity.getText());
        
        int a=product_name.getSelectedItem().toString().compareTo("Select");
        if(a==1)
        {
            product_name_label.setText("*Select a Product");
            count++;
        }
        
        int b=pro_size.getSelectedItem().toString().compareTo("Select");
        if(a==1)
        {
            size_label.setText("*Select a Size");
            count++;
        }
        
        if(quantity2==false)
        {
              quantity_label.setText("*Insert only Numerics");
              count++;
        }
        
        if(reorder_date.getDate()== null)
         {
              date_label.setText("*Select a Date");
              count++;
         }
        
        if (count==0)
        {
        reorder_1 c1=new reorder_1(); 
       
        c1.setReorderID(reorder_ID_label.getText());
        c1.setProductID(product_id_label.getText());
        c1.setProductName(product_name.getSelectedItem().toString());
        c1.setSize(pro_size.getSelectedItem().toString());
        c1.setSupplierID(supplier_id_label.getText());
        c1.setSupplierName(supplier_name.getText());
        c1.setQuantity(Integer.parseInt(quantity.getText().trim()));
        c1.setReorderDate(reorder_date.getDate());
        c1.setStatus(status.getSelectedItem().toString());
       
        c1.storeDB();
        tableload();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        product_name.enable();
        pro_size.enable();
        status.enable();
        quantity.enable();
        
       
       
        reorder_ID_label.setText("");
        product_id_label.setText("");
        supplier_id_label.setText("");
        supplier_name.setText("");
      //product_name.setSelectedIndex(0);
       //pro_size.setSelectedIndex(0);
        quantity.setText("");
        reorder_date.setDate(null);
       //status.setSelectedIndex(0);
       
        product_name_label.setText("");
        quantity_label.setText("");
        size_label.setText("");
        date_label.setText("");
        
        genReorderID();
        reorder_ID_label.setText(reorder_id);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pro_sizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro_sizeMouseEntered
        
         fillProductIDCombo();
    }//GEN-LAST:event_pro_sizeMouseEntered

    private void product_nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_nameMouseEntered
      
      //  fillSizeCombo();
      //  fillSupplierCombo();
       // fillSupplierIDCombo();
        
        
       
    }//GEN-LAST:event_product_nameMouseEntered

    private void product_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_nameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
               
        String to = receiver_mail.getText();
        String subject1 = subject.getText();
        String message =  desc.getText();
                
                String user = "hareendran.shree@my.sliit.lk";
                String pass = "niroosan#12";

                SendMail s1=new SendMail();
                s1.send(to,subject1, message, user, pass);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void mail_supplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mail_supplierMouseEntered
       
        
    }//GEN-LAST:event_mail_supplierMouseEntered

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        status.enable();
        
        int r = jTable1.getSelectedRow();

        String reorder_id = jTable1.getValueAt(r ,0).toString();
        String product_id=jTable1.getValueAt(r,1).toString();
        String product_name1 = jTable1.getValueAt(r ,2).toString();
        String size_1 = jTable1.getValueAt(r ,3).toString();
        String supplier_id = jTable1.getValueAt(r ,4).toString();
        String supplier_name1=jTable1.getValueAt(r,5).toString();
        String quantity1=jTable1.getValueAt(r ,6).toString();
        Date date1=(Date) jTable1.getValueAt(r ,7);
        String status1 = jTable1.getValueAt(r ,8).toString();
        
        
        reorder_ID_label.setText(reorder_id);
        product_id_label.setText(product_id);
        supplier_id_label.setText(supplier_id );
        supplier_name.setText(supplier_name1);
        product_name.setSelectedItem(product_name1);
        pro_size.setSelectedItem(size_1);
        quantity.setText(quantity1);
        reorder_date.setDate(date1);
        status.setSelectedItem(status1);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String value1=reorder_ID_label.getText();
        String value2=status.getSelectedItem().toString();
         
        try{
            
        
        String sql="update reorder set status='"+value2 +"' where reor_id='"+value1+"' ";
        
        pst=con.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Updated");
        
         }catch(Exception e){

            JOptionPane.showMessageDialog(null,e);

        }

        tableload();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void product_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_product_nameItemStateChanged
        fillSizeCombo();
        fillSupplierCombo();
        fillSupplierIDCombo();
        
    }//GEN-LAST:event_product_nameItemStateChanged

    private void mail_supplierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mail_supplierItemStateChanged
       
         fillEmailAddress();
    }//GEN-LAST:event_mail_supplierItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date_label;
    private javax.swing.JTextArea desc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> mail_supplier;
    private javax.swing.JComboBox<String> pro_size;
    private javax.swing.JLabel product_id_label;
    private javax.swing.JComboBox<String> product_name;
    private javax.swing.JLabel product_name_label;
    private javax.swing.JTextField quantity;
    private javax.swing.JLabel quantity_label;
    private javax.swing.JLabel receiver_mail;
    private javax.swing.JLabel reorder_ID_label;
    private com.toedter.calendar.JDateChooser reorder_date;
    private javax.swing.JLabel size_label;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField subject;
    private javax.swing.JLabel supplier_id_label;
    private javax.swing.JLabel supplier_name;
    // End of variables declaration//GEN-END:variables
}
