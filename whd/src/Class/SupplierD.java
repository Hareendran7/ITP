/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
/**
 *
 * @author Mudara Bandaranayake
 */
public class SupplierD {
    private String Suppid;
    private String Compname;
    private String Suppaddress;
    private String Suppcontact;
    private String Suppname;
    private String Suppmail;
    private String Supppaydays;
    Connection conn=null;
    Statement statement = null;
    ResultSet result = null;
    PreparedStatement prpdStmt=null;
    
    
    public String getsupp_id() {
        return Suppid;
    }
    public String getcomp_name() {
        return Compname;
    }
    public String getsupp_address() {
        return Suppaddress;
    }
    public String getsupp_contact() {
        return Suppcontact;
    }
    public String getsupp_name() {
        return Suppname;
    }
    public String getsupp_mail() {
        return Suppmail;
    }
    public String getsupp_paydays() {
        return Supppaydays;
    }
     public void setsupp_id(String Suppids) {
       this.Suppid = Suppids;
    }
     public void setcomp_name(String Compnames) {
       this.Compname = Compnames;
    }
     public void setsupp_address(String Suppaddresss) {
       this.Suppaddress = Suppaddresss;
    }
     public void setsupp_contact(String Suppcontacts) {
       this.Suppcontact = Suppcontacts;
    }
     public void setsupp_name(String Suppnames) {
       this.Suppname = Suppnames;
    }
     public void setsupp_mail(String Suppmails) {
       this.Suppmail = Suppmails;
    }
     public void setsupp_paydays(String Supppaydayss) {
       this.Supppaydays= Supppaydayss;
    }
     public static void main(String[] args) {
         
     }
     
         
    public void insert(){
        try { 
            conn = DBconnecter.connect();
            String sql = " insert into supplier (supp_id,comp_name, supp_address, supp_contact, supp_name, supp_mail, supp_paydays)"
            + " values (?,?, ?, ?, ?, ?, ?)";
            prpdStmt = conn.prepareStatement(sql);
            prpdStmt.setString (1, Suppid);
            prpdStmt.setString (2, Compname);
            prpdStmt.setString (3, Suppaddress);
            prpdStmt.setString(4, Suppcontact);
            prpdStmt.setString (5, Suppname);
            prpdStmt.setString (6, Suppmail);
            prpdStmt.setString (7, Supppaydays);
            prpdStmt.execute();
            JOptionPane.showMessageDialog(null,"Records Added Successfully.","Action Successful",
                JOptionPane.PLAIN_MESSAGE);
        } 
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Add Record.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }    
    }
    public ResultSet search(String cname){
        try {
            conn = DBconnecter.connect();
            String sql = "SELECT supp_id AS SupplierID,comp_name AS Company,supp_address AS Address,supp_contact AS contact,supp_name AS Name,supp_mail AS Email,supp_paydays AS Duration FROM supplier WHERE comp_name='"+cname+"'";
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Search.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    public void remove(String cname){
        try {
            conn = DBconnecter.connect();
            statement = conn.createStatement();
            String sql = "DELETE FROM supplier WHERE comp_name ='"+cname+"'";
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"One or more Records will be Deleted.","Action Successful",
            JOptionPane.PLAIN_MESSAGE);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Remove Records.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
            System.out.println("Deleted records into the table...");
    }
    public ResultSet searchAll(){
        try {
            conn = DBconnecter.connect();
            String sql = "SELECT supp_id AS SupplierID,comp_name AS Company,supp_address AS Address,supp_contact AS contact,supp_name AS Name,supp_mail AS Email,supp_paydays AS Duration FROM supplier";
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Search All Records.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    public void update(String sid){
        try {
            conn = DBconnecter.connect();
            String sql = "update supplier set comp_name=? ,supp_address=?,supp_contact= ?,supp_name=?,supp_mail=?,supp_paydays=? where supp_id='"+sid+"'";
            prpdStmt = conn.prepareStatement(sql);
            prpdStmt.setString (1, Compname);
            prpdStmt.setString (2, Suppaddress);
            prpdStmt.setString(3, Suppcontact);
            prpdStmt.setString (4, Suppname);
            prpdStmt.setString (5, Suppmail);
            prpdStmt.setString (6, Supppaydays);
            prpdStmt.execute();
            JOptionPane.showMessageDialog(null,"Record Updated Successfully.","Action Successful",
            JOptionPane.PLAIN_MESSAGE);
        } 
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Update Details.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    public ResultSet loadData(String cname){
        try{
            conn = DBconnecter.connect();
            statement = conn.createStatement();
            String sql = "SELECT supp_id,supp_address,supp_contact,supp_name,supp_mail,supp_paydays FROM supplier where comp_name='"+cname+"'";
            result = statement.executeQuery(sql);
        }
        catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null,"Couldn't Load Data.","Warning",
            JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
}


   
