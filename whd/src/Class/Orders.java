
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
import javax.swing.JOptionPane;




/**
 *
 * @author Mudara Bandaranayake
 */
public class Orders {
    private String Ordid;
   
    public String getord_id() {
        return Ordid;
    }
     public void setord_id(String Ordids) {
       this.Ordid = Ordids;
    }
    Connection conn = null;
    Statement statement = null;
    ResultSet result=null;
    ResultSet result1=null;
    ResultSet result2=null;
    PreparedStatement prpdStmt = null;
    public static void main(String[] args) {
         
     }
    public ResultSet getOrders(){
        try {
            conn = DBconnecter.connect();
            String sql = "SELECT distinct "
            + "ord_id FROM order_1 WHERE status ='NotProcessed' ORDER BY ord_date";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Get Orders.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    public void removeOrder(String oid){
        try {
            conn = DBconnecter.connect();
            statement = conn.createStatement();
            String sql = "DELETE FROM order_1 WHERE ord_id ='"+oid+"'";
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"One or more Records will be Deleted.","Action Successful",
            JOptionPane.PLAIN_MESSAGE);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Perform Delete Action.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    public ResultSet search(String oid){
        try {
            conn = DBconnecter.connect();
            String sql = "SELECT ord_id AS OrderID, prod_id AS ProductID,supp_id AS SupplierID, ret_id AS RetailerID, ord_date AS OrderDate,qty AS Quantity,status AS Status FROM order_1 WHERE ord_id ='"+oid+"'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);   
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Search Orders.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    public ResultSet searchAll(){
        try {
            conn = DBconnecter.connect();
            String sql = "SELECT ord_id AS OrderID, prod_id AS ProductID,supp_id AS SupplierID, ret_id AS RetailerID, ord_date AS OrderDate,qty AS Quantity,status AS Status FROM order_1";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);   
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Search All Records.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
     
        return result;
    }
    public ResultSet calculatePayment(String oid){
        try {
            conn = DBconnecter.connect();
            String sql ="Select SUM(total) FROM order_1 WHERE ord_id='"+oid+"' AND status='Processed'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Calculate Order Total.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    public ResultSet generatePo(String oid){
        try {
            conn = DBconnecter.connect();
            String sql ="Select o.prod_id,p.prod_name,o.qty,p.mrp,p.sell_price,o.total FROM order_1 o,product p WHERE p.prod_id=o.prod_id AND o.ord_id='"+oid+"' AND status='Processed'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Generate Purchase Order.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    public ResultSet checkAvailability(String oid){
        try {
            conn = DBconnecter.connect();
            String sql ="SELECT o.prod_id,o.prod_name,o.qty,p.quantity,p.rol,p.size_1,p.supp_id,p.comp_name FROM order_1 o,product p WHERE o.prod_id=p.prod_id AND o.qty>p.quantity AND ord_id='"+oid+"'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
            JOptionPane.showMessageDialog(null,"Checked Availability.","Action Successful",
            JOptionPane.PLAIN_MESSAGE);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Check Availability.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
         return result;
    }
    public ResultSet getAvailable(String oid){
        try {
            conn = DBconnecter.connect();
            String sql ="SELECT o.prod_id,o.prod_name,o.qty,p.rol,p.size_1,p.supp_id,p.comp_name FROM order_1 o,product p WHERE o.prod_id=p.prod_id AND o.qty<=p.quantity AND ord_id='"+oid+"'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
            
        }
        catch (SQLException se) {
            se.printStackTrace();
            System.out.println("Error in getAvailable");
            JOptionPane.showMessageDialog(null,"Couldn't Get Available Orders.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
         return result;
    }
    public void updateOrderstatus(String oid){
        try {
        conn = DBconnecter.connect();
        String sql = "update order_1 set status=? where ord_id='"+oid+"'";
        prpdStmt = conn.prepareStatement(sql);
        prpdStmt.setString (1, "Processed");
        prpdStmt.executeUpdate();
        } 
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Update Order Status.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }   
    }
 
    public ResultSet findSupplier(String oid){
        try {
            conn = DBconnecter.connect();
            String sql ="Select distinct s.supp_address,s.comp_name FROM supplier s,order_1 o WHERE o.supp_id=s.supp_id AND o.ord_id ='"+oid+"'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Find Supplier.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    public void reduceInventory(String oid,String pid){
        int sqty=0;
        int nqty=0;
        try {
            conn = DBconnecter.connect();
            String sql ="Select prod_id,qty from order_1 where ord_id='"+oid+"' AND prod_id='"+pid+"'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
            while(result.next()){
                String prod_id=result.getString("prod_id");
                int oqty=result.getInt("qty");
                String sql1 ="Select quantity FROM product WHERE prod_id='"+prod_id+"'";
                statement = conn.createStatement();
                result1=statement.executeQuery(sql1);
                while(result1.next()){
                    sqty=result1.getInt("quantity");
                    nqty=(sqty-oqty);
                    String sql3 = "update product set quantity=? where prod_id='"+prod_id+"'";
                    prpdStmt = conn.prepareStatement(sql3);
                    prpdStmt.setInt (1, nqty);
                    prpdStmt.executeUpdate();
                    }
            }
        }
        catch (SQLException se) {
                    se.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Couldn't Reduce Inventory.","Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    public void insertOrderdetails(String oid,Double tot){
        try { 
            conn = DBconnecter.connect();
            String sql = " insert into order_details (ord_id,total,upd_total)"
            + " values (?, ?, ?)";
            prpdStmt = conn.prepareStatement(sql);
            prpdStmt.setString (1, oid);
            prpdStmt.setDouble(2,tot);
            prpdStmt.setDouble(3,tot);
            prpdStmt.execute();
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("Couldn't insert Order Details");
            JOptionPane.showMessageDialog(null,"Couldn't Insert Order Details.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }    
    }
    public ResultSet checkReorder(String oid){
        try {
            conn = DBconnecter.connect();
            String sql ="SELECT o.prod_id,o.prod_name,p.quantity,p.size_1,p.supp_id,p.comp_name,p.rol FROM order_1 o,product p WHERE o.prod_id=p.prod_id AND p.quantity<=p.rol AND ord_id='"+oid+"'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
            
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Check Reorder.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
     public void insertReorder(String rid,String pid,String pname,int rol,String size,String sid,String cname,Date cdate){
        try { 
           conn = DBconnecter.connect();
           String sql = " insert into reorder (reor_id,prod_id,prod_name,quantity,size_1,supp_id,comp_name,reor_date)"
           + " values (?, ?, ?, ?, ?, ?, ?, ?)";
           prpdStmt = conn.prepareStatement(sql);
           prpdStmt.setString (1,rid);
           prpdStmt.setString (2,pid);
           prpdStmt.setString(3,pname);
           prpdStmt.setInt(4,rol);
           prpdStmt.setString(5,size);
           prpdStmt.setString(6,sid);
           prpdStmt.setString(7,cname);
           prpdStmt.setDate(8,new java.sql.Date(cdate.getTime()));
           prpdStmt.execute();
           JOptionPane.showMessageDialog(null,"Product  " +pname+"  "+size+"  will be Reordered.","Action Successful",
                JOptionPane.PLAIN_MESSAGE);
      
        } 
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Insert Reorder.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }    
    }
     public void updateReorder(String pid,String oid){
        try {
            conn = DBconnecter.connect();
            String sql = "update order_1 set status=? where prod_id='"+pid+"' AND ord_id='"+oid+"'";
            prpdStmt = conn.prepareStatement(sql);
            prpdStmt.setString (1, "Stocksout");
            prpdStmt.executeUpdate();
        } 
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Update Reorder.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }   
     } 
     public int checkReorderdate(String pid,Date cdate){
        int period=0;
        try {
            conn = DBconnecter.connect();
            String sql  ="SELECT * from reorder WHERE prod_id='"+pid+"'";
            statement = conn.createStatement();
            result=statement.executeQuery(sql);
            if (!result.isBeforeFirst() ) {    
                period=20;
            }
            else{
            String sql1 ="SELECT MAX(reor_date) from reorder WHERE prod_id='"+pid+"'";
            statement= conn.createStatement();
            result1=statement.executeQuery(sql1);
            while(result1.next()){
                Date maxrdate=result1.getDate("MAX(reor_date)");
                String sql2 ="SELECT DATEDIFF('"+cdate+"', '"+maxrdate+"') AS DateDiff";
                statement= conn.createStatement();
                result2=statement.executeQuery(sql2);
                while(result2.next()){
                    period=result2.getInt("DateDiff");
                }
            }
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't check reorder date.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return period; 
     }
}
    
    

    
