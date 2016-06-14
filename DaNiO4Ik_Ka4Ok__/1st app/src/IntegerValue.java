
    public class IntegerValue implements Observerable   {
    private Integer a;
    private Observer p;

    public IntegerValue() {
        
    }

    public void setA(int value) {
        this.a = value;
        notifyObservers();

    }

    public int getA() {
        return a;
    }

	@Override
	public void registerPrinter(Observer p) {
		this.p=p;
		
	}

	@Override
	public void notifyObservers() {
		p.update(a);		
	}



}

