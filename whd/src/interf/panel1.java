/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

import code.DBconnect;
import code.product_1;
import code.validate_1;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author HARIpc
 */
public class panel1 extends javax.swing.JPanel {

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs = null;
    /**
     * Creates new form add_product
     */
    
    public String prod_id="";
    
    public panel1() {
        initComponents();
        
        con = DBconnect.connect();
        
        fillSupplierCombo();
       
        product_name.disable();
        supplier_name.disable();
        size_1.disable();
        category.disable();
        supplier_id.disable();
        buy_price.disable();
        sell_price.disable();
        mrp.disable();
        quantity.disable();
        cont_size.disable();
        description.disable();
        reorder_level.disable();
       
        
    }

     
    public void fillSupplierCombo()
    {
        try
        {
            String sql="select comp_name from supplier";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                String comboitems=rs.getString("comp_name");
                supplier_name.addItem(comboitems);
            }
        }
        catch(Exception e)
        {
            
        }
        
       
    }
    
    public void fillSupplierIDCombo()
     {
         String name=supplier_name.getSelectedItem().toString();
         try
         {
             String sql="select supp_id from supplier where comp_name='"+name+"' ";
             pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next())
            {
                String add1=rs.getString("supp_id");
                supplier_id.setText(add1);

            }
         }
         
         catch(Exception e)
        {
            
        }
     }
    public void genProductID()
           {
        try{
            String qry="SELECT prod_id FROM product ORDER BY prod_id DESC LIMIT 1";
            pst=con.prepareStatement(qry);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String r1=rs.getString("prod_id");
                int ln=r1.length();
                String stxt=r1.substring(0,3);
                String snum=r1.substring(3,ln);
                int n=Integer.parseInt(snum);
                n++;
                snum=Integer.toString(n);
                
                 prod_id=stxt+snum;
                
            }
            else
            {
                prod_id= "pro123";
            }
            }
        
        catch(Exception e){
    
        JOptionPane.showMessageDialog(null,e);
    }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add_product = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        product_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buy_price = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        product_id_label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        size_1 = new javax.swing.JComboBox<>();
        supplier_name = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        sell_price = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        reorder_level = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        supplier_id = new javax.swing.JLabel();
        product_name_label = new javax.swing.JLabel();
        supplier_name_label = new javax.swing.JLabel();
        size_1_label = new javax.swing.JLabel();
        category_label = new javax.swing.JLabel();
        buy_price_label = new javax.swing.JLabel();
        sell_price_label = new javax.swing.JLabel();
        reorder_level_label = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        mrp = new javax.swing.JTextField();
        cont_size = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mrp_label = new javax.swing.JLabel();
        cont_size_label = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        quantity_label = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(867, 559));

        add_product.setBackground(new java.awt.Color(51, 51, 51));
        add_product.setToolTipText("");
        add_product.setPreferredSize(new java.awt.Dimension(867, 559));
        add_product.setLayout(null);

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new-file-icon.png"))); // NOI18N
        jButton3.setText("New");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add_product.add(jButton3);
        jButton3.setBounds(630, 210, 170, 40);

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit-validated-icon (1).png"))); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add_product.add(jButton2);
        jButton2.setBounds(630, 260, 170, 40);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Supplier ID");
        add_product.add(jLabel2);
        jLabel2.setBounds(40, 110, 80, 20);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Product Name");
        add_product.add(jLabel3);
        jLabel3.setBounds(40, 70, 120, 30);

        product_name.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        product_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_nameActionPerformed(evt);
            }
        });
        add_product.add(product_name);
        product_name.setBounds(190, 70, 230, 30);

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Supplier Name");
        add_product.add(jLabel9);
        jLabel9.setBounds(40, 140, 120, 30);

        description.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        add_product.add(description);
        description.setBounds(190, 500, 230, 30);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Description");
        add_product.add(jLabel6);
        jLabel6.setBounds(40, 500, 110, 30);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buying Price");
        add_product.add(jLabel5);
        jLabel5.setBounds(40, 260, 120, 30);

        buy_price.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        add_product.add(buy_price);
        buy_price.setBounds(190, 260, 230, 30);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product ID");
        add_product.add(jLabel1);
        jLabel1.setBounds(40, 40, 90, 30);

        product_id_label.setBackground(new java.awt.Color(255, 255, 255));
        product_id_label.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        product_id_label.setForeground(new java.awt.Color(255, 255, 255));
        add_product.add(product_id_label);
        product_id_label.setBounds(190, 40, 230, 30);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Add New Product");
        add_product.add(jLabel7);
        jLabel7.setBounds(340, 0, 250, 40);

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Size");
        add_product.add(jLabel10);
        jLabel10.setBounds(40, 180, 50, 30);

        size_1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        size_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ", "25ml", "50ml", "60ml", "100ml", "120ml", "200ml", "400ml", "20g", "40g" }));
        size_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                size_1ActionPerformed(evt);
            }
        });
        add_product.add(size_1);
        size_1.setBounds(190, 180, 230, 30);

        supplier_name.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        supplier_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select " }));
        supplier_name.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                supplier_nameItemStateChanged(evt);
            }
        });
        supplier_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplier_nameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplier_nameMouseEntered(evt);
            }
        });
        supplier_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplier_nameActionPerformed(evt);
            }
        });
        add_product.add(supplier_name);
        supplier_name.setBounds(190, 140, 230, 30);

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Selling Price");
        add_product.add(jLabel11);
        jLabel11.setBounds(40, 300, 120, 30);

        sell_price.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        add_product.add(sell_price);
        sell_price.setBounds(190, 300, 230, 30);

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Reorder Level");
        add_product.add(jLabel12);
        jLabel12.setBounds(40, 420, 110, 30);

        reorder_level.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        add_product.add(reorder_level);
        reorder_level.setBounds(190, 420, 230, 30);

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Category");
        add_product.add(jLabel13);
        jLabel13.setBounds(40, 220, 100, 30);

        category.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ", "Face Wash", "Shampoo", "Fairness Cream", "Conditioner", "Silicone", "Hand Wash", "Soap" }));
        category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryMouseClicked(evt);
            }
        });
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        add_product.add(category);
        category.setBounds(190, 220, 230, 30);

        supplier_id.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        supplier_id.setForeground(new java.awt.Color(255, 255, 255));
        add_product.add(supplier_id);
        supplier_id.setBounds(190, 100, 230, 30);

        product_name_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        product_name_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(product_name_label);
        product_name_label.setBounds(430, 70, 180, 30);

        supplier_name_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        supplier_name_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(supplier_name_label);
        supplier_name_label.setBounds(430, 140, 180, 30);

        size_1_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        size_1_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(size_1_label);
        size_1_label.setBounds(430, 180, 180, 30);

        category_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        category_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(category_label);
        category_label.setBounds(430, 220, 180, 30);

        buy_price_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        buy_price_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(buy_price_label);
        buy_price_label.setBounds(430, 260, 180, 30);

        sell_price_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        sell_price_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(sell_price_label);
        sell_price_label.setBounds(430, 300, 180, 30);

        reorder_level_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        reorder_level_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(reorder_level_label);
        reorder_level_label.setBounds(430, 420, 180, 30);

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("MRP");
        add_product.add(jLabel14);
        jLabel14.setBounds(40, 340, 80, 30);

        mrp.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        mrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrpActionPerformed(evt);
            }
        });
        add_product.add(mrp);
        mrp.setBounds(190, 340, 230, 30);

        cont_size.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cont_size.setToolTipText("");
        cont_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cont_sizeActionPerformed(evt);
            }
        });
        add_product.add(cont_size);
        cont_size.setBounds(190, 460, 230, 30);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Container Size(ml)");
        add_product.add(jLabel4);
        jLabel4.setBounds(40, 460, 150, 30);

        mrp_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        mrp_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(mrp_label);
        mrp_label.setBounds(430, 340, 180, 30);

        cont_size_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cont_size_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(cont_size_label);
        cont_size_label.setBounds(430, 460, 190, 30);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity");
        add_product.add(jLabel8);
        jLabel8.setBounds(40, 380, 80, 30);

        quantity.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        add_product.add(quantity);
        quantity.setBounds(190, 380, 230, 30);

        quantity_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        quantity_label.setForeground(new java.awt.Color(255, 0, 0));
        add_product.add(quantity_label);
        quantity_label.setBounds(430, 380, 180, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        product_name.enable();
        supplier_name.enable();
        size_1.enable();
        category.enable();
        supplier_id.enable();
        buy_price.enable();
        sell_price.enable();
        mrp.enable();
        quantity.enable();
        cont_size.enable();
        description.enable();
        reorder_level.enable();
        
        product_name_label.setText("");
        supplier_name_label.setText("");
        size_1_label.setText("");
        category_label.setText("");
        buy_price_label.setText("");
        sell_price_label.setText("");
        mrp_label.setText("");
        quantity_label.setText("");
        cont_size_label.setText("");
        reorder_level_label.setText("");
        
        product_name.setText("");
        supplier_id.setText("");
        buy_price.setText("");
        sell_price.setText("");
        mrp.setText("");
        quantity.setText("");
        cont_size.setText("");
        description.setText("");
        reorder_level.setText("");
        product_id_label.setText("");
        supplier_name.setSelectedIndex(0);
        size_1.setSelectedIndex(0);
        category.setSelectedIndex(0);

        genProductID();

        product_id_label.setText(prod_id);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        product_name_label.setText("");
        supplier_name_label.setText("");
        size_1_label.setText("");
        category_label.setText("");
        buy_price_label.setText("");
        sell_price_label.setText("");
        mrp_label.setText("");
        quantity_label.setText("");
        
        cont_size_label.setText("");
        reorder_level_label.setText("");
        
        
        boolean productname;
        boolean buyprice;
        boolean sellprice;
        boolean mrp1;
        boolean quantity1;
        boolean reorderlevel;
        boolean container_size;
        
        int count=0;
       
        validate_1 v1=new validate_1();
        productname=v1.check_letters(product_name.getText());
        buyprice=v1.numcheck(buy_price.getText());
        sellprice=v1.numcheck(sell_price.getText());
        mrp1=v1.numcheck(mrp.getText());
        quantity1=v1.numcheck(quantity.getText());
        reorderlevel=v1.numcheck(reorder_level.getText());
        container_size=v1.numcheck(cont_size.getText());
        
        if(product_name.getText().isEmpty())
         {
              product_name_label.setText("*Required field");
              count++;
         }
        
        int a=supplier_name.getSelectedItem().toString().compareTo("Select");
        if(a==1)
        {
            supplier_name_label.setText("*Select a Supplier");
            count++;
        }
        
        int b=size_1.getSelectedItem().toString().compareTo("Select");
        if(b==1)
        {
            size_1_label.setText("*Select a Size");
            count++;
        }
        
        
        int c=category.getSelectedItem().toString().compareTo("Select");
        if(c==1)
        {
           category_label.setText("*Select a Category");
           count++;
        }
        
        if(buy_price.getText().isEmpty())
        {
            buy_price_label.setText("*Required field");
            count++;
        }
        
        if(sell_price.getText().isEmpty())
        {
           sell_price_label.setText("*Required field");
           count++;
        }
        
        if(mrp.getText().isEmpty())
        {
           mrp_label.setText("*Required field");
           count++;
        }
        
        if(quantity.getText().isEmpty())
        {
           quantity_label.setText("*Required field");
           count++;
        }
        
        if(reorder_level.getText().isEmpty())
        {
           reorder_level_label.setText("*Required field");
           count++;
        }
        
        if(cont_size.getText().isEmpty())
        {
           cont_size_label.setText("*Required field");
           count++;
        }
        
        if(productname==false)
        {
              product_name_label.setText("*Insert only letters");
              count++;
        }
        
        if(buyprice==false)
        {
              buy_price_label.setText("*Insert only numerics");
              count++;
        }
        
         
        if(sellprice==false)
        {
              sell_price_label.setText("*Insert only numerics");
              count++;
        }
        
        if(mrp1==false)
        {
              mrp_label.setText("*Insert only numerics");
              count++;
        }
        
        if(quantity1==false)
        {
              quantity_label.setText("*Insert only numerics");
              count++;
        }
         
        if(reorderlevel==false)
        {
              reorder_level_label.setText("*Insert only numerics");
              count++;
        }
        
        if(container_size==false)
        {
              cont_size_label.setText("*Insert only numerics");
              count++;
        }
        
        if (count==0)
        {
        product_1 a1=new product_1();
       
        
        a1.setProductID(product_id_label.getText());
        a1.setProductName(product_name.getText());
        a1.setSupplierID(supplier_id.getText());
        a1.setSupplierName(supplier_name.getSelectedItem().toString());
        a1.setSize(size_1.getSelectedItem().toString());
        a1.setCategory(category.getSelectedItem().toString());
        a1.setBuyPrice(Double.parseDouble(buy_price.getText()));
        a1.setSellPrice(Double.parseDouble(sell_price.getText()));
        a1.setMrp(Double.parseDouble(mrp.getText()));
        a1.setQuantity(Integer.parseInt(quantity.getText().trim()));
        a1.setReorderLevel(Integer.parseInt(reorder_level.getText().trim()));
        a1.setContainerSize(Integer.parseInt(cont_size.getText().trim()));
        a1.setDescription(description.getText());

        a1.storeDB();
        
        product_name_label.setText("");
        supplier_name_label.setText("");
        size_1_label.setText("");
        category_label.setText("");
        buy_price_label.setText("");
        sell_price_label.setText("");
        mrp_label.setText("");
        quantity_label.setText("");
        cont_size_label.setText("");
        reorder_level_label.setText("");
        
        product_name.setText("");
        supplier_id.setText("");
        buy_price.setText("");
        sell_price.setText("");
        mrp.setText("");
        quantity.setText("");
        cont_size.setText("");
        description.setText("");
        reorder_level.setText("");
        product_id_label.setText("");
        supplier_name.setSelectedIndex(0);
        size_1.setSelectedIndex(0);
        category.setSelectedIndex(0);
        
        product_name.disable();
        supplier_name.disable();
        size_1.disable();
        category.disable();
        supplier_id.disable();
        buy_price.disable();
        sell_price.disable();
        mrp.disable();
        quantity.disable();
        cont_size.disable();
        description.disable();
        reorder_level.disable();
        
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryMouseClicked
        
    }//GEN-LAST:event_categoryMouseClicked

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

    private void supplier_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplier_nameMouseClicked
        
    }//GEN-LAST:event_supplier_nameMouseClicked

    private void supplier_nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplier_nameMouseEntered
       
    }//GEN-LAST:event_supplier_nameMouseEntered

    private void product_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_nameActionPerformed

    private void size_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_size_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_size_1ActionPerformed

    private void mrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mrpActionPerformed

    private void cont_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cont_sizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cont_sizeActionPerformed

    private void supplier_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplier_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplier_nameActionPerformed

    private void supplier_nameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_supplier_nameItemStateChanged
       
         fillSupplierIDCombo();
    }//GEN-LAST:event_supplier_nameItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add_product;
    private javax.swing.JTextField buy_price;
    private javax.swing.JLabel buy_price_label;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel category_label;
    private javax.swing.JTextField cont_size;
    private javax.swing.JLabel cont_size_label;
    private javax.swing.JTextField description;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mrp;
    private javax.swing.JLabel mrp_label;
    private javax.swing.JLabel product_id_label;
    private javax.swing.JTextField product_name;
    private javax.swing.JLabel product_name_label;
    private javax.swing.JTextField quantity;
    private javax.swing.JLabel quantity_label;
    private javax.swing.JTextField reorder_level;
    private javax.swing.JLabel reorder_level_label;
    private javax.swing.JTextField sell_price;
    private javax.swing.JLabel sell_price_label;
    private javax.swing.JComboBox<String> size_1;
    private javax.swing.JLabel size_1_label;
    private javax.swing.JLabel supplier_id;
    private javax.swing.JComboBox<String> supplier_name;
    private javax.swing.JLabel supplier_name_label;
    // End of variables declaration//GEN-END:variables

 private ImageIcon format=null;
    //image related
    String filename=null;
    int s=0;
    byte[] person_image=null;
}
