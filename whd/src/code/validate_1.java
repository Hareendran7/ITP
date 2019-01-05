/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import static java.sql.JDBCType.BLOB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Date;
/**
 *
 * @author HARIpc
 */


public class validate_1 {
    
    Connection con = null;
    PreparedStatement pst = null;       //contains a sql statement which has been pre compiled
    ResultSet rs = null; 
    
    
    
     public boolean check_letters(String n)     //if there is a digit then return false else return true
    {
        for(int i=0;i<n.length();i++)
        {
            char a = n.charAt(i);
            if(Character.isDigit(a))
            {
                return false;
            }
        }
        
        return true;
    }
   public boolean numcheck(String n)  
    {
        int numcount = 0;
   
        for(int i=0;i<n.length();i++)
            {
            char num = n.charAt(i);
            
            if(Character.isDigit(num) )
            {
                numcount++;
            }
            }
            if(numcount==n.length())
                return true;
            
            return false;
    }
 
    public boolean doublecheck(String n)  
    {
        int numcount = 0;
   
        for(int i=0;i<n.length();i++)
            {
            char num = n.charAt(i);
            
            if((Character.isDigit(num)) || (num=='.') )
            {
                numcount++;
            }
            }
            if(numcount==n.length())
                return true;
            
            return false;
    }
    



   
}
