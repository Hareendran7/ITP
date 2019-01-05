/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
public class validation {
    
    public static boolean validateNumber(String number){
        char arr[]=number.toCharArray();
        
        for(int i=0; i<arr.length;i++){
            if(!Character.isDigit(arr[i])){
                return false;
            }
        }
        return true;
    }
     
     
     public static boolean emailValidate(String s)
     {
         if(!s.isEmpty())
         {
             int at=s.indexOf("@");
             int dot=s.indexOf(".");
             if(at<1||dot+2>s.length()||at+2>dot)
             {
                 return false;
             }
         }
         return true;
         
     }
    
     
      public static boolean validateName(String name){
    
        boolean b= false;
        String namePattern="^[a-zA-Z]+$";
        Pattern pattern=Pattern.compile(namePattern);
        Matcher matcher=pattern.matcher(name);
        
        if(matcher.matches())
          b=true;
        else
            b=false;
       
           return b;
        
    }

   public static boolean validateNIC(String nic){
     
        boolean c=false;
        
        String nicPattern="^[0-9]{9}[v|V]";
        Pattern pattern=Pattern.compile(nicPattern);
        Matcher matcher=pattern.matcher(nic);
        
           if(matcher.matches())
             c=true;
            
             else
                  c=false;
        
            return c;
   }
   
   public static boolean validateSal(String sal){
     boolean g= false;
     String sal1="^[0-9]*$";
     Pattern pattern=Pattern.compile(sal1);
     Matcher matcher=pattern.matcher(sal);
     if(matcher.matches())
         g=true;     
       else
         g=false;
           
     return g;
  }
   
  public void isBlank(String field,JLabel jLabel) 
  {
     if(field.isEmpty()){
         jLabel.setText("Please enter a value");
     }
     else{
         jLabel.setText(" ");
     } 
  }
   
    public static boolean validateapp(String DOB,String app) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        Date date1;
        try {
            date1 = dateFormat.parse(DOB);
            Date date2 = dateFormat.parse(app);
             if(date1.after(date2)) {
                return false;
            }
        else {
        return true;
             }
        } catch (ParseException ex) {
            Logger.getLogger(validation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    
     

}
    public void isContact(String field,JLabel jLabel)
    {
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
    public void dateBlank(Date field,JLabel jLabel){    
    if(field==null){
    jLabel.setText("Please Enter a Value");
    }
    else{
    jLabel.setText("");
    }
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
