public class Printer implements Observer { 
     private int a;
     private int i=-1;
     int n = 2;
     int b[] = new int[n];
 
     void display(int a) throws TooManyRecords{ 
         if(this.a != a){ 
                i++;
                if (i >= n) 
                	throw new TooManyRecords("gyhau");
                b[i]=a;
                System.out.println(b[i]);
        	 }
         this.a = a; 
     } 
 
 	@Override 
 	public void update(Integer value) throws TooManyRecords { 
 		display(value);		 
 	} 
 } 

