
public interface Observable {
    void registerObserver(Printer o);
    void notifyObs() throws TooManyRecords;
}
