/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classs;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author it16112810
 */
public class validate {
    
    
    public void isBlank(String field,JLabel jLabel){    
    if(field.isEmpty()){
    jLabel.setText("Please enter a value");
    }
    else{
    jLabel.setText("");;
    }
    }
    public void isContact(String field,JLabel jLabel){
    if(field.length()==10){
    jLabel.setText("");
    }
    else{
    jLabel.setText("Please enter a valid contact");;
    }  
    }
    public void isMail(String field,JLabel jLabel){
    int count = 0;
    for (int i=0; i < field.length(); i++)
    {
        if (field.charAt(i) =='@')
        {
               count++;
        }
               if (count!=1) {
                   System.out.println(count);
                   jLabel.setText("Please enter a valid mail");
               }
               else{
                jLabel.setText("");
              } 
    }
    }
 public static boolean doublecheck(String n)  
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
 

  public boolean currentDate (String date){
         Date todayDate=new Date();
          boolean status=true;
         SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
         String exdate=  Date_Format.format(todayDate);
         
         if (!date.equals(exdate)){
              status=false;
              JOptionPane.showMessageDialog(null, " Enter current date");
              
         }
         return status;
     }
    
}