
package classs;

/**
 *
 * @author it16112810
 */
public class table_1 {
    
    private final  String DS_ID;
    private final  String ST_ID;
    private final  String S_DATE;
    private final  String S_DES;
    private final  String SPR_ID;
    private final  String S_QTY;
    private final  String S_UNITPRICE;
    private final  String S_AMOUNT;
   
    

   public table_1 (String DS_ID,String ST_ID,String S_DATE,String S_DES,String SPR_ID,String S_QTY,String S_UNITPRICE,String S_AMOUNT)
    {

   this.DS_ID=DS_ID;
   this.ST_ID=ST_ID;
   this.S_DATE=S_DATE;
   this.S_DES=S_DES;
   this.SPR_ID=SPR_ID;
   this.S_QTY=S_QTY;
   this.S_UNITPRICE=S_UNITPRICE;
   this.S_AMOUNT=S_AMOUNT;
   

   }
   
   
   public String getDS_ID(){

   return DS_ID;
   }

   public String getST_ID(){

   return ST_ID;
   }

  public String getS_DATE(){

   return S_DATE;
   }
   public String getS_DES(){

   return S_DES;
   }
    
   public String  getSPR_ID(){

   return SPR_ID;
   }
   public String  getS_QTY(){

   return S_QTY;
   }

   public String  getS_UNITPRICE(){

   return S_UNITPRICE;
   }


   public String getS_AMOUNT(){

   return S_AMOUNT;
   }
   
   }
   