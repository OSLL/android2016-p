public class Printer implements Observer {
    private int a;

    void display(int a){
        if(this.a != a){
            System.out.println("New A: "+a);
        }
        this.a = a;
    }

	@Override
	public void update(Integer value) {
		display(value);		
	}
}
