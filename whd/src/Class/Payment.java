
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import warehouse.panelSupppayment;


/**
 *
 * @author Mudara Bandaranayake
 */
public class Payment {
    
    private int Suppayid;
    private String Suppid;
    private String Stocid;
    private double Amount;
    private Date Pduedate;
    private Date Paiddate;
    private double Commission;
    private double Paidamount;
    private double Payremain;
    Connection conn = null;
    Statement statement = null;
    ResultSet result=null;
    ResultSet result1=null;
    ResultSet result2=null;
    PreparedStatement prpdStmt = null;
    public int getsuppay_id() {
        return Suppayid;
    }
    public String getsupp_id() {
        return Suppid;
    }
    public String getstoc_id() {
        return Stocid;
    }
    public double getamount() {
        return Amount;
    }
    public Date getpdue_date() {
        return Pduedate;
    }
    public Date getpaid_date() {
        return Paiddate;
    }
    public double getcommission() {
        return Commission;
    }
    public double getpaid_amount() {
        return Paidamount;
    }
    public double getpay_remain() {
        return Payremain;
    }
    public void setsuppay_id(int Suppayids) {
       this.Suppayid = Suppayids;
    }
     public void setsupp_id(String Suppids) {
       this.Suppid = Suppids;
    }
     public void setstoc_id(String Stocids) {
       this.Stocid= Stocids;
    }
     public void setamount(double Amounts) {
       this.Amount = Amounts;
    }
     public void setpdue_date(Date Pduedates) {
       this.Pduedate= Pduedates;
    }
    public void setpaid_date(Date Paiddates) {
       this.Paiddate = Paiddates;
    }
     public void setcommission(double Commissions) {
       this.Commission = Commissions;
    }
     public void setpaid_amount(double Paidamount) {
       this.Paidamount = Paidamount;
    }
     public void setpay_remain(double Payremains) {
       this.Payremain= Payremains;
    }
    public static void main(String[] args) {
         
     }
    public ResultSet getStocks(){
        try {
            conn = DBconnecter.connect();
            String sql = "SELECT stoc_id FROM stock WHERE stoc_id NOT IN (SELECT stoc_id FROM suppayment WHERE pay_status='Complete')";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Get StockID.","Warning",
                JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("filled records of the table...");
        return result;
    }
    public boolean showLabel (String stoid){
        boolean bool = false;
        try {
            conn = DBconnecter.connect();
            String sql = "SELECT distinct stoc_id FROM suppayment WHERE pay_status='Pending'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
            while(result.next()){
                String stocid  = result.getString("stoc_id");
                if(stocid.equals(stoid)){
                bool=true;
                break;
                }
                else{
                bool=false;
                }
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Show On Label.","Warning",
                JOptionPane.WARNING_MESSAGE);
        } 
        return bool;   
    }
    public void update(String stoid){
        try {
                conn = DBconnecter.connect();
                String sql = "update suppayment set pdue_date=?,paid_date=?,paid_amount= ?,pay_remain=? where stoc_id='"+stoid+"'";
                prpdStmt = conn.prepareStatement(sql);     
                prpdStmt.setDate (1,new java.sql.Date(Pduedate.getTime()));
                prpdStmt.setDate (2,new java.sql.Date(Paiddate.getTime()));
                prpdStmt.setDouble (3, Paidamount);
                prpdStmt.setDouble (4, Payremain);
                prpdStmt.execute();
                JOptionPane.showMessageDialog(null,"Record Updated Successfully.","Action Successful",
                JOptionPane.PLAIN_MESSAGE);
        } 
        catch (SQLException se) {
                se.printStackTrace();
                JOptionPane.showMessageDialog(null,"Couldn't Update.","Warning",
                JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("Updated records into the table...");    
    }
    public ResultSet search(String stoid){
        try {
                conn = DBconnecter.connect(); 
                String sql = "SELECT suppay_id AS PayID,supp_id AS SupplierID,amount AS Total,pdue_date AS DueDate,paid_date AS PaidDate,commission AS Comission,paid_amount AS PaidAmount,pay_status AS Status FROM suppayment WHERE stoc_id ='"+stoid+"'";
                statement = conn.createStatement();
                result=statement.executeQuery(sql);
        }
        catch (SQLException se) {
                se.printStackTrace();
                JOptionPane.showMessageDialog(null,"Couldn't Search.","Warning",
                JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("Searched records of the table...");
        return result;
    }
    public void remove(String stoid){
        try {
            conn = DBconnecter.connect();
            statement = conn.createStatement();
            String sql = "DELETE FROM suppayment WHERE stoc_id='"+stoid+"'";
            statement.executeUpdate(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Perform Action.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    public ResultSet searchAll(){
        try {
            conn = DBconnecter.connect();     
            String sql = "SELECT suppay_id AS PayID,supp_id AS SupplierID,amount AS Total,pdue_date AS DueDate,paid_date AS PaidDate,commission AS Comission,paid_amount AS PaidAmount,pay_status AS Status FROM suppayment";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Search All Records.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("Searched records of the table...");
        return result;
    }
    public void findAmount(String stoid){
        double supptotal=0;
        double disttotal=0;
        double commission=0;
        Date pduedate=findDate(stoid);
        try{
            conn = DBconnecter.connect();
            String sql = "Select st.prod_id,p.supp_id from product p,stock st WHERE st.prod_id=p.prod_id AND  st.stoc_id = '" + stoid + "'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
            try {
                while(result.next()){
                    String prodid  = result.getString("st.prod_id");
                    String suppid  = result.getString("p.supp_id");
                    String sql1 = "Select s.quantity,p.buy_price,p.sell_price from stock s,product p where s.prod_id=p.prod_id AND s.prod_id = '" + prodid + "' AND s.stoc_id='"+stoid+"'";
                    statement = conn.createStatement();
                    result1=statement.executeQuery(sql1);
                    while(result1.next()){
                        int stockqty = result1.getInt("s.quantity");
                        double unitprice = result1.getDouble("p.buy_price");
                        double sellprice = result1.getDouble("p.sell_price");
                        double suppcost=(stockqty*unitprice);
                        double distcost=(stockqty*sellprice);
                        supptotal=(supptotal+suppcost);
                        disttotal=(disttotal+distcost);
                    }
                commission=(disttotal-supptotal);
                try { 
                conn = DBconnecter.connect();
                String sql2 = " insert into suppayment (supp_id,stoc_id,amount,pdue_date,commission,pay_remain)"
                + " values (?,?,?,?,?,?)";
                prpdStmt = conn.prepareStatement(sql2);     
                prpdStmt.setString (1, suppid);
                prpdStmt.setString (2, stoid);
                prpdStmt.setDouble (3, supptotal);
                prpdStmt.setDate (4, new java.sql.Date(pduedate.getTime()));
                prpdStmt.setDouble (5, commission);
                prpdStmt.setDouble (6, supptotal);
                prpdStmt.execute();    
        }
        catch (SQLException se) {
                se.printStackTrace();
                JOptionPane.showMessageDialog(null,"Couldn't Find Amount.","Warning",
                JOptionPane.WARNING_MESSAGE);
        }
        }    
        } catch (SQLException ex) {
            Logger.getLogger(panelSupppayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        }catch(Exception e){
            System.out.println(e);
        }
        }
    public Date findDate(String stoid){
        try{
            conn = DBconnecter.connect();
            statement = conn.createStatement();
            String sql = "SELECT st.rece_date,s.supp_id FROM stock st,supplier s,product p WHERE st.prod_id=p.prod_id AND p.supp_id=s.supp_id AND stoc_id='"+stoid+"'";
            result = statement.executeQuery(sql);
                while(result.next()){
                    Date recedate = result.getDate("st.rece_date");
                    String suppid=result.getString("s.supp_id");
                    conn = DBconnecter.connect();
                    statement = conn.createStatement();
                    String sql1 = "SELECT supp_paydays FROM supplier WHERE supp_id='"+suppid+"'";
                    result1 = statement.executeQuery(sql1);
                        while(result1.next()){
                            String supppaydays = result1.getString("supp_paydays");
                            conn = DBconnecter.connect();
                            statement = conn.createStatement();
                            String sql2 = "SELECT DATE_ADD('"+recedate+"', INTERVAL "+supppaydays+" DAY) AS pdue_date";
                            result2 = statement.executeQuery(sql2);
                            while(result2.next()){
                                Date pduedate = result2.getDate("pdue_date");
                                setpdue_date(pduedate);
                            }
                        }
                }
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Find Date.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return Pduedate;
    } 
    
    public ResultSet loadData(String stoid){
        try{
            conn = DBconnecter.connect();
            statement = conn.createStatement();
            String sql = "SELECT suppay_id,supp_id,stoc_id,amount,pdue_date,commission,pay_remain FROM suppayment where stoc_id='"+stoid+"'";
            result = statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Load Data.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    public ResultSet viewCompleted(){
        try {
            conn = DBconnecter.connect();
            String sql ="Select distinct stoc_id AS StockID,pdue_date AS DueDate,pay_status AS Status FROM suppayment WHERE pay_status='Complete'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't View Completed.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("Viewed Not Processed...");
        return result;
    } 
    public void updatePaystatus(String stoid){
        try {
            conn = DBconnecter.connect();
            String sql = "update suppayment set pay_status=? where stoc_id='"+stoid+"'";
            prpdStmt = conn.prepareStatement(sql);
            prpdStmt.setString (1, "Complete");
            prpdStmt.executeUpdate();
        } 
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Update Payment Status.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
     System.out.println("Updated status into the table..."+stoid);
    }
    public void updateExtrapaid(String sid,double epaid){
        try {
                conn = DBconnecter.connect();
                String sql = "update supplier set ex_paid=? where supp_id='"+sid+"'";
                prpdStmt = conn.prepareStatement(sql);     
                prpdStmt.setDouble (1,epaid);
                prpdStmt.execute();
                JOptionPane.showMessageDialog(null,"Record Updated Successfully.","Action Successful",
                JOptionPane.PLAIN_MESSAGE);
        } 
        catch (SQLException se) {
                se.printStackTrace();
                JOptionPane.showMessageDialog(null,"Couldn't Update Extra Payment.","Warning",
                JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("Updated records into the table...");    
    }
    public double getExtrapaid(String sid){
        double expaid=0;
        try {
            conn = DBconnecter.connect();
            String sql ="SELECT ex_paid FROM supplier WHERE supp_id='"+sid+"'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
            while(result.next()){
                expaid=result.getDouble("ex_paid");
            }
        } 
        catch (SQLException se) {
                se.printStackTrace();
                JOptionPane.showMessageDialog(null,"Couldn't Get Extra Payment.","Warning",
                JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("Got Extrapaid...");
        return expaid;
    }
    public int getDuration(Date cdate,Date pddate){
        int duration=0;
        try {
            conn = DBconnecter.connect();
            String sql="SELECT DATEDIFF('"+pddate+"', '"+new java.sql.Date(cdate.getTime())+"') AS DateDiff";
            statement= conn.createStatement();
            result=statement.executeQuery(sql);
            while(result.next()){
                    duration=result.getInt("DateDiff");
                    System.out.println(duration);
                }
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Get Duration.","Warning",
                JOptionPane.WARNING_MESSAGE);
            System.out.println("Error in supDate");
        }
        return duration;
    }
}