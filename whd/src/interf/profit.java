/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import mycode.annualTansactions;
import mycode.dbConnect;
import mycode.month;
import mycode.validation;

/**
 *
 * @author LENOVO
 */
public class profit extends javax.swing.JPanel {

    /**
     * Creates new form profit
     */
    Connection conn= null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    DateFormat df= DateFormat.getDateInstance();
    
    public profit() {
        initComponents();
        conn=dbConnect.connect();
        
         annualTransactions();
         monthlyTransactions();
        

    
    }
    
    public void annualTransactions(){
         Date todayDate=new Date();
    SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
    String exdate=  Date_Format.format(todayDate);
    
      
    String[] part=exdate.split("-");
    String month=part[1];
    String year=part[0];
    String ddd=part[2];
    Integer intt=Integer.parseInt(month);
    Integer yrt=Integer.parseInt(year);
    Integer day=Integer.parseInt(ddd);
    int preYR=yrt-1;
    String preyear=String.valueOf(preYR);
    
    
      //jLabel6.setText(year); 
    Integer premonth=intt -1;
    month mm=new month();
    String previousMonth=mm.month(premonth);
    
    Integer nextMo=intt +1;
    month mmm=new month();
    String nextMonth=mmm.month(nextMo);
    
    month m=new month();
    String x =m.month(intt);
    
    
    if(x.equals("January") &&day==1 && yrt==2018 ){
        int aug=8;
        String monthh="August";
      jLabel6.setText(" for the End of "+previousMonth+"-"+preyear+"");
      DefaultTableModel model1 =(DefaultTableModel) jTable2.getModel();
      model1.addRow(new Object[]{"INCOME","",""});
      
       //current balance
      annualTansactions p=new annualTansactions();
      double abal=p.Janbalance(pst, conn, rs,   monthh, preYR);
      String CurrBal=String.valueOf(abal);
      model1.addRow(new Object[]{"Balance of 1st August",CurrBal,"-"});
        System.out.println(abal);
      //retailer Income
      annualTansactions pq=new annualTansactions();
      double retr=pq.retailerIncome(pst, conn, rs, preYR);
      String r=String.valueOf(retr);
      model1.addRow(new Object[]{"Retailer Income",r,"-"});
      
       //other Income
       annualTansactions po=new annualTansactions();
       double oInc=po.otherIncome(pst, conn, rs, preYR);
       String other=String.valueOf(oInc);
       model1.addRow(new Object[]{"Other Income",other,"-"});
       
       //total income
       double totalIncome=abal+retr+oInc;
       String ttotInc=String.valueOf(totalIncome);
       model1.addRow(new Object[]{"Total Income","",ttotInc});
       
        model1.addRow(new Object[]{"","",""});
        model1.addRow(new Object[]{"EXPENSE","",""});
        
         //salary
       annualTansactions z=new annualTansactions();
       double ssal=z.salary(pst, conn, rs, preYR);
       String salaryyy=String.valueOf(ssal);
       model1.addRow(new Object[]{"Employee Salary",salaryyy,"-"});
       
        //Retailer Damage
       
        annualTansactions zz=new annualTansactions();
        double rettDam=zz.RetailerDamage(pst, conn, rs, preYR);
        String d=String.valueOf(rettDam);
        model1.addRow(new Object[]{"Retailer Damage",d,"-"});
        
         
        //stock exxpense
          annualTansactions zzz=new annualTansactions();
          double q=zzz.stockExpense(pst, conn, rs,  preYR);
          String stock=String.valueOf(q);
          model1.addRow(new Object[]{"Stock Expense",stock,"-"}); 
          
         //delivery
       annualTansactions zzzz=new annualTansactions();
       double l=zzzz.delivery(pst, conn, rs,  preYR);
       String deel=String.valueOf(l);
       model1.addRow(new Object[]{"Delivery Payment",deel,"-"});
       
         //utilites
       
       //electricity
        annualTansactions u=new annualTansactions();
        double e=u.electricity(pst, conn, rs, preYR);
        
        //water
        annualTansactions uu=new annualTansactions();
        double ee=uu.water(pst, conn, rs, preYR);
        
        //telephone
        annualTansactions uuu=new annualTansactions();
        double eee=uuu.telephone(pst, conn, rs, preYR);
        //rent
        annualTansactions uuuu=new annualTansactions();
        double eeee=uuuu.rent(pst, conn, rs, preYR);
        
        double utility=e+ee+eee+eeee;
        String uti=String.valueOf( utility);
        model1.addRow(new Object[]{"Utilities",uti,"-"});
        
         //otherexpense
        
        annualTansactions oE=new annualTansactions();
        double exp=oE.otherExpense(pst, conn, rs,preYR);
        String k=String.valueOf(exp);
        model1.addRow(new Object[]{"Other Expenses",k,"-"});
        
         //total expense
        double totalExp=exp+utility+l+q+rettDam+ssal;
        String expe=String.valueOf(totalExp);
        
        model1.addRow(new Object[]{"Total Expense","",expe});
        
         //profit
               double profitt=totalIncome-totalExp;
               String proo=Double.toString(profitt);
         model1.addRow(new Object[]{"","",""});
         model1.addRow(new Object[]{"","",""});
         model1.addRow(new Object[]{"PROFIT/LOSS","",proo});
         
         if(profitt>0){
          String strr = new String("(Profit)");
                  model1.addRow(new Object[]{"Status","",strr});
              
           }else{              
                 String strr = new String("(Loss)");
                  model1.addRow(new Object[]{"Status","",strr});
               }
        
    }else if (x.equals("January") && day==1){
       String monthh="January";
      jLabel6.setText(" for the End of "+previousMonth+"-"+preyear+"");
      DefaultTableModel model1 =(DefaultTableModel) jTable2.getModel();
      model1.addRow(new Object[]{"INCOME","",""});
   //  annual profit loss

      //current balance
      annualTansactions p=new annualTansactions();
      double abal=p.Janbalance(pst, conn, rs,monthh,yrt);
      String CurrBal=String.valueOf(abal);
      model1.addRow(new Object[]{"Balance of 1st of January",CurrBal,"-"});
      
      //retailer Income
      annualTansactions pq=new annualTansactions();
      double retr=pq.retailerIncome(pst, conn, rs, preYR);
      String r=String.valueOf(retr);
      model1.addRow(new Object[]{"Retailer Income",r,"-"});
      
      //other Income
       annualTansactions po=new annualTansactions();
       double oInc=po.otherIncome(pst, conn, rs, preYR);
       String other=String.valueOf(oInc);
       model1.addRow(new Object[]{"Other Income",other,"-"});
       
       //total income
       double totalIncome=abal+retr+oInc;
       String ttotInc=String.valueOf(totalIncome);
       model1.addRow(new Object[]{"Total Income","",ttotInc});
       
       model1.addRow(new Object[]{"","",""});
       model1.addRow(new Object[]{"EXPENSE","",""});
       
       //salary
       annualTansactions z=new annualTansactions();
       double ssal=z.salary(pst, conn, rs, preYR);
       String salaryyy=String.valueOf(ssal);
       model1.addRow(new Object[]{"Employee Salary",salaryyy,"-"});
       
       //Retailer Damage
       
        annualTansactions zz=new annualTansactions();
        double rettDam=zz.RetailerDamage(pst, conn, rs,preYR);
        String d=String.valueOf(rettDam);
        model1.addRow(new Object[]{"Retailer Damage",d,"-"});
        
        //stock exxpense
          annualTansactions zzz=new annualTansactions();
          double q=zzz.stockExpense(pst, conn, rs, preYR);
          String stock=String.valueOf(q);
          model1.addRow(new Object[]{"Stock Expense",stock,"-"});   
       //delivery
       annualTansactions zzzz=new annualTansactions();
       double l=zzzz.delivery(pst, conn, rs, preYR);
       String deel=String.valueOf(l);
       model1.addRow(new Object[]{"Delivery Payment",deel,"-"});
       
       //utilites
       
       //electricity
        annualTansactions u=new annualTansactions();
        double e=u.electricity(pst, conn, rs, preYR);
        
        //water
        annualTansactions uu=new annualTansactions();
        double ee=uu.water(pst, conn, rs, preYR);
        
        //telephone
        annualTansactions uuu=new annualTansactions();
        double eee=uuu.telephone(pst, conn, rs, preYR);
        //rent
        annualTansactions uuuu=new annualTansactions();
        double eeee=uuuu.rent(pst, conn, rs, preYR);
        
        double utility=e+ee+eee+eeee;
        String uti=String.valueOf( utility);
        model1.addRow(new Object[]{"Utilities",uti,"-"});
        
        //otherexpense
        
        annualTansactions oE=new annualTansactions();
        double exp=oE.otherExpense(pst, conn, rs,preYR);
        String k=String.valueOf(exp);
        model1.addRow(new Object[]{"Other Expenses",k,"-"});
        
        //total expense
        double totalExp=exp+utility+l+q+rettDam+ssal;
        String expe=String.valueOf(totalExp);
        
        model1.addRow(new Object[]{"Total Expense","",expe});
        
         //profit
               double profitt=totalIncome-totalExp;
               String proo=Double.toString(profitt);
         model1.addRow(new Object[]{"","",""});
         model1.addRow(new Object[]{"","",""});
         model1.addRow(new Object[]{"PROFIT/LOSS","",proo});
         
         if(profitt>0){
          String strr = new String("(Profit)");
                  model1.addRow(new Object[]{"Status","",strr});
              
           }else{              
                 String strr = new String("(Loss)");
                  model1.addRow(new Object[]{"Status","",strr});
               }
         
    
    }else if(yrt==2017){
        String jan="August";  
      jLabel6.setText("2017");
      DefaultTableModel model1 =(DefaultTableModel) jTable2.getModel();
      model1.addRow(new Object[]{"INCOME","",""});
   //  annual profit loss

      //current balance
      annualTansactions p=new annualTansactions();
      double abal=p.Janbalance(pst, conn, rs,jan,yrt);
      String CurrBal=String.valueOf(abal);
      model1.addRow(new Object[]{"Balance of 1st of August",CurrBal,"-"});
      
      //retailer Income
      annualTansactions pq=new annualTansactions();
      double retr=pq.retailerIncome(pst, conn, rs, yrt);
      String r=String.valueOf(retr);
      model1.addRow(new Object[]{"Retailer Income",r,"-"});
      
      //other Income
       annualTansactions po=new annualTansactions();
       double oInc=po.otherIncome(pst, conn, rs, yrt);
       String other=String.valueOf(oInc);
       model1.addRow(new Object[]{"Other Income",other,"-"});
       
       //total income
       double totalIncome=abal+retr+oInc;
       String ttotInc=String.valueOf(totalIncome);
       model1.addRow(new Object[]{"Total Income","",ttotInc});
       
       model1.addRow(new Object[]{"","",""});
       model1.addRow(new Object[]{"EXPENSE","",""});
       
       //salary
       annualTansactions z=new annualTansactions();
       double ssal=z.salary(pst, conn, rs, yrt);
       String salaryyy=String.valueOf(ssal);
       model1.addRow(new Object[]{"Employee Salary",salaryyy,"-"});
       
       //Retailer Damage
       
        annualTansactions zz=new annualTansactions();
        double rettDam=zz.RetailerDamage(pst, conn, rs,yrt);
        String d=String.valueOf(rettDam);
        model1.addRow(new Object[]{"Retailer Damage",d,"-"});
        
        //stock exxpense
          annualTansactions zzz=new annualTansactions();
          double q=zzz.stockExpense(pst, conn, rs, yrt);
          String stock=String.valueOf(q);
          model1.addRow(new Object[]{"Stock Expense",stock,"-"});   
       //delivery
       annualTansactions zzzz=new annualTansactions();
       double l=zzzz.delivery(pst, conn, rs, yrt);
       String deel=String.valueOf(l);
       model1.addRow(new Object[]{"Delivery Payment",deel,"-"});
       
       //utilites
       
       //electricity
        annualTansactions u=new annualTansactions();
        double e=u.electricity(pst, conn, rs, yrt);
        
        //water
        annualTansactions uu=new annualTansactions();
        double ee=uu.water(pst, conn, rs, yrt);
        
        //telephone
        annualTansactions uuu=new annualTansactions();
        double eee=uuu.telephone(pst, conn, rs, yrt);
        //rent
        annualTansactions uuuu=new annualTansactions();
        double eeee=uuuu.rent(pst, conn, rs,yrt);
        
        double utility=e+ee+eee+eeee;
        String uti=String.valueOf( utility);
        model1.addRow(new Object[]{"Utilities",uti,"-"});
        
        //otherexpense
        
        annualTansactions oE=new annualTansactions();
        double exp=oE.otherExpense(pst, conn, rs,yrt);
        String k=String.valueOf(exp);
        model1.addRow(new Object[]{"Other Expenses",k,"-"});
        
        //total expense
        double totalExp=exp+utility+l+q+rettDam+ssal;
        String expe=String.valueOf(totalExp);
        
        model1.addRow(new Object[]{"Total Expense","",expe});
        
         //profit
               double profitt=totalIncome-totalExp;
               String proo=Double.toString(profitt);
         model1.addRow(new Object[]{"","",""});
         model1.addRow(new Object[]{"","",""});
         model1.addRow(new Object[]{"PROFIT/LOSS","",proo});
         
         if(profitt>0){
          String strr = new String("(Profit)");
                  model1.addRow(new Object[]{"Status","",strr});
              
           }else{              
                 String strr = new String("(Loss)");
                  model1.addRow(new Object[]{"Status","",strr});
               }
         
    }else{
      String jan="January";  
      jLabel6.setText(" "+month+"-"+year+"");
      DefaultTableModel model1 =(DefaultTableModel) jTable2.getModel();
      model1.addRow(new Object[]{"INCOME","",""});
   //  annual profit loss

      //current balance
      annualTansactions p=new annualTansactions();
      double abal=p.Janbalance(pst, conn, rs,jan,yrt);
      String CurrBal=String.valueOf(abal);
      model1.addRow(new Object[]{"Balance of 1st of January",CurrBal,"-"});
      
      //retailer Income
      annualTansactions pq=new annualTansactions();
      double retr=pq.retailerIncome(pst, conn, rs, yrt);
      String r=String.valueOf(retr);
      model1.addRow(new Object[]{"Retailer Income",r,"-"});
      
      //other Income
       annualTansactions po=new annualTansactions();
       double oInc=po.otherIncome(pst, conn, rs, yrt);
       String other=String.valueOf(oInc);
       model1.addRow(new Object[]{"Other Income",other,"-"});
       
       //total income
       double totalIncome=abal+retr+oInc;
       String ttotInc=String.valueOf(totalIncome);
       model1.addRow(new Object[]{"Total Income","",ttotInc});
       
       model1.addRow(new Object[]{"","",""});
       model1.addRow(new Object[]{"EXPENSE","",""});
       
       //salary
       annualTansactions z=new annualTansactions();
       double ssal=z.salary(pst, conn, rs, yrt);
       String salaryyy=String.valueOf(ssal);
       model1.addRow(new Object[]{"Employee Salary",salaryyy,"-"});
       
       //Retailer Damage
       
        annualTansactions zz=new annualTansactions();
        double rettDam=zz.RetailerDamage(pst, conn, rs,yrt);
        String d=String.valueOf(rettDam);
        model1.addRow(new Object[]{"Retailer Damage",d,"-"});
        
        //stock exxpense
          annualTansactions zzz=new annualTansactions();
          double q=zzz.stockExpense(pst, conn, rs, yrt);
          String stock=String.valueOf(q);
          model1.addRow(new Object[]{"Stock Expense",stock,"-"});   
       //delivery
       annualTansactions zzzz=new annualTansactions();
       double l=zzzz.delivery(pst, conn, rs, yrt);
       String deel=String.valueOf(l);
       model1.addRow(new Object[]{"Delivery Payment",deel,"-"});
       
       //utilites
       
       //electricity
        annualTansactions u=new annualTansactions();
        double e=u.electricity(pst, conn, rs, yrt);
        
        //water
        annualTansactions uu=new annualTansactions();
        double ee=uu.water(pst, conn, rs, yrt);
        
        //telephone
        annualTansactions uuu=new annualTansactions();
        double eee=uuu.telephone(pst, conn, rs, yrt);
        //rent
        annualTansactions uuuu=new annualTansactions();
        double eeee=uuuu.rent(pst, conn, rs,yrt);
        
        double utility=e+ee+eee+eeee;
        String uti=String.valueOf( utility);
        model1.addRow(new Object[]{"Utilities",uti,"-"});
        
        //otherexpense
        
        annualTansactions oE=new annualTansactions();
        double exp=oE.otherExpense(pst, conn, rs,yrt);
        String k=String.valueOf(exp);
        model1.addRow(new Object[]{"Other Expenses",k,"-"});
        
        //total expense
        double totalExp=exp+utility+l+q+rettDam+ssal;
        String expe=String.valueOf(totalExp);
        
        model1.addRow(new Object[]{"Total Expense","",expe});
        
         //profit
               double profitt=totalIncome-totalExp;
               String proo=Double.toString(profitt);
         model1.addRow(new Object[]{"","",""});
         model1.addRow(new Object[]{"","",""});
         model1.addRow(new Object[]{"PROFIT/LOSS","",proo});
         
         if(profitt>0){
          String strr = new String("(Profit)");
                  model1.addRow(new Object[]{"Status","",strr});
              
           }else{              
                 String strr = new String("(Loss)");
                  model1.addRow(new Object[]{"Status","",strr});
               }
         
    }
    

 
        
    
              
        
    }
    
    
    public void monthlyTransactions(){
    Date todayDate=new Date();
    SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
    String exdate=  Date_Format.format(todayDate);
    
      
    String[] part=exdate.split("-");
    String month=part[1];
    String year=part[0];
    String dd=part[2];
    Integer day=Integer.parseInt(dd);
    Integer intt=Integer.parseInt(month);
    Integer yrt=Integer.parseInt(year);
    Integer nextYR=yrt+1;
    String nextYear=String.valueOf(nextYR);
    //jLabel6.setText(year);
    //last year
    int lyr=yrt-1;
    String lastyear=String.valueOf(lyr);
    //previous month
    int premonth=intt -1;
    month mm=new month();
    String previousMonth=mm.month(premonth);
    
    //next month
    Integer nextMo=intt +1;
    month mmm=new month();
    String nextMonth=mmm.month(nextMo);
    
    month m=new month();
    String x=m.month(intt);

    //monthly profit and loss
     
    if(x.equals("January")){
        if(day==1){
            jLabel2.setText("End of "+previousMonth+"-"+lastyear+"  "); 
            try{
     String q="Select balance from month_trans where month='"+previousMonth+"' and year='"+lastyear+"'";
               pst=conn.prepareStatement(q);
               rs=pst.executeQuery();
             
               while(rs.next()){
               double bal=rs.getDouble("balance");
               
               String balance=Double.toString(bal);
                
               DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
               model.addRow(new Object[]{"INCOME","",""});
               model.addRow(new Object[]{"Current Balance",balance,"-"}); 
               
              
            
           String sql="SELECT elect,water,tele,rent,salary,ret_damage,stoc_expe,deliv,oth_exp,ret_inco,oth_inc FROM month_trans WHERE month='"+previousMonth+"' and year='"+lastyear+"'";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           
           while(rs.next()){
               double pcode=rs.getDouble("elect");
               double pname=rs.getDouble("water");
               double pduration=rs.getDouble("tele");
               double semfee=rs.getDouble("rent");
               double salary=rs.getDouble("salary");
               double retDam=rs.getDouble("ret_damage");
               double stock=rs.getDouble("stoc_expe");
               double deli=rs.getDouble("deliv");
               double OthEx=rs.getDouble("oth_exp");
               double retInc=rs.getDouble("ret_inco");
               double othInc=rs.getDouble("oth_inc");
               
               String sal=Double.toString(salary);
               String Retdma=Double.toString(retDam);
               String stoc=Double.toString(stock);
               String delivery=Double.toString(deli);
               String electricity=Double.toString(pcode);
               String water=Double.toString(pname);
               String tele=Double.toString(pduration);
               String rent=Double.toString(semfee);
               String expe=Double.toString(OthEx);
               String retIncc=Double.toString(retInc);
               String otheInc=Double.toString(othInc);
               
                //total income
               double income=bal+retInc+othInc;
               String totIncome=Double.toString(income);
               
                //total expense
               double expense=pcode+pname+pduration+semfee+salary+retDam+stock+deli+OthEx;
               String totExpense=Double.toString(expense);
               
                //profit
               double profit=income-expense;
               String pro=Double.toString(profit);
               
               model.addRow(new Object[]{"Retailer Income",retIncc,"-"});
               model.addRow(new Object[]{"Other Income",otheInc,"-"});
               model.addRow(new Object[]{"Total Income","",totIncome});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"EXPENSE","",""});
               model.addRow(new Object[]{"Employee Salary",sal,"-"});
               model.addRow(new Object[]{"Retailer Damage",Retdma,"-"});
               model.addRow(new Object[]{"Stock Expense",stoc,"-"});
               model.addRow(new Object[]{"Delivery Payment",delivery,"-"});
               model.addRow(new Object[]{"Electricity Bill",electricity,"-"});
               model.addRow(new Object[]{"Water Bill",water,"-"});
               model.addRow(new Object[]{"Telephone Bill",tele,"-"});
               model.addRow(new Object[]{"Company Rent",rent,"-"});
               model.addRow(new Object[]{"Other Expenses",expe,"-"});
               model.addRow(new Object[]{"Total Expense","",totExpense});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"PROFIT/LOSS","",pro});
               
               if(profit>0){
                 String str = new String("(Profit)");
                  model.addRow(new Object[]{"Status","",str});
              
               }else{              
                 String str = new String("(Loss)");
                      model.addRow(new Object[]{"Status","",str});
               }
                
           try{
          String wq="INSERT INTO month_trans(year,month,elect,water,tele,rent,salary,ret_damage,stoc_expe,deliv,oth_exp,ret_inco,oth_inc,tot_income,tot_expense,balance) values ('"+year+"','"+x+"','0','0','0','0','0','0','0','0','0','0','0','0','0','"+pro+"')";
          pst= conn.prepareStatement(wq);
          pst.execute();
        }catch(Exception e){
                System.out.println(e);
        }}
               }}catch(Exception e){
                System.out.println(e);
        }
        }
        
        
        else{
             jLabel2.setText(" "+x+"-"+year+"  ");
                      try{
     String q="Select balance from month_trans where month='"+x+"' and year='"+year+"'";
               pst=conn.prepareStatement(q);
               rs=pst.executeQuery();
             
               while(rs.next()){
               double bal=rs.getDouble("balance");
               
               String balance=Double.toString(bal);
                
               DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
               model.addRow(new Object[]{"INCOME","",""});
               model.addRow(new Object[]{"Current Balance",balance,"-"}); 
               
              
            
           String sql="SELECT elect,water,tele,rent,salary,ret_damage,stoc_expe,deliv,oth_exp,ret_inco,oth_inc FROM month_trans WHERE month='"+x+"' and year='"+year+"'";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           
           while(rs.next()){
               double pcode=rs.getDouble("elect");
               double pname=rs.getDouble("water");
               double pduration=rs.getDouble("tele");
               double semfee=rs.getDouble("rent");
               double salary=rs.getDouble("salary");
               double retDam=rs.getDouble("ret_damage");
               double stock=rs.getDouble("stoc_expe");
               double deli=rs.getDouble("deliv");
               double OthEx=rs.getDouble("oth_exp");
               double retInc=rs.getDouble("ret_inco");
               double othInc=rs.getDouble("oth_inc");
               
               String sal=Double.toString(salary);
               String Retdma=Double.toString(retDam);
               String stoc=Double.toString(stock);
               String delivery=Double.toString(deli);
               String electricity=Double.toString(pcode);
               String water=Double.toString(pname);
               String tele=Double.toString(pduration);
               String rent=Double.toString(semfee);
               String expe=Double.toString(OthEx);
               String retIncc=Double.toString(retInc);
               String otheInc=Double.toString(othInc);
               
                //total income
               double income=bal+retInc+othInc;
               String totIncome=Double.toString(income);
               
                //total expense
               double expense=pcode+pname+pduration+semfee+salary+retDam+stock+deli+OthEx;
               String totExpense=Double.toString(expense);
               
                //profit
               double profit=income-expense;
               String pro=Double.toString(profit);
               
               model.addRow(new Object[]{"Retailer Income",retIncc,"-"});
               model.addRow(new Object[]{"Other Income",otheInc,"-"});
               model.addRow(new Object[]{"Total Income","",totIncome});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"EXPENSE","",""});
               model.addRow(new Object[]{"Employee Salary",sal,"-"});
               model.addRow(new Object[]{"Retailer Damage",Retdma,"-"});
               model.addRow(new Object[]{"Stock Expense",stoc,"-"});
               model.addRow(new Object[]{"Delivery Payment",delivery,"-"});
               model.addRow(new Object[]{"Electricity Bill",electricity,"-"});
               model.addRow(new Object[]{"Water Bill",water,"-"});
               model.addRow(new Object[]{"Telephone Bill",tele,"-"});
               model.addRow(new Object[]{"Company Rent",rent,"-"});
               model.addRow(new Object[]{"Other Expenses",expe,"-"});
               model.addRow(new Object[]{"Total Expense","",totExpense});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"PROFIT/LOSS","",pro});
               
               if(profit>0){
                 String str = new String("(Profit)");
                  model.addRow(new Object[]{"Status","",str});
              
               }else{              
                 String str = new String("(Loss)");
                      model.addRow(new Object[]{"Status","",str});
               }
               
        }
               }
                      }catch(Exception ea){
                
                }
  
        }}
    else{
        if(day==1){
             jLabel2.setText("End of "+previousMonth+"-"+year+"  "); 
             try{
     String q="Select balance from month_trans where month='"+previousMonth+"' and year='"+year+"'";
               pst=conn.prepareStatement(q);
               rs=pst.executeQuery();
             
               while(rs.next()){
               double bal=rs.getDouble("balance");
               
               String balance=Double.toString(bal);
                
               DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
               model.addRow(new Object[]{"INCOME","",""});
               model.addRow(new Object[]{"Current Balance",balance,"-"}); 
               
              
            
           String sql="SELECT elect,water,tele,rent,salary,ret_damage,stoc_expe,deliv,oth_exp,ret_inco,oth_inc FROM month_trans WHERE month='"+previousMonth+"' and year='"+year+"'";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           
           while(rs.next()){
               double pcode=rs.getDouble("elect");
               double pname=rs.getDouble("water");
               double pduration=rs.getDouble("tele");
               double semfee=rs.getDouble("rent");
               double salary=rs.getDouble("salary");
               double retDam=rs.getDouble("ret_damage");
               double stock=rs.getDouble("stoc_expe");
               double deli=rs.getDouble("deliv");
               double OthEx=rs.getDouble("oth_exp");
               double retInc=rs.getDouble("ret_inco");
               double othInc=rs.getDouble("oth_inc");
               
               String sal=Double.toString(salary);
               String Retdma=Double.toString(retDam);
               String stoc=Double.toString(stock);
               String delivery=Double.toString(deli);
               String electricity=Double.toString(pcode);
               String water=Double.toString(pname);
               String tele=Double.toString(pduration);
               String rent=Double.toString(semfee);
               String expe=Double.toString(OthEx);
               String retIncc=Double.toString(retInc);
               String otheInc=Double.toString(othInc);
               
                //total income
               double income=bal+retInc+othInc;
               String totIncome=Double.toString(income);
               
                //total expense
               double expense=pcode+pname+pduration+semfee+salary+retDam+stock+deli+OthEx;
               String totExpense=Double.toString(expense);
               
                //profit
               double profit=income-expense;
               String pro=Double.toString(profit);
               
               model.addRow(new Object[]{"Retailer Income",retIncc,"-"});
               model.addRow(new Object[]{"Other Income",otheInc,"-"});
               model.addRow(new Object[]{"Total Income","",totIncome});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"EXPENSE","",""});
               model.addRow(new Object[]{"Employee Salary",sal,"-"});
               model.addRow(new Object[]{"Retailer Damage",Retdma,"-"});
               model.addRow(new Object[]{"Stock Expense",stoc,"-"});
               model.addRow(new Object[]{"Delivery Payment",delivery,"-"});
               model.addRow(new Object[]{"Electricity Bill",electricity,"-"});
               model.addRow(new Object[]{"Water Bill",water,"-"});
               model.addRow(new Object[]{"Telephone Bill",tele,"-"});
               model.addRow(new Object[]{"Company Rent",rent,"-"});
               model.addRow(new Object[]{"Other Expenses",expe,"-"});
               model.addRow(new Object[]{"Total Expense","",totExpense});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"PROFIT/LOSS","",pro});
               
               if(profit>0){
                 String str = new String("(Profit)");
                  model.addRow(new Object[]{"Status","",str});
              
               }else{              
                 String str = new String("(Loss)");
                      model.addRow(new Object[]{"Status","",str});
               }
                
           try{
          String wq="INSERT INTO month_trans(year,month,elect,water,tele,rent,salary,ret_damage,stoc_expe,deliv,oth_exp,ret_inco,oth_inc,tot_income,tot_expense,balance) values ('"+year+"','"+x+"','0','0','0','0','0','0','0','0','0','0','0','0','0','"+pro+"')";
          pst= conn.prepareStatement(wq);
          pst.execute();
        }catch(Exception e){
                System.out.println(e);
        }}
               }}catch(Exception e){
                System.out.println(e);
        }
        
        }else{
            jLabel2.setText(" "+x+"-"+year+"  ");
                             try{
     String q="Select balance from month_trans where month='"+x+"' and year='"+year+"'";
               pst=conn.prepareStatement(q);
               rs=pst.executeQuery();
             
               while(rs.next()){
               double bal=rs.getDouble("balance");
               
               String balance=Double.toString(bal);
                
               DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
               model.addRow(new Object[]{"INCOME","",""});
               model.addRow(new Object[]{"Current Balance",balance,"-"}); 
               
              
            
           String sql="SELECT elect,water,tele,rent,salary,ret_damage,stoc_expe,deliv,oth_exp,ret_inco,oth_inc FROM month_trans WHERE month='"+x+"' and year='"+year+"'";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           
           while(rs.next()){
               double pcode=rs.getDouble("elect");
               double pname=rs.getDouble("water");
               double pduration=rs.getDouble("tele");
               double semfee=rs.getDouble("rent");
               double salary=rs.getDouble("salary");
               double retDam=rs.getDouble("ret_damage");
               double stock=rs.getDouble("stoc_expe");
               double deli=rs.getDouble("deliv");
               double OthEx=rs.getDouble("oth_exp");
               double retInc=rs.getDouble("ret_inco");
               double othInc=rs.getDouble("oth_inc");
               
               String sal=Double.toString(salary);
               String Retdma=Double.toString(retDam);
               String stoc=Double.toString(stock);
               String delivery=Double.toString(deli);
               String electricity=Double.toString(pcode);
               String water=Double.toString(pname);
               String tele=Double.toString(pduration);
               String rent=Double.toString(semfee);
               String expe=Double.toString(OthEx);
               String retIncc=Double.toString(retInc);
               String otheInc=Double.toString(othInc);
               
                //total income
               double income=bal+retInc+othInc;
               String totIncome=Double.toString(income);
               
                //total expense
               double expense=pcode+pname+pduration+semfee+salary+retDam+stock+deli+OthEx;
               String totExpense=Double.toString(expense);
               
                //profit
               double profit=income-expense;
               String pro=Double.toString(profit);
               
               model.addRow(new Object[]{"Retailer Income",retIncc,"-"});
               model.addRow(new Object[]{"Other Income",otheInc,"-"});
               model.addRow(new Object[]{"Total Income","",totIncome});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"EXPENSE","",""});
               model.addRow(new Object[]{"Employee Salary",sal,"-"});
               model.addRow(new Object[]{"Retailer Damage",Retdma,"-"});
               model.addRow(new Object[]{"Stock Expense",stoc,"-"});
               model.addRow(new Object[]{"Delivery Payment",delivery,"-"});
               model.addRow(new Object[]{"Electricity Bill",electricity,"-"});
               model.addRow(new Object[]{"Water Bill",water,"-"});
               model.addRow(new Object[]{"Telephone Bill",tele,"-"});
               model.addRow(new Object[]{"Company Rent",rent,"-"});
               model.addRow(new Object[]{"Other Expenses",expe,"-"});
               model.addRow(new Object[]{"Total Expense","",totExpense});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"","",""});
               model.addRow(new Object[]{"PROFIT/LOSS","",pro});
               
               if(profit>0){
                 String str = new String("(Profit)");
                  model.addRow(new Object[]{"Status","",str});
              
               }else{              
                 String str = new String("(Loss)");
                      model.addRow(new Object[]{"Status","",str});
               }
               
        }
               }
                      }catch(Exception ea){
                
                }
  
        }
    
    
    }

    
    
    
//     try{
//     String q="Select balance from month_trans where month='"+previousMonth+"'";
//               pst=conn.prepareStatement(q);
//               rs=pst.executeQuery();
//             
//               while(rs.next()){
//               double bal=rs.getDouble("balance");
//               
//               String balance=Double.toString(bal);
//                
//               DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
//               model.addRow(new Object[]{"INCOME","",""});
//               model.addRow(new Object[]{"Current Balance",balance,"-"}); 
//               
//              
//            
//           String sql="SELECT elect,water,tele,rent,salary,ret_damage,stoc_expe,deliv,oth_exp,ret_inco,oth_inc FROM month_trans WHERE month='"+previousMonth+"'";
//           pst=conn.prepareStatement(sql);
//           rs=pst.executeQuery();
//           
//           while(rs.next()){
//               double pcode=rs.getDouble("elect");
//               double pname=rs.getDouble("water");
//               double pduration=rs.getDouble("tele");
//               double semfee=rs.getDouble("rent");
//               double salary=rs.getDouble("salary");
//               double retDam=rs.getDouble("ret_damage");
//               double stock=rs.getDouble("stoc_expe");
//               double deli=rs.getDouble("deliv");
//               double OthEx=rs.getDouble("oth_exp");
//               double retInc=rs.getDouble("ret_inco");
//               double othInc=rs.getDouble("oth_inc");
//               
//               String sal=Double.toString(salary);
//               String Retdma=Double.toString(retDam);
//               String stoc=Double.toString(stock);
//               String delivery=Double.toString(deli);
//               String electricity=Double.toString(pcode);
//               String water=Double.toString(pname);
//               String tele=Double.toString(pduration);
//               String rent=Double.toString(semfee);
//               String expe=Double.toString(OthEx);
//               String retIncc=Double.toString(retInc);
//               String otheInc=Double.toString(othInc);
//               
//                //total income
//               double income=bal+retInc+othInc;
//               String totIncome=Double.toString(income);
//               
//                //total expense
//               double expense=pcode+pname+pduration+semfee+salary+retDam+stock+deli+OthEx;
//               String totExpense=Double.toString(expense);
//               
//                //profit
//               double profit=income-expense;
//               String pro=Double.toString(profit);
//               
//               model.addRow(new Object[]{"Retailer Income",retIncc,"-"});
//               model.addRow(new Object[]{"Other Income",otheInc,"-"});
//               model.addRow(new Object[]{"Total Income","",totIncome});
//               model.addRow(new Object[]{"","",""});
//               model.addRow(new Object[]{"EXPENSE","",""});
//               model.addRow(new Object[]{"Employee Salary",sal,"-"});
//               model.addRow(new Object[]{"Retailer Damage",Retdma,"-"});
//               model.addRow(new Object[]{"Stock Expense",stoc,"-"});
//               model.addRow(new Object[]{"Delivery Payment",delivery,"-"});
//               model.addRow(new Object[]{"Electricity Bill",electricity,"-"});
//               model.addRow(new Object[]{"Water Bill",water,"-"});
//               model.addRow(new Object[]{"Telephone Bill",tele,"-"});
//               model.addRow(new Object[]{"Company Rent",rent,"-"});
//               model.addRow(new Object[]{"Other Expenses",expe,"-"});
//               model.addRow(new Object[]{"Total Expense","",totExpense});
//               model.addRow(new Object[]{"","",""});
//               model.addRow(new Object[]{"","",""});
//               model.addRow(new Object[]{"PROFIT/LOSS","",pro});
//               
//               if(profit>0){
//                 String str = new String("(Profit)");
//                  model.addRow(new Object[]{"Status","",str});
//              
//               }else{              
//                 String str = new String("(Loss)");
//                      model.addRow(new Object[]{"Status","",str});
//               }
//                
//            
//              
//              
//            
//                
//            if(day==1){
//            try{
//          String wq="INSERT INTO month_trans(year,month,elect,water,tele,rent,salary,ret_damage,stoc_expe,deliv,oth_exp,ret_inco,oth_inc,tot_income,tot_expense,balance) values ('"+year+"','"+x+"','0','0','0','0','0','0','0','0','0','0','0','0','0','"+pro+"')";
//          pst= conn.prepareStatement(wq);
//          pst.execute();
//        }catch(Exception e){
//                System.out.println(e);
//        }
//            }else{
//                
//            }
//           
//            }
//               }}catch(Exception e){
//                System.out.println(e);
//        }
           
                   
               
         
            }
          
         
     
//     
            
     
    
    
    
               


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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(827, 559));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(827, 559));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(827, 559));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Profit and Loss for the");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Amount(Rs)", "Total(Rs)"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Direct To Door");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel3)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Monthly Profit and Loss", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(827, 559));

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Amount(Rs)", "Total(Rs)"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Direct To Door");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Annual Profit and Loss");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        jTabbedPane1.addTab("Annual Profit and Loss", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
