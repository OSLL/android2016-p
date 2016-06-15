package com.company;
import java.util.ArrayList;

public class IntegerValue implements Observable {
    private Observer myObserver;

    private Integer value;

    public void setValue(Integer value) {
      //  printer.display(this.value, value);
        this.value = value;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        myObserver = o;
    }

    @Override
    public void removeObserver(Observer o) {
        myObserver = null;
    }

    @Override
    public void notifyObservers() {
        myObserver.update(value);
    }
}
