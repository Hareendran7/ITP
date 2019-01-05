/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycode;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class validation {
     public void isBlank(String field,JLabel jLabel){    
    if(field.isEmpty()){
    jLabel.setText("Please enter a value");
    }
    else{
    jLabel.setText("");;
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
     
//    public void currentMonth (int month,int year){
//           YearMonth.of(year,month); 
//           LocalDate endMonth = date.atEndOfMonth(); //2015-12-31
        
//      String dateString = "01/13/2012";
//      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US); 
//      LocalDate date = LocalDate.parse(dateString, dateFormat);
//      LocalDate newDate = date.withDayOfMonth(date.getMonth().maxLength());
//      System.out.println(newDate);
      
     
     public boolean firstOfMonth(String date){
          //Date todayDate=new Date();
         //SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
         //String exdate=  Date_Format.format(todayDate);
        boolean status =true; 
       String[] part=date.split("-");
       String month=part[1];
       String year=part[0];
       String dd=part[2];
       
//       Integer intt=Integer.parseInt(month);
//       Integer yrt=Integer.parseInt(year);
       Integer day=Integer.parseInt(dd);
       if(day != 1){
           status=false;
           JOptionPane.showMessageDialog(null, " Record not Added,Check The Date Again"); 
           
       }
       
       return status;
     }
    }

