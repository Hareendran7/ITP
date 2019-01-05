/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mycode.dailyTransactions;
import mycode.dbConnect;
import mycode.month;
import mycode.monthlyTransactions;
import mycode.validation;
import warehouse.salary;

/**
 *
 * @author LENOVO
 */
public class transactions extends javax.swing.JPanel {

    /**
     * Creates new form transactions
     */
    
    Connection conn= null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    DateFormat df= DateFormat.getDateInstance();
    
    public transactions() {
    initComponents();
    conn=dbConnect.connect();
        
    Date todayDate=new Date();
    SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
    String exdate=  Date_Format.format(todayDate);
    jLabel2.setText("Transactions on "+exdate+"");
    jLabel37.setText(exdate);
    
    String[] part=exdate.split("-");
    String month=part[1];
    String year=part[0];
    Integer intt=Integer.parseInt(month);
    Integer yrt=Integer.parseInt(year);
    
//    month m=new month();
//  String x=m.month(intt);
//   jLabel14.setText(""+x+"-"+year+"  Transactions");
    
    monthlyTran();
    dailyTransactions();
   
    jButton4.setEnabled(false);
    
    }
    
    public void dailyTransactions(){
        Date todayDate=new Date();
    SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
    String exdate=  Date_Format.format(todayDate);
    jLabel2.setText("Transactions on "+exdate+"");
        //view daily transactions
         //stock 
        double amount;
        dailyTransactions a= new  dailyTransactions();
        amount=a.SupplierPaymentStockExpense(pst, conn, rs,exdate);
        String stoc= String.valueOf(amount);
        jLabel6.setText(stoc);
        
        //retailer Damage
        double amount1;
        dailyTransactions b= new dailyTransactions();
        amount1=b.RetailerDamage(pst, conn, rs, exdate);
        String retDam=String.valueOf(amount1);
        jLabel7.setText(retDam);
        
        //delivery
        
        double damount;
        dailyTransactions q=new  dailyTransactions();
        damount= q.delivery(pst, conn, rs, exdate);
        String delivery=String.valueOf(damount);
        jLabel8.setText(delivery);
        
        
        //retailer Income
        double amount2;
        dailyTransactions c= new dailyTransactions();
        amount2=c.retailerIncome(pst, conn, rs, exdate);
        String retInc=String.valueOf(amount2);
        jLabel9.setText(retInc);
    }
    public void monthlyTran(){
          Date todayDate=new Date();
    SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
    String exdate=  Date_Format.format(todayDate);
    //jLabel2.setText("Transactions on "+exdate+"");
    
    String[] part=exdate.split("-");
    String month=part[1];
    String year=part[0];
    String ddd=part[2];
    Integer intt=Integer.parseInt(month);
    Integer yrt=Integer.parseInt(year);
    Integer day=Integer.parseInt(ddd);
     //previous month
    int pre=intt-1;
    month aa=new month();
    String pree=aa.month(pre);
    month aaa=new month();
    String curentMo=aaa.month(intt);
    //previous year
    int yr=yrt-1;
    String lastyr=String.valueOf(yr);
    
    month m=new month();
    String x=m.month(intt);
//   
//    String yearrr=String.valueOf(yrt);
  

    if(x.equals("January")){
        if(day==1){
            jLabel14.setText("End of "+pree+"-"+lastyr+"  Transactions"); 
             int dece=12;

    String yearrr=String.valueOf(yrt);
    
         //salary
    double sal;
    monthlyTransactions a=new  monthlyTransactions();
    sal=a.Salary(pst, conn, rs,   dece, yr);
    String salary=String.valueOf(sal);
    jLabel24.setText(salary);
     
    //retailer damage
    double retDamage;
    monthlyTransactions b=new  monthlyTransactions();
    retDamage=b.RetailerDamage(pst, conn, rs,  dece, yr);
    String dmage=String.valueOf(retDamage);
    jLabel26.setText(dmage);
     
    //stock expense   
    double stockExpense;
    monthlyTransactions c=new  monthlyTransactions();
    stockExpense=c.stockExpense(pst, conn, rs,  dece, yr);
    String stock=String.valueOf( stockExpense);
    jLabel25.setText(stock);
        System.out.println(stockExpense);
    //delivery
    double delivery;
    monthlyTransactions dd=new monthlyTransactions();
    delivery=dd.delivery(pst, conn, rs, dece, yr);
    String del=String.valueOf(delivery);
    jLabel27.setText(del);
    
    //other expenses  
    double otherExpenses;
    monthlyTransactions d=new monthlyTransactions();
    otherExpenses=d.otherExpense(pst, conn, rs,dece, yr);
    String otherEx=String.valueOf(otherExpenses);
    jLabel28.setText(otherEx);
    
    //income
    //retailer income
    double retIncome;
    monthlyTransactions f=new  monthlyTransactions();
    retIncome =f.retailerIncome(pst, conn, rs, dece, yr);
    String retailer=String.valueOf(retIncome);
    jLabel33.setText(retailer);
    
     //other income
    double otherIncome;
    monthlyTransactions  g=new   monthlyTransactions ();
    otherIncome=g.otherIncome(pst, conn, rs,  dece, yr);
    String income=String.valueOf(otherIncome);
    jLabel34.setText(income);
        }
        
        else{
            jLabel14.setText(" "+curentMo+"-"+year+"  Transactions");
//             int dece=12;

    String yearrr=String.valueOf(yrt);
    
         //salary
    double sal;
    monthlyTransactions a=new  monthlyTransactions();
    sal=a.Salary(pst, conn, rs,  intt,yrt);
    System.out.println(sal);
    String salary=String.valueOf(sal);
    jLabel24.setText(salary);
     
    //retailer damage
    double retDamage;
    monthlyTransactions b=new  monthlyTransactions();
    retDamage=b.RetailerDamage(pst, conn, rs,  intt, yrt);
    String dmage=String.valueOf(retDamage);
    jLabel26.setText(dmage);
     
    //stock expense   
    double stockExpense;
    monthlyTransactions c=new  monthlyTransactions();
    stockExpense=c.stockExpense(pst, conn, rs,  intt, yrt);
    String stock=String.valueOf( stockExpense);
    jLabel25.setText(stock);
        System.out.println(stockExpense);
    //delivery
    double delivery;
    monthlyTransactions dd=new monthlyTransactions();
    delivery=dd.delivery(pst, conn, rs, intt, yrt);
    String del=String.valueOf(delivery);
    jLabel27.setText(del);
    
    //other expenses  
    double otherExpenses;
    monthlyTransactions d=new monthlyTransactions();
    otherExpenses=d.otherExpense(pst, conn, rs,intt, yrt);
    String otherEx=String.valueOf(otherExpenses);
    jLabel28.setText(otherEx);
    
    //income
    //retailer income
    double retIncome;
    monthlyTransactions f=new  monthlyTransactions();
    retIncome =f.retailerIncome(pst, conn, rs, intt, yrt);
    String retailer=String.valueOf(retIncome);
    jLabel33.setText(retailer);
    
     //other income
    double otherIncome;
    monthlyTransactions  g=new   monthlyTransactions ();
    otherIncome=g.otherIncome(pst, conn, rs,  intt, yrt);
    String income=String.valueOf(otherIncome);
    jLabel34.setText(income);
        }
  
    }else{
        if(day==1){
            jLabel14.setText("End of "+pree+"-"+year+"  Transactions"); 
            
               String yearrr=String.valueOf(yrt);
    
         //salary
    double sal;
    monthlyTransactions a=new  monthlyTransactions();
    sal=a.Salary(pst, conn, rs,   pre, yrt);
    String salary=String.valueOf(sal);
    jLabel24.setText(salary);
     
    //retailer damage
    double retDamage;
    monthlyTransactions b=new  monthlyTransactions();
    retDamage=b.RetailerDamage(pst, conn, rs,  pre, yrt);
    String dmage=String.valueOf(retDamage);
    jLabel26.setText(dmage);
     
    //stock expense   
    double stockExpense;
    monthlyTransactions c=new  monthlyTransactions();
    stockExpense=c.stockExpense(pst, conn, rs,  pre, yrt);
    String stock=String.valueOf( stockExpense);
    jLabel25.setText(stock);
        System.out.println(stockExpense);
    //delivery
    double delivery;
    monthlyTransactions dd=new monthlyTransactions();
    delivery=dd.delivery(pst, conn, rs, pre, yrt);
    String del=String.valueOf(delivery);
    jLabel27.setText(del);
    
    //other expenses  
    double otherExpenses;
    monthlyTransactions d=new monthlyTransactions();
    otherExpenses=d.otherExpense(pst, conn, rs,pre, yrt);
    String otherEx=String.valueOf(otherExpenses);
    jLabel28.setText(otherEx);
    
    //income
    //retailer income
    double retIncome;
    monthlyTransactions f=new  monthlyTransactions();
    retIncome =f.retailerIncome(pst, conn, rs, pre, yrt);
    String retailer=String.valueOf(retIncome);
    jLabel33.setText(retailer);
    
     //other income
    double otherIncome;
    monthlyTransactions  g=new   monthlyTransactions ();
    otherIncome=g.otherIncome(pst, conn, rs,  pre, yrt);
    String income=String.valueOf(otherIncome);
    jLabel34.setText(income);
        }else{
            jLabel14.setText(" "+curentMo+"-"+year+"  Transactions");
                           String yearrr=String.valueOf(yrt);
    
         //salary
    double sal;
    monthlyTransactions a=new  monthlyTransactions();
    sal=a.Salary(pst, conn, rs,   intt, yrt);
    String salary=String.valueOf(sal);
    jLabel24.setText(salary);
     
    //retailer damage
    double retDamage;
    monthlyTransactions b=new  monthlyTransactions();
    retDamage=b.RetailerDamage(pst, conn, rs, intt, yrt);
    String dmage=String.valueOf(retDamage);
    jLabel26.setText(dmage);
     
    //stock expense   
    double stockExpense;
    monthlyTransactions c=new  monthlyTransactions();
    stockExpense=c.stockExpense(pst, conn, rs,  intt, yrt);
    String stock=String.valueOf( stockExpense);
    jLabel25.setText(stock);
        System.out.println(stockExpense);
    //delivery
    double delivery;
    monthlyTransactions dd=new monthlyTransactions();
    delivery=dd.delivery(pst, conn, rs, intt, yrt);
    String del=String.valueOf(delivery);
    jLabel27.setText(del);
    
    //other expenses  
    double otherExpenses;
    monthlyTransactions d=new monthlyTransactions();
    otherExpenses=d.otherExpense(pst, conn, rs,intt, yrt);
    String otherEx=String.valueOf(otherExpenses);
    jLabel28.setText(otherEx);
    
    //income
    //retailer income
    double retIncome;
    monthlyTransactions f=new  monthlyTransactions();
    retIncome =f.retailerIncome(pst, conn, rs, intt, yrt);
    String retailer=String.valueOf(retIncome);
    jLabel33.setText(retailer);
    
     //other income
    double otherIncome;
    monthlyTransactions  g=new   monthlyTransactions ();
    otherIncome=g.otherIncome(pst, conn, rs,  intt, yrt);
    String income=String.valueOf(otherIncome);
    jLabel34.setText(income);
            
        }

    }
    
    
        
//    if(x.equals("January")){
//         //previous month
//    
////    int dece=12;
////
////    String yearrr=String.valueOf(yrt);
////    
////         //salary
////    double sal;
////    monthlyTransactions a=new  monthlyTransactions();
////    sal=a.Salary(pst, conn, rs,   dece, yr);
////    String salary=String.valueOf(sal);
////    jLabel24.setText(salary);
////     
////    //retailer damage
////    double retDamage;
////    monthlyTransactions b=new  monthlyTransactions();
////    retDamage=b.RetailerDamage(pst, conn, rs,  dece, yr);
////    String dmage=String.valueOf(retDamage);
////    jLabel26.setText(dmage);
////     
////    //stock expense   
////    double stockExpense;
////    monthlyTransactions c=new  monthlyTransactions();
////    stockExpense=c.stockExpense(pst, conn, rs,  dece, yr);
////    String stock=String.valueOf( stockExpense);
////    jLabel25.setText(stock);
////        System.out.println(stockExpense);
////    //delivery
////    double delivery;
////    monthlyTransactions dd=new monthlyTransactions();
////    delivery=dd.delivery(pst, conn, rs, dece, yr);
////    String del=String.valueOf(delivery);
////    jLabel27.setText(del);
////    
////    //other expenses  
////    double otherExpenses;
////    monthlyTransactions d=new monthlyTransactions();
////    otherExpenses=d.otherExpense(pst, conn, rs,dece, yr);
////    String otherEx=String.valueOf(otherExpenses);
////    jLabel28.setText(otherEx);
////    
////    //income
////    //retailer income
////    double retIncome;
////    monthlyTransactions f=new  monthlyTransactions();
////    retIncome =f.retailerIncome(pst, conn, rs, dece, yr);
////    String retailer=String.valueOf(retIncome);
////    jLabel33.setText(retailer);
////    
////     //other income
////    double otherIncome;
////    monthlyTransactions  g=new   monthlyTransactions ();
////    otherIncome=g.otherIncome(pst, conn, rs,  dece, yr);
////    String income=String.valueOf(otherIncome);
////    jLabel34.setText(income);
//    }else{
//       //jLabel14.setText(" "+curentMo+"-"+year+"  Transactions");
//          //salary
//    double sal;
//    monthlyTransactions a=new  monthlyTransactions();
//    sal=a.Salary(pst, conn, rs,   pre, yrt);
//    String salary=String.valueOf(sal);
//    jLabel24.setText(salary);
//    
//    //retailer damage
//    double retDamage;
//    monthlyTransactions b=new  monthlyTransactions();
//    retDamage=b.RetailerDamage(pst, conn, rs,  pre, yrt);
//    String dmage=String.valueOf(retDamage);
//    jLabel26.setText(dmage);
//    
//    //stock expense   
//    double stockExpense;
//    monthlyTransactions c=new  monthlyTransactions();
//    stockExpense=c.stockExpense(pst, conn, rs,  pre, yrt);
//    String stock=String.valueOf( stockExpense);
//    jLabel25.setText(stock);
//    
//    //delivery
//    double delivery;
//    monthlyTransactions dd=new monthlyTransactions();
//    delivery=dd.delivery(pst, conn, rs,  pre, yrt);
//    String del=String.valueOf(delivery);
//    jLabel27.setText(del);
//    
//    //other expenses  
//    double otherExpenses;
//    monthlyTransactions d=new monthlyTransactions();
//    otherExpenses=d.otherExpense(pst, conn, rs, pre, yrt);
//    String otherEx=String.valueOf(otherExpenses);
//    jLabel28.setText(otherEx);
//    
//    //income
//    //retailer income
//    double retIncome;
//    monthlyTransactions f=new  monthlyTransactions();
//    retIncome =f.retailerIncome(pst, conn, rs,  pre, yrt);
//    String retailer=String.valueOf(retIncome);
//    jLabel33.setText(retailer);
//    
//     //other income
//    double otherIncome;
//    monthlyTransactions  g=new   monthlyTransactions ();
//    otherIncome=g.otherIncome(pst, conn, rs,  pre, yrt);
//    String income=String.valueOf(otherIncome);
//    jLabel34.setText(income);
//        
    
   
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(827, 559));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(827, 559));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(827, 559));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Retailer Damage");

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Retailer Income");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stock Expense");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Delivery Payment");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Daily Transactions", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(827, 559));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Add Transactions");

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add Expense");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Income/Expense Type");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Amount(Rs)");

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add Income");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jButton2))
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addComponent(jTextField2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(123, 123, 123))
        );

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Income Type", "Amount(Rs)"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Expense Type", "Amount(Rs)"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Transactions", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(827, 559));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Telephone Bill");

        jLabel29.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Retailer Income");

        jLabel33.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Electricity Bill");

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Stock Expense");
        jLabel19.setToolTipText("");

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Delivery Payment");

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Total Income(Rs)");

        jLabel24.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Company Rent");

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Retailer Damage");

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Other Income");

        jLabel28.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Other Expenses");

        jLabel32.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Total Expense(Rs)");

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Employee Salary");

        jLabel36.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));

        jLabel35.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Water Bill");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel30)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jLabel32)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel22)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jLabel37.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Monthly Transactions", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Daily Transactions");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //view monthly transactions
    Date todayDate=new Date();
    SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
    String exdate=  Date_Format.format(todayDate);
    
    String[] part=exdate.split("-");
    String month=part[1];
    String year=part[0];
    Integer intt=Integer.parseInt(month);
    Integer yrt=Integer.parseInt(year);
    
     month m=new month();
     String x=m.month(intt);
//   jLabel14.setText(""+x+"-"+year+"  Transactions");

//    
    //previous month
    int preMo=intt-1;
    String previousMonth=String.valueOf(preMo);
    month p=new month();
    String y=p.month(preMo);
    //previous year
    int preyr=yrt-1;
    String lastyr=String.valueOf(preyr);
     
    String elec=jTextField3.getText();
    String water=jTextField4.getText();
    String tele=jTextField5.getText();
    String rent=jTextField6.getText();
    
    double ele=Double.parseDouble(elec);
    double waterbill=Double.parseDouble(water);
    double telep=Double.parseDouble(tele);
    double ren=Double.parseDouble(rent);
        System.out.println(y);
        System.out.println(lastyr);
    
    if(x.equals("January")){
//            jLabel14.setText("End of "+y+"-"+lastyr+"  Transactions"); 
        int desc=12;
          //salary
    double sal;
    monthlyTransactions a=new  monthlyTransactions();
    sal=a.Salary(pst, conn, rs,  desc,preyr);
    String salary=String.valueOf(sal);
    jLabel24.setText(salary);
    
    //retailer damage
    double retDamage;
    monthlyTransactions b=new  monthlyTransactions();
    retDamage=b.RetailerDamage(pst, conn, rs, desc, preyr);
    String dmage=String.valueOf(retDamage);
    jLabel26.setText(dmage);
    
    //stock expense   
    double stockExpense;
    monthlyTransactions c=new  monthlyTransactions();
    stockExpense=c.stockExpense(pst, conn, rs, desc,preyr);
    String stock=String.valueOf( stockExpense);
    jLabel25.setText(stock);
    
    //delivery
    double delivery;
    monthlyTransactions dd=new monthlyTransactions();
    delivery=dd.delivery(pst, conn, rs, desc,preyr);
    String del=String.valueOf(delivery);
    jLabel27.setText(del);
    
    //other expenses  
    double otherExpenses;
    monthlyTransactions d=new monthlyTransactions();
    otherExpenses=d.otherExpense(pst, conn, rs, desc,preyr);
    String otherEx=String.valueOf(otherExpenses);
    jLabel28.setText(otherEx);
    
    //income
    //retailer income
    double retIncome;
    monthlyTransactions f=new  monthlyTransactions();
    retIncome =f.retailerIncome(pst, conn, rs,desc,preyr);
    String retailer=String.valueOf(retIncome);
    jLabel33.setText(retailer);
    
     //other income
    double otherIncome;
    monthlyTransactions  g=new   monthlyTransactions ();
    otherIncome=g.otherIncome(pst, conn, rs,desc, preyr);
    String income=String.valueOf(otherIncome);
    jLabel34.setText(income);
    
   
    
    
    
     //total expense
    double totallEx=ele+waterbill+telep+ren+retDamage+stockExpense+otherExpenses+sal+delivery;
    String totExpense=Double.toString(totallEx);
    jLabel36.setText(totExpense);
    
    
    //total income
    double totallIn=retIncome+otherIncome;
    String totIncome=Double.toString(totallIn);
    jLabel35.setText(totIncome);
    
    validation v=new validation();
      boolean value=v.firstOfMonth(exdate);
      if(value==true){
        try{
            String q="Update month_trans set elect ='"+ele+"',water='"+water+"',tele='"+telep+"',rent='"+ren+"',salary='"+sal+"',ret_damage='"+retDamage+"',stoc_expe='"+stockExpense+"',deliv='"+delivery+"',oth_exp='"+otherExpenses+"',ret_inco='"+retIncome+"',oth_inc='"+otherIncome+"',tot_income='"+totIncome +"',tot_expense='"+totExpense+"' where month='"+y+"' and year='"+lastyr+"'";
            pst= conn.prepareStatement(q);
            pst.execute();
              JOptionPane.showMessageDialog(null, " Added successfully");    
        }catch(Exception e){
            System.out.println(e);
        }
      }else{
          
      }
    
    
    }else{
//            jLabel14.setText("End of "+y+"-"+year+"  Transactions"); 
           //salary
    double sal;
    monthlyTransactions a=new  monthlyTransactions();
    sal=a.Salary(pst, conn, rs,  preMo, yrt);
    String salary=String.valueOf(sal);
    jLabel24.setText(salary);
    
    //retailer damage
    double retDamage;
    monthlyTransactions b=new  monthlyTransactions();
    retDamage=b.RetailerDamage(pst, conn, rs, preMo, yrt);
    String dmage=String.valueOf(retDamage);
    jLabel26.setText(dmage);
    
    //stock expense   
    double stockExpense;
    monthlyTransactions c=new  monthlyTransactions();
    stockExpense=c.stockExpense(pst, conn, rs, preMo, yrt);
    String stock=String.valueOf( stockExpense);
    jLabel25.setText(stock);
    
    //delivery
    double delivery;
    monthlyTransactions dd=new monthlyTransactions();
    delivery=dd.delivery(pst, conn, rs, preMo, yrt);
    String del=String.valueOf(delivery);
    jLabel27.setText(del);
    
    //other expenses  
    double otherExpenses;
    monthlyTransactions d=new monthlyTransactions();
    otherExpenses=d.otherExpense(pst, conn, rs, preMo, yrt);
    String otherEx=String.valueOf(otherExpenses);
    jLabel28.setText(otherEx);
    
    //income
    //retailer income
    double retIncome;
    monthlyTransactions f=new  monthlyTransactions();
    retIncome =f.retailerIncome(pst, conn, rs, preMo, yrt);
    String retailer=String.valueOf(retIncome);
    jLabel33.setText(retailer);
    
     //other income
    double otherIncome;
    monthlyTransactions  g=new   monthlyTransactions ();
    otherIncome=g.otherIncome(pst, conn, rs,preMo, yrt);
    String income=String.valueOf(otherIncome);
    jLabel34.setText(income);
    
   
    
    
    
     //total expense
    double totallEx=ele+waterbill+telep+ren+retDamage+stockExpense+otherExpenses+sal+delivery;
    String totExpense=Double.toString(totallEx);
    jLabel36.setText(totExpense);
    
    
    //total income
    double totallIn=retIncome+otherIncome;
    String totIncome=Double.toString(totallIn);
    jLabel35.setText(totIncome);
    
       validation v=new validation();
      boolean value=v.firstOfMonth(exdate);
      if(value==true){
        try{
            String q="Update month_trans set elect ='"+ele+"',water='"+water+"',tele='"+telep+"',rent='"+ren+"',salary='"+sal+"',ret_damage='"+retDamage+"',stoc_expe='"+stockExpense+"',deliv='"+delivery+"',oth_exp='"+otherExpenses+"',ret_inco='"+retIncome+"',oth_inc='"+otherIncome+"',tot_income='"+totIncome +"',tot_expense='"+totExpense+"' where month='"+y+"' and year='"+year+"'";
            pst= conn.prepareStatement(q);
            pst.execute();
              JOptionPane.showMessageDialog(null, " Added successfully");    
        }catch(Exception e){
            System.out.println(e);
        }
      }else{
          
      }
   
    
    }
    
//      //salary
//    double sal;
//    monthlyTransactions a=new  monthlyTransactions();
//    sal=a.Salary(pst, conn, rs,  preMo, yrt);
//    String salary=String.valueOf(sal);
//    jLabel24.setText(salary);
//    
//    //retailer damage
//    double retDamage;
//    monthlyTransactions b=new  monthlyTransactions();
//    retDamage=b.RetailerDamage(pst, conn, rs, preMo, yrt);
//    String dmage=String.valueOf(retDamage);
//    jLabel26.setText(dmage);
//    
//    //stock expense   
//    double stockExpense;
//    monthlyTransactions c=new  monthlyTransactions();
//    stockExpense=c.stockExpense(pst, conn, rs, preMo, yrt);
//    String stock=String.valueOf( stockExpense);
//    jLabel25.setText(stock);
//    
//    //delivery
//    double delivery;
//    monthlyTransactions dd=new monthlyTransactions();
//    delivery=dd.delivery(pst, conn, rs, preMo, yrt);
//    String del=String.valueOf(delivery);
//    jLabel27.setText(del);
//    
//    //other expenses  
//    double otherExpenses;
//    monthlyTransactions d=new monthlyTransactions();
//    otherExpenses=d.otherExpense(pst, conn, rs, preMo, yrt);
//    String otherEx=String.valueOf(otherExpenses);
//    jLabel28.setText(otherEx);
//    
//    //income
//    //retailer income
//    double retIncome;
//    monthlyTransactions f=new  monthlyTransactions();
//    retIncome =f.retailerIncome(pst, conn, rs, preMo, yrt);
//    String retailer=String.valueOf(retIncome);
//    jLabel33.setText(retailer);
//    
//     //other income
//    double otherIncome;
//    monthlyTransactions  g=new   monthlyTransactions ();
//    otherIncome=g.otherIncome(pst, conn, rs,preMo, yrt);
//    String income=String.valueOf(otherIncome);
//    jLabel34.setText(income);
//    
//   
//    
//    
//    
//     //total expense
//    double totallEx=ele+waterbill+telep+ren+retDamage+stockExpense+otherExpenses+sal+delivery;
//    String totExpense=Double.toString(totallEx);
//    jLabel36.setText(totExpense);
//    
//    
//    //total income
//    double totallIn=retIncome+otherIncome;
//    String totIncome=Double.toString(totallIn);
//    jLabel35.setText(totIncome);
//   
//    
//    if(!elec.equals("") && !water.equals("") && !tele.equals("") && !rent.equals("") ){
//         
//             try{
//             String Q= "INSERT INTO month_trans(year,month,elect,water,tele,rent,salary,ret_damage,stoc_expe,deliv,oth_exp,ret_inco,oth_inc) values ('"+year+"','"+ x+"',"+ ele+","+ water+","+ telep+","+ ren+","+ sal+","+retDamage+","+stockExpense+","+delivery+","+otherExpenses+","+retIncome+","+otherIncome+")";
//             pst= conn.prepareStatement(Q);
//             pst.execute();
//             JOptionPane.showMessageDialog(null, " Added successfully");  
//            }
//             catch(SQLException  ex){
//              JOptionPane.showMessageDialog(null, " Record not added");    
//            }
//    }else{
//           JOptionPane.showMessageDialog(null, " Please fill all the payments");    
//    }

//      validation v=new validation();
//      boolean value=v.firstOfMonth(exdate);
//      if(value==true){
//        try{
//            String q="Update month_trans set elect ='"+ele+"',water='"+water+"',tele='"+telep+"',rent='"+ren+"',salary='"+sal+"',ret_damage='"+retDamage+"',stoc_expe='"+stockExpense+"',deliv='"+delivery+"',oth_exp='"+otherExpenses+"',ret_inco='"+retIncome+"',oth_inc='"+otherIncome+"',tot_income='"+totIncome +"',tot_expense='"+totExpense+"' where month='"+y+"' and year='"+year+"'";
//            pst= conn.prepareStatement(q);
//            pst.execute();
//              JOptionPane.showMessageDialog(null, " Added successfully");    
//        }catch(Exception e){
//            System.out.println(e);
//        }
//      }else{
//          
//      }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          //add income
        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
        String exdate=  Date_Format.format(jDateChooser1.getDate());
        validation c=new validation();
          
          //c.isBlank(amnt, jLabel10);
          
          String desc=jTextField1.getText();
          String amnt=jTextField2.getText();
          //float f = Float.parseFloat(amnt);
          double f=Double.parseDouble(amnt);
         if(desc.equals(""))
         {
       //  c.isBlank(desc, jLabel40);
        //c.isBlank(amnt, jLabel14);
         }
         else{
        try{
           String sql="select * from income where date='"+exdate+"' and income_type='"+desc+"'";
            pst = conn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           
           if(rs.next()){
             JOptionPane.showMessageDialog(null, " Already updated");  
           }else{                
                 
             String Q= "INSERT INTO income(date,income_type,amount) values ('"+ exdate+"','"+desc+"','"+f+"')";
             pst= conn.prepareStatement(Q);
             pst.execute();
            DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{exdate,desc,amnt});

             
//            JOptionPane.showMessageDialog(null, " Added Successfully");      
             
            
            
           }        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, " Record not added");
        }
         }
        
             jTextField1.setText(null);
             jTextField2.setText(null);
             jDateChooser1.setDate(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         //add expense
          SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
          String exdate=  Date_Format.format(jDateChooser1.getDate());
          String desc=jTextField1.getText();
          String amnt=jTextField2.getText();
          //float f = Float.parseFloat(amnt);
          double f=Double.parseDouble(amnt);
          
         validation c=new validation();
         if(desc.equals(""))
         {
//         c.isBlank(desc, jLabel40);
        // c.isBlank(amnt, jLabel14);
         }
         else
         {
           try{
               String sql="select * from expense where date='"+exdate+"' and expense_type='"+desc+"'";
                pst = conn.prepareStatement(sql);
               ResultSet rs = pst.executeQuery();
          
           if(rs.next()){
               JOptionPane.showMessageDialog(null, " Already updated");
           }  
           else{

                 
             String Q= "INSERT INTO expense(date,expense_type,amount) values ('"+ exdate+"','"+desc+"','"+f+"')";
             pst= conn.prepareStatement(Q);
             pst.execute();
             DefaultTableModel model =(DefaultTableModel) jTable2.getModel();
             model.addRow(new Object[]{exdate,desc,amnt});
//                  JOptionPane.showMessageDialog(null, " Added Successfully");     
             
             }
            
         }
         
    catch(Exception e){
             JOptionPane.showMessageDialog(null, " Record not added");
        }
    
         
              jTextField1.setText(null);
              jTextField2.setText(null); 
              jDateChooser1.setDate(null);
              
                            
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
        String exdate=jLabel37.getText().substring(8,10);
         
        try {
             if(Integer.parseInt(exdate) ==01)
                {
                    
                jButton4.setEnabled(true);

                }
             } 
        catch (Exception ex) {
                Logger.getLogger(salary.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jLabel37MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
