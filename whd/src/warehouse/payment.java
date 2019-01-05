package warehouse;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import warehouse.DBonnect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vijeyaratnam
 */
public class payment {
    
   Connection con = null;
   ResultSet rs = null;
   PreparedStatement ps =null;
   
   static String payid;
   static String orderid;
   static String retid;
   static String amount;
   static String duedate;
   static String coldate;
   static String status;
   
    //SET PAYMENT ID
    public void setPayId( String pid )
    {
        payid = pid;
    }
    
    /*RETURN PAYMENT ID
    public String getPayId()
    {
        return payid;
    }
    */
    
    //SET ORDER ID
    public void setOrderId( String oid )
    {
        orderid = oid ;
    }
    
    //SET RETAILER ID
    public void setRetId( String rid )
    {
        retid = rid;
    }
      
    //SET AMOUNT
    public void setAmount( String amt )
    {
        amount = amt;
        
    }
    
    //SET DUE DATE
    public void setDueDate( String ddate )
    {
        duedate = ddate;
        
    }
    
    //SET COLLECTION DATE
    public void setColDate( String cdate )
    {
        coldate = cdate;
    }
    
    //SET STATUS
    public void setStat( String stat )
    {
        status = stat;
    }
    
   
    
    public void connectDB()
    {
     con = DBonnect.getConnection();
     
     try{
         String sql = "Insert into set_payment(pay_id, ord_id, ret_id, amou, due_date, stat ) values ('"+payid+"', '"+orderid+"', '"+retid+"', '"+amount+"', '"+duedate+"', '"+status+"')";
     
         PreparedStatement pst = con.prepareStatement(sql);
         pst.execute();  //TO EXECUTE A QUERY
         JOptionPane.showMessageDialog(null, "Record successfully added");
     }
     
     catch ( Exception e){
         JOptionPane.showMessageDialog(null, "Error in inserting data"+e);
     }
         
    }
    
    public void updateDB_1()
   {
       con = DBonnect.getConnection();
        
       try{
           String sql = "UPDATE set_payment SET amou = '"+amount+"' , due_date='"+duedate+"' where pay_id='"+payid+"'";
           
           PreparedStatement pst = con.prepareStatement(sql);
           pst.execute(sql);
           JOptionPane.showMessageDialog(null, "Record Successfully Updated");
       }
       
       catch( Exception e)
       {
           System.out.println("Couldn't be updated:" +e);
       }
   }
    
    
    public void sub_update(String ord_id)
    {
        con = DBonnect.getConnection(); 
                
        try{
          String sql = "UPDATE delivery SET deliverystatus ='saved'  where deliveryID = '"+ord_id+"'";
          ps = con.prepareStatement(sql);
             ps.execute();
     }
      catch(Exception e)
      {
          System.out.println("Error" +e);
      }
    }
    
    public void updatecol(String payid)
    
    {
        con = DBonnect.getConnection(); 
        
        try{
            String sql = "UPDATE set_payment SET stat ='"+status+"', set_date = '"+coldate+"', due_date = '"+duedate+"', amou= '"+amount+"'  where pay_id ='"+payid+"' ";
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Record Successfully Updated");
        }
        
        catch(Exception e)
      {
         System.out.println("Couldn't be updated:" +e);
      }
    }
    
     public void updatedue(String payid)
    
    {
        con = DBonnect.getConnection(); 
        
        try{
            String sql = "UPDATE set_payment SET stat ='"+status+"', due_date = '"+duedate+"', amou= '"+amount+"'  where pay_id ='"+payid+"' ";
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Record Successfully Updated");
        }
        
        catch(Exception e)
      {
         System.out.println("Couldn't be updated:" +e);
      }
    }
    
    
}
