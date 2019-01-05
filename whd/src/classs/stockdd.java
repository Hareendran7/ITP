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
public class stockdd {
    

    private final  String DRO_ID;
    private final  String DR_DATE;
    private final  String DR_DES;
    private final  String DRPR_ID;
 
   
    

   public stockdd (String DRO_ID,String DR_DATE,String DR_DES,String DRPR_ID)
    {

 
   this.DRO_ID=DRO_ID;
   this.DR_DATE=DR_DATE;
   this.DR_DES=DR_DES;
   this.DRPR_ID=DRPR_ID;
  

   }
 
   

   public String getDRO_ID(){

   return DRO_ID;
   }

  public String getDR_DATE(){

   return DR_DATE;
   }
   public String getDR_DES(){

   return DR_DES;
   }
    
   public String  getDRPR_ID(){

   return DRPR_ID;
   }

   
    
    
}
