
 public class IntegerValue implements Observerable   { 
     private Integer a; 
     private Observer p; 
 
 
     public IntegerValue() { 
          
     } 
 
     public int getA() { 
         return a; 
     } 
  
 
 	@Override 
 	public void notifyObservers() throws TooManyRecords { 
 		p.update(a);		 
 	}


	public void setA(int value) throws TooManyRecords {
		// TODO Auto-generated method stub
		this.a = value; 
        notifyObservers(); 
	}



	public void registerPrinter(Printer p2) {
		// TODO Auto-generated method stub
		this.p=p2; 
	}

	@Override
	public void registerPrinter(Observer p) {
		// TODO Auto-generated method stub
		
	} 
 
 
 
 
 
 
 } 
 
