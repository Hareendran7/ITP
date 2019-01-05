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
public class table {
    
    
    
    private final  String DR_ID;
    private final  String RO_ID;
    private final  String R_DATE;
    private final  String R_DES;
    private final  String RPR_ID;
    private final  String R_QTY;
    private final  String R_UNITPRICE;
    private final  String R_AMOUNT;
   
    

   public table (String DR_ID,String RO_ID,String R_DATE,String R_DES,String RPR_ID,String R_QTY,String R_UNITPRICE,String R_AMOUNT)
    {

   this.DR_ID=DR_ID;
   this.RO_ID=RO_ID;
   this.R_DATE=R_DATE;
   this.R_DES=R_DES;
   this.RPR_ID=RPR_ID;
   this.R_QTY=R_QTY;
   this.R_UNITPRICE=R_UNITPRICE;
   this.R_AMOUNT=R_AMOUNT;
   

   }
   
   
   public String getDR_ID(){

   return DR_ID;
   }

   public String getRO_ID(){

   return RO_ID;
   }

  public String getR_DATE(){

   return R_DATE;
   }
   public String getR_DES(){

   return R_DES;
   }
    
   public String  getRPR_ID(){

   return RPR_ID;
   }
   public String  getR_QTY(){

   return R_QTY;
   }

   public String  getR_UNITPRICE(){

   return R_UNITPRICE;
   }


   public String getR_AMOUNT(){

   return R_AMOUNT;
   }
   
    
    
}
