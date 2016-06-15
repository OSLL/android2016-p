
interface Observer{ 
     void update(Integer value); 
 } 
 

 interface Observerable{ 
     void registerPrinter(Observer p); 
     void notifyObservers(); 
 } 
  
public class MainProgram {
	
    
    public static void main(String[] args) {
        IntegerValue iv = new IntegerValue();
        Printer p =new Printer();
        iv.registerPrinter(p);
        iv.setA(3);
        iv.setA(3);
        iv.setA(122);
        iv.setA(122);
    }

}