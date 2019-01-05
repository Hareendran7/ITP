/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classs;

/**
 *
 * @author it16112810
 */
public class stockD {
    
     
    private final  String stoc_id;
    private final  String prod_id ;
    private final  String size_1;
    private final  String prod_name;
    private final  String quantity;
    private final  String rece_date;
    private final  String expi_date;
    private final  String desc_1;
   private final  String stor_location;
    

   public stockD (String stoc_id,String prod_id,String size_1,String prod_name,String quantity,String rece_date,String expi_date,String desc_1,String stor_location)
    {

   this.stoc_id=stoc_id;
   this.prod_id=prod_id;
   this.size_1=size_1;
   this.prod_name=prod_name;
   this.quantity=quantity;
   this.rece_date=rece_date;
   this.expi_date=expi_date;
   this.desc_1=desc_1;
   this.stor_location=stor_location;

   }
   
   
   public String getstoc_id(){

   return stoc_id;
   }

   public String getprod_id(){

   return prod_id;
   }

  public String getsize_1(){

   return size_1;
   }
   public String getprod_name(){

   return prod_name;
   }
    
   public String  getquantity(){

   return quantity;
   }
   public String  getrece_date(){

   return rece_date;
   }

   public String  getexpi_date(){

   return expi_date;
   }


   public String getdesc_1(){

   return desc_1;
   }
   
     public String stor_location(){

   return stor_location;
   }
    
    
  
}
