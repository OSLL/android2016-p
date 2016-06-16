import java.util.ArrayList;

class Printer implements Observer {
    private IntegerValue integervalue;
    public ArrayList<Integer> integers;
    private int maxx = 1;
    
    public Printer(IntegerValue integervalue) {
        this.integervalue = integervalue;
        integervalue.registerObserver(this);
        integers = new ArrayList<Integer>();
    }   

	public void update(int value) throws TooManyRecords {
	   
	    if (maxx <= integers.size())
			throw new TooManyRecords();
		display(value);
		integers.add(value);
    }

    public void display(int value) {
        System.out.println(value);
    }
}