interface Observer{  
      void update(Integer value) throws TooManyRecords;  
  }  
   
 
 
  interface Observerable{  
      void registerPrinter(Observer p);  
      void notifyObservers() throws TooManyRecords;  
  }  
    
 public class MainProgram { 
 	 
      
     public static void main(String[] args) { 
    	 try{
         IntegerValue iv = new IntegerValue(); 
         Printer p =new Printer(); 
         iv.registerPrinter(p); 
         iv.setA(3); 
         iv.setA(3); 
         iv.setA(122); 
         iv.setA(122); 
         iv.setA(1431); 
         iv.setA(1); 
         iv.setA(12); 
         iv.setA(125);
    	 }
    	 catch (TooManyRecords t){
    		 System.out.println("gahgla");
    	 }
     } 
 
 
 } 

