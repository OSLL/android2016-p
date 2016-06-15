import java.util.ArrayList;

class IntegerValue implements Observable {
    private ArrayList<Observer> observers;
    private int value;

    
    
    public IntegerValue() {
        observers = new ArrayList<Observer>();
    }
    
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() throws TooManyRecords {

        for (Observer observer : observers)
            observer.update(value);
    }
         
    public void setValues(int value) throws TooManyRecords {
    	if (value != this.value)
    	{
    		this.value = value;
    		
            notifyObservers();
    	}
    }
}