package com.company;

/**
 * Created by user on 6/14/2016.
 */
public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
