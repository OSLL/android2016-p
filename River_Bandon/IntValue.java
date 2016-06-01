public class IntValue implements Observable {
    private int data;
    Printer obs;

    IntValue() {
        Printer o = new Printer();
        registerObserver(o);
    }

    public int getValue() {
        return data;
    }

    public void setValue(int new_data) {
        data = new_data;
        notifyObs();

    }
    @Override
    public void registerObserver(Printer o) {
        obs = o;
    }
    public void notifyObs() {
        obs.display(getValue());
    }
}
